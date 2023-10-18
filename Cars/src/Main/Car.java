package Main;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Car extends Thread{
	
	//quantidade de interações do gameloop
	final int INTERACTION_FINAL = 50;
	int interaction = 0;
	
	int id;
	
	//velocidade
	float V;
	
	//aceleração
	float A;
	
	//deslocamento final e inicial
	float S_Inicial;
	float S_Final;
	
	//numeros aleatorios
	Random r = new Random();
	
	public static Semaphore semaphore;
	int[] ranking;
	
	public Car(int id, int ranking[])
	{
		this.id = id;
		this.ranking = ranking;
		this.semaphore = new Semaphore(1);
	}
	
	public void run()
	{
		float gameTime = 0;
		
		//GameLoop
		while(interaction < INTERACTION_FINAL)
		{
			
			long inicio = System.currentTimeMillis();
			
			Update(gameTime);
			
			long fim = System.currentTimeMillis();
			gameTime = (float)(fim - inicio)* 0.001f;
			interaction++;
			
		}
		
		
		try {
			semaphore.acquire();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		for(int i = 0; i<ranking.length; i++)
		{
			if(ranking[i] == -1)
			{
				ranking[i] = id;
				break;
			}
		}
		
		System.out.println("Carro_" + this.id + " alcançou a linha de chegada.");
		
		semaphore.release();
		
	}
	
	private void Update(float gameTime)
	{
		//gerando a aceleração aleatoria
		this.A = r.nextFloat(0,100);
		
		//calculando a velocidade final
		
		this.V = this.V + this.A * gameTime;
		
		//calculando o deslocamento
		this.S_Inicial = this.S_Inicial + this.V * gameTime; 
		this.S_Final += this.S_Inicial;
		
		
		//System.out.println("O Carro_" + this.id + " andou " + this.S_Inicial + " m e já percorreu " + this.S_Final  + " m");
		
		
	}

}
