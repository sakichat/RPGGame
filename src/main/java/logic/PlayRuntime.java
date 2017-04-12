package logic;


import logic.map.GameMap;
import logic.player.Player;
import logic.turn.TurnThread;
import ui.scene.PlayScene;
import ui.view.GameMapView;

public class PlayRuntime {
    private static PlayRuntime currentRuntime = new PlayRuntime();

    public static PlayRuntime currentRuntime() {
        return currentRuntime;
    }

    private Play play;

    public Play getPlay() {
        return play;
    }
    public GameMap getMap() {
        return play.getCurrentMap();
    }

    public Player getPlayer() {
        return play.getMainPlayer();
    }

    private TurnThread turnThread;

    public TurnThread getTurnThread() {
        return turnThread;
    }

    private PlayScene playScene;

    public PlayScene getPlayScene() {
        return playScene;
    }

    public GameMapView getMapView(){
        return playScene.getGameMapView();
    }

    public void initiate(PlayScene playScene, Play play){
        this.playScene = playScene;
        this.play = play;
        play.resolveMap();
        playScene.setPlay(play);
    }

    public void begin(){

    }

    public void end(){
        this.playScene = null;
        this.play = null;
    }
}
