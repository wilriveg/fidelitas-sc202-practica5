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
 * Objeto estudiante, que representa cada uno de los alumnos de la clase.
 */
public class Estudiante {
    private double nota; // la nota del estudiante.
    private String nombre; // el nombre del estudiante.

    
    /**
    * Método constructor
    */
    public Estudiante(double nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }
   
    /**
     * Métodos getters y setters.
     */
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    /**
     * Override del toString() para mostrar la información de forma más clara.
     */
    public String toString(){
        return  "|| Nombre: " + getNombre()
                + " | Nota: " + getNota() + "|| \n";
    }
    
    /**
     * Método para leer notas. Recibe un array vacío de estudiantes y lo devuelve con los valores dados.
     */
    public static Estudiante[] leerNotas(Estudiante[] estudiantes){
        // recorrer el array y rellenar nombre y nota usando JOptionPane.
        for (int i = 0; i<estudiantes.length; i++){
            String nombreEstudiante = JOptionPane.showInputDialog(null, "Escriba el nombre del estudiante # " + (i+1) );
            double notaEstudiante = Double.parseDouble(JOptionPane.showInputDialog(null, "Escriba la nota (0-100) del estudiante #" + (i+1) ));
            // validar que la nota tenga un valor correcto, en caso contrario registrar un 0 para evitar complicar la solución.
            if (notaEstudiante < 0 || notaEstudiante > 100){
                JOptionPane.showMessageDialog(null, "Valor incorrecto para la nota. Se registrará un 0.");
                notaEstudiante = 0;
            }
            estudiantes[i] = new Estudiante (notaEstudiante, nombreEstudiante); // crea el nuevo estudiante, con los valores dados.
        }
        // devuelve con datos.
        return estudiantes;
    }
    
    /**
     * Método para mostrar las notas.
     */
    public static void mostrarNotas(Estudiante[] estudiantes){
        // armar String de estudiantes.
        String listaEstudiantes = "---ESTUDIANTES REGISTRADOS---\n";
        // recorrer el array en busca de la info, para agregarla al String.
        for (int i=0; i<estudiantes.length; i++){
            String estudiante = estudiantes[i].toString();
            listaEstudiantes+=estudiante;
        }
        // mostrar el String con datos.
        JOptionPane.showMessageDialog(null, listaEstudiantes); 
    }
    
    /**
     * Método para calcular promedio de notas, y mostrar estudiantes con nota mayor al promedio.
     */
    public static void calcularPromedio(Estudiante[] estudiantes){
        double sumaNotas = 0.0; // inicializar la sumatoria de notas para cálculo del promedio.
        // recorrer el array para obtener las notas de los estudiantes.
        for (int i=0; i<estudiantes.length; i++){
            double notaEstudiante = estudiantes[i].getNota();
            sumaNotas+=notaEstudiante; // agregar a sumatoria.
            }
        // calcula el promedio (sumatoria entre cantidad de estudiantes).
        double promedio = sumaNotas / estudiantes.length;
        // mostrar el promedio.
        JOptionPane.showMessageDialog(null, "El promedio de notas es de: " + promedio);
        
        // ahora mostrar sólo los estudiantes con nota superior al promedio.
        String estudiantesSuperiorPromedio = "---ESTUDIANTES CON NOTAS SUPERIOR AL PROMEDIO---\n";
        // recorrer el arreglo y comparar la nota de cada estudiante.
        for (int i = 0; i<estudiantes.length; i++){
            if (estudiantes[i].getNota() > promedio){ // si la nota es mayor, agregar al String
                String estudiante = estudiantes[i].toString();
                estudiantesSuperiorPromedio += estudiante;
                }
            }
        // mostrar la lista de estudiantes
        JOptionPane.showMessageDialog(null, estudiantesSuperiorPromedio);
    }
    
    
}
