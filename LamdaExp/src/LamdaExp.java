interface Executable{
	int execute(int a, int b);
}

interface StringExecutable{
	String execute(String a);
}


class Runner{
	void run(Executable e){
		System.out.println("Inside runner");
		int value = e.execute(12,13);
		System.out.println("Return value "+value);
	}
	
	void run(StringExecutable e){
		System.out.println("Inside runner");
		String value = e.execute("Qwerty");
		System.out.println("Return value "+value);
	}
}

//()->System.out.println("Inside lambda expression")

/*(a) -> {
			System.out.println("Inside lamda expression");
			return 8+a;}*/

//(a) -> 8+a

/*(int a) -> {
			System.out.println("Inside lamda expression");
			return 8+a;
			}
 * */

/*(a,b) -> {
			System.out.println("Inside lamda expression");
			return b+a;
			}
			*/

public class LamdaExp {

	public static  void main(String args[]){
		
		int c =100;
		
		int d =50;
		
		Runner runner = new Runner();
		runner.run(new Executable(){

			@Override
			public int execute(int a,int b){
				System.out.println("Inside execute");
				//Can do this in methods of anonymous class int d = 99;
				return b+a+c;
			}			
		});
		
		System.out.println("==========================");
		
		runner.run((a,b) -> {
			System.out.println("Inside lambda expression");
			//Cant do this, no new scope int d = 98;
			return b+a+c;
			});
		
		System.out.println("==========================");
		
		Executable ex = (a,b) -> {
			System.out.println("Inside lambda expression 2");
			//Cant do this, no new scope int d = 98;
			return b+a+c;
			};
			
			runner.run(ex);
		
			System.out.println("==========================");
			
			Object obj = (Executable)(a,b) -> {
				System.out.println("Inside lambda expression 3");
				//Cant do this, no new scope int d = 98;
				return b+a+c;
				};
				
				runner.run((Executable)obj);
	}
}
