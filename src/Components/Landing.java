package Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Landing extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JLabel title_Landing;
    private JMenuItem afiliado_add;
    private JMenu afiliado_option;
    private JMenuBar menu;
    private JMenu fundacion_option;
    private JMenuItem fundacion_add;
    private JMenuItem fundacion_view;
    private JMenu curso_option;
    private JMenuItem curso_add;
    private JMenuItem curso_view;
    private JMenu capacitacion_option;
    private JMenuItem capacitacion_add;
    private JMenuItem capacitacion_view;
    private JMenu logout;
    private JMenu certificado_option;
    private JMenuItem certificado_add;
    private JMenuItem certificado_view;

    Landing(){
        this.setSize(520, 520);
        this.setVisible(true);
        this.getContentPane().setLayout(null);

    }

    public static void main(String[] args) {
        Landing window = new Landing();
    }

}
