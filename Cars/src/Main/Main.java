package Main;

public class Main {

	public static void main(String[] args) {
		
		//threads
		Car car[] = new Car[4];
		
		//ranking de cada carro
		int[] ranking = new int[4];
		
		//iniciando as threads
		for(int i =0; i<car.length; i++)
		{
			ranking[i] = -1;
			car[i] = new Car(i,ranking);
			car[i].start();
			
		}
		
		//garantindo que as threads sejam finalizadas antes do ranking
		for(int i =0; i<car.length; i++)
		{
			
			try {
				car[i].join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
		//mostrando o ranking
		for(int i =0; i<ranking.length; i++)
		{
			System.out.println(ranking[i]);
		}
		
		
	}

}
