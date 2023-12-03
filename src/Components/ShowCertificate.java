package Components;

import javax.swing.*;
import java.awt.*;

public class ShowCertificate extends JInternalFrame{
    private JButton regresarButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JButton siguienteButton;
    private JButton anteriorButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JPanel panel1;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JLabel titulo;

    public ShowCertificate(){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
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


    }
}
