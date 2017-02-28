package demo;

import ui.scene.MainScene;
import ui.view.NavigationView;
import ui.view.Window;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Demo {
    public static void main(String[] args) {
        NavigationView navigationView = new NavigationView();
        new Window(navigationView);
        navigationView.push(new MainScene());
    }
}
