package Main;

import java.util.Arrays;
import java.util.Scanner;

import Clases.*;

public class main{
    public static void main(String[] args){

        Scanner inp = new Scanner(System.in);
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("|                             BIENVENIDO                           |");
        System.out.println("|                        1. Agregar Usuario                        |");
        System.out.println("|                        2. Buscar Usuario                         |");
        System.out.println("|                        3. Eliminar Usuario                       |");
        System.out.println("|                        4. Salir                                  |");
        System.out.println(" ------------------------------------------------------------------");
        System.out.println("Opción:");
        int opc = inp.nextInt();


        switch(opc){

            case 1:
                agregarUsuario();
                break;

            case 2:
            	break;

            case 3:
               	 break;

            case 4:
            	System.out.println("Ha finalizado.");
            	break;
   		 }

         inp.close();

	}

    public static void agregarUsuario() {

        Scanner scanner = new Scanner(System.in);
        int maxUsuarios = 5;
        Usuario[] usuarios = new Usuario[maxUsuarios];

        int numUsuarios = 0;

        while (numUsuarios < maxUsuarios) {
            System.out.println("Ingrese los datos del Usuario " + (numUsuarios + 1));

            System.out.println("ID: ");
            long id = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.println("Fecha de Nacimiento (dd mm aa): ");
            int dd = scanner.nextInt();
            int mm = scanner.nextInt();
            int aa = scanner.nextInt();
            scanner.nextLine();
            Fecha fechaNac = new Fecha(dd, mm, aa);

            System.out.println("Ciudad de Nacimiento: ");
            String ciudadNac = scanner.nextLine();

            System.out.println("Datos de la Dirección:");
            System.out.println("Calle: ");
            String calle = scanner.nextLine();

            System.out.println("Número de Calle: ");
            int noCalle = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Nomenclatura: ");
            String nomenclatura = scanner.nextLine();

            System.out.println("Barrio: ");
            String barrio = scanner.nextLine();

            System.out.println("Ciudad: ");
            String ciudadDir = scanner.nextLine();

            Direccion direccion = new Direccion(calle, noCalle, nomenclatura, barrio, ciudadDir);

            System.out.println("Teléfono: ");
            long tel = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Email: ");
            String email = scanner.nextLine();

            usuarios[numUsuarios] = new Usuario(id, nombre, fechaNac, ciudadNac, direccion, tel, email);
            numUsuarios++;

            System.out.println("¿Desea ingresar otro usuario? (S/N): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("S")) {
                
                Arrays.sort(usuarios, 0, numUsuarios);
                for (int i = 0; i < numUsuarios; i++) {
                    System.out.println("Usuario " + (i + 1) + ": " + usuarios[i].getNombre());
                    System.out.println("ID " + (i + 1) + ": " + usuarios[i].getId());

                }

            break;

            }
        }
    }
}