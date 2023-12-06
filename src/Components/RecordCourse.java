package Components;

import java.awt.Font;
import javax.swing.*;
import Data.Models.Course;
import Data.DataStructures.List;
import Data.Models.User;
public class RecordCourse extends JInternalFrame{
    private JPanel panel1;
    private JLabel titulo;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JTextArea textArea1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JTextField levelJtf;
    private JLabel levelJlb;

    long CourseCurrentId = 0;
//    List<Course> courseList = new List<Course>();

    public RecordCourse(Landing landing){

        RecordCourse recordCourse = this;

        this.setSize(700, 500);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registro de Curso");
        this.setVisible(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);


        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);
        this.levelJlb.setFont(subtitle_font);

        List<String> userNames = new List<String>();

        String[] namesArray = new String[landing.Users.Count];

        for (int i = 0; i < landing.Users.Count; i ++){
            try{
                User user = landing.Users.getItemAtIndex(i);

                namesArray[i] = user.getUserName();
            }
            catch (Exception ex){

            }

        }

        comboBox1.setModel(new DefaultComboBoxModel<>(namesArray));

        registrarButton.addActionListener(e -> {
            // Obtener datos del formulario
            String description = textArea1.getText();
            int duration = (int) spinner1.getValue();
            String level = levelJtf.getText();
            String teacherUserName = comboBox1.getSelectedItem().toString();

            User user = new User();

            try{
                user = landing.Users.findByUserName(teacherUserName);
            }
            catch (Exception ex){

            }

            long maestroId = user.getId(); // Asignar el ID del maestro deseado

            CourseCurrentId++;

            // Crear un nuevo curso
            Course newCourse = new Course(CourseCurrentId, duration, description, maestroId, level);

            // Agregar el curso a la lista
            landing.Courses.insertAtEnd(newCourse);

            // Limpiar los campos después de agregar el curso
            textArea1.setText("");
            spinner1.setValue(0);
            comboBox1.setSelectedIndex(0);

            // Mostrar un mensaje de éxito o realizar alguna otra acción
            JOptionPane.showMessageDialog(recordCourse, "Curso registrado exitosamente");
        });

        // Agregar ActionListener al botón regresarButton
        regresarButton.addActionListener(e -> this.dispose()); // Cerrar la ventana al hacer clic en "Regresar"

    }

}


