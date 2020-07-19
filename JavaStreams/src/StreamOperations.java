import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {

    public static <T1, T2, R> Stream<R> zip(List<T1> list1, List<T2> list2, BiFunction<? super T1, ? super T2, ? extends R> mapper) {
        int size = list1.size();
        if(list2.size() != size){
            throw new IllegalArgumentException("List sizes are different");
        }
        return IntStream.range(0, size).mapToObj(idx -> mapper.apply(list1.get(idx),list2.get(idx)));
    }

    public static <T> Predicate<T> distinct(long atLeast){
        Map<T, Long> map = new ConcurrentHashMap<>();
        return t-> map.merge(t,1L,Long::sum)==atLeast;
    }
}
