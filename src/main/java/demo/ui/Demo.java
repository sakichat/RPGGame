package demo.ui;

import ui.scene.MainScene;
import ui.view.ViewFlow;
import ui.view.Window;

/**
 * Created by Penelope on 17/2/24.
 *
 * @author Siyu Chen
 */
public class Demo {
    public static void main(String[] args) {
        ViewFlow viewFlow = new ViewFlow();
        new Window(viewFlow);
        viewFlow.push(new MainScene());
    }
}
