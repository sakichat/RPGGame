package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class MainScene extends Scene {


    @Override
    public void init() {
        super.init();
        titleName = "Game";

        backButton = false;
        saveButton = false;
    }

    protected void initSubviews() {
        JButton playButton = new JButton("Play");
        playButton.setSize(160, 40);
        playButton.setLocation(20, 20);
        main.add(playButton);

        JButton editorButton = new JButton("Editor");
        editorButton.setSize(160, 40);
        editorButton.setLocation(20, 60);
        main.add(editorButton);

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
