/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica5;

import javax.swing.JOptionPane;

/**
 *
 * @author AndrésBaltodano
 */

/**
 * Clase para ejecutar los requerimientos del Ejercicio 3.
 */
public class Ejercicio3 {
    
    /**
    * Método a llamar desde el Menú del programa.
    */
    public static void ejercicioTres(){
        // primero preguntar cuantos estudiantes hay que registrar. '20' como sugerencia de límite.
        byte cantidad = Byte.parseByte(JOptionPane.showInputDialog(null, "Escriba la cantidad de estudiantes del curso: (1-20)"));
        // crear el array con la cantidad dada.
        Estudiante estudiantes[] = new Estudiante[cantidad];
        // ejecutar los métodos usando el array creado.
        Estudiante.leerNotas(estudiantes);
        Estudiante.mostrarNotas(estudiantes);
        Estudiante.calcularPromedio(estudiantes);
    }
    
}
