package code._2_challenge._1_fizzbuzz;

public class PrintNumbers {

	public void stage1(){	
		FizzBuzz FizzBuzz = new FizzBuzz();
		for(int i=1;i<=100;i++){
			System.out.println(FizzBuzz.fizzBuzz(i));
		} 
	}

	public void stage2(){	
		FizzBuzz FizzBuzz = new FizzBuzz();
		for(int i=1;i<=100;i++){
			System.out.println(FizzBuzz.fizzBuzz2(i));
		} 
	}

}