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
        //Remove whitespace
        String.replaceAll("\\s+","");
        try {
            System.out.println("current string:" + String);
            fileToInt = Integer.parseInt(String);
        }
        catch (NumberFormatException e)
        {
            //warn instead of kill
        System.out.println("Number execption:" + String);
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
        System.out.println("Please enter location of bag number 0 to load:");
        String bagLocationA = input.nextLine();
        ArrayList<String> bagA;
        bagA = game.fileReader(bagLocationA, noOfPlayers);

        System.out.println("Please enter location of bag number 1 to load:");
        String bagLocationB = input.nextLine();
        ArrayList<String> bagB;
        bagB = game.fileReader(bagLocationB, noOfPlayers);
        
        System.out.println("Please enter location of bag number 2 to load:");
        String bagLocationC = input.nextLine();
        ArrayList<String> bagC;
        bagC = game.fileReader(bagLocationC, noOfPlayers);        
    }
}
