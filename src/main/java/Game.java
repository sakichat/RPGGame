import ui.scene.MainScene;
import ui.view.NavigationView;
import ui.view.Window;

/**
 * @author Qi Xia
 * @version 0.3
 * This is the main program.
 */
public class Game {
    public static void main(String[] args) {
        NavigationView navigationView = new NavigationView();
        new Window(navigationView);
        navigationView.push(new MainScene());
    }
}
