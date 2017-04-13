package logic;


import logic.map.GameMap;
import logic.player.Player;
import logic.turn.TurnThread;
import ui.scene.PlayScene;
import ui.view.GameMapView;

/**
 * @author Kai QI
 * @version 0.3
 * This class is PlayRuntime, which uses the singleton pattern to storage the data
 */
public class PlayRuntime {

    /**
     * the property of currentRuntime
     */
    private static PlayRuntime currentRuntime = new PlayRuntime();

    /**
     * The method of currentRuntime
     * @return
     */
    public static PlayRuntime currentRuntime() {
        return currentRuntime;
    }

    /**
     * property of play
     */
    private Play play;

    /**
     * Setter for play
     * @param play
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * Getter for play
     * @return Play
     */
    public Play getPlay() {
        return play;
    }

    /**
     * Setter for map
     * @return GameMap
     */
    public GameMap getMap() {
        return play.currentMap();
    }

    /**
     * Setter for mainPlayer
     * @return Player
     */
    public Player getMainPlayer() {
        return play.getMainPlayer();
    }

    /**
     * the property of turnThread
     */
    private TurnThread turnThread;

    /**
     * Getter for turnThread
     * @return
     */
    public TurnThread getTurnThread() {
        return turnThread;
    }

    /**
     * property of playScene
     */
    private PlayScene playScene;

    /**
     * Getter of playScene
     * @return PlayScene
     */
    public PlayScene getPlayScene() {
        return playScene;
    }

    /**
     * Getter of MapView
     * @return GameMapView
     */
    public GameMapView getMapView(){
        return playScene.getGameMapView();
    }

    /**
     * The method of initiate
     * @param playScene PlayScene
     * @param play Play
     */
    public void initiate(PlayScene playScene, Play play){
        this.playScene = playScene;
        this.play = play;
        play.resolveMap();
        playScene.setPlay(play);
        play.addObserver(playScene);
        play.addObserver(playScene.getGameMapView());
    }

    /**
     * attribute
     */
    private volatile boolean stopped;

    /**
     * This method isStopped
     * @return Boolean
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * setter
     * @param stopped
     */
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    /**
     * The method of begin
     */
    public void begin(){
        turnThread = new TurnThread();
        turnThread.start();
    }

    public void stop(){

    }
}
