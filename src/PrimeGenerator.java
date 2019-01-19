import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeGenerator {

    public static void main(String[] args) {
        infinitePrimes().limit(50).forEach(System.out::println);
    }

    public static IntStream infinitePrimes() {
        return Stream.generate(new Supplier<Integer>() {
            private final AtomicInteger current = new AtomicInteger(2);
            @Override
            public Integer get() {
                if(this.current.intValue() <= 3) {
                    return this.current.getAndIncrement();
                }
                while(!isPrime(this.current.incrementAndGet())) {
                }
                return this.current.get();
            }
        }).mapToInt(Integer::intValue);
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
