package gui_pro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assignment extends JFrame implements ActionListener {
    JTextField result;
    JButton[]number=new JButton[10];
    JButton[]function=new JButton[9];
    Font my_font=new Font("Isotope",Font.BOLD,20);
    JButton ba1,ba2,ba3,ba4,ba5,ba6,ba7;
    JButton ba8,ba9;
    double num1=0,num2=0,res=0;
    char opr;
    public Assignment() {
        setTitle("Normal calculator");

        setBounds(30,30,450,600);
        setLayout(null);
       setBackground(Color.white);
        ba1=new JButton();
        ba2=new JButton();
        ba3=new JButton();
        ba4=new JButton();
        ba5=new JButton();
        ba6=new JButton();
        ba7=new JButton();
        ba8=new JButton(".");
        ba9=new JButton("=");
        function[0]=ba1;
        function[1]=ba2;
        function[2]=ba3;
        function[3]=ba4;
        function[4]=ba5;
        function[5]=ba6;
        function[6]=ba7;
        function[7]=ba8;
        function[8]=ba9;
        for (int i = 0; i < 9; i++) {
            function[i].addActionListener(this);
            function[i].setFont(my_font);
            function[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
           number[i]=new JButton(String.valueOf(i));
            number[i].addActionListener(this);
            number[i].setFont(my_font);
            number[i].setFocusable(false);
        }
       JLabel label=new JLabel();
       label.setBounds(0,0,450,600);
        ImageIcon icon=new ImageIcon("C:\\Users\\nayan\\IdeaProjects\\project1\\src\\images2\\cal.jpeg");
        Image img=icon.getImage();
        Image imasc=img.getScaledInstance(450,600,Image.SCALE_SMOOTH);
        ImageIcon im=new ImageIcon(imasc);
        label.setIcon(im);
        label.setLayout(null);
        add(label);
        JPanel panel=new JPanel();
        panel.setBounds(0,70,450,520);
        panel.setBackground(new Color(0,100,180));
        panel.setLayout(new GridLayout(6,4,3,3));
        label.add(panel);

        ba1.setText("+");
        ba1.setBackground(new Color(255,255,255));
        panel.add(number[1]);
        panel.add(number[2]);
        panel.add(ba1);
        ba2.setText("-");
        ba2.setBackground(new Color(255,255,255));
        panel.add(number[3]);
        panel.add(number[4]);
        panel.add(ba2);
        ba3.setText("*");
        ba3.setBackground(new Color(255,255,255));
        panel.add(number[5]);
        panel.add(number[6]);
        panel.add(ba3);
        ba4.setText("/");
        ba4.setBackground(new Color(255,255,255));
        panel.add(number[7]);
        panel.add(number[8]);
        panel.add(ba4);
        ba5.setText("%");
        ba5.setBackground(new Color(255,255,255));
        panel.add(number[9]);
        panel.add(number[0]);
        panel.add(ba5);
        result=new JTextField();
        result.setBounds(10,0,300,60);
        result.setBorder(BorderFactory.createEmptyBorder());
        result.setBackground(new Color(51,150,160)) ;
        result.setFont(my_font);
        label.add(result);
        ba6.setText("AC");
        ba6.setBounds(300,300,80,30);
        ba6.setBackground(new Color(255,255,255));
        panel.add(ba6);
        ba7.setBounds(340,10,70,50);
        ba7.setText("BACK");
        ba7.setBorder(BorderFactory.createEmptyBorder());
        ba7.setBackground(new Color(255,204,0));
        label.add(ba7);
        panel.add(ba8);
        panel.add(ba9);
       setVisible(true);

    }
    public static void main(String[] args) {

      new Assignment();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
        if(e.getSource()==number[i]) {
            result.setText(result.getText().concat(String.valueOf(i)));
        }
        }
        if(e.getSource()==ba8){
            result.setText(result.getText().concat("."));
        }
        if(e.getSource()==ba1){
            num1= Double.parseDouble(result.getText());
            opr='+';
            result.setText("");
        }
        if(e.getSource()==ba2){
            num1= Double.parseDouble(result.getText());
            opr='-';
            result.setText("");

        }
        if(e.getSource()==ba3){
            num1= Double.parseDouble(result.getText());
            opr='*';
            result.setText("");
        }
        if(e.getSource()==ba4){
            num1= Double.parseDouble(result.getText());
            opr='/';
            result.setText("");
        }
        if(e.getSource()==ba5){
            num1= Double.parseDouble(result.getText());
            opr='%';
            result.setText("");
        }
        if (e.getSource()==ba9){
            num2=Double.parseDouble(result.getText());
            switch (opr){
                case '+':
                    res=num1+num2;
                    break;
                case '-':
                    res=num1-num2;
                    break;
                case '*':
                    res=num1*num2;
                    break;
                case '/':
                    res=num1/num2;
                    break;
                case '%':
                    res=num1%num2;
                    break;

            }
            result.setText(String.valueOf(res));
            num1=res;
        }
        if(e.getSource()==ba6){
            result.setText("");
        }
        if(e.getSource()==ba7){
          setVisible(false);
          new Des();
        }

    }
}
