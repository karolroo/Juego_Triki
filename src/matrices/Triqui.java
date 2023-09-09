package matrices;

import java.util.Scanner;

public class Triqui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] tablero = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        boolean juegoTerminado = false;
        char jugadorActual = 'X';

        //inicia juego

        System.out.println("1.Iniciar juego");
        int fill = sc.nextInt();

        //Pedir jugada

        while (!juegoTerminado && fill == 1) {
            System.out.println("Tablero");
            mostrarTablero(tablero);

            System.out.println("Indique fila 0-2");
            int fila = sc.nextInt();

            System.out.println("Indique columna 0-2");
            int columna = sc.nextInt();


            //Verificar jugada
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;

                // Verificar si hay un ganador
                if (ganador(tablero, jugadorActual)) {
                    mostrarTablero(tablero);
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;

                    //Si no hay jugador
                } else if (tableroLleno(tablero)) {
                    mostrarTablero(tablero);
                    System.out.println("¡El juego ha terminado en empate!");
                    juegoTerminado = true;
                } else {
                    // Cambiar al siguiente jugador
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }

            } else {

                System.out.println("Jugada inválida. Inténtalo de nuevo.");
            }
        }
            sc.close();
        }

        //Tablero

    //funcion tablero
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    //Funcion ganador
    public static boolean ganador(char[][] tablero, char jugador) {
        // Verificar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                    (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }
        return (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
                (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador);
    }
    //Funcion tablero lleno
    public static boolean tableroLleno(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}



