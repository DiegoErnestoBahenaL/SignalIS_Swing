package Components;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    private JPanel panelLogin;
    private JTextField txfUsuario;
    private JPasswordField txfPaswword;
    private JLabel lbtTitle;
    private JButton btnLogin;
    private JLabel logo;
    private JLabel lbUsuario;
    private JLabel lbPassword;

    public Login() {
        // TODO: place custom component creation code here
        this.setSize(700, 700);
        this.setContentPane(panelLogin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Iniciar Sesión");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Login window = new Login();
    }
}
