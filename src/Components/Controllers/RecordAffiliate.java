package Components.Controllers;

import Data.DataStructures.List;
import Data.Models.Affiliate;
import Data.Models.AffiliateTypeEnum;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordAffiliate extends JInternalFrame{
    private JPanel panel1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JTextField nameJtf;
    private JTextField fathersLastNameJtf;
    private JTextField mothersLastNameJtf;
    private JTextField ageJtf;
    private JComboBox selectType;
    private JComboBox selectUser;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JLabel sub5;
    private JLabel sub6;




    public RecordAffiliate(Landing landing){
       initComponents();

       RecordAffiliate recordAffiliate = this;

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

        selectUser.setModel(new DefaultComboBoxModel<>(namesArray));

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordAffiliate.dispose();
            }
        });
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = new User();
                try
                {
                    String nameSelected = selectUser.getSelectedItem().toString();
                    selectedUser =  landing.Users.findByUserName(nameSelected);
                }
                catch (Exception ex){

                }

                landing.AffiliateCurrentId += 1 ;

                Affiliate newAffiliate = new Affiliate(
                        landing.AffiliateCurrentId ,
                        nameJtf.getText(),
                        fathersLastNameJtf.getText(),
                        mothersLastNameJtf.getText(),
                        Integer.valueOf(ageJtf.getText()),
                        selectType.getSelectedItem().toString(),
                        selectedUser.getId()
                );

                landing.Affiliates.push(newAffiliate);

                JOptionPane.showMessageDialog(recordAffiliate, "Afiliado registrado exitosamente", "Registrar Afiliado", JOptionPane.INFORMATION_MESSAGE);
                clean();
            }
        });
    }

    public void clean(){
        nameJtf.setText("");
        fathersLastNameJtf.setText("");
        mothersLastNameJtf.setText("");
        ageJtf.setText("");
        nameJtf.requestFocus();
    }
    public void initComponents(){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registro de Curso");
        this.setVisible(true);
        this.setIconifiable(true); // set minimize
        this.setClosable(true);
        this.setResizable(true);

        selectType.setModel(new DefaultComboBoxModel<>(AffiliateTypeEnum.values()));




//-----------------------------------FONTS------------------------------------------------------//
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

    }
}

