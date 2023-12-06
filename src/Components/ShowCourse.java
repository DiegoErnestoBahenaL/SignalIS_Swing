package Components;

import Data.DataStructures.List;
import Data.Models.Affiliate;
import Data.Models.Course;

import javax.swing.*;
import java.awt.*;

public class ShowCourse extends JInternalFrame{
    private JButton regresarButton;
    private JButton guardarButton;
    private JButton anteriorButton;
    private JButton eliminarButton;
    private JButton siguienteButton;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JScrollBar scrollBar1;
    private JPanel panel1;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;

    private int currentIndex = 0;

    public ShowCourse(Landing landing){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Consultar Cursos");
        this.setVisible(true);
        this.setClosable(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);

//        List<Course> course = landing.Courses.show();

        Course currentCourse = null;
        try {
            currentCourse = landing.Courses.getItemAtIndex(currentIndex);
            // Mostrar el curso en la interfaz gráfica, por ejemplo, en un JTextArea o JLabel
            textArea1.setText(currentCourse.getDescription()); // Suponiendo que textArea1 es el área para mostrar la descripción del curso
        } catch (Exception ex) {
            ex.printStackTrace(); // Manejo de excepciones
        }
        this.setVisible(true);

        // Método asociado al botón "Siguiente"
        siguienteButton.addActionListener(e -> {
            if (currentIndex < landing.Courses.Count - 1) {
                currentIndex++;
                // Mostrar el curso actualizado
                Course updatedCourse = null;
                try {
                    updatedCourse = landing.Courses.getItemAtIndex(currentIndex);
                    textArea1.setText(updatedCourse.getDescription());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya estás en el último curso");
            }
        });

        // Método asociado al botón "Anterior"
        anteriorButton.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                // Mostrar el curso anterior
                Course previousCourse = null;
                try {
                    previousCourse = landing.Courses.getItemAtIndex(currentIndex);
                    textArea1.setText(previousCourse.getDescription());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Estás en el primer curso, maneja esto
                JOptionPane.showMessageDialog(null, "Ya estás en el primer curso");
            }
        });



    }
}
