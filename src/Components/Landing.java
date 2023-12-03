package Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Landing extends JFrame{
    private JPanel panel1;
    private JMenuItem InsertAffiliates;
    private JDesktopPane Desk_Pane;
    private JMenu AffiliateMenu;
    private JMenuBar MenuBar;
    private JMenuItem InsertFoundation;
    private JMenuItem DisplayFoundation;
    private JMenu FoundationMenu;
    private JMenu CourseMenu;
    private JMenuItem InsertCourse;
    private JMenuItem DisplayCourse;
    private JMenu TrainingMenu;
    private JMenuItem InsertTraining;
    private JMenuItem DisplayTraining;
    private JMenu CertificateMenu;
    private JMenuItem InsertCertificate;
    private JMenuItem DisplayCertificate;

    public Landing(){
        initcomponents();
        Landing landing = this;
        InsertAffiliates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordAffiliate r_a = new RecordAffiliate();
                Desk_Pane.add(r_a);
            }
        });
        InsertFoundation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordFoundation record_foundation = new RecordFoundation();
                Desk_Pane.add(record_foundation);
            }
        });
        InsertCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordCourse record_course = new RecordCourse();
                Desk_Pane.add(record_course);
            }
        });
        InsertTraining.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordTraining record_training = new RecordTraining();
                Desk_Pane.add(record_training);
            }
        });
        InsertCertificate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecordCertificate record_certificate = new RecordCertificate();
                Desk_Pane.add(record_certificate);
            }
        });
        DisplayFoundation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowFoundation s_f = new ShowFoundation();
                Desk_Pane.add(s_f);
            }
        });
        DisplayCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCourse s_c = new ShowCourse();
                Desk_Pane.add(s_c);
            }
        });
        DisplayTraining.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTraining show_training = new ShowTraining();
                Desk_Pane.add(show_training);
            }
        });
        DisplayCertificate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCertificate show_certificate = new ShowCertificate();
                Desk_Pane.add(show_certificate);
            }
        });
        this.setContentPane(panel1);
        this.setVisible(true);
    }
    public void initcomponents(){
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Landing");
    }

    public static void main(String[] args) {
        Landing window = new Landing();
    }
}