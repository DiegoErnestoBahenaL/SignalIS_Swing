package Components;

import javax.swing.*;
import java.awt.*;

public class RecordFoundation extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JSpinner spinner1;
    private JCheckBox opción1CheckBox1;
    private JCheckBox opción2CheckBox1;
    private JCheckBox opción3CheckBox1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;
    private JLabel sub4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;

    public RecordFoundation(){

        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Registro de Fundación");
        this.setVisible(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);
        this.sub4.setFont(subtitle_font);

    }


    public static void main(String[] args) {
        RecordFoundation window = new RecordFoundation();
    }
}
