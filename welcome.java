package gui_pro;
import java.awt.*;
import javax.swing.*;
public class welcome extends JFrame implements Runnable {
    Thread t1;
    public welcome() {
		setBounds(40,30,1200,600);
        setBackground(Color.white);
        setTitle("WELCOME PAGE");
        setLayout(new FlowLayout());
        JLabel la=new JLabel();
        la.setBounds(0,0,1150,550);
        ImageIcon icon=new ImageIcon("C:\\Users\\nayan\\IdeaProjects\\project1\\src\\images2\\travel3.jpg");
        Image img=icon.getImage();
        Image imgscal=img.getScaledInstance(1150,550,Image.SCALE_SMOOTH);
        ImageIcon scalicon=new ImageIcon(imgscal);
        la.setIcon(scalicon);
        la.setLayout(null);
        add(la);
        JLabel label=new JLabel();
        label.setText("welcome");
        label.setBounds(450,30,400,200);
        JLabel log=new JLabel("Pls wait a while...");
        log.setBounds(900,450,250,80);
        log.setFont(new Font("Aldhabi", Font.BOLD,20));
        label.setForeground(new Color(200,0,0));
        label.setFont(new Font("Algerian", Font.ITALIC,70));
        label.setForeground(Color.blue);
        label.setLayout(null);
        la.add(label);
        la.add(log);
//		setUndecorated(true);
        t1=new Thread(this);
        t1.start();
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(9000);
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
       new Login();
    }

    public static void main(String[] args) {
        welcome we=new welcome();
        we.setVisible(true);

//        int i;
//        int x=1;
//        for ( i=2; i<=600; i+=10,x+=7) {
//            we.setLocation(700-((i+x)/2),320-(i/2));
//            we.setSize(i+x,i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
                // TODO: handle exception
            }
        }
    }

