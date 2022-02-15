package com.anm.TresEnRaya;

import java.util.Random;

import vista.interfazG;

public class Tablero {
	private char[][] tablero;
	/*
	 * [1,1][2,1][3,1]
	 * [1,2][2,2][3,2]
	 * [1,3][2,3][3,3]
	 */
	
	public Tablero() {
		tablero = new char[3][3];
	}
	
	public boolean jugarCasilla(char op, int x,int y) {
		if(tablero[x][y] != 'X' && tablero[x][y] != 'O')
			if(x < 3 && x >= 0 && y < 3 && y >= 0 && (op == 'X' || op == 'O'))
				tablero[x][y] = op;
		
		return tablero[x][y] != 'X' && tablero[x][y] != 'O';
	}
	
	public Pair<Boolean,Character> finDeJuego() {
		int contColumna = 0,contFila = 0, contDiagonal = 0;
		char[] opciones = {'X','Y'};
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
			
			for(int i = 0; i < 3; i++) {
				contDiagonal = 0;
				if(tablero[i][i] == op)
					contDiagonal++;
			}
			
			if(contDiagonal == 3) {
				fin = true;
				ganador = op;
				break;
			}
			
			for(int i = 0; i < 3; i++) {
				contDiagonal = 0;
				if(tablero[i][3 - i] == op)
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
	
	
	public int[] jugarCPU() {
		Random rand = new Random();
		int x = rand.nextInt(3), y = rand.nextInt(3);
		while(tablero[x][y] == 'X' || tablero[x][y] == 'O') {
			x = rand.nextInt(3);
			y = rand.nextInt(3);
		}
		
		tablero[x][y] = 'O';
		int[] sol = {x,y};

		return sol;
	}
}
