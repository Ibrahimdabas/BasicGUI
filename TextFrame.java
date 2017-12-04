package textframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextFrame extends JFrame implements ActionListener {

    private static final int FRAME_WIDTH    = 300;

    //private static final int FRAME_HEIGHT   = 250;
    //different height so the images/icons fit
    
    private static final int FRAME_HEIGHT = 550;
    
    private static final int FRAME_X_ORIGIN = 150;

    private static final int FRAME_Y_ORIGIN = 250;

    private static final String EMPTY_STRING = "";

    private static final String NEWLINE = System.getProperty("line.separator");

    private JButton clearButton;

    private JButton addButton;
    
    private JButton exitButton;
    
    //test JButton for an icon button
    private JButton imageButton;
    
    private JTextField inputLine;

    private JTextArea  textArea;
    
    //adding a JLabel for an image
    private JLabel imgLabel;
    
    public static void main(String[] args) {
        TextFrame frame = new TextFrame() {};
        frame.setVisible(true);
    }
    public TextFrame() {
        Container contentPane;

        //set the frame properties
        setSize      (FRAME_WIDTH, FRAME_HEIGHT);
        setResizable (false);
        //setResizable makes sure that the objects inside the JFrame are "ordered"
        //ie; not placed randomly in one line but in a more aesthetic way
        
        setTitle     ("Program TextFrame Ch14");
        setLocation  (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);

        contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout());

        //adding the JLabel with an image in it
        imgLabel = new JLabel(new ImageIcon("icon.png"));
        contentPane.add(imgLabel);
        
        textArea = new JTextArea();
        textArea.setColumns(22);
        textArea.setRows(8);
        //we use setColumns and setRows to define the size of the textArea
        //setColumns and setRows are replacable by textArea.setSize(width, height);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));
        //change the color of the textArea's border
        
//---------------------------------------
//  Different types of borders; some borders effective if background color is changed
//
//        textArea.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.gray));
//        textArea.setBorder(BorderFactory.createLoweredBevelBorder());
//        textArea.setBorder(BorderFactory.createRaisedBevelBorder());
//        textArea.setBorder(BorderFactory.createTitledBorder("JTextArea"));
//
//-------------------------------------

        textArea.setEditable(false);
        contentPane.add(textArea);

//----------------------------------------------------
//      To add scroll bars to the text area, replace the above statement
//      contentPane.add(textArea) with the following code      
//      i removed the comment in order to avoid the textArea growing too big
//      original code had this section commented
//      ScrollPanes only appear when the area grows big enough for them to be needed
        JScrollPane scrollText= new JScrollPane(textArea);
        scrollText.setSize(200, 135);
        contentPane.add(scrollText);

//------------------------------------------------------
        //if we dont use the JScrollPane, the textArea eventually grows too big
        //and the buttons "disappear"
        
        inputLine = new JTextField();
        inputLine.setColumns(22);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);
        
        //create and place two buttons on the frame
        addButton = new JButton("ADD");
        contentPane.add(addButton);
        addButton.addActionListener(this);
        
        clearButton = new JButton("CLEAR");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        
        //adding a button that has an image inside of it
        imageButton = new JButton(new ImageIcon("icon_1.png"));
        contentPane.add(imageButton);
        
        //add a button to close the program upon being clicked
        exitButton = new JButton("EXIT");
        contentPane.add(exitButton);
        exitButton.addActionListener(this);
        //Instead of making the action listener here, it is defined underneath the code in a seperate class
        //where it is initialized, this also makes code easier to read and edit
        
        /* exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exiting the frame.....");
                System.exit(0);
            }
        });
        */
        
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

//-------------------------------------------------
//      Public Methods:
//
//          void    actionPerformed   (   ActionEvent        )
//
//------------------------------------------------

    /**
     * Standard method to respond the action event.
     *
     * @param event the ActionEvent object
     *
     */
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) event.getSource();

            if (clickedButton == addButton) {
                addText(inputLine.getText());
            } else if(clickedButton == exitButton) {
                JOptionPane.showMessageDialog(null, "Exiting the frame....");
                System.exit(0);
            } else {
                clearText( );
            }

        } else { //the event source is inputLine
            addText(inputLine.getText());
        }
    }

    private void addText(String newline) {
        textArea.append(newline + NEWLINE);
        inputLine.setText("");
    }

    private void clearText( ) {
        textArea.setText(EMPTY_STRING);
        inputLine.setText(EMPTY_STRING);
    }

}
