package org.afi.sample.java;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Light weight threads not supported, but you can try something like that
public class Coroutines {
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(2);

    public static void main(String... args) throws ExecutionException, InterruptedException {
        final Future<List<Integer>> count2 = THREAD_POOL.submit(new DiscoverMultiples(2));
        final Future<List<Integer>> count3 = THREAD_POOL.submit(new DiscoverMultiples(3));

        System.out.println(count2.get().size() + " multiples of 2 found");
        System.out.println(count3.get().size() + " multiples of 3 found");
    }

    private static class DiscoverMultiples implements Callable<List<Integer>> {
        private final int multiple;

        public DiscoverMultiples(int multiple) {
            this.multiple = multiple;
        }

        @Override
        public List<Integer> call() {
            return IntStream.range(1, 100)
                    .filter(number -> {
                        sleep(100);
                        return number % multiple == 0;
                    })
                    .boxed()
                    .peek(this::printResult)
                    .collect(Collectors.toList());
        }

        private void printResult(Integer number) {
            System.out.println("[" + getCurrentThreadName() + "] Multiple of " + multiple + " found: " + number);
        }

        private String getCurrentThreadName() {
            return Thread.currentThread().getName();
        }

        private void sleep(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

