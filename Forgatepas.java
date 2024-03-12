package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Forgatepas extends JFrame implements ActionListener {
    String url="jdbc:postgresql://localhost:5432/test";
    String username="postgres";
    String password="sql@2024";
    JLabel emailverify,re;
    JTextField emailtext;
    JButton forget;
    Font my_font=new Font("Georgia",Font.BOLD,16);
    Font my_font_=new Font("Georgia",Font.BOLD,12);
    Forgatepas(){
        setBounds(400,150,400,200);
        setLayout(null);
        setBackground(Color.white);
        emailverify=new JLabel("EMAIL");
        emailverify.setBounds(20,40,80,60);
        emailverify.setForeground(Color.blue);
        emailverify.setFont(my_font);
        add(emailverify);
        emailtext=new JTextField();
        emailtext.setBounds(115,50,200,30);
        add(emailtext);
        re=new JLabel();
        re.setText("Fill email to recover password");
        re.setBounds(20,20,300,40);
        re.setForeground(Color.red);
        re.setFont(my_font_);
        add(re);
        forget=new JButton("Recover");
        forget.setBounds(230,100,120,30);
        forget.setBackground(Color.white);
        forget.setFont(my_font);
        forget.addActionListener(this);
        add(forget);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Forgatepas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==forget){
            String email=emailtext.getText();
            String quary1="SELECT * FROM customer password where email='"+email+"'";
            try {
                Connection con= DriverManager.getConnection(url,username,password);
                Statement str= con.createStatement();
                ResultSet rs=str.executeQuery(quary1);
                rs.next();
                String password= rs.getString(1);
                System.out.println(password);
                setVisible(false);
                JOptionPane.showMessageDialog(this,"Recover successfully");
                }catch (Exception ei){
                    System.out.println(ei);
                }
        }
        }
    }

