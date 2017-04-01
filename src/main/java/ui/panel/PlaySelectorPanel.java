package ui.panel;

import logic.Play;
import ui.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by GU_HAN on 2017-04-01.
 */
public class PlaySelectorPanel extends Panel {
    public interface Delegate{
        /**
         * This method is to give the two parameters
         * @param playSelectorPanel
         */
        void playSelectorPerformAction(PlaySelectorPanel playSelectorPanel, Play play);
    }

    private Delegate delegate;

    public Delegate getDelegate() {
        return delegate;
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    private JTextField textField;
    private JButton searchButton;
    private View playSelector;
    private String buttonText;

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void init(){
        super.init();
        title = "Play Selector";
        setSize(290, 170);
    }

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

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSelector.removeAll();
                search();
            }
        });
    }

    /**
     *
     */
    public void search(){
//        List<String> names =

    }
}
