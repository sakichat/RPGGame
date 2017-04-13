package logic;


import logic.map.GameMap;
import logic.player.Player;
import logic.turn.TurnThread;
import ui.scene.FinishScene;
import ui.scene.PlayScene;
import ui.view.GameMapView;

import javax.swing.*;

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
        playScene.setPlay(play);
        playScene.refreshMap();
        play.addObserver(playScene);
        play.addObserver(playScene.getGameMapView());
    }

    /**
     * attribute
     */
    private volatile boolean stopped;

    /**
     * The method of begin
     */
    public void begin(){
        turnThread = new TurnThread();
        turnThread.start();
        stopped = false;
    }

    /**
     * constructor
     */

    public void stop(){
        stopped = true;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void toNextMap(){
        play.moveToNextMap();
        playScene.refreshMap();
    }

    public void toFinish(String message){
        SwingUtilities.invokeLater(() -> {
            FinishScene finishScene = new FinishScene();
            finishScene.setMessageLabel(message);
            playScene.getNavigationView().push(finishScene);
        });
    }
}
