interface Executable1{
	void execute();
}

class Runner1{
	void run(Executable1 e){
		System.out.println("Inside runner");
		e.execute();

	}
}

//()->System.out.println("Inside lambda expression")

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runner1 runner = new Runner1();
		runner.run(new Executable1() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("Inside execute");
			}
		});
		
		
		System.out.println("======================================");
		
		runner.run(()->System.out.println("Inside lambda expression"));
	}

}
