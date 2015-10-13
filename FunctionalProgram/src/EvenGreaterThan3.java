
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class EvenGreaterThan3 {

	public static boolean isGreaterThan3(int number){
		System.out.println("isGreaterThan3 :"+number);
		return number >3;
	}
	
	public static boolean isEven(int number){
		System.out.println("isEven :"+number);
		return number % 2 ==0; 
	}
	
	public static int doubleIt(int number){
		System.out.println("doubleIt :"+number);
		return number*2;
	}
	
	public static void main(String[] args) {
		// find double of first even number greater than 3
		List<Integer> values = Arrays.asList(1,2,3,5,6,5,4,7,9,11);
		
		for(int e:values){
			if(isGreaterThan3(e))
				if(isEven(e)){
					System.out.println(doubleIt(e));
				break;
				}
		}
		System.out.println();
		System.out.println("1============================================================");
		System.out.println();
		/*System.out.println(values.stream()
			.filter(index->index >3)
			.filter(index->index%2==0)
			.map(e->e*2)
			.findFirst()
			.get()
			);*/
		//functio to function higher order function
		//lazy & composition
		//instead of calling method for checking greater than 3 define a predicate that performs this check
		Predicate<Integer> isGreaterThan3 = number -> number>3;
		
		//use Function to check greater than condition for different values
		Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> 
		number -> number > pivot;
		
		System.out.println(values.stream()
				.filter(isGreaterThan.apply(3))
				.filter(EvenGreaterThan3::isEven)
				.map(EvenGreaterThan3::doubleIt)
				.findFirst()
				.get()
				);
		System.out.println();
		System.out.println("2============================================================");
		/*System.out.println();
		Stream<Integer> tmp = values.stream()
				.filter(EvenGreaterThan3::isGreaterThan3)
				.filter(EvenGreaterThan3::isEven)
				.map(EvenGreaterThan3::doubleIt);
		
		System.out.println(tmp.findFirst().get());*/
		}

}
