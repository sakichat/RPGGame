package ui.panel;

import game.Player;
import map.GameMap;
import persistence.MapFileManager;
import persistence.PlayerFileManager;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * Created by thereaghostflash on 2017-03-02.
 */
public class MapSelectorPanel extends Panel  {
    private JTextField textField;
    private JButton searchButton;
    private View mapSelector;
    private MapDelegate mapDelegate;

    public MapDelegate getMapDelegate() {
        return mapDelegate;
    }

    public void setMapDelegate(MapDelegate mapDelegate) {
        this.mapDelegate = mapDelegate;
    }

    @Override
    public void init() {
        super.init();
        title = "Map Selector";
        setSize(290,170);
    }

    @Override
    public void initSubviews() {
        super.initSubviews();
        mapSelector.setLayout(null);
        mapSelector.setLocation(10,80);
        mapSelector.setSize(290,90);
        add(mapSelector);

        textField.setLayout(null);
        textField.setSize(160,40);
        textField.setLocation(10,30);
        add(textField);

        searchButton.setLayout(null);
        searchButton.setSize(100,40);
        searchButton.setLocation(180,30);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mapSelector.removeAll();
                search();
            }
        });

    }

    public void search(){
        List<String> names = MapFileManager.allNames();
        int number = 0;
        int yOfView = 0;
        int xOfView = 0;



        for (String name : names){
            if (name.contains(textField.getText()) && number < 3){
                GameMap gameMap = MapFileManager.read(name);

                JLabel mapLabel = new JLabel();
                mapLabel.setLayout(null);
                mapLabel.setSize(160,20);
                mapLabel.setLocation(xOfView,yOfView);
                mapLabel.setText(gameMap.getName());
                mapSelector.add(mapLabel);

                JButton addButton = new JButton("Add");
                addButton.setLocation(170,yOfView);
                addButton.setSize(60,20);
                mapSelector.add(addButton);

                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mapDelegate.mapSelectorPerformAction(MapSelectorPanel.this,gameMap);

                    }
                });

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }
}
