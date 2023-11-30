package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Data.DataStructures.List;
import Data.Models.Affiliate;
import Data.Models.AffiliateTypeEnum;

public class ShowAffiliate extends JFrame{

    List<Affiliate> list = new List<Affiliate>();
    private JPanel panel1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JLabel sub5;
    private JLabel sub6;
    public ShowAffiliate(){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Registro de Curso");
        this.setVisible(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().isEmpty() && !textField2.getText().isEmpty() && !textField3.getText().isEmpty() && !textField5.getText().isEmpty()){ //Faltan combos
                    Affiliate affiliate = new Affiliate();
                    //long id, String name, String fathersLastName, String mothersLastName, int age, AffiliateTypeEnum type, long userId
                    affiliate.setName(textField1.getText());
                    affiliate.setFathersLastName(textField2.getText());
                    affiliate.setMothersLastName(textField3.getText());
                    affiliate.setAge(Integer.parseInt(textField5.getText()));
                    affiliate.setType((AffiliateTypeEnum) comboBox1.getSelectedItem());
                    affiliate.setUserId(Long.parseLong(comboBox2.getSelectedItem().toString())); //?

                    list.insertAtEnd(affiliate);

                    System.out.println(list.toString());
                }
            }
        });
    }



    public static void main(String[] args) {
        ShowAffiliate window = new ShowAffiliate();
    }
}

