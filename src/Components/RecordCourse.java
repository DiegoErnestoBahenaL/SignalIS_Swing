package Components;
import java.awt.Font;
import javax.swing.*;


public class RecordCourse extends JInternalFrame{
    private JPanel panel1;
    private JLabel titulo;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JTextArea textArea1;
    private JButton regresarButton;
    private JButton registrarButton;
    private JLabel sub1;
    private JLabel sub2;
    private JLabel sub3;

    public RecordCourse(){
        this.setSize(700, 500);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Registro de Curso");
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


