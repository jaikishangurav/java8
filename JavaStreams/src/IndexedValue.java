import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IndexedValue<T> {
    private final int index;
    private final T value;

    @Override
    public String toString() {
        return "IndexedValue{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }

    public IndexedValue(int index, T value){
        this.index = index;
        this.value = value;
    }

    public static <T> Stream<IndexedValue<T>> withIndices(List<T> list){
        return IntStream.range(0,list.size())
                .mapToObj(idx -> new IndexedValue<>(idx, list.get(idx)));
    }

    public int getIndex() {
        return index;
    }

    public T getValue() {
        return value;
    }
}
