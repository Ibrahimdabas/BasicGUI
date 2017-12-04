package basicgui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BasicGUI extends JFrame implements ActionListener {
    
    public static void main(String[] args) {
        JFrame J;
        J = new JFrame();
        String title = "Ye XD";
        J.setTitle(title);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();
        double l =  screenSize.getHeight();
        
        /*
         * J.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         * OR we can not use window constants
         */
        
        J.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //J.setSize(600,300);
        
        J.setSize(900,600);
        //There is no need for setSize when we use J.pack();
        
        /*
         * J.setLocation(150, 250);
         * OR use this to center
         */
        
        J.setLocationRelativeTo(null);
        
        Container c = J.getContentPane();
        
       /*
        * c.setBackground(Color.black);
        * OR we can use new Color(rgb,rgb,rgb);
        * c.setBackground(new Color(150,65,157));
        */
        
        c.setBackground(Color.BLUE);
        c.setLayout(new FlowLayout());
        
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Exit");
        
        JLabel label;
        JTextArea textArea = new JTextArea();
        textArea.setText("text area\n");
        textArea.append("with multiple lines");
        
        final JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(150,50));
        
        JLabel imgLabel = new JLabel(new ImageIcon("icon.png"));
        
        label = new JLabel("Welcome to uhhhhhhhhhh ", JLabel.CENTER);
        label.setForeground(new Color(150,65,157));
        Font f = label.getFont();
        label.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exiting Frame....");
                System.out.println("NOOOOOOOOOOOOOO");
                System.exit(0);
            }
        });
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "This button doesn't do anything yet");
                //get text in field after initalizing the text field
                final String fieldText = field.getText();
                JOptionPane.showMessageDialog(null, fieldText);
                System.out.println("YESSSSSSSSSSSS");
            }
        });
        //ok.addActionListener(eventListener);
        //cancel.addActionListener(eventListener);
        c.add(imgLabel);
        c.add(textArea);
        c.add(label);
        c.add(field);
        c.add(ok);
        c.add(cancel);
        //make the frame components show immediatly
        J.pack();
        J.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
