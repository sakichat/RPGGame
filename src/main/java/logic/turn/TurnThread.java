package logic.turn;


public class TurnThread extends Thread{

    public static double PAUSE_FAST = 0.2;
    public static double PAUSE_NORMAL = 0.5;
    public static double PAUSE_SLOW = 0.1;

    public static void pause(double duration){
        try {
            Thread.sleep((int)(duration * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
