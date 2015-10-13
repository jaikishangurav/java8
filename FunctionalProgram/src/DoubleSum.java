import java.util.Arrays;
import java.util.List;


public class DoubleSum {

	private static int doubleIT(int val){
		System.out.println(val);
		return val*2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println(
				numbers.parallelStream()
				.mapToInt(e -> doubleIT(e))
				.sum()
				);
	}

}
