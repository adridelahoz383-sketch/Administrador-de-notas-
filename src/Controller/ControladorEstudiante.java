/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Estudiante;
import Model.GestorEstudiante;
import View.Vista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class ControladorEstudiante {

// Referencia a la vista
    private Vista vista;

// Gestor que maneja la lógica del sistema
    private GestorEstudiante gestor;

// Constructor del controlador
    public ControladorEstudiante(Vista vista) {

        this.vista = vista;

        // Se inicializa el gestor
        gestor = new GestorEstudiante();

    }

// Método para registrar estudiantes
    public void registrarEstudiante() {

        // Obtener datos de los campos
        String codigo = vista.getTxtCodigo().getText();
        String nombre = vista.getTxtNombre().getText();
        String carrera = vista.getTxtCarrera().getText();

        String nota1Texto = vista.getTxtNota1().getText();
        String nota2Texto = vista.getTxtNota2().getText();
        String nota3Texto = vista.getTxtNota3().getText();

        // Validar campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || carrera.isEmpty()
                || nota1Texto.isEmpty() || nota2Texto.isEmpty() || nota3Texto.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return;

        }

        // Variables para guardar las notas convertidas
        double nota1;
        double nota2;
        double nota3;

        // Convertir las notas de String a double
        try {

            nota1 = Double.parseDouble(nota1Texto);
            nota2 = Double.parseDouble(nota2Texto);
            nota3 = Double.parseDouble(nota3Texto);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Las notas deben ser numéricas");
            return;

        }

        // Validar rango de notas
        if (nota1 < 0 || nota1 > 5
                || nota2 < 0 || nota2 > 5
                || nota3 < 0 || nota3 > 5) {

            JOptionPane.showMessageDialog(null, "Las notas deben estar entre 0 y 5");
            return;

        }

        // Crear objeto estudiante
        Estudiante estudiante = new Estudiante(
                carrera,
                nota1,
                nota2,
                nota3,
                nombre,
                codigo
        );

        // Agregar estudiante al arreglo
        gestor.agregarEstudiante(estudiante);

        JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente");

        // Limpiar campos y actualizar tabla
        limpiarCampos();

        llenarTabla();

    }

// Método para buscar estudiantes
    public void buscarEstudiante() {

        // Obtener código ingresado
        String codigo = vista.getTxtCodigo().getText();

        // Buscar estudiante
        Estudiante estudiante = gestor.obtenerEstudiante(codigo);

        // Si existe se muestran los datos
        if (estudiante != null) {

            vista.getTxtNombre().setText(estudiante.getNombre());
            vista.getTxtCarrera().setText(estudiante.getCarrera());

            vista.getTxtNota1().setText(String.valueOf(estudiante.getNota1()));
            vista.getTxtNota2().setText(String.valueOf(estudiante.getNota2()));
            vista.getTxtNota3().setText(String.valueOf(estudiante.getNota3()));

        } else {

            JOptionPane.showMessageDialog(null, "Estudiante no encontrado");

        }

    }

// Método para actualizar estudiantes
    public void actualizarEstudiante() {

        // Obtener datos actualizados
        String codigo = vista.getTxtCodigo().getText();
        String nombre = vista.getTxtNombre().getText();
        String carrera = vista.getTxtCarrera().getText();

        double nota1 = Double.parseDouble(vista.getTxtNota1().getText());
        double nota2 = Double.parseDouble(vista.getTxtNota2().getText());
        double nota3 = Double.parseDouble(vista.getTxtNota3().getText());

        // Crear nuevo objeto actualizado
        Estudiante estudiante = new Estudiante(
                carrera,
                nota1,
                nota2,
                nota3,
                nombre,
                codigo
        );

        // Actualizar estudiante
        gestor.actualizarEstudiante(estudiante);

        JOptionPane.showMessageDialog(null, "Estudiante actualizado");

        // Actualizar tabla y limpiar campos
        llenarTabla();

        limpiarCampos();

    }

// Método para eliminar estudiantes
    public void eliminarEstudiante() {

        // Obtener código
        String codigo = vista.getTxtCodigo().getText();

        // Eliminar estudiante
        gestor.eliminarEstudiante(codigo);

        JOptionPane.showMessageDialog(null, "Estudiante eliminado");

        // Actualizar tabla y limpiar campos
        llenarTabla();

        limpiarCampos();

    }

// Método para limpiar los campos
    public void limpiarCampos() {

        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtCarrera().setText("");

        vista.getTxtNota1().setText("");
        vista.getTxtNota2().setText("");
        vista.getTxtNota3().setText("");

    }

// Método para actualizar la JTable
    public void llenarTabla() {

        DefaultTableModel modelo
                = (DefaultTableModel) vista.getTablaEstudiantes().getModel();

        modelo.setRowCount(0);

        Estudiante[] estudiantes = gestor.getEstudiantes();

        for (int i = 0; i < gestor.getContadorEstudiantes(); i++) {

            modelo.addRow(new Object[]{
                estudiantes[i].getId(),
                estudiantes[i].getNombre(),
                estudiantes[i].getCarrera(),
                estudiantes[i].getNota1(),
                estudiantes[i].getNota2(),
                estudiantes[i].getNota3(),
                estudiantes[i].calcularPromedio(),
                estudiantes[i].obtenerEstado()

            });

        }

        vista.getLblPromedioGeneral().setText(
                "Promedio general: " + gestor.promedioGeneral()
        );

    }
}
