public class Main {
    public static void main(String[] args) {
        boolean turn = true;
        TTTUtils.setStuff();
        for(int i = 0; i < 9; i++){
            TTTUtils.drawField();
            while(!TTTUtils.getInput(turn)){}
            turn = !turn;
            if(TTTUtils.checkWincondition()){
                TTTUtils.drawField();
                System.out.println("Player " + (turn?2:1) + " Wins!");
                return;
            }
        }
        TTTUtils.drawField();
        System.out.println("Drawn!");
    }
}
