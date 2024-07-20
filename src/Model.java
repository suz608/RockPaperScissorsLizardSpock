/**
 * Job of the model:
 * - Produces computer choice
 * - Gets user's choice from the controller
 * - Decides who's the winner
 * - Passes the winner to the controller
 */

import java.util.Random;

public class Model {
    int userChoice;
    Choice computerChoice;
    Winner w;

    public Model(){
    }

    public String getComputerChoice(){
        switch (computerChoice) {
            case Spock:
                return "Spock";
            case Paper:
                return "Paper";
            case Scissors:
                return "Scissors";
            case Rock:
                return "Rock";
            case Lizard:
                return "Lizard";
            default:
                return "NULL";
        }
    }
    public String getWinner(){
        w=comparator(getUserChoice(userChoice),getRandom());
        if(w==Winner.You){return "You";}else if(w==Winner.Computer){return "Computer";}else return "Tie";
    }

    public Winner comparator(Choice a,Choice b){
        switch (a){
            case Paper:
                if(b== Choice.Rock ||b== Choice.Spock){return Winner.You;}
                if(b==Choice.Paper){return null;}
                break;
            case Spock:
                if(b== Choice.Scissors ||b== Choice.Rock){return Winner.You;}
                if(b==Choice.Spock){return null;}
                break;
            case Rock:
                if(b== Choice.Scissors ||b== Choice.Lizard){return Winner.You;}
                if(b==Choice.Rock){return null;}
                break;
            case Scissors:
                if(b== Choice.Lizard ||b== Choice.Paper){return Winner.You;}
                if(b==Choice.Scissors){return null;}
                break;
            case Lizard:
                if(b== Choice.Paper ||b== Choice.Spock){return Winner.You;}
                if(b==Choice.Lizard){return null;}
                break;
        }
        return Winner.Computer;
    }

    public void setUserChoice(int i){
        userChoice=i;
    }
    public Choice getUserChoice(int userChoice){
        return intToChoice(userChoice);
    }

    public Choice getRandom(){
        Random random=new Random();
        computerChoice=intToChoice(random.nextInt(1,6));
        return computerChoice;
    }

    public Choice intToChoice(int i){
        switch(i){
            case 1:
                return Choice.Paper;
            case 2:
                return Choice.Lizard;
            case 3:
                return Choice.Rock;
            case 4:
                return Choice.Scissors;
            case 5:
                return Choice.Spock;
        }
        return null;
    }


}
