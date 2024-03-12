package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Extra_details extends JFrame implements ActionListener {
    String url = "jdbc:postgresql://localhost:5432/test";
    String username = "postgres";
    String password = "sql@2024";
    JLabel ad, Pin, ag, box, nat;
    JButton ba, add;

    Checkbox box1, box2, box3, box4, box5;
    JTextField ja, pintext, agtext;
    Font new_font = new Font("Times New Roman", Font.BOLD, 18);

    Extra_details() {
        setBounds(250, 50, 600, 450);
        setLayout(null);
        setTitle("Extra details ");
        ad = new JLabel("Address");
        ad.setBounds(10, 10, 110, 80);
        ad.setForeground(Color.blue);
        ad.setFont(new_font);
        ja = new JTextField();
        ja.setBounds(100, 10, 330, 60);
        ja.setBorder(BorderFactory.createEmptyBorder());
        Pin = new JLabel("PIN");
        Pin.setBounds(30, 60, 90, 70);
        Pin.setForeground(Color.blue);
        pintext = new JTextField();
        pintext.setBounds(100, 80, 150, 30);
        add(Pin);
        add(pintext);
        ag = new JLabel("Age");
        ag.setBounds(30, 100, 90, 70);
        ag.setForeground(Color.blue);
        agtext = new JTextField();
        agtext.setBounds(100, 130, 100, 20);
        add(Pin);
        add(agtext);
        box = new JLabel("Gender");
        box.setBounds(20, 150, 110, 80);
        box.setForeground(Color.blue);
        box1 = new Checkbox("Male");
        box1.setBounds(110, 140, 80, 90);
        add(box1);
        box2 = new Checkbox("Female");
        box2.setBounds(200, 140, 80, 90);
        add(box2);
        box3 = new Checkbox("other");
        box3.setBounds(290, 140, 80, 90);
        add(box3);
        nat = new JLabel("Nationality");
        nat.setBounds(20, 200, 150, 80);
        nat.setForeground(Color.blue);
        box4 = new Checkbox("Indian");
        box4.setBounds(150, 200, 80, 90);
        add(box4);
        box5 = new Checkbox("Other");
        box5.setBounds(230, 200, 80, 90);
        add(box5);
        add(nat);
        add(ja);
        add(box);
        add(ag);
        add(ad);
        ba = new JButton("Back");
        ba.setBounds(20, 300, 120, 30);
        ba.setBackground(Color.cyan);
        ba.addActionListener(this);
        add = new JButton("Submit");
        add.setBounds(200, 300, 150, 30);
        add.setBackground(Color.cyan);
        add.addActionListener(this);
        add(ba);
        add(add);

        setVisible(true);
    }

    public static void main(String[] args) {

        new Extra_details();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ba) {
            setVisible(false);
            new Des();
        }
        if (e.getSource() == add) {
            String name = ja.getText();
            String number = pintext.getText();
            String quary = "INSERT INTO details values('" + name + "','" + number + "')";
            try {
                Connection con = DriverManager.getConnection(url, username, password);
                Statement st = con.createStatement();
                st.executeUpdate(quary);
//                ResultSet rs=st.executeQuery(quary);
                setVisible(false);
                JOptionPane.showMessageDialog(this, "ADD successfully");
                new payment();
            } catch (Exception ei) {
                System.out.println(ei);
            }
        }

    }
}
