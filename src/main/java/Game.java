import ui.scene.MainScene;
import ui.view.NavigationView;
import ui.view.Window;

/**
 * Created by Saki on 2017/3/2.
 */
public class Game {
    public static void main(String[] args) {
        NavigationView navigationView = new NavigationView();
        new Window(navigationView);
        navigationView.push(new MainScene());
    }
}
