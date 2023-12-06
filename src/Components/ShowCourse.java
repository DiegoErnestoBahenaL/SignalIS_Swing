package Components;

import Data.DataStructures.List;
import Data.Models.Course;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCourse extends JInternalFrame{
    private JButton regresarButton;
    private JButton guardarButton;
    private JButton anteriorButton;
    private JButton eliminarButton;
    private JButton siguienteButton;
    private JTextArea textArea1;
    private JSpinner durationSpinner;
    private JComboBox selectResponsible;
    private JScrollBar scrollBar1;
    private JPanel panel1;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JTextField levelJtf;
    private JLabel levelJlb;
    private long currentId = 0;
    private int currentIndex = 0;

    public ShowCourse(Landing landing){

        ShowCourse showCourse = this;

        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Consultar Cursos");
        this.setIconifiable(true);
        this.setResizable(true);
        this.setVisible(true);
        this.setClosable(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);
        this.levelJlb.setFont((subtitle_font));



        Course currentCourse = null;
        try {
            currentCourse = landing.Courses.getItemAtIndex(currentIndex);

            currentId = currentCourse.getId();
            // Mostrar el curso en la interfaz gráfica, por ejemplo, en un JTextArea o JLabel
            textArea1.setText(currentCourse.getDescription()); // Suponiendo que textArea1 es el área para mostrar la descripción del curso

            Data.DataStructures.List<String> userNames = new List<String>();

            String[] namesArray = new String[landing.Users.Count];

            for (int i = 0; i < landing.Users.Count; i ++){
                try{
                    User user = landing.Users.getItemAtIndex(i);

                    namesArray[i] = user.getUserName();
                }
                catch (Exception ex){

                }

            }

            selectResponsible.setModel(new DefaultComboBoxModel<>(namesArray));

            User user = landing.Users.findById(currentCourse.getIdMaestro());

            selectResponsible.setSelectedItem(user.getUserName());

            durationSpinner.setValue(currentCourse.getDurationInHours());

            levelJtf.setText(currentCourse.getLevel());


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

                    User user = landing.Users.findById(updatedCourse.getIdMaestro());

                    selectResponsible.setSelectedItem(user.getUserName());

                    durationSpinner.setValue(updatedCourse.getDurationInHours());

                    levelJtf.setText(updatedCourse.getLevel());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(showCourse, "Ya estás en el último curso");
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

                    User user = landing.Users.findById(previousCourse.getIdMaestro());

                    selectResponsible.setSelectedItem(user.getUserName());

                    durationSpinner.setValue(previousCourse.getDurationInHours());

                    levelJtf.setText(previousCourse.getLevel());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Estás en el primer curso, maneja esto
                JOptionPane.showMessageDialog(showCourse, "Ya estás en el primer curso");
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCourse.dispose();
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener datos del formulario
                String description = textArea1.getText();
                int duration = (int) durationSpinner.getValue();
                String level = levelJtf.getText();
                String teacherUserName = selectResponsible.getSelectedItem().toString();

                User user = new User();

                try{
                    user = landing.Users.findByUserName(teacherUserName);
                }
                catch (Exception ex){

                }

                long maestroId = user.getId(); // Asignar el ID del maestro deseado

                Course newCourse = new Course(currentId, duration, description, maestroId, level);


                try {
                    landing.Courses.set(currentIndex, newCourse);

                    JOptionPane.showMessageDialog(showCourse, "Curso Actualizado");

                }catch (Exception ex){

                }

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Course courseToDelete = landing.Courses.getItemAtIndex(currentIndex);

                    landing.Courses.delete(courseToDelete);

                    JOptionPane.showMessageDialog(showCourse, "Curso Eliminado");
                }
                catch ( Exception ex){

                }
            }
        });
    }
}
