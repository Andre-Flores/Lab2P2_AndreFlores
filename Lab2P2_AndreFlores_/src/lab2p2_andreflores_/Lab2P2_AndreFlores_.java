package lab2p2_andreflores_;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2P2_AndreFlores_ {

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Object> recursos = new ArrayList<>();
        usuarios.add(new Usuario("estudiante", "contraest", "estudiante"));
        usuarios.add(new Usuario("profe", "contraprofe", "profesor"));
        usuarios.add(new Usuario("bibliotecario", "contrabibliotecario", "bibliotecario"));

        Scanner entrada = new Scanner(System.in);

        Usuario usuarioActual = null;

        System.out.println("Inicio de sesion:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        System.out.print("Contraseña: ");
        String contrasenia = entrada.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                usuarioActual = usuario;
                break;
            }
        }
        if (usuarioActual == null) {
            System.out.println("Inicio de sesion fallido. Usuario o contrasenia incorrectos.");
            return;
        }

        System.out.println("Inicio de sesion exitoso como " + usuarioActual.getTipoUsuario());

        int opcion = 0;

        do {
            if (usuarioActual.getTipoUsuario().equals("estudiante")) {
                System.out.println("1. Listar Recursos");
            } else if (usuarioActual.getTipoUsuario().equals("profesor")) {
                System.out.println("1. Listar Recursos\n2. Crear Recurso");
            } else {
                System.out.println("1. Listar Recursos\n2. Crear Recurso\n3. Eliminar Recurso\n4. Modificar Recurso");
            }

            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Listar recursos");
                    for (Object recurso : recursos) {
                        System.out.println(recurso);
                        listarRecursos(recursos);
                    }
                    break;
                case 2:
                    System.out.println("Crear recursos");
                    break;
                case 3:
                    if (usuarioActual.getTipoUsuario().equals("bibliotecario")) {
                        System.out.println("Eliminar recurso");
                    } else {
                        System.out.println("Acceso no autorizado.");
                    }
                    break;
                case 4:
                    if (usuarioActual.getTipoUsuario().equals("bibliotecario")) {
                        System.out.println("Modificar recurso");
                    } else {
                        System.out.println("Acceso no autorizado.");

                    }

                    break;
                case 5:
                    System.out.println("salir");
                    break;
                default:
                    System.out.println("opcion no valida");
                    break;

            } // fin switch

        } while (opcion != 5);// fin do
    }

    private static void listarRecursos(ArrayList<Object> recursos) {
        if (recursos.isEmpty()){
            System.out.println("no hay recursos disponibles");
        }else{
            System.out.println("recursos disponibles:");
            for (Object recurso : recursos) {
                System.out.println(recurso);
                
            }
        }
     {
            
        }
    }
}
