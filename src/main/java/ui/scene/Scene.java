package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Scene extends View {
    public View contentView;
    public String title;
    public JLabel titleLabel;
    public JButton backButton;
    public JButton saveButton;
    public boolean backButtonEnabled;
    public boolean saveButtonEnabled;

    public Scene() {
        init();
        initHeader();
        initWindows();
        initBack();
        initSave();
        initSubviews();
    }

    protected void init(){
        setLayout(null);

        this.setSize(1000, 600);
    }

    protected void initHeader() {

        JPanel header = new JPanel();
        header.setSize(1000, 40);
        header.setLocation(0, 0);
        this.add(header);
        header.setBackground(new Color(0xf4f4f4));

        titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setSize(1000, 40);
        titleLabel.setLocation(0, 0);
        header.add(titleLabel);
    }

    protected void initWindows() {
        contentView = new View();
        contentView.setSize(1000, 560);
        contentView.setLocation(0, 40);
        this.add(contentView);
        contentView.setBackground(new Color(0xFFFFFF));
    }

    protected void initBack() {
        if (backButtonEnabled == true) {
            backButton = new JButton("Back");
            backButton.setSize(60, 20);
            backButton.setLocation(10, 10);
            this.add(backButton);
        }
    }

    protected void initSave() {
        if (saveButtonEnabled == true) {
            saveButton = new JButton("Save");
            saveButton.setSize(60, 20);
            saveButton.setLocation(930, 10);
            this.add(saveButton);
        }
    }

    protected void initSubviews(){

    }

}
