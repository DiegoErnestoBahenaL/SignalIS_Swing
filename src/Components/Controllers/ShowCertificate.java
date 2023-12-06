package Components.Controllers;

import Data.DataStructures.List;
import Data.Models.Certificate;
import Data.Models.Course;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCertificate extends JInternalFrame{
    private JButton regresarButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JButton siguienteButton;
    private JButton anteriorButton;
    private JPanel panel1;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel lbFecha;
    private JLabel titulo;
    private JTextField tfCapacitacion;
    private JTextField tfNombre;
    private JTextField tfMaestro;
    private JTextField tfFecha;

    private long currentId = 0;
    private int currentIndex = 0;
    public ShowCertificate(Landing landing){

        ShowCertificate showCertificate = this;

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
        this.lbFecha.setFont(subtitle_font);

        Certificate currentCertificate = null;
        try {
            currentCertificate = landing.Certificates.getItemAtIndex(currentIndex);

            currentId = currentCertificate.getId();
            // Mostrar el curso en la interfaz gráfica, por ejemplo, en un JTextArea o JLabel
            tfNombre.setText(currentCertificate.getStudentName());
            tfMaestro.setText(currentCertificate.getTeacherName());
            tfCapacitacion.setText(String.valueOf(currentCertificate.getTrainingId()));
            tfFecha.setText(currentCertificate.getDate());

        } catch (Exception ex) {
            ex.printStackTrace(); // Manejo de excepciones
        }
        this.setVisible(true);

        siguienteButton.addActionListener(e -> {
            if (currentIndex < landing.Courses.Count - 1) {
                currentIndex++;
                Certificate updatedCertificate = null;
                try {
                    updatedCertificate = landing.Certificates.getItemAtIndex(currentIndex);
                    tfNombre.setText(updatedCertificate.getStudentName());
                    tfMaestro.setText(updatedCertificate.getTeacherName());
                    tfCapacitacion.setText(String.valueOf(updatedCertificate.getTrainingId()));
                    tfFecha.setText(updatedCertificate.getDate());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(showCertificate, "Ya estás en el último curso");
            }
        });

        anteriorButton.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                // Mostrar el curso anterior
                Certificate previousCertificate = null;
                try {
                    tfNombre.setText(previousCertificate.getStudentName());
                    tfMaestro.setText(previousCertificate.getTeacherName());
                    tfCapacitacion.setText(String.valueOf(previousCertificate.getTrainingId()));
                    tfFecha.setText(previousCertificate.getDate());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                // Estás en el primer curso, maneja esto
                JOptionPane.showMessageDialog(showCertificate, "Ya estás en el primer curso");
            }
        });


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCertificate.dispose();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Certificate certificateToDelete = landing.Certificates.getItemAtIndex(currentIndex);

                    landing.Certificates.delete(certificateToDelete);

                    JOptionPane.showMessageDialog(showCertificate, "Curso Eliminado");
                }
                catch ( Exception ex){

                }
            }
        });

    }
}
