import java.util.Arrays;
import java.util.List;

public class IntegerStream {

	public static void main(String[] args) {
		Integer integerArray[] = {45,34,56,38,67,58,45,77};
		List<Integer> integerList = Arrays.asList(integerArray);
		integerList.stream().filter(s->s%2==0).sorted().forEach(System.out::println);;

	}

}
