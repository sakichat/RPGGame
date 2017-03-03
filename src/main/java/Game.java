import ui.scene.MainScene;
import ui.view.NavigationView;
import ui.view.Window;

/**
 * @author qi xia
 * @version 0.1
 * This is the main program
 */
public class Game {
    public static void main(String[] args) {
        NavigationView navigationView = new NavigationView();
        new Window(navigationView);
        navigationView.push(new MainScene());
    }
}
