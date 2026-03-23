package ejercicio5.wilton.r;

import javax.swing.JOptionPane;

/**
 * Generar dos matrices con números aleatorios sin repetir,
 * intercambiar el mínimo de A con el máximo de B
 * y mostrar resultados antes y después.
 * 
 * @author Wilton Rivera
 */
public class Ejercicio2WiltonR {

    public static void main(String[] args) {
        ejercicio2();
    }

    public static void ejercicio2() {

        // Solicita la cantidad de repeticiones del proceso
        int repeticiones = Integer.parseInt(
                JOptionPane.showInputDialog("Cantidad de repeticiones:")
        );

        // Ciclo para repetir el proceso N veces
        for (int r = 1; r <= repeticiones; r++) {

            // Solicitar dimensiones de las matrices
            int filas = Integer.parseInt(JOptionPane.showInputDialog("Filas:"));
            int columnas = Integer.parseInt(JOptionPane.showInputDialog("Columnas:"));

            // Validación: evitar más de 70 números 
            if (filas * columnas * 2 > 70) {
                JOptionPane.showMessageDialog(null,
                        "Demasiados espacios para no repetir números");
                r--; // Reintenta la repetición
                continue;
            }

            // Declaración de matrices
            int[][] A = new int[filas][columnas];
            int[][] B = new int[filas][columnas];

            // Llenar matrices con números aleatorios sin repetir
            llenarMatriz(A, B);
            llenarMatriz(B, A);

            // Guardar estado inicial de las matrices
            String aAntes = mostrar(A);
            String bAntes = mostrar(B);

            //  BUSCAR MÍNIMO EN A 
            int min = A[0][0];
            int fMin = 0, cMin = 0;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (A[i][j] < min) {
                        min = A[i][j];
                        fMin = i;
                        cMin = j;
                    }
                }
            }

            // BUSCAR MÁXIMO EN B 
            int max = B[0][0];
            int fMax = 0, cMax = 0;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (B[i][j] > max) {
                        max = B[i][j];
                        fMax = i;
                        cMax = j;
                    }
                }
            }

            // INTERCAMBIO 
            int temp = A[fMin][cMin];
            A[fMin][cMin] = B[fMax][cMax];
            B[fMax][cMax] = temp;

            // Guardar estado final de las matrices
            String aDespues = mostrar(A);
            String bDespues = mostrar(B);

            // Mostrar resultados
            JOptionPane.showMessageDialog(null,
                    "REPETICIÓN " + r +
                    "\n\nMATRIZ A (ANTES):\n" + aAntes +
                    "\nMATRIZ B (ANTES):\n" + bAntes +
                    "\nMínimo de A: " + min +
                    "\nMáximo de B: " + max +
                    "\n\nMATRIZ A (DESPUÉS):\n" + aDespues +
                    "\nMATRIZ B (DESPUÉS):\n" + bDespues
            );
        }
    }

    /**
     * Llena una matriz con números aleatorios del 1 al 70
     * sin repetir valores ni en esta matriz ni en la otra.
     *
     * @param matriz matriz a llenar
     * @param otra   matriz para validar que no se repitan valores
     */
    public static void llenarMatriz(int[][] matriz, int[][] otra) {
        int num;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                // Generar número aleatorio y validar que no exista
                do {
                    num = (int)(Math.random() * 70) + 1;
                } while (existe(num, matriz) || existe(num, otra));

                matriz[i][j] = num;
            }
        }
    }

    /**
     * Verifica si un número ya existe dentro de una matriz
     *
     * @param num número a buscar
     * @param matriz matriz donde buscar
     * @return true si existe, false si no
     */
    public static boolean existe(int num, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Convierte una matriz en texto formateado para mostrarla
     *
     * @param m matriz a mostrar
     * @return String con formato de tabla
     */
    public static String mostrar(int[][] m) {
        String s = "";

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                s += String.format("%4d", m[i][j]); // Alinea columnas
            }
            s += "\n";
        }

        return s;
    }
}
