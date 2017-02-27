package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Penelope on 17/2/26.
 *
 * @author Siyu Chen
 */
public class Scene extends View {
    public JPanel main;
    public JLabel sceneTitle;

    public Scene() {
        super();

        setLayout(null);
        this.setSize(1000, 600);

        this.initHeader();
//        this.initHeader();
        this.initWindows();
    }
//
//    public Scene(JLabel sceneTitle) {
//        this.sceneTitle = sceneTitle;
//    }

    public void initHeader() {

        JPanel header = new JPanel();
        header.setSize(1000, 40);
        header.setLocation(0, 0);
        this.add(header);
        header.setBackground(new Color(0xf4f4f4));

        JLabel sceneTitle = new JLabel("", JLabel.CENTER);
        sceneTitle.setSize(1000, 40);
        sceneTitle.setLocation(0, 0);
        header.add(sceneTitle);
    }
//
//    public Scene(JPanel main) {
//        this.main = main;
//    }

    public void initWindows() {
        JPanel main = new JPanel();
        main.setSize(1000, 560);
        main.setLocation(0, 40);
        this.add(main);
        main.setBackground(new Color(0xFFFFFF));
    }


    public JPanel getMain() {
        return main;
    }

    public void setMain(JPanel main) {
        this.main = main;
    }

    public JLabel getSceneTitle() {
        return sceneTitle;
    }

    public void setSceneTitle(JLabel sceneTitle) {
        this.sceneTitle = sceneTitle;
    }
}
