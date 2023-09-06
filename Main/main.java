package Main;

import java.util.Scanner;

import Clases.*;

public class main {
    public static void main(String[] args) {

        Registro registro = new Registro();
        registro.importar();
        int opc;
        boolean salir = false;
        Scanner inp = new Scanner(System.in);
        while (!salir) {
            System.out.println(" ------------------------------------------------------------------");
            System.out.println("|                             BIENVENIDO                           |");
            System.out.println("|                        1. Agregar Usuario                        |");
            System.out.println("|                        2. Buscar Usuario                         |");
            System.out.println("|                        3. Eliminar Usuario                       |");
            System.out.println("|                        4. Salir                                  |");
            System.out.println(" ------------------------------------------------------------------");

            System.out.print("Opción:");
            opc = inp.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Ingrese los datos del Usuario ");
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Fecha de Nacimiento (dd mm aa): ");
                    int dd = scanner.nextInt();
                    int mm = scanner.nextInt();
                    int aa = scanner.nextInt();
                    scanner.nextLine();
                    Fecha fechaNac = new Fecha(dd, mm, aa);

                    System.out.print("Ciudad de Nacimiento: ");
                    String ciudadNac = scanner.nextLine();

                    System.out.println("Datos de la Dirección:");
                    System.out.print("Calle: ");
                    String calle = scanner.nextLine();

                    System.out.print("Número de Calle: ");
                    int noCalle = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nomenclatura: ");
                    String nomenclatura = scanner.nextLine();

                    System.out.print("Barrio: ");
                    String barrio = scanner.nextLine();

                    System.out.print("Ciudad: ");
                    String ciudadDir = scanner.nextLine();

                    Direccion direccion = new Direccion(calle, noCalle, nomenclatura, barrio, ciudadDir);

                    System.out.print("Teléfono: ");
                    long tel = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario(id, nombre, fechaNac, ciudadNac, direccion, tel, email);

                    if (registro.agregar(usuario)) {
                        System.out.println("Usuario agregado correctamente.");
                    } else {
                        System.out.print("El usuario no pudo ser agregado correctamente.");
                    }
                    break;

                case 2:
                    Scanner buscar = new Scanner(System.in);

                    System.out.print("Ingrese la id del usuario que quiere buscar:");
                
                    long idBuscar = buscar.nextLong();
                    
                    Usuario usuarioEncontrado = registro.buscarUsuario(idBuscar);
                    if (usuarioEncontrado != null) {
                        System.out.println("El usuario fue encontrado correctamente, sus datos son:");
                        System.out.println("ID: " + usuarioEncontrado.getId());
                        System.out.println("Nombre: " + usuarioEncontrado.getNombre());
                        System.out.println("Fecha de Nacimiento: (" + usuarioEncontrado.getFechaNac().getDd() + " "
                                + usuarioEncontrado.getFechaNac().getMm() + " "
                                + usuarioEncontrado.getFechaNac().getAa() + " " + ")");
                        System.out.println("Ciudad de Nacimiento: " + usuarioEncontrado.getCiudadNac());
                        System.out.println("Datos de la Dirección:");
                        System.out.println("Calle: " + usuarioEncontrado.getDir().getCalle());
                        System.out.println("Número de Calle: " + usuarioEncontrado.getDir().getNoCalle());
                        System.out.println("Nomenclatura: " + usuarioEncontrado.getDir().getNomenclatura());
                        System.out.println("Barrio: " + usuarioEncontrado.getDir().getBarrio());
                        System.out.println("Ciudad: " + usuarioEncontrado.getDir().getCiudad());
                        System.out.println("Teléfono: " + usuarioEncontrado.getTel());
                        System.out.println("Email: " + usuarioEncontrado.getEmail());
                    } else {
                        System.out.println("El usuario que intenta buscar no existe.");
                    }
                    
                    break;

                case 3:
                    Scanner eliminar = new Scanner(System.in);
                    System.out.print("Ingrese la id del usuario que quiere eliminar:");
                    long idEliminar = eliminar.nextLong();
                    if (registro.eliminar(idEliminar) != null) {
                        System.out.println("El usuario fue eliminado correctamente.");
                    } else {
                        System.out.println("El usuario que intenta eliminar no existe.");
                    }
                    
                    break;

                case 4:
                    System.out.println("Ha finalizado.");
                    salir = true;
                    break;
            }
        }
        inp.close();
    }
}