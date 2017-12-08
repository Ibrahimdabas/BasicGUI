/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewCalc extends JFrame implements ActionListener {
public float l1=0;
public float l2=0;
private JButton multi;
private JButton exitButton;
private JButton sum;
private JButton minus;
private JButton addButton;
private JButton diri;
private JButton clearButton;
private JTextField inputLine;
private JLabel u;

    public static void main(String[] args) {
        NewCalc f=new NewCalc () {};
       f.setVisible(true);
    }
public NewCalc (){
    Container c;
    setSize(250,150);
    setResizable (false);
    setTitle("Calculater");
    setLocation(250,300);
    c=getContentPane( );
    c.setLayout(new FlowLayout());
      u=new JLabel();
        u.setText("TheResult");
        c.add(u);
    inputLine=new JTextField();
    inputLine.setColumns(22);
    c.add(inputLine);
  inputLine.addActionListener(this);
  JLabel 
  imgLabel = new JLabel(new ImageIcon("iw.png"));
        c.add(imgLabel);
    addButton = new JButton("ADD Num");
        c.add(addButton);
        addButton.addActionListener(this);
    sum = new JButton("+");
        c.add(sum);
        sum.addActionListener(this);
         multi = new JButton("*");
        c.add(multi);
        multi.addActionListener(this); 
        diri = new JButton("/");
        c.add(diri);
        diri.addActionListener(this); 
        minus = new JButton("-");
       c.add(minus);
        minus.addActionListener(this);
        exitButton = new JButton("EXIT");
        c.add(exitButton);
        exitButton.addActionListener(this);
        clearButton = new JButton("CLEAR");
        c.add(clearButton);
        clearButton.addActionListener(this);
      
        setDefaultCloseOperation( EXIT_ON_CLOSE );
}
     private void clearText( ) {
        l1=0;
        l2=0;
        u.setText("TheResult");
        inputLine.setText("");
    }
    private void addText(String newline) {
        if (l1==0){
            l1=Integer.parseInt(newline);
            
        }else if (l1!=0&&l2!=0){
          
            l1=Integer.parseInt(newline); 
            JOptionPane.showMessageDialog(null, "Edit the num 1 Insert num 2");
            l2=0;
        }
        else{
            l2=Integer.parseInt(newline);
            System.out.println(l1);
        
        }}
    @Override
    public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) ae.getSource();           
              if(clickedButton == exitButton) {
             System.exit(0);}
              else if (clickedButton == addButton)  {
                  
                 addText(inputLine.getText());
                         inputLine.setText("");     
                }
            else if(clickedButton == sum) {
               u.setText(" the result =  "+String.valueOf((l1+l2)));
               // JOptionPane.showMessageDialog(null, " the result of "+l1+" + " +l2+" = "+(l1+l2));
            }
                
            else if(clickedButton == diri) {
                if (l2!=0){
                    u.setText(" the result =  "+String.valueOf((l1/l2)));
                //JOptionPane.showMessageDialog(null, "the the result of "+l1+" / " +l2+" = "+(l1/l2));
                }
                else {
                    u.setText("divided by zero");
                // JOptionPane.showMessageDialog(null, " divide by zero");   
                }}
            else if(clickedButton == multi) {
                u.setText(" the result =   "+String.valueOf((l1*l2)));
               // JOptionPane.showMessageDialog(null, "the the result of "+l1+" * " +l2+" = "+(l1*l2));
            }
                else if(clickedButton == minus) {
                    u.setText(" the result =  "+String.valueOf((l1-l2)));
               // JOptionPane.showMessageDialog(null, "the result of "+l1+" - " +l2+" = "+(l1-l2));             
                }
                else 
                    clearText();
                
         }}}        
