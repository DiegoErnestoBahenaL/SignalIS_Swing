package Components.Controllers;

import Data.DataStructures.List;
import Data.Models.Affiliate;
import Data.Models.Course;
import Data.Models.Training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordTraining extends JInternalFrame{
    private JPanel panel1;
    private JTextField startDateJtf;
    private JTextField endDateJtf;
    private JSpinner capacitySpinner;
    private JTextArea locationTxtA;
    private JButton regresarButton;
    private JButton registrarButton;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JLabel sub5;
    private JLabel sub6;
    private JList<Object> studentsJlist;
    private JList<Object> coursesJlist;
    DefaultListModel studentsModel = new DefaultListModel<>();

    DefaultListModel coursesModel = new DefaultListModel<>();
    long AffiliateCurrentId = 0;

    public RecordTraining(Landing landing){

        RecordTraining recordTraining = this;


        List<Affiliate> affiliates= landing.Affiliates.show();


        for (int i = 0; i < affiliates.Count; i ++){
            try{
                Affiliate affiliate = affiliates.getItemAtIndex(i);
                studentsModel.addElement(affiliate.getName());
            }
            catch (Exception ex){

            }

        }

        for (int i = 0; i < landing.Courses.Count; i ++){
            try{
                Course course = landing.Courses.getItemAtIndex(i);

                coursesModel.addElement(course.getId());
            }
            catch (Exception ex){

            }

        }

        studentsJlist.setModel(studentsModel);
        coursesJlist.setModel(coursesModel);

        studentsJlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        coursesJlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setIconifiable(true);
        this.setTitle("Registro de Capacitación");
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
        this.sub6.setFont(subtitle_font);


        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordTraining.dispose();
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startDate =  startDateJtf.getText();
                String endDate = endDateJtf.getText();
                String location = locationTxtA.getText();
                int capacity = (int)capacitySpinner.getValue();

                Object[] studentsNamesArray = studentsJlist.getSelectedValuesList().toArray();
                Object[] coursesIdsArray = coursesJlist.getSelectedValuesList().toArray();

                List<String> namesList = new List<>();
                List<String> idsList = new List<>();

                for (int i = 0 ; i < studentsNamesArray.length; i++){
                    namesList.insertAtEnd(studentsNamesArray[i].toString());
                }

                for (int i = 0 ; i < coursesIdsArray.length; i++){
                    idsList.insertAtEnd(coursesIdsArray[i].toString());
                }

                landing.TrainingCurrentId += 1;

                landing.Trainings.insertAtEnd(new Training(landing.TrainingCurrentId, startDate, endDate, location, capacity, idsList, namesList));

                JOptionPane.showMessageDialog(recordTraining, "Capacitación registrada exitosamente", "Registrar Capacitación", JOptionPane.INFORMATION_MESSAGE);

                clean();
            }
        });
    }

    public void clean(){
        startDateJtf.setText("");
        endDateJtf.setText("");
        locationTxtA.setText("");
        capacitySpinner.setValue(0);
        startDateJtf.requestFocus();
    }
}
