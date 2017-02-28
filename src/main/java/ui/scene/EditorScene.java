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
    private JLabel label;
    private JButton button;

    @Override
    protected void init() {
        super.init();

        title = "Editor";
        backButtonEnabled = true;
        saveButtonEnabled = false;
    }
    protected void initSubviews() {
        label = new JLabel("Item");
        label.setSize(160, 40);
        label.setLocation(20, 20);
        contentView.add(label);

        label = new JLabel("Player");
        label.setSize(160, 40);
        label.setLocation(210, 20);
        contentView.add(label);

        JLabel mapLabel = new JLabel("Map");
        mapLabel.setSize(160, 40);
        mapLabel.setLocation(400, 20);
        contentView.add(mapLabel);

        label = new JLabel("Campaign");
        label.setSize(160, 40);
        label.setLocation(590, 20);
        contentView.add(label);

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(20, 70);
        contentView.add(button);
        JButton itemCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(210, 70);
        contentView.add(button);
        JButton playerCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(400, 70);
        contentView.add(button);
        JButton mapCreateButton = button;

        button = new JButton("Create");
        button.setSize(160, 40);
        button.setLocation(590, 70);
        contentView.add(button);
        JButton campaignCreateButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(20, 150);
        contentView.add(button);
        JButton itemEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(210, 150);
        contentView.add(button);
        JButton playerEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(400, 150);
        contentView.add(button);
        JButton mapEditButton = button;

        button = new JButton("Edit");
        button.setSize(160, 40);
        button.setLocation(590, 150);
        contentView.add(button);
        JButton campaignEditButton = button;

        repaint();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditorScene.this.navigationView.pop();
            }
        });

        itemCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemCreationScene itemCreationScene = new ItemCreationScene();
                EditorScene.this.navigationView.push(itemCreationScene);
            }
        });

        itemEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemEdit();
            }
        });

        playerCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerCreationScene playerCreationScene = new PlayerCreationScene();
                EditorScene.this.navigationView.push(playerCreationScene);
            }
        });

        mapCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapCreationScene mapCreationScene = new MapCreationScene();
                EditorScene.this.navigationView.push(mapCreationScene);
            }
        });

        campaignCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CampaignCreationScene campaignCreationScene = new CampaignCreationScene();
                EditorScene.this.navigationView.push(campaignCreationScene);
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
