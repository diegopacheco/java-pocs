package com.github.diegopacheco.sandbox.java.jest;

import static com.hazelcast.jet.stream.DistributedCollectors.toIMap;

import java.util.Arrays;
import java.util.regex.Pattern;

import com.hazelcast.core.IMap;
import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.stream.IStreamMap;

public class WordCountApp {

	private static final Pattern PATTERN = Pattern.compile("\\W+");

	public static void main(String[] args) {
		JetInstance jet = Jet.newJetInstance();

		// Create an additional instance; it will automatically
		// discover the first one and form a cluster
		Jet.newJetInstance();

		IStreamMap<Integer, String> source = jet.getMap("source");

		source.put(0, "It was the best of times, " + "it was the worst of times ");
		source.put(1, "There were a king with a large jaw and a " + "queen with a plain face, on the that things in "
				+ "general were settled for ever.");
		source.put(2, "It was the year of Our Lord one thousand " + "seven hundred and seventy-five. Spiritual "
				+ "revelations were conceded to England at that " + "favoured period");

		IMap<String, Integer> counts = source.stream().map(e -> e.getValue().toLowerCase())
				.flatMap(line -> Arrays.stream(PATTERN.split(line)))
				.collect(toIMap(m -> m, m -> 1, (left, right) -> left + right));

		System.out.println("Counts=" + counts.entrySet());
		Jet.shutdownAll();
	}

}
