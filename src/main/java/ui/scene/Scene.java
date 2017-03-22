package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a superclass for other scenes class.
 * @author Siyu Chen
 * @version 0.2
 */
public class Scene extends View{
    public View contentView;
    public String title;
    public JLabel titleLabel;
    public JButton backButton;
    public JButton saveButton;
    public boolean backButtonEnabled;
    public boolean saveButtonEnabled;

    /**
     * This is a constructor to init the calling sequence for these methods
     */
    public Scene() {
        init();
        initHeader();
        initWindows();
        initBack();
        initSave();
        initSubviews();
    }

    /**
     * This init() method init the basic properties for Scene
     */
    protected void init(){
        this.setSize(1000, 600);
    }

    /**
     * This initHeader() method init the navigation title bar for Scene.
     * And it sets a property called title in order to add specific title name on different scenes
     */
    protected void initHeader() {

        View header = new View();
        header.setSize(1000, 40);
        header.setLocation(0, 0);
        this.add(header);
        header.setBackground(new Color(0xf4f4f4));

        titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setSize(1000, 40);
        titleLabel.setLocation(0, 0);
        header.add(titleLabel);
    }

    /**
     * This initWindows() method init the main content view in the Scene class
     */
    protected void initWindows() {
        contentView = new View();
        contentView.setSize(1000, 560);
        contentView.setLocation(0, 40);
        this.add(contentView);
        contentView.setBackground(new Color(0xFFFFFF));
    }

    /**
     * This initBack() method init the backButton on scenes.
     * There is a boolean property backButtonEnabled to make sure whether a scene needs this button.
     */
    protected void initBack() {
        if (backButtonEnabled == true) {
            backButton = new JButton("Back");
            backButton.setSize(60, 20);
            backButton.setLocation(10, 10);
            this.add(backButton);
        }
    }

    /**
     * This initSave() method init the saveButton on scenes.
     * There is a boolean property saveButtonEnabled to make sure whether a scene needs this button.
     */
    protected void initSave() {
        if (saveButtonEnabled == true) {
            saveButton = new JButton("Save");
            saveButton.setSize(60, 20);
            saveButton.setLocation(930, 10);
            this.add(saveButton);
        }
    }

    /**
     * This initSubviews() method is to call the method in subclasses
     */
    protected void initSubviews(){

    }

}
