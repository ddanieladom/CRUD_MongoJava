package bdn_mdbj_act6;

import java.util.Scanner;

/**
 * @author DANIELA
 */
public class BDN_MDBJ_Act6 {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        Scanner lector = new Scanner(System.in);
        String nombre, nombre_n, tipo, tipo_n;
        int edad, edad_n;
        /* con.mostrar();
        System.out.println("");
        con.actualizar("yuki", "gato", 3, "Nora", "gato", 3);
         */
        con.mostrar();
        int op = 0;
        do {
            menu();
            op = lector.nextInt();

            switch (op) {
                case 1:
                    con.mostrar();
                    break;
                case 2:
                    System.out.println("Ingrese el nombre");
                    nombre = lector.next();
                    System.out.println("Ingrese el tipo");
                    tipo = lector.next();
                    System.out.println("Ingrese la edad");
                    edad = lector.nextInt();
                    con.insertar(nombre, tipo, edad);
                    con.mostrar();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la mascota a eliminar");
                    nombre = lector.next();
                    System.out.println("Ingrese el tipo");
                    tipo = lector.next();
                    System.out.println("Ingrese la edad");
                    edad = lector.nextInt();
                    con.eliminar(nombre, tipo, edad);
                    con.mostrar();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre antiguo de la mascota");
                    nombre = lector.next();
                    System.out.println("Ingrese el tipo");
                    tipo = lector.next();
                    System.out.println("Ingrese la edad");
                    edad = lector.nextInt();

                    System.out.println("\n Ingrese el nombre nuevo");
                    nombre_n = lector.next();
                    System.out.println("Ingrese el tipo");
                    tipo_n = lector.next();
                    System.out.println("Ingrese la edad");
                    edad_n = lector.nextInt();
                    con.actualizar(nombre, tipo, edad, nombre_n, tipo_n, edad_n);

                    con.mostrar();
                    break;
                default:
                    System.err.println("Opción incorrecto");

            }
        } while (op != 0);

        con.mostrar();
    }

    public static void menu() {
        System.out.println("\nGetion de Mascotas ▼°ᴥ°▼");
        System.out.println("Seleccione la opción \n "
                + "1.-Mostrar mascotas"
                + "\n 2.-Agregar mascota"
                + "\n 3.-Eliminar mascota"
                + "\n 4.-Modificar mascota"
                + "\n");
    }

}
