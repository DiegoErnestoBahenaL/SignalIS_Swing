package Components;

import Data.DataStructures.List;
import Data.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panelLogin;
    private JTextField txfUsuario;
    private JPasswordField txfPaswword;
    private JLabel lbtTitle;
    private JButton btnLogin;
    private JLabel logo;
    private JLabel lbUsuario;
    private JLabel lbPassword;

    public List<User> Users = new List<>();



    public Login() {

        Users.insertAtBeginning(new User(1, "dbahenalopez@hotmail.com", "12345"));
        Users.insertAtBeginning(new User(2, "estela@hotmail.com", "12345"));
        Users.insertAtBeginning(new User(3, "enock@hotmail.com", "12345"));
        Users.insertAtBeginning(new User(4, "adrian@hotmail.com", "12345"));

        Login loginForm = this;

        initComponents();


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txfUsuario.getText();
                String password = String.valueOf(txfPaswword.getPassword());

                Clean();


                boolean hasAccess = false;

                for (int i = 0; i < Users.Count; i++){
                   try {
                       User userInList = Users.getItemAtIndex(i);

                       if (userInList.getUserName().equals(user) && userInList.getPassword().equals(password)){

                           hasAccess = true;

                            Landing landingForm = new Landing(loginForm);

                            landingForm.setVisible(true);

                            loginForm.setVisible(false);

                            break;
                       }

                   }
                   catch (Exception ex){
                       JOptionPane.showMessageDialog(loginForm, "Sucedió un error al hacer login. Contacte al administrado", "Error", JOptionPane.WARNING_MESSAGE);
                   }


                }

                if (!hasAccess){
                    JOptionPane.showMessageDialog(loginForm, "Ingrese credenciales válidas", "Login inválido", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        Login window = new Login();
    }

    public void initComponents (){
        this.setSize(700, 700);
        this.setContentPane(panelLogin);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Iniciar Sesión");
        this.setVisible(true);
    }

    private void Clean(){
        txfUsuario.setText("");
        txfPaswword.setText("");

        txfUsuario.requestFocus();
    }
}
