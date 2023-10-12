package Main;

public class Main {

	public static void main(String[] args) {
		
		Car car[] = new Car[4];
		for(int i =0; i<car.length; i++)
		{
			car[i] = new Car(i);
			car[i].start();
			
		}
		for(int i =0; i<car.length; i++)
		{
			car[i].run();
		}
	}

}
