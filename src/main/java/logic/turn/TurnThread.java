package logic.turn;


import logic.Logger;
import logic.Play;
import logic.PlayRuntime;
import logic.player.Player;

public class TurnThread extends Thread{

    private volatile boolean end;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public static double PAUSE_FAST = 1;
    public static double PAUSE_NORMAL = 2;
    public static double PAUSE_SLOW = 3;

    public static void pause(double duration){
        try {
            Thread.sleep((int)(duration * 1000));
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void run() {
        PlayRuntime playRuntime = PlayRuntime.currentRuntime();

        while (!playRuntime.getMap().finishObjective()){
            Play play = playRuntime.getPlay();
            Player currentPlayer = play.currentPlayer();
            currentPlayer.turn();
            Logger.getInstance().log(currentPlayer + " finished its turn");

            play.nextPlayer();
            try {
                Thread.sleep((int)(1000000 * 1000));
            } catch (InterruptedException e) {

            }

        }
    }
}
