/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class Estudiante extends UsuarioAcademico implements Calculable{


// Carrera del estudiante
private String carrera; 

// Notas del estudiante
private double nota1; 
private double nota2;
private double nota3;


// Constructor de la clase estudiante
public Estudiante(String carrera, double nota1, double nota2, double nota3, String nombre, String id) {
    
    // Se llama al constructor de la clase padre
    super(nombre, id);
    
    this.carrera = carrera;
    this.nota1 = nota1;
    this.nota2 = nota2;
    this.nota3 = nota3;
}



// Método para calcular el promedio
public double calcularPromedio(){
   
    return (nota1 + nota2 + nota3)/3; 
}



// Método para obtener el estado del estudiante
public String obtenerEstado(){
    
   // Si el promedio es mayor o igual a 3 aprueba
   if(calcularPromedio() >=3 ){
       return "Aprobado"; 
   }
   
   // Si no cumple la condición reprueba
   return "Reprobado"; 
}



// Método toString para mostrar información del estudiante
@Override
public String toString() {
    
    StringBuilder sb = new StringBuilder();
    
    sb.append("Estudiante{");
    sb.append(" nombre= ").append(getNombre());
    sb.append(" codigo= ").append(getId());
    sb.append(" carrera= ").append(carrera);
    sb.append(", nota1= ").append(nota1);
    sb.append(", nota2= ").append(nota2);
    sb.append(", nota3= ").append(nota3);
    sb.append(", promedio= ").append(getPromedio());
    sb.append(", Estado= ").append(getEstado());
    sb.append('}');
    
    return sb.toString();
}



// Getter de carrera
public String getCarrera() {
    return carrera;
}


// Getter de nota 1
public double getNota1() {
    return nota1;
}


// Getter del promedio
public double getPromedio(){
    return calcularPromedio();
}


// Getter del estado
public String getEstado(){
    return obtenerEstado(); 
}


// Getter de nota 2
public double getNota2() {
    return nota2;
}


// Getter de nota 3
public double getNota3() {
    return nota3;
}



// Setter de carrera
public void setCarrera(String carrera) {
    this.carrera = carrera;
}


// Setter de nota 1
public void setNota1(double nota1) {
    this.nota1 = nota1;
}


// Setter de nota 2
public void setNota2(double nota2) {
    this.nota2 = nota2;
}


// Setter de nota 3
public void setNota3(double nota3) {
    this.nota3 = nota3;
}


}
