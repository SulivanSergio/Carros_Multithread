package Main;

import java.util.Random;

public class Car extends Thread{
	
	boolean rodando = true;
	
	
	int id;
	
	//velocidade
	float V;
	
	//aceleração
	float A;
	
	//deslocamento final e inicial
	float S_Inicial;
	float S_Final;
	
	Random r = new Random();
	
	public Car(int id)
	{
		this.id = id;
	}
	
	public void run()
	{
		float gameTime = 0;
		
		//GameLoop
		while(rodando)
		{
			long inicio = System.currentTimeMillis();
			
			Update(gameTime);
			
			long fim = System.currentTimeMillis();
			gameTime = (float)(fim - inicio)* 0.001f;
			
		}
		
		
		
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
		
		
		System.out.println("O Carro_"+this.id+" andou "+ this.S_Inicial +"m e já percorreu "+ this.S_Final  +"m");
		
		if(this.S_Final >= 10f)
		{
			
			rodando =false;
			System.out.println("Carro_"+ this.id+" alcançou a linha de chegada.");
		}
		
	}

}
