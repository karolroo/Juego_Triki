package matrices;

import java.util.Scanner;

public class ListaDeNotas {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            double [][]notas=new double[2][3];
            System.out.println("1.Iniciar");
            int fill= sc.nextInt();

            while (fill==1){
                System.out.println("Desea agregar una nota: y = Si |n = No");
                String resp= sc.next();
                if(resp.equals("y")) {
                    System.out.println("Indique el id Usuario");
                    int i = sc.nextInt();

                    System.out.println("Indique la posicion de la nota");
                    int j = sc.nextInt();

                    System.out.println("Indique la nota");
                    notas[i][j] = sc.nextDouble();

                } else if (resp.equals("n")) {
                    for (int i = 0; i < notas.length; i++) {
                        for (int j = 0; j < notas[i].length; j++) {
                            System.out.println(notas[i][j]);
                        }
                        System.out.println("\n");

                    }
                    fill=0;
                }
            }
        }
    }
