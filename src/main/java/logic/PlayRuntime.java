package logic;


import logic.map.GameMap;
import logic.player.Player;
import logic.turn.TurnThread;
import ui.scene.PlayScene;
import ui.view.GameMapView;

public class PlayRuntime {
    private static PlayRuntime currentRuntime;

    public static PlayRuntime currentRuntime() {
        return currentRuntime;
    }

    public static void setCurrentRuntime(PlayRuntime currentRuntime) {
        PlayRuntime.currentRuntime = currentRuntime;
    }

    private Play play;

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public GameMap getMap() {
        return play.getCurrentMap();
    }

    public Player getPlayer() {
        return play.getPlayer();
    }

    private TurnThread turnThread;

    public TurnThread getTurnThread() {
        return turnThread;
    }

    public void setTurnThread(TurnThread turnThread) {
        this.turnThread = turnThread;
    }

    private PlayScene playScene;

    public PlayScene getPlayScene() {
        return playScene;
    }

    public void setPlayScene(PlayScene playScene) {
        this.playScene = playScene;
    }

    public GameMapView getMapView(){
        return playScene.getGameMapView();
    }
}
