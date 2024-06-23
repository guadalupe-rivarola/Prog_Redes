package Archivos;

import java.io.File;
import java.io.PrintStream;

public class main {
    static PrintStream ps = new PrintStream(System.out);

    public static void main(String[] args) {
        Ejercicios ejercicio = new Ejercicios();
        String ruta = "";
        String nombre = "Inventario";
        String extension = ".dat";
        File archivo = new File(ruta.concat(nombre).concat(extension));
        ejercicio.crearArchivo(ruta, nombre, extension);
        boolean continuar = true;

        while (continuar) {
            ps.println(Utils.ANSI_BLUE + "\nMenú:");
            ps.println(Utils.ANSI_BLUE + "1. Agregar producto.");
            ps.println(Utils.ANSI_BLUE + "2. Mostrar productos.");
            ps.println(Utils.ANSI_RED + "3. Salir" + Utils.ANSI_RESET);
            String texto = Ejercicios.leerDatos();
            int opcion;
            try {
                opcion = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                ps.println("Opción no válida. Por favor, intente nuevamente.");
                continue;
            }
            switch (opcion) {
                case 1:
                    ejercicio.escribirArchivo(archivo);
                    break;
                case 2:
                    ejercicio.leerArchivo(archivo);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    ps.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }
    }
}
