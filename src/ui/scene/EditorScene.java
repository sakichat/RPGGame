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
public class EditorScene extends View {
    public EditorScene() {
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


        JButton back = new JButton("Back");
        back.setSize(60, 20);
        back.setLocation(10, 10);
        title.add(back);

        JLabel editorLabel = new JLabel("Editor", JLabel.CENTER);
        editorLabel.setSize(1000, 40);
        editorLabel.setLocation(0, 0);
        title.add(editorLabel);

        JPanel desktop = new JPanel();
        desktop.setSize(1000, 540);
        desktop.setLocation(0, 40);
        add(desktop);

        JLabel itemLabel = new JLabel("Item");
        itemLabel.setSize(160, 40);
        itemLabel.setLocation(20, 20);
        desktop.add(itemLabel);

        JLabel charaLabel = new JLabel("Player");
        charaLabel.setSize(160, 40);
        charaLabel.setLocation(210, 20);
        desktop.add(charaLabel);

        JLabel mapLabel = new JLabel("Map");
        mapLabel.setSize(160, 40);
        mapLabel.setLocation(400, 20);
        desktop.add(mapLabel);

        JLabel campLabel = new JLabel("Campaign");
        campLabel.setSize(160, 40);
        campLabel.setLocation(590, 20);
        desktop.add(campLabel);

        JButton itemCreate = new JButton("Create");
        itemCreate.setSize(160, 40);
        itemCreate.setLocation(20, 70);
        desktop.add(itemCreate);

        JButton charaCreate = new JButton("Create");
        charaCreate.setSize(160, 40);
        charaCreate.setLocation(210, 70);
        desktop.add(charaCreate);

        JButton mapCreate = new JButton("Create");
        mapCreate.setSize(160, 40);
        mapCreate.setLocation(400, 70);
        desktop.add(mapCreate);

        JButton campCreate = new JButton("Create");
        campCreate.setSize(160, 40);
        campCreate.setLocation(590, 70);
        desktop.add(campCreate);

        JButton itemEdit = new JButton("Edit");
        itemEdit.setSize(160, 40);
        itemEdit.setLocation(20, 150);
        desktop.add(itemEdit);

        JButton charaEdit = new JButton("Edit");
        charaEdit.setSize(160, 40);
        charaEdit.setLocation(210, 150);
        desktop.add(charaEdit);

        JButton mapEdit = new JButton("Edit");
        mapEdit.setSize(160, 40);
        mapEdit.setLocation(400, 150);
        desktop.add(mapEdit);

        JButton campEdit = new JButton("Edit");
        campEdit.setSize(160, 40);
        campEdit.setLocation(590, 150);
        desktop.add(campEdit);

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
