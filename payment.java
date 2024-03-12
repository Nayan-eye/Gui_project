package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class payment extends JFrame implements ActionListener {
   JLabel card_no,expire_date,Owner;
   JTextField notext,datetext,nametext;
    JButton ba, add;
    Font my_font=new Font("Georgia",Font.BOLD,16);
    payment(){
            setBounds(350,150,350,450);
            setLayout(null);
            card_no=new JLabel("CARD NO");
            card_no.setBounds(20,20,80,50);
            setFont(my_font);
            expire_date=new JLabel("Expire_date");
        expire_date.setBounds(20,65,80,50);
            setFont(my_font);
           Owner=new JLabel("CARD_Holder");
        Owner.setBounds(20,120,80,50);
            setFont(my_font);
            add(Owner);
            add(expire_date);
            add(card_no);
            notext=new JTextField();
           notext.setBounds(100,25,210,30);
            add(notext);
            datetext=new JTextField();
        datetext.setBounds(100,85,210,30);
            add(datetext);
            nametext=new JTextField();
        nametext.setBounds(110,130,210,30);
            add(nametext);
            ba=new JButton("Back");
            ba.setBounds(40,200,100,50);
            ba.setBackground(Color.cyan);
            add(ba);
            ba.addActionListener(this);
            add=new JButton("Next");
            add.setBounds(180,200,100,50);
            add.setBackground(Color.cyan);
            add(add);
            add.addActionListener(this);
            setVisible(true);
    }
    public static void main(String[] args) {
      new  payment();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ba){
            setVisible(false);
            new Des();
        }
        if (e.getSource()==add){
            String nsme = nametext.getText();
            setVisible(false);
            JOptionPane.showMessageDialog(this, "PAYMENT DETAILS RECEIVED");
            new Loadiing2(nsme);
        }

    }
}
