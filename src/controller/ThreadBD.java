package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadBD extends Thread{
	
	Semaphore semaforo;
	int idTransacao;
	
	public ThreadBD(Semaphore semaforo, int idTransacao) {
		this.semaforo = semaforo;
		this.idTransacao = idTransacao;
	}
	
	public void run() {
		try {
			semaforo.acquire();
			Calculos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}
	long id = getId();
	Random random = new Random();
	public void Calculos() {
		if(id % 3 == 1) {
			double calc = random.nextDouble(0.2, 2.0);
			System.out.println("thread #"+id+" Calculando "+calc);
			try {
				Thread.sleep(1000);
				System.out.println("Transação concluída");
				id += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(id % 3 == 2) {
			double calc = random.nextDouble(0.5, 1.6);
			System.out.println("thread #"+id+" Calculando "+calc);
			try {
				Thread.sleep(1500);
				System.out.println("Transação concluída");
				id += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}else if(id % 3 == 0) {
			double calc = random.nextDouble(1.0, 3.0);
			System.out.println("thread #"+id+" Calculando "+calc);
			try {
				Thread.sleep(1500);
				System.out.println("Transação concluída");
				id += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
