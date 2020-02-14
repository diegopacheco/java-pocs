import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Main {
  public static void main(String args[]) throws Throwable {
    Flowable.just("Hello world").subscribe(System.out::println);

    Flowable.range(1, 5)
      .map(v -> v * v)
      .filter(v -> v % 3 == 0)
      .subscribe(System.out::println);

    Flowable.fromCallable(() -> {
        Thread.sleep(1000); //  imitate expensive computation
        return "Done";
    })
      .subscribeOn(Schedulers.io())
      .observeOn(Schedulers.single())
      .subscribe(System.out::println, Throwable::printStackTrace);
    Thread.sleep(2000);

    Flowable.range(1, 10)
      .parallel()
      .runOn(Schedulers.computation())
      .map(v -> v * v)
      .sequential()
      .blockingSubscribe(System.out::println);
    
    AtomicInteger count = new AtomicInteger();
    Observable.range(1, 10)
      .doOnNext(ignored -> count.incrementAndGet())
      .ignoreElements()
      .andThen(Single.fromCallable(() -> count.get()))
      .subscribe(System.out::println);

  }
}
