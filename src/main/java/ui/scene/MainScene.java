package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Main Scene class extends Scene class
 * @author Siyu Chen
 * @version 0.2
 */
public class MainScene extends Scene {


    /**
     * This init() method overrides that in superclass to set up own properties for this subclass
     */
    @Override
    public void init() {
        super.init();
        title = "Game";

        backButtonEnabled = false;
        saveButtonEnabled = false;
    }

    /**
     * This method creates components on the main scene
     */
    protected void initSubviews() {
        JButton playButton = new JButton("Play");
        playButton.setSize(160, 40);
        playButton.setLocation(20, 20);
        contentView.add(playButton);

        JButton editorButton = new JButton("Editor");
        editorButton.setSize(160, 40);
        editorButton.setLocation(20, 70);
        contentView.add(editorButton);

        repaint();

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadyScene readyScene = new ReadyScene();
                MainScene.this.navigationView.push(readyScene);
            }
        });

        editorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorScene editorScene = new EditorScene();
                MainScene.this.navigationView.push(editorScene);
            }
        });
    }

}
