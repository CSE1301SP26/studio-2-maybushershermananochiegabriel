import java.util.Scanner;
public class Ruin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startAmount = 500;
        double winChance = .50;
        int winLimit = 1000;
        int count = 0;

        int x = startAmount;
        int simulations = 500;
        int lossCount = 0;
        for (int i = 0; i <= simulations; i++) {
            count = 0;
            startAmount = x;
        while (startAmount < winLimit && startAmount > 0) {
            double randomNumber = Math.random();
            boolean win = (randomNumber < winChance);
            if (win) {
                startAmount++;
            }
            else {
                startAmount--;
            }
            count++;
        }
        if (startAmount == winLimit){
            System.out.println("Simulation " + i +": "+ count +" WIN");

        }
        else{
            System.out.println("Simulation " + i +": "+ count +" LOSE");
            lossCount++;
        }
    }
    
        
        System.out.println("Losses: " + lossCount + " Simulations: " + simulations);
        double ruinRate = (double)lossCount / simulations;
        System.out.println("Ruin rate from simulation: " + ruinRate);

        double a = ((1 - winChance) / (winChance)); 

        double expectedRuin;

            if(winChance == 0.5) { 
                expectedRuin = (1.0-((double)x / winLimit));
                System.out.println("Expected ruin rate: " + expectedRuin);

            }
            else {
                expectedRuin = (Math.pow(a, x) - Math.pow(a, winLimit)) / (1-(Math.pow(a, winLimit)));
                System.out.println("Expected ruin rate: " + expectedRuin);
            }
    
        }

    }
