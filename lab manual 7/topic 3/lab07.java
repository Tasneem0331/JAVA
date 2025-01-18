package money;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MoneyExchanger extends JFrame implements ActionListener {
JButton bt1=new JButton("Convert");
JLabel label=new JLabel();
JTextField text=new JTextField();
JLabel input=new JLabel();

Container c;

MoneyExchanger(){
    c=this.getContentPane();
    c.setLayout(null);
    bt1.setBounds(150,100,80,30);
    label.setBounds(300,50,80,30);
    text.setBounds(100,50,80,30);
    input.setBounds(100,20,80,30);
    c.add(text);
    c.add(bt1);
    c.add(label);
    c.add(input);
    input.setText("Input $");
    bt1.addActionListener(this);
}
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bt1){
bt1.setBackground(Color.green);
            int i= Integer.parseInt(text.getText());
            if(i>=0){
           double tk=103.23*i;
            label.setText("Tk="+tk);}
            else
               JOptionPane.showMessageDialog(null,"Invalid input");
        }
    }
}
public class lab07 {
    public static void main(String[] args){
        MoneyExchanger Frame=new MoneyExchanger();
        Frame.setTitle("Well come to CSE RUET");
        Frame.setVisible(true);
        Frame.setSize(400,400);
        Frame.setResizable(false);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
