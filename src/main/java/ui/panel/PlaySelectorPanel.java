package ui.panel;

import logic.Play;
import persistence.PlayFileManager;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Guangbi Zhang
 * @version 0.3
 */
public class PlaySelectorPanel extends Panel {

    /**
     * Delegate
     */

    /**
     * InnerClass to declaration of delegate
     */
    public interface Delegate{
        /**
         * This method is to give the two parameters
         * @param playSelectorPanel
         */
        void playSelectorPerformAction(PlaySelectorPanel playSelectorPanel, Play play);
    }

    /**
     * Property declaration.
     */
    private Delegate delegate;

    /**
     * Getter for delegate
     * @return
     */
    public Delegate getDelegate() {
        return delegate;
    }

    /**
     * Setter for enhancedDelegate
     * @param delegate
     */
    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    private JTextField textField;
    private JButton searchButton;
    private View playSelector;

    /**
     * this method is to initial the view
     */
    @Override
    public void init(){
        super.init();
        title = "Play Selector";
        setSize(290, 170);
    }

    /**
     * this method is to set sub-views
     */
    public void initSubviews(){
        super.initSubviews();
        playSelector = new View();
        playSelector.setLayout(null);
        playSelector.setLocation(10, 80);
        playSelector.setSize(290, 90);
        add(playSelector);

        textField = new JTextField();
        textField.setLayout(null);
        textField.setSize(160, 40);
        textField.setLocation(10, 30);
        add(textField);

        searchButton = new JButton("Search");
        searchButton.setLayout(null);
        searchButton.setSize(100, 40);
        searchButton.setLocation(180, 30);
        add(searchButton);

        searchButton.addActionListener(e -> {
            playSelector.removeAll();
            search();
        });
    }

    /**
     * this method is to search the files
     */
    public void search(){
        List<String> names = PlayFileManager.allNames();
        int number = 0;
        int yOfView = 0;
        int xOfView = 0;

        for (String name : names) {
            if(name.contains(textField.getText()) && number < 3){
                Play play = PlayFileManager.read(name);

                JLabel playLabel = new JLabel();
                playLabel.setLayout(null);
                playLabel.setSize(160, 20);
                playLabel.setLocation(xOfView, yOfView);
                playLabel.setText(play.getName());
                playSelector.add(playLabel);

                JButton selectButton = new JButton("Select");
                selectButton.setLocation(170, yOfView);
                selectButton.setSize(60, 20);
                playSelector.add(selectButton);

                selectButton.addActionListener(e -> delegate.playSelectorPerformAction(PlaySelectorPanel.this, play));

                number++;
                yOfView += 30;
            }
        }
        repaint();
    }
}
