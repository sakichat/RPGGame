package demo.ui;

import ui.scene.MainScene;
import ui.view.ViewFlow;
import ui.view.Window;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Demo {
    public static void main(String[] args) {
        ViewFlow viewFlow = new ViewFlow();
        new Window(viewFlow);
        viewFlow.push(new MainScene());
    }
}
