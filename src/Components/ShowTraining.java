package Components;

import javax.swing.*;
import java.awt.*;

public class ShowTraining extends JInternalFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JTextArea textArea1;
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
    private JList list1;
    private JList list2;

    public ShowTraining(){
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


    }
}
