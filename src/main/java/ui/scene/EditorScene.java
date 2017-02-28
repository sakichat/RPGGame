package ui.scene;

import game.Equipment;
import persistence.EquipmentFileManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class EditorScene extends Scene {
    @Override
    protected void init() {
        super.init();

        title = "Editor";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }
    protected void initSubviews() {
        JLabel itemLabel = new JLabel("Item");
        itemLabel.setSize(160, 40);
        itemLabel.setLocation(20, 20);
        contentView.add(itemLabel);

        JLabel charaLabel = new JLabel("Player");
        charaLabel.setSize(160, 40);
        charaLabel.setLocation(210, 20);
        contentView.add(charaLabel);

        JLabel mapLabel = new JLabel("Map");
        mapLabel.setSize(160, 40);
        mapLabel.setLocation(400, 20);
        contentView.add(mapLabel);

        JLabel campLabel = new JLabel("Campaign");
        campLabel.setSize(160, 40);
        campLabel.setLocation(590, 20);
        contentView.add(campLabel);

        JButton itemCreate = new JButton("Create");
        itemCreate.setSize(160, 40);
        itemCreate.setLocation(20, 70);
        contentView.add(itemCreate);

        JButton charaCreate = new JButton("Create");
        charaCreate.setSize(160, 40);
        charaCreate.setLocation(210, 70);
        contentView.add(charaCreate);

        JButton mapCreate = new JButton("Create");
        mapCreate.setSize(160, 40);
        mapCreate.setLocation(400, 70);
        contentView.add(mapCreate);

        JButton campCreate = new JButton("Create");
        campCreate.setSize(160, 40);
        campCreate.setLocation(590, 70);
        contentView.add(campCreate);

        JButton itemEdit = new JButton("Edit");
        itemEdit.setSize(160, 40);
        itemEdit.setLocation(20, 150);
        contentView.add(itemEdit);

        JButton charaEdit = new JButton("Edit");
        charaEdit.setSize(160, 40);
        charaEdit.setLocation(210, 150);
        contentView.add(charaEdit);

        JButton mapEdit = new JButton("Edit");
        mapEdit.setSize(160, 40);
        mapEdit.setLocation(400, 150);
        contentView.add(mapEdit);

        JButton campEdit = new JButton("Edit");
        campEdit.setSize(160, 40);
        campEdit.setLocation(590, 150);
        contentView.add(campEdit);

        repaint();

        backButton.addActionListener(new ActionListener() {
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

        itemEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemEdit();
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
    private void itemEdit(){
        JFileChooser fileChooser = new JFileChooser(EquipmentFileManager.folderPath());
        fileChooser.setFileFilter(new FileNameExtensionFilter("json", "json"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String name = EquipmentFileManager.filePathToName(selectedFile.getName());
            Equipment equipment = EquipmentFileManager.read(name);

            ItemEditingScene itemEditingScene = new ItemEditingScene();
            itemEditingScene.setEquipment(equipment);
            navigationView.push(itemEditingScene);
        }
    }
}
