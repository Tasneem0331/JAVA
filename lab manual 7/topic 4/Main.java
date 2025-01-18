import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Calculator extends JFrame implements ActionListener, MouseListener {
    JButton[] bx = new JButton[16];
    String op=null;
    String str1="",str2="";
    Font f = new Font("Arial", Font.BOLD, 20);

    Font f2=new Font("Digital-7",Font.BOLD,18);
    Font f1 = new Font("Arial", Font.BOLD, 29);
    JLabel label = new JLabel();
    Container c;

    Calculator() {
        c = this.getContentPane();
        c.setBackground(Color.DARK_GRAY);
        c.setLayout(null);
        label.setBounds(10, 10, 270, 60);
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(f2);
        c.add(label);
        label.setHorizontalAlignment(JLabel.RIGHT);

        //button starts

        int i;
        int k = 1, j = 1;
        for (i = 1; i <= 9; i++) {
            bx[i] = new JButton(Integer.toString(i));
            bx[i].setBounds(20 + (j - 1) * 65, 90 + (k - 1) * 60, 50, 50);
            bx[i].setFont(f);
            c.add(bx[i]);
            bx[i].addActionListener(this);
            bx[i].addMouseListener(this);
            j++;
            if (i % 3 == 0) {
                k++;
                j = 1;
            }

        }
        //for 0button;
    i=1;
    bx[0]=new JButton("0");
    bx[0].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[0].setFont(f);
        bx[0].addMouseListener(this);
        bx[0].addActionListener(this);
    c.add(bx[i-1]);
        //for +
    i=2;
    bx[10]=new JButton("+");
    bx[10].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[10].setFont(f);
    c.add(bx[10]);
        bx[10].addMouseListener(this);
        bx[10].addActionListener(this);

        //-
    i=3;
    bx[11]=new JButton("-");
    bx[11].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[11].setFont(f);
    c.add(bx[11]);
    bx[11].addMouseListener(this);
        bx[11].addActionListener(this);

        //=
    i=4;
    bx[14]=new JButton("=");
    bx[14].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[14].setFont(f);
    bx[14].setBackground(Color.pink);
        bx[14].addActionListener(this);
        bx[14].addMouseListener(this);
    c.add(bx[14]);

    //for *
    i=4;
    k--;
    bx[12]=new JButton("*");
    bx[12].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[12].setFont(f);
        bx[12].addMouseListener(this);
       bx[12].addActionListener(this);
   // bx[12].setBackground(Color.pink);
    c.add(bx[12]);

    //for /
    i=4;
    k--;
    bx[13]=new JButton("/");
    bx[13].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[13].setFont(f);
   //bx[13].setBackground(Color.pink);
       bx[13].addMouseListener(this);
        bx[13].addActionListener(this);
    c.add(bx[13]);

    //for C
    i=4;
    k--;
    bx[15]=new JButton("C");
    bx[15].setBounds(20+(i-1)*65,90+(k-1)*60,50,50);
    bx[15].setFont(f);
       bx[15].addMouseListener(this);
        bx[15].addActionListener(this);
    bx[15].setBackground(Color.pink);
    c.add(bx[15]);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<=9;i++){
            if(e.getSource()==bx[i]){
                str1=str1+Integer.toString(i);
                label.setText(str1);

            }
        }
        if(e.getSource()==bx[15]){
            str1="";
            str2="";
            label.setText(str1);

        }
        for(int i=10;i<=13;i++) {
            if (e.getSource() == bx[i]) {
                //str1""=str2""
                switch(i){
                    case 10:op="+";break;
                    case 11:op="-";break;
                    case 12:op="*";break;
                    case 13:op="/";break;
                }
                str2=str1;
                label.setText(op);
                str1="";
            }
            //System.out.println("str2="+str2);
            //System.out.println("str1="+str1);
            if(e.getSource()==bx[14]){

                int x=Integer.parseInt(str2);
                int y=Integer.parseInt(str1);
                //System.out.println(x);
                double z=0;
                int count=0;

                switch(op){
                    case "+":z=x+y;break;
                    case "-":z=x-y;break;
                    case "*":z=x*y;break;
                    case "/":{
                                if(y==0){
                                count=1;
                                 }
                               else{
                                z=(double)x/y;
                              }
                           }
                    break;
                }
                if(count==1){
                    label.setText("Math Error");
                }
                else {
                label.setText(""+z);}
            }

        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i <=9; i++) {
            if (e.getSource() == bx[i]){
                bx[i].setForeground(Color.green);
                bx[i].setFont(f1);
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i <=15; i++) {
            if (e.getSource() == bx[i]){
                bx[i].setForeground(null);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Calculator frame=new Calculator();
        frame.setTitle("My calculator");
        frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setBounds(50,50,300,400);
      frame.setResizable(false);


    }
}