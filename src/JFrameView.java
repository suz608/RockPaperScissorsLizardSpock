/**
 * Job of the view:
 * - Displays the window for the user
 * - Holds all the methods related to displaying
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class JFrameView extends JFrame{
    private JButton exitButton,rulesButton,backButton;
    private JPanel panel;
    private JTextPane text;
    // JTextPane could create more customized text compared with JTextField or JTextArea
    public JFrameView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Once the frames are closed, exit the program

        GridBagLayout g=new GridBagLayout();
        this.setLayout(g);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        // Set the layout

        this.setTitle("Rock, Paper, Scissors, Spock, Lizard ");
        // Set the title of the frame

        panel=new JPanel();
        ImageIcon icon=new ImageIcon(new ImageIcon("rps.png").getImage().getScaledInstance(500,500, 20));
        // Resize the loaded image
        panel.add(new JLabel(icon));
        this.add(panel);

        text=new JTextPane();
        text.setPreferredSize(new Dimension(175,160));
        text.setBackground(Color.pink);
        text.setFont(Font.getFont("DIALOG"));
        text.setText(" Welcome to the game!");
        this.add(text,c);

        rulesButton = new JButton("Help");
        rulesButton.setActionCommand("Rules Button");
        this.add(rulesButton);

        backButton = new JButton("Back");
        backButton.setActionCommand("Back Button");
        this.add(backButton);
        backButton.setVisible(false);

        exitButton = new JButton("Exit");
        exitButton.setActionCommand("Exit Button");
        this.add(exitButton);

        pack();
    }

    /**
     * Methods allows the controller to be the listener that listens to the event
     * taking inputs from the user
     * @param listener
     */
    public void setActionListener(ActionListener listener) {
        rulesButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        backButton.addActionListener(listener);
    }
    public void setMouseListener(MouseListener listener) {
        panel.addMouseListener(listener);
    }

    /**
     * All the methods related to visibility
     */

    public void display() {
        setVisible(true);
    }
    public void setButtonInvisible(){
        rulesButton.setVisible(false);
        backButton.setVisible(true);
    }

    public void setButtonBack(){
        rulesButton.setVisible(true);
        backButton.setVisible(false);
        showText(false);
    }

    public void showText(Boolean b){
        if(b){text.setVisible(true);}
        else text.setVisible(false);
    }

    /**
     * Set the String displayed by the text box
     * @param s
     */

    public void setText(String s){
        text.setText(s);
    }

}
