package com.diegopacheco.hollow;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.fs.HollowFilesystemBlobRetriever;
import com.netflix.hollow.api.objects.generic.GenericHollowObject;
import com.netflix.hollow.api.producer.HollowProducer;
import com.netflix.hollow.api.producer.fs.HollowFilesystemBlobStager;
import com.netflix.hollow.api.producer.fs.HollowFilesystemPublisher;
import com.netflix.hollow.core.memory.MemoryMode;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) throws Exception {
    List<Movie> movies = List.of(
        new Movie(1, "Inside Out", 2015),
        new Movie(2, "Dune", 2021),
        new Movie(3, "Heat", 1995)
    );
    List<Movie> stored = roundTrip(movies);
    for (Movie movie : stored) {
      System.out.println(movie.getId() + " - " + movie.getTitle() + " (" + movie.getYear() + ")");
    }
  }

  static List<Movie> roundTrip(List<Movie> movies) throws Exception {
    Map<Integer, String> titles = movies.stream().collect(Collectors.toMap(Movie::getId, Movie::getTitle, (first, second) -> first));
    Path blobPath = Files.createTempDirectory("hollow-blobs");
    HollowFilesystemPublisher publisher = new HollowFilesystemPublisher(blobPath);
    HollowFilesystemBlobStager stager = new HollowFilesystemBlobStager(blobPath, HollowProducer.BlobCompressor.NO_COMPRESSION);
    HollowProducer producer = HollowProducer.withPublisher(publisher).withBlobStager(stager).build();
    producer.initializeDataModel(Movie.class);
    long version = producer.runCycle(state -> {
      for (Movie movie : movies) {
        state.add(movie);
      }
    });
    HollowConsumer consumer = HollowConsumer.withBlobRetriever(new HollowFilesystemBlobRetriever(blobPath))
        .withMemoryMode(MemoryMode.ON_HEAP)
        .build();
    consumer.triggerRefreshTo(version);
    HollowReadStateEngine readEngine = consumer.getStateEngine();
    BitSet ordinals = readEngine.getTypeState("Movie").getPopulatedOrdinals();
    List<Movie> result = new LinkedList<>();
    for (int ordinal = ordinals.nextSetBit(0); ordinal >= 0; ordinal = ordinals.nextSetBit(ordinal + 1)) {
      GenericHollowObject movie = new GenericHollowObject(readEngine, "Movie", ordinal);
      int id = movie.getInt("id");
      int year = movie.getInt("year");
      String title = titles.getOrDefault(id, "");
      result.add(new Movie(id, title, year));
    }
    return result;
  }
}
