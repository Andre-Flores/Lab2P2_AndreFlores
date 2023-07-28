package lab2p2_andreflores;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab2P2_AndreFlores {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String gerenteUser = "gerente";
        String gerenteContrasenia = "g3r$nt0";
        System.out.println("Bienvenido al sistema, gerente");
        System.out.println("ingrese el usuario: ");
        String user = entrada.nextLine();
        System.out.println(" ingrese la contrasenia: ");
        String contra = entrada.nextLine();
        if (user.equalsIgnoreCase(gerenteUser) && contra.equalsIgnoreCase(gerenteContrasenia)) {
            System.out.println("ingreso exitoso, gerente.");
            int opcion;
            do {
                System.out.println("Seleccione una Opcion:");
                System.out.println("1. Chefs");
                System.out.println("2. Meseros");
                System.out.println("3. Bartenders");
                System.out.println("4. Mesas");
                System.out.println("0. Salir");
                opcion = entrada.nextInt();
                entrada.nextLine();
                switch (opcion) {
                    case 1:
                        adminChefs();
                        break;
                    case 2:
                        adminMeseros();
                        break;
                    case 3:
                        adminBartender();
                        break;
                    case 4:
                        adminMesas();
                        break;
                    case 0:
                        System.out.println("Cerrando el sistema de administracion.");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } while (opcion != 0);
        } else {
            System.out.println("Usuario o contraseña incorrectos. Cierre del programa.");
        }
    }
    public static ArrayList<ClassChefs> chefs = new ArrayList<>();
    public static ArrayList<ClassMeseros> meseros = new ArrayList<>();
    public static ArrayList<ClassBartender> bartenders = new ArrayList<>();
    public static ArrayList<ClassMesa> mesas = new ArrayList<>();

    public static void adminChefs() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu Chefs:");
            System.out.println("1. Crear Chef");
            System.out.println("2. Modificar Chef");
            System.out.println("3. Eliminar Chef");
            System.out.println("4. Listar Chefs");
            System.out.println("0. Regresar al Menu principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearChef();
                    break;
                case 2:
                    modificarChef();
                    break;
                case 3:
                    eliminarChef();
                    break;
                case 4:
                    listarChefs();
                    break;
                case 0:
                    System.out.println("Regresando al Menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);

    }

    public static void crearChef() {
        Scanner scanner = new Scanner(System.in);
        if (chefs.size() >= 14) {
            System.out.println("No se puede agregar mas chefs. Se ha alcanzado el limite maximo.");
            return;
        }

        System.out.println("Ingrese el Nombre del Chef:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la Edad del Chef:");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el Turno del Chef (matutino/despertino):");
        String turno = scanner.nextLine();
        if (turno.equalsIgnoreCase("matutino")) {
            if (getNumChefsMatutino() >= 7) {
                System.out.println("No se puede agregar mas chefs en el turno matutino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else if (turno.equalsIgnoreCase("vespertino")) {
            if (getNumChefsVespertino() >= 7) {
                System.out.println("No se puede agregar mas chefs en el turno vespertino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else {
            System.out.println("El turno ingresado no es valido.");
            return;
        }
        System.out.println("Ingrese el Numero de Estrellas Michelin del Chef:");
        int numEstrellasMichelin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el Sueldo del Chef:");
        double sueldo = scanner.nextDouble();

        ClassChefs chef = new ClassChefs(nombre, edad, turno, numEstrellasMichelin, sueldo);
        chefs.add(chef);
        System.out.println("Chef creado exitosamente.");
    }

    public static void modificarChef() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Chef a modificar:");
        String nombre = scanner.nextLine();
        ClassChefs chefEncontrado = buscarChefPorNombre(nombre);

        if (chefEncontrado != null) {
            System.out.println("Ingrese la nueva Edad del Chef:");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nuevo Turno del Chef (matutino/despertino):");
            String turno = scanner.nextLine();
            if (turno.equalsIgnoreCase("matutino")) {
                if (!chefEncontrado.getTurno().equalsIgnoreCase("matutino") && getNumChefsMatutino() >= 7) {
                    System.out.println("No se puede cambiar el turno a matutino. Se ha alcanzado el limite maximo de chefs en este turno.");
                    return;
                }
            } else if (turno.equalsIgnoreCase("vespertino")) {
                if (!chefEncontrado.getTurno().equalsIgnoreCase("vespertino") && getNumChefsVespertino() >= 7) {
                    System.out.println("No se puede cambiar el turno a vespertino. Se ha alcanzado el limite maximo de chefs en este turno.");
                    return;
                }
            } else {
                System.out.println("El turno ingresado no es valido.");
                return;
            }
            System.out.println("Ingrese el nuevo Numero de Estrellas Michelin del Chef:");
            int numEstrellasMichelin = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nuevo Sueldo del Chef:");
            double sueldo = scanner.nextDouble();

            chefEncontrado.setEdad(edad);
            chefEncontrado.setTurno(turno);
            chefEncontrado.setNumEstrellasMichelin(numEstrellasMichelin);
            chefEncontrado.setSueldo(sueldo);

            System.out.println("Chef modificado exitosamente.");
        } else {
            System.out.println("Chef no encontrado.");
        }
    }

    public static void eliminarChef() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Chef a eliminar:");
        String nombre = scanner.nextLine();
        ClassChefs chefEncontrado = buscarChefPorNombre(nombre);

        if (chefEncontrado != null) {
            chefs.remove(chefEncontrado);
            System.out.println("Chef eliminado exitosamente.");
        } else {
            System.out.println("Chef no encontrado.");
        }
    }

    public static void listarChefs() {
        if (chefs.isEmpty()) {
            System.out.println("No hay chefs registrados.");
        } else {
            System.out.println("Listado de Chefs:");
            for (ClassChefs chef : chefs) {
                System.out.println(chef);
            }
        }
    }

    public static ClassChefs buscarChefPorNombre(String nombre) {
        for (ClassChefs chef : chefs) {
            if (chef.getNombre().equalsIgnoreCase(nombre)) {
                return chef;
            }
        }
        return null;
    }

    public static int getNumChefsMatutino() {
        int numChefsMatutino = 0;
        for (ClassChefs chef : chefs) {
            if (chef.getTurno().equalsIgnoreCase("matutino")) {
                numChefsMatutino++;
            }
        }
        return numChefsMatutino;
    }

    public static int getNumChefsVespertino() {
        int numChefsVespertino = 0;
        for (ClassChefs chef : chefs) {
            if (chef.getTurno().equalsIgnoreCase("vespertino")) {
                numChefsVespertino++;
            }
        }
        return numChefsVespertino;
    }

    public static void adminMeseros() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu Meseros:");
            System.out.println("1. Crear Mesero");
            System.out.println("2. Modificar Mesero");
            System.out.println("3. Eliminar Mesero");
            System.out.println("4. Listar Meseros");
            System.out.println("0. Regresar al Menu principal");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    crearMesero();
                    break;
                case 2:
                    modificarMesero();
                    break;
                case 3:
                    eliminarMesero();
                    break;
                case 4:
                    listarMeseros();
                    break;
                case 0:
                    System.out.println("Regresando al Menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void crearMesero() {
        Scanner scanner = new Scanner(System.in);
        if (meseros.size() >= 8) {
            System.out.println("No se puede agregar mas meseros. Se ha alcanzado el limite maximo.");
            return;
        }

        System.out.println("Ingrese el Nombre del Mesero:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la Edad del Mesero:");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el Turno del Mesero (matutino/despertino):");
        String turno = scanner.nextLine();
        if (turno.equalsIgnoreCase("matutino")) {
            if (getNumMeserosMatutino() >= 4) {
                System.out.println("No se puede agregar mas meseros en el turno matutino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else if (turno.equalsIgnoreCase("vespertino")) {
            if (getNumMeserosVespertino() >= 4) {
                System.out.println("No se puede agregar mas meseros en el turno vespertino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else {
            System.out.println("El turno ingresado no es valido.");
            return;
        }
        System.out.println("Ingrese el Sueldo del Mesero:");
        double sueldo = scanner.nextDouble();
        System.out.println("Ingrese la Propina del Mesero:");
        double propina = scanner.nextDouble();

        ClassMeseros mesero = new ClassMeseros(nombre, edad, turno, sueldo, propina);
        meseros.add(mesero);
        System.out.println("Mesero creado exitosamente.");
    }

    public static void modificarMesero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Mesero a modificar:");
        String nombre = scanner.nextLine();
        ClassMeseros meseroEncontrado = buscarMeseroPorNombre(nombre);

        if (meseroEncontrado != null) {
            System.out.println("Ingrese la nueva Edad del Mesero:");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nuevo Turno del Mesero (matutino/despertino):");
            String turno = scanner.nextLine();
            if (turno.equalsIgnoreCase("matutino")) {
                if (!meseroEncontrado.getTurno().equalsIgnoreCase("matutino") && getNumMeserosMatutino() >= 4) {
                    System.out.println("No se puede cambiar el turno a matutino. Se ha alcanzado el limite maximo de meseros en este turno.");
                    return;
                }
            } else if (turno.equalsIgnoreCase("vespertino")) {
                if (!meseroEncontrado.getTurno().equalsIgnoreCase("vespertino") && getNumMeserosVespertino() >= 4) {
                    System.out.println("No se puede cambiar el turno a vespertino. Se ha alcanzado el limite maximo de meseros en este turno.");
                    return;
                }
            } else {
                System.out.println("El turno ingresado no es valido.");
                return;
            }
            System.out.println("Ingrese el nuevo Sueldo del Mesero:");
            double sueldo = scanner.nextDouble();
            System.out.println("Ingrese la nueva Propina del Mesero:");
            double propina = scanner.nextDouble();

            meseroEncontrado.setEdad(edad);
            meseroEncontrado.setTurno(turno);
            meseroEncontrado.setSueldo(sueldo);
            meseroEncontrado.setPropina(propina);

            System.out.println("Mesero modificado exitosamente.");
        } else {
            System.out.println("Mesero no encontrado.");
        }
    }

    public static void eliminarMesero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Mesero a eliminar:");
        String nombre = scanner.nextLine();
        ClassMeseros meseroEncontrado = buscarMeseroPorNombre(nombre);

        if (meseroEncontrado != null) {
            meseros.remove(meseroEncontrado);
            System.out.println("Mesero eliminado exitosamente.");
        } else {
            System.out.println("Mesero no encontrado.");
        }
    }

    public static void listarMeseros() {
        if (meseros.isEmpty()) {
            System.out.println("No hay meseros registrados.");
        } else {
            System.out.println("Listado de Meseros:");
            for (ClassMeseros mesero : meseros) {
                System.out.println(mesero);
            }
        }
    }

    public static ClassMeseros buscarMeseroPorNombre(String nombre) {
        for (ClassMeseros mesero : meseros) {
            if (mesero.getNombre().equalsIgnoreCase(nombre)) {
                return mesero;
            }
        }
        return null;
    }

    public static int getNumMeserosMatutino() {
        int numMeserosMatutino = 0;
        for (ClassMeseros mesero : meseros) {
            if (mesero.getTurno().equalsIgnoreCase("matutino")) {
                numMeserosMatutino++;
            }
        }
        return numMeserosMatutino;
    }

    public static int getNumMeserosVespertino() {
        int numMeserosVespertino = 0;
        for (ClassMeseros mesero : meseros) {
            if (mesero.getTurno().equalsIgnoreCase("vespertino")) {
                numMeserosVespertino++;
            }
        }
        return numMeserosVespertino;

    }

    public static void adminBartender() {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu Bartenders:");
            System.out.println("1. Crear Bartender");
            System.out.println("2. Modificar Bartender");
            System.out.println("3. Eliminar Bartender");
            System.out.println("4. Listar Bartenders");
            System.out.println("0. Regresar al Menu principal");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    crearBartender();
                    break;
                case 2:
                    modificarBartender();
                    break;
                case 3:
                    eliminarBartender();
                    break;
                case 4:
                    listarBartenders();
                    break;
                case 0:
                    System.out.println("Regresando al Menu principal.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);
    }

    static void crearBartender() {
        Scanner entrada = new Scanner(System.in);
        if (bartenders.size() >= 4) {
            System.out.println("No se puede agregar mas bartenders. Se ha alcanzado el limite maximo.");
            return;
        }

        System.out.println("Ingrese el Nombre del Bartender:");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese la Edad del Bartender:");
        int edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese el Turno del Bartender (matutino/despertino):");
        String turno = entrada.nextLine();
        if (turno.equalsIgnoreCase("matutino")) {
            if (getNumBartendersMatutino() >= 2) {
                System.out.println("No se puede agregar mas bartenders en el turno matutino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else if (turno.equalsIgnoreCase("vespertino")) {
            if (getNumBartendersVespertino() >= 2) {
                System.out.println("No se puede agregar mas bartenders en el turno vespertino. Se ha alcanzado el limite maximo.");
                return;
            }
        } else {
            System.out.println("El turno ingresado no es valido.");
            return;
        }
        System.out.println("Ingrese el Sueldo del Bartender:");
        double sueldo = entrada.nextDouble();
        int numLicoresDisponibles;
        System.out.println("Ingrese el Numero de Licores Disponibles del Bartender:");
        numLicoresDisponibles = entrada.nextInt();

        if (numLicoresDisponibles <= 0) {
            System.out.println("Necesita tener al menos 1 Licor para ser bartender");
        } else {

        }
        ClassBartender bartender = new ClassBartender(nombre, edad, turno, sueldo, numLicoresDisponibles);

        bartenders.add(bartender);

        System.out.println(
                "Bartender creado exitosamente.");
    }

    static void modificarBartender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Bartender a modificar:");
        String nombre = scanner.nextLine();
        ClassBartender bartenderEncontrado = buscarBartenderPorNombre(nombre);

        if (bartenderEncontrado != null) {
            System.out.println("Ingrese la nueva Edad del Bartender:");
            int edad = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingrese el nuevo Turno del Bartender (matutino/despertino):");
            String turno = scanner.nextLine();
            if (turno.equalsIgnoreCase("matutino")) {
                if (!bartenderEncontrado.getTurno().equalsIgnoreCase("matutino") && getNumBartendersMatutino() >= 2) {
                    System.out.println("No se puede cambiar el turno a matutino. Se ha alcanzado el limite maximo de bartenders en este turno.");
                    return;
                }
            } else if (turno.equalsIgnoreCase("vespertino")) {
                if (!bartenderEncontrado.getTurno().equalsIgnoreCase("vespertino") && getNumBartendersVespertino() >= 2) {
                    System.out.println("No se puede cambiar el turno a vespertino. Se ha alcanzado el limite maximo de bartenders en este turno.");
                    return;
                }
            } else {
                System.out.println("El turno ingresado no es valido.");
                return;
            }
            System.out.println("Ingrese el nuevo Sueldo del Bartender:");
            double sueldo = scanner.nextDouble();
            System.out.println("Ingrese el nuevo Numero de Licores Disponibles del Bartender:");
            int numLicoresDisponibles = scanner.nextInt();

            bartenderEncontrado.setEdad(edad);
            bartenderEncontrado.setTurno(turno);
            bartenderEncontrado.setSueldo(sueldo);
            bartenderEncontrado.setNumLicoresDisponibles(numLicoresDisponibles);

            System.out.println("Bartender modificado exitosamente.");
        } else {
            System.out.println("Bartender no encontrado.");
        }
    }

    public static void eliminarBartender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Nombre del Bartender a eliminar:");
        String nombre = scanner.nextLine();
        ClassBartender bartenderEncontrado = buscarBartenderPorNombre(nombre);

        if (bartenderEncontrado != null) {
            bartenders.remove(bartenderEncontrado);
            System.out.println("Bartender eliminado exitosamente.");
        } else {
            System.out.println("Bartender no encontrado.");
        }
    }

    public static void listarBartenders() {
        if (bartenders.isEmpty()) {
            System.out.println("No hay bartenders registrados.");
        } else {
            System.out.println("Listado de Bartenders:");
            for (ClassBartender bartender : bartenders) {
                System.out.println(bartender);
            }
        }
    }

    public static ClassBartender buscarBartenderPorNombre(String nombre) {
        for (ClassBartender bartender : bartenders) {
            if (bartender.getNombre().equalsIgnoreCase(nombre)) {
                return bartender;
            }
        }
        return null;
    }

    public static int getNumBartendersMatutino() {
        int numBartendersMatutino = 0;
        for (ClassBartender bartender : bartenders) {
            if (bartender.getTurno().equalsIgnoreCase("matutino")) {
                numBartendersMatutino++;
            }
        }
        return numBartendersMatutino;
    }

    public static int getNumBartendersVespertino() {
        int numBartendersVespertino = 0;
        for (ClassBartender bartender : bartenders) {
            if (bartender.getTurno().equalsIgnoreCase("vespertino")) {
                numBartendersVespertino++;
            }
        }
        return numBartendersVespertino;

    }

    static void adminMesas() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu Mesas:");
            System.out.println("1. Crear Mesa");
            System.out.println("2. Modificar Mesa");
            System.out.println("3. Eliminar Mesa");
            System.out.println("4. Listar Mesas");
            System.out.println("0. Regresar al menu principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearMesa();
                    break;
                case 2:
                    modificarMesa();
                    break;
                case 3:
                    eliminarMesa();
                    break;
                case 4:
                    listarMesas();
                    break;
                case 0:
                    System.out.println("Regresando al menu principal.");
                    break;
                default:
                    System.out.println("Opción no valida.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void crearMesa() {
        Scanner scanner = new Scanner(System.in);
        if (mesas.size() >= 10) {
            System.out.println("No se puede agregar mas mesas. Se ha alcanzado el limite maximo.");
            return;
        }

        System.out.println("Ingrese el Numero de Platos de la Mesa:");
        int numPlatos = scanner.nextInt();
        System.out.println("Ingrese el Numero de Utensilios de la Mesa:");
        int numUtensilios = scanner.nextInt();
        System.out.println("Ingrese el Precio Total de la Mesa:");
        double precioTotal = scanner.nextDouble();

        ClassMesa mesa = new ClassMesa(numPlatos, numUtensilios, precioTotal);
        mesas.add(mesa);
        System.out.println("Mesa creada exitosamente.");
    }

    public static void modificarMesa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Numero de Platos de la Mesa a modificar:");
        int numPlatos = entrada.nextInt();
        System.out.println("Ingrese el Numero de Utensilios de la Mesa a modificar:");
        int numUtensilios = entrada.nextInt();
        ClassMesa mesaEncontrada = buscarMesaPorPlatosYUtensilios(numPlatos, numUtensilios);

        if (mesaEncontrada != null) {
            System.out.println("Ingrese el nuevo Numero de Platos de la Mesa:");
            int nuevoNumPlatos = entrada.nextInt();
            System.out.println("Ingrese el nuevo Numero de Utensilios de la Mesa:");
            int nuevoNumUtensilios = entrada.nextInt();
            System.out.println("Ingrese el nuevo Precio Total de la Mesa:");
            double nuevoPrecioTotal = entrada.nextDouble();

            mesaEncontrada.setNumPlatos(nuevoNumPlatos);
            mesaEncontrada.setNumUtensilios(nuevoNumUtensilios);
            mesaEncontrada.setPrecioTotal(nuevoPrecioTotal);

            System.out.println("Mesa modificada exitosamente.");
        } else {
            System.out.println("Mesa no encontrada.");
        }
    }

    static void eliminarMesa() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el Numero de Platos de la Mesa a eliminar:");
        int numPlatos = entrada.nextInt();
        System.out.println("Ingrese el Numero de Utensilios de la Mesa a eliminar:");
        int numUtensilios = entrada.nextInt();
        ClassMesa mesaEncontrada = buscarMesaPorPlatosYUtensilios(numPlatos, numUtensilios);

        if (mesaEncontrada != null) {
            mesas.remove(mesaEncontrada);
            System.out.println("Mesa eliminada exitosamente.");
        } else {
            System.out.println("Mesa no encontrada.");
        }
    }

    public static void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas registradas.");
        } else {
            System.out.println("Listado de Mesas:");
            for (ClassMesa mesa : mesas) {
                System.out.println(mesa);
            }
            double sumaTotal = 0;
            for (ClassMesa mesa : mesas) {
                sumaTotal += mesa.getPrecioTotal();
            }
            System.out.println("Suma del Precio Total de todas las Mesas: " + sumaTotal);
        }
    }

    public static ClassMesa buscarMesaPorPlatosYUtensilios(int numPlatos, int numUtensilios) {
        for (ClassMesa mesa : mesas) {
            if (mesa.getNumPlatos() == numPlatos && mesa.getNumUtensilios() == numUtensilios) {
                return mesa;
            }
        }
        return null;
    }
} // fin classes
