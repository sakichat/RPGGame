package logic.turn;


import logic.Logger;
import logic.Play;
import logic.PlayRuntime;
import logic.player.Player;

/**
 * @author Qi Xia
 * @version 0.3
 */
public class TurnThread extends Thread{



    /**
     * static constant
     */
    public static double PAUSE_FAST = 0.5;
    public static double PAUSE_NORMAL = 1;
    public static double PAUSE_SLOW = 2;

    /**
     * This method is pause
     * @param duration
     */
    public static void pause(double duration){
        try {
            Thread.sleep((int)(duration * 1000));
        } catch (InterruptedException e) {
        }
    }

    /**
     * This method is waitForUser
     * @param userResponse
     */
    public static void waitForUser(UserResponse userResponse){

        setUserResponse(userResponse);

        PlayRuntime.currentRuntime().getPlayScene().setEnableControls(true);

        try {
            Thread.sleep(1000000 * 1000);
        } catch (InterruptedException e) {

        }
    }

    /**
     * This method is backToRun
     */
    public static void backToRun(){

        PlayRuntime.currentRuntime().getPlayScene().setEnableControls(false);

        PlayRuntime.currentRuntime().getTurnThread().interrupt();
    }

    /**
     * This method is for run the play
     */
    @Override
    public void run() {
        
        PlayRuntime playRuntime = PlayRuntime.currentRuntime();

        playRuntime.getPlayScene().setEnableControls(false);

        while (!playRuntime.getMap().finishObjective()){
            Play play = playRuntime.getPlay();
            Player currentPlayer = play.currentPlayer();
            if (currentPlayer.isAlive()) {
                currentPlayer.turn();
                Logger.getInstance().log(currentPlayer + " finished its turn");
            }
            play.nextPlayer();
            waitForUser(UserResponse.TURN);
        }
    }

    /**
     * attribute static constant
     */
    private static volatile UserResponse userResponse;

    /**
     * gettter
     * @return UserResponse
     */
    public static UserResponse getUserResponse() {
        return userResponse;
    }

    /**
     * setter
     * @param userResponse
     */
    public static void setUserResponse(UserResponse userResponse) {
        TurnThread.userResponse = userResponse;
    }

    /**
     * enum method
     */
    public enum UserResponse {
        TURN,
        MOVE,
        ATTACK,
        INTERACT
    }
}
