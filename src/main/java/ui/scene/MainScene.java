package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class MainScene extends Scene {

    public MainScene() {
        setLayout(null);
//        setSize(1000, 600);

//        this.initSubviews();

        this.initHeader();
        this.initWindows();
        initSubviews();
    }

    public void initSubviews() {
//
//        JPanel title = new JPanel();
//        title.setSize(1000, 40);
//        title.setLocation(0, 0);
//        add(title);
//        title.setBackground(new Color(0xf4f4f4));

//        JLabel gameLabel = new JLabel("Game", JLabel.CENTER);
//        gameLabel.setSize(1000, 40);
//        title.add(gameLabel);

//        JPanel main = new JPanel();
//        main.setSize(1000, 560);
//        main.setLocation(0, 40);
//        add(main);
//        JLabel title = super.getSceneTitle();
//        title.setText("Game");
//        super.setSceneTitle(title);

//        sceneTitle.setText("Game");


        JButton playButton = new JButton("Play");
        playButton.setSize(160, 40);
        playButton.setLocation(20, 60);
        add(playButton);

        JButton editorButton = new JButton("Editor");
        editorButton.setSize(160, 40);
        editorButton.setLocation(20, 100);
        add(editorButton);

        repaint();

        editorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorScene editorScene = new EditorScene();
                MainScene.this.viewFlow.push(editorScene);
//                MainScene.this.add(editorScene);
            }
        });
    }

}
