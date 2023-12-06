package Components.Controllers;

import Data.DataStructures.List;
import Data.Models.Course;
import Data.Models.Training;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowTraining extends JInternalFrame{
    private JTextField tfInicio; //Fecha inicio
    private JTextField tfFin; //Fecha fin
    private JComboBox cbCapacidad; //Capacidad
    private JTextArea taUbicacion;
    private JButton regresarButton;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JLabel sub5;
    private JPanel panel1;
    private JTextField tfCapacidad;
    private JTextArea taAlumnos;
    private JTextArea taCursos;
    private long currentId = 0;
    private int currentIndex = 0;

    public ShowTraining(Landing landing){
        ShowTraining showTraining = this;
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Consultar Certificados");
        this.setVisible(true);
        this.setClosable(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);
        this.sub4.setFont(subtitle_font);
        this.sub5.setFont(subtitle_font);

        Training currentTraining = null;
        try {
            currentTraining = landing.Trainings.getItemAtIndex(currentIndex);

            currentId = currentTraining.getId();

            tfInicio.setText(currentTraining.getStartDate());
            tfFin.setText(currentTraining.getStartDate());
            tfCapacidad.setText(currentTraining.getEndDate());
            taAlumnos.setText(currentTraining.getStudents().toString());
            taCursos.setText(currentTraining.getCourses().toString());
            taUbicacion.setText(currentTraining.getLocation());

        } catch (Exception ex) {
            ex.printStackTrace(); // Manejo de excepciones
        }
        this.setVisible(true);

        siguienteButton.addActionListener(e -> {
            if (currentIndex < landing.Trainings.Count - 1) {
                currentIndex++;
                // Mostrar el curso actualizado
                Training updatedTraining = null;
                try {
                    updatedTraining = landing.Trainings.getItemAtIndex(currentIndex);
                    tfInicio.setText(updatedTraining.getStartDate());
                    tfFin.setText(updatedTraining.getStartDate());
                    tfCapacidad.setText(updatedTraining.getEndDate());
                    taAlumnos.setText(updatedTraining.getStudents().toString());
                    taCursos.setText(updatedTraining.getCourses().toString());
                    taUbicacion.setText(updatedTraining.getLocation());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(showTraining, "Ya estás en el último curso");
            }
        });

        // Método asociado al botón "Anterior"
        anteriorButton.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                // Mostrar el curso anterior
                Training previousTraining = null;
                try {
                    previousTraining = landing.Trainings.getItemAtIndex(currentIndex);
                    tfInicio.setText(previousTraining.getStartDate());
                    tfFin.setText(previousTraining.getStartDate());
                    tfCapacidad.setText(previousTraining.getEndDate());
                    taAlumnos.setText(previousTraining.getStudents().toString());
                    taCursos.setText(previousTraining.getCourses().toString());
                    taUbicacion.setText(previousTraining.getLocation());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Estás en el primer curso, maneja esto
                JOptionPane.showMessageDialog(showTraining, "Ya estás en el primer curso");
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTraining.dispose();
            }
        });

//        guardarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                tfInicio.setText(updatedTraining.getStartDate());
////                tfFin.setText(updatedTraining.getStartDate());
////                tfCapacidad.setText(updatedTraining.getEndDate());
////                taAlumnos.setText(updatedTraining.getStudents().toString());
////                taCursos.setText(updatedTraining.getCourses().toString());
////                taUbicacion.setText(updatedTraining.getLocation());
//                // Obtener datos del formulario
//                String description = textArea1.getText();
//                int duration = (int) durationSpinner.getValue();
//                String level = levelJtf.getText();
//                String teacherUserName = selectResponsible.getSelectedItem().toString();
//
//                User user = new User();
//
//                try{
//                    user = landing.Users.findByUserName(teacherUserName);
//                }
//                catch (Exception ex){
//
//                }
//
//                long maestroId = user.getId(); // Asignar el ID del maestro deseado
//
//                Course newCourse = new Course(currentId, duration, description, maestroId, level);
//
//
//                try {
//                    landing.Courses.set(currentIndex, newCourse);
//
//                    JOptionPane.showMessageDialog(showTraining, "Curso Actualizado");
//
//                }catch (Exception ex){
//
//                }
//
//            }
//
//        });

//        eliminarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    Course courseToDelete = landing.Courses.getItemAtIndex(currentIndex);
//
//                    landing.Courses.delete(courseToDelete);
//
//                    JOptionPane.showMessageDialog(showTraining, "Curso Eliminado");
//                }
//                catch ( Exception ex){
//
//                }
//            }
//        });
    }
}
