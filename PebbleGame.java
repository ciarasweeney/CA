import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        if(playerNoInt < 0){
            System.exit(0);
        }
        return playerNoInt;
    }

    public ArrayList<String> fileReader(String filename, int noOfPlayers) throws FileNotFoundException{

        ArrayList<String> pebbles = new ArrayList<String>();
        Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter(",");
        String nextLine;
        while (sc.hasNext()){
            nextLine = sc.next();
            fileCheck(nextLine);
            pebbles.add(new String(nextLine));
        }
        sc.close();

        if(pebbles.size() < (noOfPlayers*3)){
            //warn instead of kill
            System.exit(0);
        }

        return pebbles;
    }

    public int fileCheck(String String){
        int fileToInt = 0;
        try {
            fileToInt = Integer.parseInt(String);
        }
        catch (NumberFormatException e)
        {
            //warn instead of kill
        System.exit(0);
        }

        if(fileToInt < 0){
            //wanr instead of kill
            System.exit(0);
        }
        return fileToInt;       
    }
 
/*    public static class PlayerInitialisation implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRunnable running");
            
        }
        
    }
*/
    public static void main(String args[]) throws FileNotFoundException {

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
        System.out.print(game.fileReader("negative_example.csv", noOfPlayers));
        
        
    }
}
