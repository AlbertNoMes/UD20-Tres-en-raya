package com.anm.TresEnRaya;

import java.util.Random;

import vista.interfazG;

public class Tablero {
	private char[][] tablero;
	private int turnos;
	/*
	 * [1,1][2,1][3,1]
	 * [1,2][2,2][3,2]
	 * [1,3][2,3][3,3]
	 */
	
	public Tablero() {
		tablero = new char[3][3];
		turnos = 0;
	}

	/*
	 * Esta funcion se encarga de colocar X o O en la casilla seleccionada
	 * comprobando que no haya anteriormente colocado algo en esa misma 
	 * casilla
	 */
	public boolean jugarCasilla(char op, int x,int y) {
		boolean comprobar = tablero[x][y] != 'X' && tablero[x][y] != 'O';
		if(comprobar) 
			if(x < 3 && x >= 0 && y < 3 && y >= 0 && (op == 'X' || op == 'O')) {
				tablero[x][y] = op;
				turnos++;
			}
		
		return comprobar;
	}
	
	/*
	 * Esta funcion se encarga de comprobar si el juego se ha acabado o no y quien ha ganado.
	 * Devuelve un objeto Pair con un booleano para saber si la partida ha acabado y un char
	 * para saber quien
	 */
	public Pair<Boolean,Character> finDeJuego() {
		int contColumna = 0,contFila = 0, contDiagonal = 0;
		char[] opciones = {'X','O'};
		boolean fin = false;
		char ganador = ' ';
		for(char op : opciones) {
			for(int i = 0; i < 3; i++) {
				contColumna = 0;
				for(int j = 0; j < 3; j++)
					if(tablero[i][j] == op)
						contColumna++;
				
				if(contColumna == 3) {
					fin = true;
					ganador = op;
					break;
				}
			}
			
			if(contColumna == 3)
				break;
			
			for(int i = 0; i < 3; i++) {
				contFila = 0;
				for(int j = 0; j < 3; j++)
					if(tablero[j][i] == op)
						contFila++;
				
				if(contFila == 3) {
					fin = true;
					ganador = op;
					break;
				}
			}
			
			if(contFila == 3)
				break;
			

			contDiagonal = 0;
			for(int i = 0; i < 3; i++) {
				if(tablero[i][i] == op)
					contDiagonal++;
			}
			
			if(contDiagonal == 3) {
				fin = true;
				ganador = op;
				break;
			}
			

			contDiagonal = 0;
			for(int i = 0; i < 3; i++) {
				if(tablero[i][2 - i] == op)
					contDiagonal++;
			}
			
			if(contDiagonal == 3) {
				fin = true;
				ganador = op;
				break;
			}
		}
		
		
		
		return new Pair<Boolean, Character>(fin,ganador);
	}
	
	/*
	 * Funcion que vacia el tablero y reinicia los turnos
	 */
	public void reiniciarPartida() {
		tablero = new char[3][3];
		turnos = 0;
	}
	
	/*
	 * Esta funcion se encarga de manegar los movimiento del ordenador, colocando
	 * un O de manera aleatoria en el tablero. Devuelve un objeto Pair con un booleano 
	 * para saber si se puede colocar o no un O y, si se puede, devuelve un array con 
	 * la posicion
	 */
	public Pair<Boolean,int[]> jugarCPU() {
		boolean ok = false;
		int[] sol = new int[2];
		if(!finDeJuego().getKey() && turnos < 9) {
			Random rand = new Random();
			int x = rand.nextInt(3), y = rand.nextInt(3);
			while(tablero[x][y] == 'X' || tablero[x][y] == 'O') {
				x = rand.nextInt(3);
				y = rand.nextInt(3);
			}
			
			tablero[x][y] = 'O';
			
			sol[0] = x;
			sol[1] = y;
			ok = true;
			turnos++;
		}
		else
			ok = false;

		return new Pair(ok,sol);
	}
}
