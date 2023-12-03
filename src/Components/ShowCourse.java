package Components;

import javax.swing.*;
import java.awt.*;

public class ShowCourse extends JInternalFrame{
    private JButton regresarButton;
    private JButton guardarButton;
    private JButton anteriorButton;
    private JButton eliminarButton;
    private JButton siguienteButton;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JComboBox comboBox1;
    private JScrollBar scrollBar1;
    private JPanel panel1;
    private JLabel titulo;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;

    public ShowCourse(){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        this.setTitle("Consultar Cursos");
        this.setVisible(true);
        this.setClosable(true);

        String general_font = "Font";
        Font title_font = new Font(general_font, Font.BOLD,  36);
        this.titulo.setFont(title_font);

        Font subtitle_font = new Font(general_font, Font.BOLD, 16);
        this.sub1.setFont(subtitle_font);
        this.sub2.setFont(subtitle_font);
        this.sub3.setFont(subtitle_font);


    }
}
