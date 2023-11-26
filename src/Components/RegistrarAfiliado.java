package Components;

import javax.swing.*;
import java.awt.*;

public class RegistrarAfiliado extends JFrame{
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
    public RegistrarAfiliado(){
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

    }

    public static void main(String[] args) {
        RegistrarAfiliado window = new RegistrarAfiliado();
    }
}

