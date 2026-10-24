/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public class GestorEstudiante {


// Arreglo donde se guardan los estudiantes
private Estudiante estudiantes[] = new Estudiante[100];

// Contador para saber cuántos estudiantes hay registrados
private int contadorEstudiantes = 0;



// Método para agregar estudiantes al arreglo
public void agregarEstudiante(Estudiante estuddiante) {
    
    // Verifica que todavía haya espacio en el arreglo
    if (contadorEstudiantes < 100) {
        
        // Guarda el estudiante en la posición actual
        estudiantes[contadorEstudiantes] = estuddiante;
        
        // Aumenta el contador
        contadorEstudiantes++;
    }

}



// Método para actualizar un estudiante
public void actualizarEstudiante(Estudiante estudiante) {
    
    // Busca la posición del estudiante usando el código
    int posicion = buscarPosicion(estudiante.getId());
    
    // Si existe se reemplaza por el nuevo objeto
    if (posicion != -1) {
        estudiantes[posicion] = estudiante;
    }
}



// Método para buscar la posición de un estudiante
public int buscarPosicion(String codigo) {

    // Recorre únicamente los estudiantes registrados
    for (int i = 0; i < contadorEstudiantes; i++) {

        // Compara el código ingresado con el código del estudiante
        if (estudiantes[i].getId().equals(codigo)) {
            return i;
        }

    }

    // Si no lo encuentra retorna -1
    return -1;

}



// Método para obtener un estudiante por código
public Estudiante obtenerEstudiante(String codigo) {
    
    // Guarda la posición encontrada
    int posicion = buscarPosicion(codigo);
    
    // Si existe retorna el estudiante
    if (posicion != -1) {
        return estudiantes[posicion];
    }
    
    // Si no existe retorna null
    return null;

}



// Método para eliminar estudiantes
public void eliminarEstudiante(String codigo) {
    
    // Buscar posición del estudiante
    int posicion = buscarPosicion(codigo);

    
    // Si existe se elimina
    if (posicion != -1) {
        
        // Mover estudiantes una posición hacia atrás
        for (int i = posicion; i < contadorEstudiantes - 1; i++) {
            estudiantes[i] = estudiantes[i + 1];
        }
        
        // La última posición queda vacía
        estudiantes[contadorEstudiantes - 1] = null;
        
        // Disminuir contador
        contadorEstudiantes--;
    }

}



// Método para calcular el promedio general
public double promedioGeneral() {
    
    // Verifica que existan estudiantes registrados
    if (contadorEstudiantes != 0) {
        
        double promedios = 0.0;

        
        // Sumar promedios de todos los estudiantes
        for (int i = 0; i < contadorEstudiantes; i++) {
            promedios += estudiantes[i].calcularPromedio();
        }

        
        // Dividir entre cantidad de estudiantes
        promedios /= contadorEstudiantes;
        
        return promedios;
    }

    
    // Si no hay estudiantes retorna 0
    return 0;
}



// Getter del arreglo de estudiantes
public Estudiante[] getEstudiantes() {
    return estudiantes;
}



// Getter del contador de estudiantes
public int getContadorEstudiantes() {
    return contadorEstudiantes;
}


}

