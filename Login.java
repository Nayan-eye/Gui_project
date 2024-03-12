package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {
    String url="jdbc:postgresql://localhost:5432/test";
    String username="postgres";
    String password="sql@2024";
        JLabel la1,la2,la3,la4;
        JTextField tx1,tx2,tx3;
        JButton login,reg,forget;
        Font my_font=new Font("Georgia",Font.BOLD,16);
    Font new_font=new Font("Times New Roman",Font.BOLD,12);
       public Login(){
            setBounds(450,30,350,550);
            setBackground(Color.white);
            setLayout(null);
           JLabel label1=new JLabel();
           label1.setBounds(50,300,270,200);
           ImageIcon icon=new ImageIcon("C:\\Users\\nayan\\IdeaProjects\\project1\\src\\images2\\login.jpeg");
           Image img=icon.getImage();
           Image imasc=img.getScaledInstance(270,120,Image.SCALE_SMOOTH);
           ImageIcon im=new ImageIcon(imasc);
           label1.setIcon(im);
            la1=new JLabel("Name..");
            la1.setBounds(20,20,80,60);
            la1.setForeground(Color.blue);
            la1.setFont(my_font);
           la2=new JLabel("Phone no..");
           la2.setBounds(20,80,100,60);
           la2.setForeground(Color.blue);
           la2.setFont(my_font);
           la3=new JLabel("Password");
           la3.setBounds(20,130,100,60);
           la3.setForeground(Color.blue);
           la3.setFont(my_font);
           la4=new JLabel();
           la4.setText("***IF NO ACCOUNT THEN PLS REGISTER YOURSELF***");
           la4.setBounds(0,185,350,80);
           la4.setForeground(Color.red);
           la4.setFont(new_font);
           tx1=new JTextField();
           tx1.setBounds(100,35,200,30);

           tx2=new JTextField();
           tx2.setBounds(115,90,200,30);
           tx3=new JTextField();
           tx3.setBounds(110,150,200,30);
           login=new JButton("Login");
           login.setBounds(20,250,110,30);
           login.setBackground(Color.cyan);
           login.setFont(my_font);
           login.addActionListener(this);
           reg=new JButton("REGISTER");
           reg.setBounds(170,250,150,30);
           reg.setBackground(Color.cyan);
           reg.setFont(my_font);
           reg.addActionListener(this);
           forget=new JButton("Forget");
           forget.setBounds(100,300,150,30);
           forget.setBackground(Color.cyan);
           forget.setFont(my_font);
           forget.addActionListener(this);
           add(label1);
           add(la1);
           add(tx1);
           add(la2);
           add(tx2);
           add(la3);
           add(tx3);
           add(la4);
           add(login);
           add(reg);
           add(forget);
           setVisible(true);
        }
    public static void main(String[] args) {
         new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reg){
         setVisible(false);
         new Regs();
        }
        if(e.getSource()==login){
            String name=tx1.getText();
            String number=tx2.getText();
            String passwoard=tx3.getText();
            String quary1="SELECT * FROM customer where name='"+name+"'AND password='"+passwoard+"'AND number='"+number+"'";
            try {
                Connection con= DriverManager.getConnection(url,username,password);
                Statement str= con.createStatement();
                ResultSet rs=str.executeQuery(quary1);
             if (rs.next()){
                 setVisible(false);
                 new Loading(name);
             }
             else {
                 JOptionPane.showMessageDialog(this,"WRONG DETAILS");
             }
            }catch (Exception ei){
                System.out.println(ei);
            }
        }
        if(e.getSource()==forget){
            setVisible(false);
            new Forgatepas();
        }
    }
}
