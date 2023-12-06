package Components.Controllers;

import Data.Models.*;
import Data.DataStructures.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordFoundation extends JInternalFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JList afiliadosJlist;
    private JList capacitacionJlist;

    DefaultListModel affiliateModel = new DefaultListModel<>();

    DefaultListModel trainingModel = new DefaultListModel<>();

    public List<Foundation> foundationList= new List<Foundation>();

    public RecordFoundation(Landing landing){

        RecordFoundation recordFoundation = this;

        List<Affiliate> affiliates = landing.Affiliates.show();

        for (int i = 0; i < affiliates.Count; i ++){
            try{
                Affiliate affiliate = affiliates.getItemAtIndex(i);
                affiliateModel.addElement(affiliate.getName());
            }
            catch (Exception ex){

            }

        }

        for (int i = 0; i < landing.Trainings.Count; i ++){
            try{
                Training training = landing.Trainings.getItemAtIndex(i);

                trainingModel.addElement(training.getId());
            }
            catch (Exception ex){

            }

        }

        afiliadosJlist.setModel(affiliateModel);
        capacitacionJlist.setModel(trainingModel);

        afiliadosJlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        capacitacionJlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);


        this.setSize(700, 500);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registro de Fundación");
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

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordFoundation.dispose();
            }
        });

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFoundation =  textField1.getText();
                int capacity = (int)spinner1.getValue();

                Object[] affiliateNamesArray = afiliadosJlist.getSelectedValuesList().toArray();
                Object[] trainingIdsArray = capacitacionJlist.getSelectedValuesList().toArray();

                List<String> namesList = new List<>();
                List<String> idsList = new List<>();

                for (int i = 0 ; i < affiliateNamesArray.length; i++){
                    namesList.insertAtEnd(affiliateNamesArray[i].toString());
                }

                for (int i = 0 ; i < trainingIdsArray.length; i++){
                    idsList.insertAtEnd(trainingIdsArray[i].toString());
                }

                landing.FoundationCurrentId += 1;

                landing.Foundations.insertAtEnd(new Foundation(landing.FoundationCurrentId, nameFoundation, capacity, idsList, namesList));

                JOptionPane.showMessageDialog(recordFoundation, "Capacitación registrada exitosamente", "Registrar Capacitación", JOptionPane.INFORMATION_MESSAGE);

                clean();
            }
        });

    }

    public void clean(){
        textField1.setText("");
        spinner1.setValue(0);
    }
}
