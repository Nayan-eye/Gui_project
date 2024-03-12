package gui_pro;

import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Regs extends JFrame implements ActionListener {
    String url="jdbc:postgresql://localhost:5432/test";
    String username="postgres";
    String password="sql@2024";
    JLabel name,Num,Email,la3,la4;
    JTextField nameText,NumText,EmailText,tx3;
    JButton back,register;
    Font new_font=new Font("Times New Roman",Font.BOLD,16);
    Font my_font=new Font("Georgia",Font.BOLD,14);
    Font new_font_=new Font("Times New Roman",Font.BOLD,14);
    public Regs(){
        setBounds(450,30,350,550);
        setTitle("Register");
        name=new JLabel("Name");
        name.setBounds(20,20,80,60);
        name.setFont(new_font);
        name.setForeground(Color.blue);
        Num=new JLabel("Phone No..");
        Num.setBounds(20,80,100,60);
        Num.setFont(new_font);
        Num.setForeground(Color.blue);
        Email=new JLabel("Email..");
        Email.setBounds(20,140,80,60);
        Email.setFont(new_font);
        Email.setForeground(Color.blue);
        la3=new JLabel("Password");
        la3.setBounds(20,190,100,60);
        la3.setForeground(Color.blue);
        la3.setFont(my_font);
        nameText =new JTextField();
        nameText.setBounds(100,35,200,30);
        nameText.setFont(my_font);
        NumText=new JTextField();
        NumText.setBounds(115,90,200,30);
        NumText.setFont(my_font);
        EmailText=new JTextField();
        EmailText.setBounds(110,150,200,30);
        EmailText.setFont(my_font);
        tx3=new JTextField();
        tx3.setBounds(110,200,200,30);
        back=new JButton("Back");
        back.setBounds(20,250,110,30);
        back.setFont(my_font);
        back.setBackground(Color.cyan);
        back.addActionListener(this);
        register=new JButton("Register");
        register.setBounds(170,250,150,30);
        register.setFont(my_font);
        register.setBackground(Color.cyan);
        register.addActionListener(this);
        la4=new JLabel();
        la4.setText("***AFTER REGISTER RELOGIN YOURSELF***");
        la4.setBounds(0,260,350,80);
        la4.setForeground(Color.red);
        la4.setFont(new_font_);
        JLabel regim=new JLabel();
        regim.setBounds(100,300,100,200);
        ImageIcon img1=new ImageIcon("C:\\Users\\nayan\\IdeaProjects\\project1\\src\\images2\\register.jpg");
        Image img2=img1.getImage();
        Image imgscal=img2.getScaledInstance(150,140,Image.SCALE_SMOOTH);
        ImageIcon im=new ImageIcon(imgscal);
        regim.setIcon(im);
        add(name);
        add(Num);
        add(Email);
        add(NumText);
        add(nameText);
        add(EmailText);
        add(back);
        add(register);
        add(la3);
        add(tx3);
        add(la4);
        add(regim);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
       new Regs();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
        if (e.getSource()==register){
            String name=nameText.getText();
            String number=NumText.getText();
            String email=EmailText.getText();
            String passwoard=tx3.getText();
            String quary="INSERT INTO customer values('"+number+"','"+name+"','"+passwoard+"','"+email+"')";
            try {
                Connection con= DriverManager.getConnection(url,username,password);
                Statement st= con.createStatement();
                st.executeUpdate(quary);
//                ResultSet rs=st.executeQuery(quary);
                setVisible(false);
            JOptionPane.showMessageDialog(this,"Register successfully");
            new Login();
            }catch (Exception ei){
                System.out.println(ei);
            }

        }
    }
}
