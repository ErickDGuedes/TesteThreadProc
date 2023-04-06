package view;

import java.util.concurrent.Semaphore;

import controller.ThreadBD;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for(int i=1; i<20; i++) {
			ThreadBD bd = new ThreadBD(semaforo, i);
			bd.start();
		}
		

	}

}
