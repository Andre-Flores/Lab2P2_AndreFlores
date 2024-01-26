package lab2p2_andreflores_;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                    crearRecurso(recursos);
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
        if (recursos.isEmpty()) {
            System.out.println("no hay recursos disponibles");
        } else {
            System.out.println("recursos disponibles:");
            for (Object recurso : recursos) {
                System.out.println(recurso);

            }
        }

    }

    private static void crearRecurso(ArrayList<Object> recursos) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Seleccione el tipo de recurso a crear:");
        System.out.println("1. Libro\n2. Articulo\n3. Curso en linea\n4. Conferencia Virtual");
        System.out.print("Ingrese el numero correspondiente al tipo de recurso: ");
        int tipoRecurso = entrada.nextInt();

        switch (tipoRecurso) {
            case 1:
                System.out.println("Ingrese el titulo del libro:");
                String tituloLibro = entrada.nextLine();
                tituloLibro = entrada.nextLine();

                System.out.println("Ingrese el autor del libro:");
                String autorLibro = entrada.nextLine();

                System.out.println("Ingrese el genero del libro:");
                String generoLibro = entrada.nextLine();

                System.out.println("Ingrese el ano de publicacion del libro:");

                String fechaStr = entrada.nextLine();

                System.out.println("El libro tiene acceso en linea? (true/false):");
                boolean accesoEnLineaLibro = entrada.nextBoolean();

                recursos.add(new Libro(tituloLibro, autorLibro, generoLibro, autorLibro, accesoEnLineaLibro));
                break;

            case 2:
                System.out.println("Ingrese el titulo del articulo:");
                String tituloArticulo = entrada.nextLine();
                tituloArticulo = entrada.nextLine();

                System.out.println("Ingrese el autor del articulo:");
                String autorArticulo = entrada.nextLine();

                System.out.println("Ingrese el tema del articulo:");
                String temaArticulo = entrada.nextLine();

                Date fechaPublicacionArticulo = new Date();

                System.out.println("El articulo tiene acceso en linea? (true/false):");
                boolean accesoEnLineaArticulo = entrada.nextBoolean();

                recursos.add(new Articulos(tituloArticulo, autorArticulo, temaArticulo, fechaPublicacionArticulo, accesoEnLineaArticulo));
                break;

            case 3:
                System.out.println("Ingrese el titulo del curso en linea:");
                String tituloCurso = entrada.nextLine();
                tituloCurso = entrada.nextLine();

                System.out.println("Ingrese el instructor del curso en linea:");
                String instructorCurso = entrada.nextLine();

                System.out.println("Ingrese la duracion en semanas del curso en linea:");
                int duracionSemanasCurso = entrada.nextInt();

                System.out.println("Ingrese la plataforma de ensenanza del curso en linea:");
                String plataformaEnsenanzaCurso = entrada.nextLine();

                recursos.add(new CursosenLinea(tituloCurso, instructorCurso, duracionSemanasCurso, plataformaEnsenanzaCurso));
                break;

            case 4:
                System.out.println("Ingrese el titulo de la conferencia virtual:");
                String tituloConferencia = entrada.nextLine();
                tituloConferencia = entrada.nextLine();

                System.out.println("Ingrese el conferencista de la conferencia virtual:");
                String conferencistaConferencia = entrada.nextLine();

                System.out.println("Ingrese la duracion de la conferencia virtual:");
                String duracionConferencia = entrada.nextLine();

                System.out.println("Ingrese el enlace de acceso de la conferencia virtual:");
                String enlaceAccesoConferencia = entrada.nextLine();

                Date fechaConferencia = new Date();

                recursos.add(new conferenciasVirtuales(tituloConferencia, conferencistaConferencia, fechaConferencia, duracionConferencia, enlaceAccesoConferencia));
                break;

            default:
                System.out.println("Opcion no valida.");
                return;
        }

        System.out.println("Recurso creado exitosamente.");
    }
}
