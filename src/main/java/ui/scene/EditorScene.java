package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class EditorScene extends Scene {
    public EditorScene() {
        setLayout(null);
//        setSize(1000, 600);

        initSubviews();
        this.initHeader();
        this.initWindows();
//        this.initBack();
    }


    protected void initSubviews() {
        JPanel title = new JPanel();
        title.setSize(1000, 40);
        title.setLocation(0, 0);
        this.add(title);
        title.setBackground(new Color(0xf4f4f4));


        JButton back = new JButton("Back");
        back.setSize(60, 20);
        back.setLocation(10, 10);
        title.add(back);

        JLabel editorLabel = new JLabel("Editor", JLabel.CENTER);
        editorLabel.setSize(1000, 40);
        editorLabel.setLocation(0, 0);
        title.add(editorLabel);

        JPanel main = new JPanel();
        main.setSize(1000, 540);
        main.setLocation(0, 40);
        this.add(main);

        JLabel itemLabel = new JLabel("Item");
        itemLabel.setSize(160, 40);
        itemLabel.setLocation(20, 20);
        main.add(itemLabel);

        JLabel charaLabel = new JLabel("Player");
        charaLabel.setSize(160, 40);
        charaLabel.setLocation(210, 20);
        main.add(charaLabel);

        JLabel mapLabel = new JLabel("Map");
        mapLabel.setSize(160, 40);
        mapLabel.setLocation(400, 20);
        main.add(mapLabel);

        JLabel campLabel = new JLabel("Campaign");
        campLabel.setSize(160, 40);
        campLabel.setLocation(590, 20);
        main.add(campLabel);

        JButton itemCreate = new JButton("Create");
        itemCreate.setSize(160, 40);
        itemCreate.setLocation(20, 70);
        main.add(itemCreate);

        JButton charaCreate = new JButton("Create");
        charaCreate.setSize(160, 40);
        charaCreate.setLocation(210, 70);
        main.add(charaCreate);

        JButton mapCreate = new JButton("Create");
        mapCreate.setSize(160, 40);
        mapCreate.setLocation(400, 70);
        main.add(mapCreate);

        JButton campCreate = new JButton("Create");
        campCreate.setSize(160, 40);
        campCreate.setLocation(590, 70);
        main.add(campCreate);

        JButton itemEdit = new JButton("Edit");
        itemEdit.setSize(160, 40);
        itemEdit.setLocation(20, 150);
        main.add(itemEdit);

        JButton charaEdit = new JButton("Edit");
        charaEdit.setSize(160, 40);
        charaEdit.setLocation(210, 150);
        main.add(charaEdit);

        JButton mapEdit = new JButton("Edit");
        mapEdit.setSize(160, 40);
        mapEdit.setLocation(400, 150);
        main.add(mapEdit);

        JButton campEdit = new JButton("Edit");
        campEdit.setSize(160, 40);
        campEdit.setLocation(590, 150);
        main.add(campEdit);

        repaint();

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorScene.this.viewFlow.pop();
            }
        });

        itemCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemCreationScene itemCreationScene = new ItemCreationScene();
                EditorScene.this.viewFlow.push(itemCreationScene);
            }
        });

        charaCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene playerCreationScene = new PlayerCreationScene();
                EditorScene.this.viewFlow.push(playerCreationScene);
            }
        });

        mapCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene mapCreationScene = new MapCreationScene();
                EditorScene.this.viewFlow.push(mapCreationScene);
            }
        });
    }
}
