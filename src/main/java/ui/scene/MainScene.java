package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Penelope on 17/2/24.
 *
 * @author Siyu Chen
 */
public class MainScene extends View {

    public MainScene() {
        setLayout(null);
        setSize(1000, 600);

        initSubviews();
    }

    private void initSubviews() {

        JPanel title = new JPanel();
        title.setSize(1000, 40);
        title.setLocation(0, 0);
        add(title);
        title.setBackground(new Color(0xf4f4f4));

        JLabel gameLabel = new JLabel("Game", JLabel.CENTER);
        gameLabel.setSize(1000, 40);
        title.add(gameLabel);

        JPanel main = new JPanel();
        main.setSize(1000, 540);
        main.setLocation(0, 40);
        add(main);

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
