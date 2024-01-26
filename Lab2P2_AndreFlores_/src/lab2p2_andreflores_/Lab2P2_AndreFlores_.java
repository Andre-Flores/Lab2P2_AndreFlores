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

        int opcionInicioSesion;

        do {
            System.out.println("1. Iniciar sesion\n2. Salir");
            System.out.print("Seleccione una opcion: ");
            opcionInicioSesion = entrada.nextInt();

            switch (opcionInicioSesion) {
                case 1:
                    usuarioActual = iniciarSesion(usuarios, entrada);
                    if (usuarioActual != null) {
                        System.out.println("Inicio de sesion exitoso como " + usuarioActual.getTipoUsuario());
                        menuPrincipal(usuarioActual, recursos, entrada);
                    } else {
                        System.out.println("Inicio de sesion fallido. Usuario o contraseña incorrectos.");
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcionInicioSesion != 2);
    }

    private static Usuario iniciarSesion(ArrayList<Usuario> usuarios, Scanner entrada) {
        System.out.println("Inicio de sesion:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        nombreUsuario = entrada.nextLine();
        System.out.print("Contraseña: ");
        String contrasenia = entrada.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
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

    private static void menuPrincipal(Usuario usuarioActual, ArrayList<Object> recursos, Scanner entrada) {
        int opcion;

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
                    listarRecursos(recursos);
                    break;
                case 2:
                    if (usuarioActual.getTipoUsuario().equals("profesor")) {
                        System.out.println("Crear recurso");
                        crearRecurso(recursos, entrada);
                    } else {
                        System.out.println("Acceso no autorizado.");
                    }
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
                    System.out.println("Saliendo del menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void crearRecurso(ArrayList<Object> recursos, Scanner entrada) {
        System.out.println("Seleccione el tipo de recurso a crear:");
        System.out.println("1. Libro\n2. Articulo\n3. Curso en linea\n4. Conferencia Virtual");
        System.out.print("Ingrese el numero correspondiente al tipo de recurso: ");
        int tipoRecurso = entrada.nextInt();

        switch (tipoRecurso) {
            case 1:
                System.out.println("Ingrese el titulo del libro:");
                entrada.nextLine(); // Limpiar el buffer
                String tituloLibro = entrada.nextLine();

                System.out.println("Ingrese el autor del libro:");
                String autorLibro = entrada.nextLine();

                System.out.println("Ingrese el genero del libro:");
                String generoLibro = entrada.nextLine();

                System.out.println("Ingrese el año de publicacion del libro:");
                String fechaStr = entrada.nextLine();

                System.out.println("El libro tiene acceso en linea? (true/false):");
                boolean accesoEnLineaLibro = entrada.nextBoolean();

                recursos.add(new Libro(tituloLibro, autorLibro, generoLibro, fechaStr, accesoEnLineaLibro));
                break;

            case 2:
                System.out.println("Ingrese el titulo del articulo:");
                entrada.nextLine(); // Limpiar el buffer
                String tituloArticulo = entrada.nextLine();

                System.out.println("Ingrese el autor del articulo:");
                String autorArticulo = entrada.nextLine();

                System.out.println("Ingrese el tema del articulo:");
                String temaArticulo = entrada.nextLine();

                System.out.println("El articulo tiene acceso en linea? (true/false):");
                boolean accesoEnLineaArticulo = entrada.nextBoolean();

                recursos.add(new Articulos(tituloArticulo, autorArticulo, temaArticulo, new Date(), accesoEnLineaArticulo));
                break;

            case 3:
                System.out.println("Ingrese el titulo del curso en linea:");
                entrada.nextLine(); // Limpiar el buffer
                String tituloCurso = entrada.nextLine();

                System.out.println("Ingrese el instructor del curso en linea:");
                String instructorCurso = entrada.nextLine();

                System.out.println("Ingrese la duracion en semanas del curso en linea:");
                int duracionSemanasCurso = entrada.nextInt();

                entrada.nextLine(); // Limpiar el buffer
                System.out.println("Ingrese la plataforma de enseñanza del curso en linea:");
                String plataformaEnsenanzaCurso = entrada.nextLine();

                recursos.add(new CursosenLinea(tituloCurso, instructorCurso, duracionSemanasCurso, plataformaEnsenanzaCurso));
                break;

            case 4:
                System.out.println("Ingrese el titulo de la conferencia virtual:");
                entrada.nextLine(); // Limpiar el buffer
                String tituloConferencia = entrada.nextLine();

                System.out.println("Ingrese el conferencista de la conferencia virtual:");
                String conferencistaConferencia = entrada.nextLine();

                System.out.println("Ingrese la duracion de la conferencia virtual:");
                entrada.nextLine(); // Limpiar el buffer
                String duracionConferencia = entrada.nextLine();

                System.out.println("Ingrese el enlace de acceso de la conferencia virtual:");
                String enlaceAccesoConferencia = entrada.nextLine();

                recursos.add(new conferenciasVirtuales(tituloConferencia, conferencistaConferencia, new Date(), duracionConferencia, enlaceAccesoConferencia));
                break;

            default:
                System.out.println("Opcion no valida.");
                return;
        }

        System.out.println("Recurso creado exitosamente.");
    }
}
