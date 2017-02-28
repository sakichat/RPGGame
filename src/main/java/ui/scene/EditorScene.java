package ui.scene;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class EditorScene extends Scene {
    @Override
    protected void init() {
        super.init();

        titleName = "Editor";
        backButton = true;
        saveButton = false;
    }
    protected void initSubviews() {
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
                EditorScene.this.navigationView.pop();
            }
        });

        itemCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemCreationScene itemCreationScene = new ItemCreationScene();
                EditorScene.this.navigationView.push(itemCreationScene);
            }
        });

        charaCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene playerCreationScene = new PlayerCreationScene();
                EditorScene.this.navigationView.push(playerCreationScene);
            }
        });

        mapCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene mapCreationScene = new MapCreationScene();
                EditorScene.this.navigationView.push(mapCreationScene);
            }
        });
    }
}
