/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author USUARIO
 */
public abstract class UsuarioAcademico {

// Nombre del usuario
private String nombre;

// Código o identificación del usuario
private String id;

// Constructor de la clase padre
public UsuarioAcademico(String nombre, String id) {
this.nombre = nombre;
this.id = id;
}

// Getter del nombre
public String getNombre() {
    return nombre;
}


// Getter del código
public String getId() {
    return id;
}


// Setter del nombre
public void setNombre(String nombreString) {
    this.nombre = nombreString;
}


// Setter del código
public void setId(String id) {
    this.id = id;
}

}