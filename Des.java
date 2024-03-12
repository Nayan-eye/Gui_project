package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  Des extends JFrame implements ActionListener {
    JButton Back,BOOK_TICKET;
    JPanel jPanel;
    Font my_font=new Font("Algerian",Font.BOLD,28);
    Font my_newfont=new Font("Bahnschrift SemiBold",Font.BOLD,12);
    public Des(){
        setBounds(10,10,1250,600);
        setTitle("Dashboard");
        JLabel la1=new JLabel();
        la1.setBounds(10,0,1250,550);
        JPanel db= new JPanel();
        JLabel dbn=new JLabel();
        dbn.setText("TRAVEL AND TOURISM MANAGEMENT");
        dbn.setBounds(50,10,80,30);
        dbn.setFont(my_font);
        dbn.setForeground(Color.white);
        db.add(dbn);
        db.setBounds(0,0,1250,50);
        db.setBackground(new Color(0,0,200));

        ImageIcon icon=new ImageIcon("C:\\Users\\nayan\\IdeaProjects\\project1\\src\\images2\\travel2.jpg");
        Image img=icon.getImage();
        Image imgscal=img.getScaledInstance(1250,550,Image.SCALE_SMOOTH);
        ImageIcon scalicon=new ImageIcon(imgscal);
        la1.setIcon(scalicon);
        jPanel=new JPanel();
        jPanel.setBounds(0,0,120,590);
        jPanel.setBackground(Color.blue);
        jPanel.setLayout(null);
        add(jPanel);
        add(la1);
        BOOK_TICKET=new JButton("BOOK_TOUR");
        BOOK_TICKET.setBounds(0,0,120,50);
        BOOK_TICKET.setBackground(new Color(255,204,0));
        BOOK_TICKET.setForeground(Color.black);
        BOOK_TICKET.setFont(my_newfont);
        jPanel.add(BOOK_TICKET);

        Back=new JButton("BACK");
        Back.setBounds(0,510,120,50);
        Back.setBackground(Color.cyan);
        Back.setForeground(Color.BLACK);
        Back.setFont(my_newfont);
        jPanel.add(Back);
        Back.addActionListener(this);
        BOOK_TICKET.addActionListener(this);


        la1.add(db);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Des();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==Back){
        setVisible(false);
    }
    if (e.getSource()==BOOK_TICKET){
        setVisible(false);
       new view_package();
      }

    }
}
