package Components.Controllers;

import Data.DataStructures.List;
import Data.DataStructures.Queue;
import Data.Models.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Landing extends JFrame {
    private JPanel mainPanel;
    private JDesktopPane desktopPane;
    private JMenuBar mainMenu;
    private JMenu afiliadosMenu;
    private JMenu fundaciónMenu;
    private JMenu cursoMenu;
    private JMenu capacitaciónMenu;
    private JMenu certificadoMenu;
    private JMenu cerrarMenu;
    private JMenuItem insertAffiliate;
    private JMenuItem showAffiliate;
    private JMenuItem insertFoundation;
    private JMenuItem showFoundation;
    private JMenuItem insertCourse;
    private JMenuItem showCourse;
    private JMenuItem insertTraining;
    private JMenuItem showTraining;
    private JMenuItem insertCertificate;
    private JMenuItem showCertificate;

    public List<User> Users;
    public Queue<Affiliate> Affiliates = new Queue<>();
    public List<Course> Courses = new List<>();
    public List<Foundation> Foundations = new List<>();
    public List<Training> Trainings = new List<>();
    public List<Certificate> Certificates = new List<>();

    long AffiliateCurrentId = 0;
    long TrainingCurrentId = 0;


    public Landing(Login loginForm, List<User> userList){
        Landing landing = this;
        Users = userList;
        initcomponents();

        insertAffiliate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordAffiliate recordAffiliate = new RecordAffiliate(landing);
                desktopPane.add(recordAffiliate);

            }
        });

        showAffiliate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowAffiliate displayAffiliate = new ShowAffiliate(landing);
                desktopPane.add(displayAffiliate);
            }
        });

        insertFoundation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordFoundation recordFoundation = new RecordFoundation();
                desktopPane.add(recordFoundation);
            }
        });

        showFoundation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowFoundation displayFoundation = new ShowFoundation();
                desktopPane.add(displayFoundation);
            }
        });

        insertCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordCourse recordCourse = new RecordCourse(landing);
                desktopPane.add(recordCourse);
            }
        });

        showCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCourse displayCourse = new ShowCourse(landing);
                desktopPane.add(displayCourse);
            }
        });

        insertTraining.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordTraining recordTraining = new RecordTraining(landing);
                desktopPane.add(recordTraining);
            }
        });

        showTraining.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTraining displayTraining = new ShowTraining();
                desktopPane.add(displayTraining);
            }
        });

        insertCertificate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordCertificate recordCertificate = new RecordCertificate(landing, Affiliates, userList, Trainings);
                desktopPane.add(recordCertificate);
            }
        });

        showCertificate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCertificate displayCertificate = new ShowCertificate(landing);
                desktopPane.add(displayCertificate);
            }
        });

        cerrarMenu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                landing.setVisible(false);
                loginForm.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public void initcomponents(){
        this.setContentPane(mainPanel);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Landing");
    }
}
