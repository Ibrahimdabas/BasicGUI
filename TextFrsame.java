package textframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFrame extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT = 260;
    private static final int FRAME_X_ORIGIN = 150;
    private static final int FRAME_Y_ORIGIN = 250;
    private static final String EMPTY_STRING = "";
    private static final String NEWLINE = System.getProperty("line.separator");
    private float l1=0;
    private float l2=0;
    private JButton clearButton;
    private JButton addButton;
    private JButton exitButton;
     private JButton sum;
    private JButton minus;
    private JButton diri;
    private JButton multi;
    private JButton imageButton;
    private JTextField inputLine;
    private JTextArea  textArea;
    private JLabel imgLabel;    
    public static void main(String[] args) {
        TextFrame frame = new TextFrame() {};
        frame.setVisible(true);}
    public TextFrame() {
        
        Container contentPane;
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        setTitle     ("Program TextFrame Ch14");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());
        imgLabel = new JLabel(new ImageIcon("iw.png"));
        contentPane.add(imgLabel);
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        textArea.setEditable(false);
        contentPane.add(textArea);
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setSize(200, 135);
        contentPane.add(scrollText);
        inputLine = new JTextField();
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);
         addButton = new JButton("ADD");
        contentPane.add(addButton);
        addButton.addActionListener(this);
        sum = new JButton("+");
        contentPane.add(sum);
        sum.addActionListener(this);
         multi = new JButton("*");
        contentPane.add(multi);
        multi.addActionListener(this); 
        diri = new JButton("/");
        contentPane.add(diri);
        diri.addActionListener(this); 
        minus = new JButton("-");
        contentPane.add(minus);
        minus.addActionListener(this);
        clearButton = new JButton("CLEAR");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        imageButton = new JButton(new ImageIcon("iw.png"));
        contentPane.add(imageButton);
        exitButton = new JButton("EXIT");
        contentPane.add(exitButton);
        exitButton.addActionListener(this);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();
            if (clickedButton == addButton) {
                addText(inputLine.getText());
            } else if(clickedButton == exitButton) {
                textArea.append( "EXIT "+ NEWLINE);
             //   JOptionPane.showMessageDialog(null, "Exiting the frame....");
                System.exit(0);
            }else if(clickedButton == sum) {
                if (l1!=0&&l2!=0){
                    textArea.append( "the result of "+l1+" + "+l2+" = "+(l1+l2)+ NEWLINE);
               // JOptionPane.showMessageDialog(null,  "the result of "+l1+"+ "+l2+"="+(l1+l2));
                }
                else {
                   textArea.append( "please insert the tow numbers"+ NEWLINE); 
                }}
            else if(clickedButton == diri) {
                if (l1!=0&&l2!=0){
                    textArea.append( "the the result of "+l1+ " / "+l2+" = "+(l1/l2)+ NEWLINE);
              //  JOptionPane.showMessageDialog(null, "the the result of"+l1+ "/"+l2+" = "+(l1/l2));
                }
                else {
                  textArea.append( "please insert the tow numbers witout zero  "+ NEWLINE);
                }}
            else if(clickedButton == multi) {
                if (l1!=0&&l2!=0){
                    textArea.append( "the the result of "+l1+" * "+l2+" = "+(l1*l2)+ NEWLINE);
              //  JOptionPane.showMessageDialog(null, "the the result of"+l1+" *"+l2+" = "+(l1*l2));
                }
                else {
                   textArea.append( "please insert the tow numbers"+ NEWLINE); 
                }}
            else if(clickedButton == minus) {
               if (l1!=0&&l2!=0){
                   textArea.append( "the the result of "+l1+" - " +l2+" = "+(l1-l2)+ NEWLINE);
              //  JOptionPane.showMessageDialog(null, "the the result of "+l1+" -"+l2+" = "+(l1-l2));
               }
                else {
                   textArea.append( "please insert the tow numbers"+ NEWLINE);
                }}
            else
            {
                clearText( );
            }
        } else { 
            addText(inputLine.getText());
        }
    }
    private void addText(String newline) {
        if (l1==0){
            l1=Integer.parseInt(newline);
            
        }else if (l1!=0&&l2!=0){
            textArea.append( "Edit first num Enter second num "+ NEWLINE); 
            l1=Integer.parseInt(newline); 
            l2=0;
        }
        else{
            l2=Integer.parseInt(newline);
            System.out.println(l1);
        } 
        textArea.append(newline + NEWLINE);
        inputLine.setText("");
    }
    private void clearText( ) {
        l1=0;
        l2=0;
        textArea.setText(EMPTY_STRING);
        inputLine.setText(EMPTY_STRING);
    }
}
