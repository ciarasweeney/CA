import java.util.Scanner;
import java.util.concurrent.*;

public class PebbleGame extends Thread {

    private int id;

    public PebbleGame(int i){
        this.id = i;
    }

    public int playerNoCheck(String playerNo) throws NumberFormatException{
        int playerNoInt = 0;
        try {
            playerNoInt = Integer.parseInt(playerNo);
        }
        catch (NumberFormatException e)
        {
        System.exit(0);
        }
        return playerNoInt;
    }
 
/*    public static class PlayerInitialisation implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRunnable running");
            
        }
        
    }
*/
    public static void main(String args[]) {

        PebbleGame game = new PebbleGame(0);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter number of players:");
        String noOfPlayersInput = input.nextLine();
        Integer noOfPlayers = game.playerNoCheck(noOfPlayersInput);
        ExecutorService executor = Executors.newFixedThreadPool(noOfPlayers);
        /*for(int i=1; i <= noOfPlayers; i++){
            Thread object = new Thread(new )

            System.out.println(i);
        }*/
        System.out.println("test");
    }
}
