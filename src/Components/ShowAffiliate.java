package Components;

import javax.swing.*;
import java.awt.*;

public class ShowAffiliate extends JInternalFrame{
    private JPanel panel1;
    private JLabel titulo;
    private JTable table1;

    public ShowAffiliate(){
        this.setSize(500, 300);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
        this.setTitle("Consultar Afiliados");
        this.setVisible(true);
        this.setClosable(true);

    }

}
