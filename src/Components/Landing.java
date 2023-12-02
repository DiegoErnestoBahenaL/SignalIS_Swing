package Components;

import javax.swing.*;
import java.awt.*;

public class Landing extends JFrame {
    private JPanel panel1;
    private JTable table1;

    Landing(){
        this.setSize(520, 520);
        this.setVisible(true);

        DesktopPane desktoppane = new DesktopPane();
        Container pane = getContentPane();
        pane.add(desktoppane, BorderLayout.CENTER);
        desktoppane.showDesktopPane(desktoppane);

    }

    public static void main(String[] args) {
        Landing window = new Landing();
    }

}

class DesktopPane extends JDesktopPane{
    int nbre_frames = 1;
    int x = 0, y = 0;

    public void showDesktopPane(DesktopPane dp){
        for(int i = 0; i < nbre_frames; i++){
            JInternalFrame internal_frame = new JInternalFrame("Frame" + i, true, true, true, true);
            internal_frame.setBounds(x, y, 500, 500);

            dp.add(internal_frame);
            internal_frame.setVisible(true);
            y += 100;
        }
    }
}
