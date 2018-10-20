import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Darf ich so eine Klasse erstellen?
public final class TTTUtils {
    private TTTUtils() {}

    /*
        Ich hab die variablen alle in dieser Klasse als static, da sich so ziemlich alles in dieser
        Klasse abspielt wirkt das auf mich so als ob ich sie global hab, was ich eigentlich nicht will,
        aber da ich keine pointer übergeben kann ist mir halt echt keine andere möglichkeit eingefallen
        das zu realisieren. Ist es möglich beispielsweiße mein field per referenc weiterzugeben, also so,
        dass sich der inhalt außerhalb der function ändert wenn ich es einer fuction übergebe?
     */

    //Ich wollte Map ausprobieren ich weiß das wär eleganter gegangen
    private static final Map<Integer, String> symbols = new HashMap<>();

    //warum muss/kann ich die größe des arrays nicht in die klammern schreiben?
    private static final int[][] wins = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    private static final Scanner sc = new Scanner(System.in);
    private static int[] field = {0,0,0,0,0,0,0,0,0};

    public static void setStuff(){
        symbols.put(0," ");
        symbols.put(1,"X");
        symbols.put(2,"O");
    }
    public static void drawField() {
        //Das soll anscheinend das Terminal clearen aber beim intelliJ Terminal functioniert es jedenfalls nicht :(
        System.out.print("\033[H\033[2J");
        for(int i = 0; i < 9; i++){
            System.out.print('[');
            System.out.print(symbols.get(field[i]));
            System.out.print(']');
            if(i%3 == 2) System.out.print('\n');
        }
    }
    public static boolean checkWincondition(){
        for(int i = 0; i < 8; i++){
            if((field[wins[i][0]] != 0) && (field[wins[i][0]] == field[wins[i][1]])
                    && (field[wins[i][0]] == field[wins[i][2]])) return true;
        }
        return false;
    }
    public static boolean getInput(boolean turn){
        System.out.print("Player " + (turn?1:2) + ": ");
        String s = sc.nextLine();
        int number;

        //Das functioniert so, aber ich habe das Gefühl, das man das besser machen hätte können
        try {
            number = Integer.parseInt(s);
        }catch (NumberFormatException e){
            System.out.println("Thats not a viable Number");
            return false;
        }

        if(number > 9 || number < 1){
            System.out.println("Thats not a viable Number");
            return false;
        }
        
        if(field[number-1] != 0){
            System.out.println("This field is not empty!");
            return false;
        }

        field[number-1] = turn?1:2; //Ich wünschte ich könnte einfach turn+1 schreiben...
        return true;
    }
}
