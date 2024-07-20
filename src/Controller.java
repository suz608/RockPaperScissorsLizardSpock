/**
 * Job of the controller:
 * - Takes user's input
 * - Maps users inputs to commands
 * - Sends the commands to the model
 * - Takes the model's result and give orders to the view to display the result
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.lang.Math.*;

public class Controller implements ActionListener,MouseListener{
    Model m;
    JFrameView v;

    public Controller(Model model,JFrameView view){
        this.m=model;
        this.v=view;
        view.setActionListener(this);
        view.setMouseListener(this);
    }

    public void go(){
        v.display();
    }

    public void mouseClicked(MouseEvent e){
        int x=e.getX();
        int y=e.getY();
        if(getDistPap(x,y)<80){m.setUserChoice(1);displayWinner();}
        else if(getDistLiz(x,y)<80){m.setUserChoice(2);displayWinner();}
        else if(getDistRoc(x,y)<80){m.setUserChoice(3);displayWinner();}
        else if(getDistSci(x,y)<80){m.setUserChoice(4);displayWinner();}
        else if(getDistSpo(x,y)<80){m.setUserChoice(5);displayWinner();}
    }

    public void displayWinner(){
        String winner= m.getWinner();
        v.showText(true);
        if(winner.equals("Tie")){
            v.setText("Computer chose "+m.getComputerChoice() +".\n"+"It is a tie!");
        }else {
            v.setText("Computer chose " + m.getComputerChoice() + ".\n" + winner + " won!");
        }
    }

    public double getDistLiz(int x,int y){
        //The center of lizard is (160,400)
        return Math.sqrt((x-160)*(x-160)+(y-400)*(y-400));
    }

    public double getDistRoc(int x,int y){
        //The center of rock is (355,400)
        return Math.sqrt((x-355)*(x-355)+(y-400)*(y-400));
    }

    public double getDistSpo(int x,int y){
        //The center of spock is (97,210)
        return Math.sqrt((x-97)*(x-97)+(y-210)*(y-210));
    }
    public double getDistSci(int x,int y){
        //The center of scissors is (247,98)
        return Math.sqrt((x-247)*(x-247)+(y-98)*(y-98));
    }
    public double getDistPap(int x,int y){
        //The center of paper is (410,210)
        return Math.sqrt((x-410)*(x-250)+(y-410)*(y-210));
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            /**
             * An alternative way to get user's choice is using action event instead of mouse event
            case "Paper":
                m.setUserChoice(1);
            case "Lizard":
                m.setUserChoice(2);
            case "Rock":
                m.setUserChoice(3);
            case "Scissors":
                m.setUserChoice(4);
            case "Spock":
                m.setUserChoice(5);
             */
            case "Rules Button":
                v.setButtonInvisible();
                v.showText(true);
                v.setText("Rules:\nScissors cuts Paper.\nPaper covers Rock.\nLizard poisons Spock.\nSpock smashes Scissors.\nScissors decapitates Lizard.\nLizard eats Paper.\nPaper disproves Spock.\nSpock vaporizes Rock.\nAnd as it always has,rock crushes Scissors.\n\nClick on the picture to make your choice.\n\nYou can play unlimited times.");
                break;
            case "Back Button":
                v.setButtonBack();
                v.setText("");
                break;
            case "Exit Button":
                System.exit(0);
                break;
        }
    }
}
