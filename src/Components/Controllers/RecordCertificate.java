package Components.Controllers;

import Data.DataStructures.List;
import Data.DataStructures.Queue;
import Data.Models.Affiliate;
import Data.Models.Certificate;
import Data.Models.Training;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RecordCertificate extends JInternalFrame{
    private JPanel panel1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JComboBox trainingsComboBox;
    private JComboBox teachersComboBox;
    private JComboBox studentsComboBox;
    private JTextField textField1;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;

//    public List<Certificate> certificateQueue= new List<Certificate>();

    public RecordCertificate(Landing landing, Queue<Affiliate> Affiliates, List<User> Users, List<Training> Trainings){
        this.setSize(700, 500);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registro de Certificado");
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

        RecordCertificate recordCertificate = this;

        List<String> userNames = new List<String>();
        String[] namesArray = new String[Users.Count];

        for (int i = 0; i < Users.Count; i ++){
            try{
                User user = Users.getItemAtIndex(i);
                namesArray[i] = user.getUserName();
            } catch (Exception ex){}
        }
        teachersComboBox.setModel(new DefaultComboBoxModel<>(namesArray));

        studentsComboBox.setModel(new DefaultComboBoxModel<>(namesArray));

        String[] trainingArray = new String[landing.Trainings.Count];

        for (int i = 0; i < landing.Trainings.Count; i ++){
            try{
                Training training = landing.Trainings.getItemAtIndex(i);

                trainingArray[i] = String.valueOf(training.getId());
            }
            catch (Exception ex){

            }
        }
        trainingsComboBox.setModel(new DefaultComboBoxModel<>(trainingArray));

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = studentsComboBox.getSelectedItem().toString();
                String teacherName = teachersComboBox.getSelectedItem().toString();
                String date = textField1.getText();



                long trainingId = Long.parseLong(trainingsComboBox.getSelectedItem().toString());

                Certificate newCertificate = new Certificate(0, studentName, teacherName, trainingId, date);

                landing.Certificates.insertAtEnd(newCertificate);

                JOptionPane.showMessageDialog(panel1, "Certificado registrado correctamente");
            }
        });
    }
}
