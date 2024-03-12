package gui_pro;

import javax.swing.*;
import java.awt.*;

public class Loadiing2 extends JFrame implements Runnable{
    JProgressBar jp;
    String namem;
    JLabel name1;
    Thread t;
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 101; i++) {
                int max = jp.getMaximum();
                int value = jp.getValue();
                if (value < max) {
                    jp.setValue(jp.getValue() + 1);
                } else {
                    setVisible(false);
                    JOptionPane.showMessageDialog(this, "BOOKING SUCCESSFULLY");
                }
                Thread.sleep(60);
            }
        }catch (Exception ei){
            System.out.println(ei);
        }
    }
    JLabel lable1,lable2;
    Font my_font=new Font("Algerian",Font.BOLD,18);
    Loadiing2(String name){
        this.namem=name;
        t=new Thread(this);
        setBounds(400,150,500,300);
        setBackground(new Color(225,225,225));
        setLayout(null);
        lable1=new JLabel();
        lable1.setText("YOUR PAYMENT IS PROCESSING...");
        lable1.setBounds(65,5,350,100);
        lable1.setFont(my_font);
        lable1.setForeground(Color.blue);
        add(lable1);
        lable2=new JLabel();
        lable2.setText("PLS WAIT..");
        lable2.setBounds(110,190,150,50);
        lable2.setFont(my_font);
        lable2.setForeground(Color.RED);
        add(lable2);
        name1 =new JLabel();
        name1.setBounds(200,220,250,50);
        name1.setText("Thank YOU "+namem);
        name1.setFont(my_font);
        name1.setForeground(Color.black);
        add(name1);
        jp=new JProgressBar();
        jp.setBounds(75,120,300,50);
        jp.setStringPainted(true);
        add(jp);
        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loadiing2("");
    }


}

