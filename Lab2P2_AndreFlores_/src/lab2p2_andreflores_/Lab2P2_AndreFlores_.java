package lab2p2_andreflores_;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2P2_AndreFlores_ {

    public static void main(String[] args) {
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("  Menu principal \n"
                    + " 1. Listar recursos\n"
                    + " 2. Crear Recursos\n"
                    + " 3. eliminar recursos\n"
                    + " 4. modificar recurso\n"
                    + " 5. salir\n"
                    );
        do {
            opcion = entrada.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Listar recursos");
                    break;
                case 2:
                    System.out.println("Crear recursos");
                    break;
                case 3:
                    System.out.println("eliminar recursos");
                    break;
                case 4:
                    System.out.println("modificar recursos");
                    break;
                case 5:
                    System.out.println("salir");
                    break;
                default:

                    break;

            } // fin switch

        } while (opcion != 5);// fin do
    }

}
