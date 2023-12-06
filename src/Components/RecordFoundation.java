package Components;

import Data.Models.Foundation;
import Data.DataStructures.List;
import javax.swing.*;
import java.awt.*;

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
    private JList list1;
    private JList list2;

    public List<Foundation> foundationList= new List<Foundation>();

    public RecordFoundation(){

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
    }
}
