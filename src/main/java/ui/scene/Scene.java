package ui.scene;

import ui.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * @author Siyu Chen
 * @version 0.1
 */
public class Scene extends View {
    public JPanel main;
    public String titleName;
    public JLabel sceneTitle;
    public JButton back;
    public JButton save;

    public Scene() {
//        super();

        setLayout(null);
        this.setSize(1000, 600);

        init();
        initHeader();
        initWindows();
        initBack();
        initSave();
        initSubviews();
    }

    protected void init(){

    }

    protected void initHeader() {

        JPanel header = new JPanel();
        header.setSize(1000, 40);
        header.setLocation(0, 0);
        this.add(header);
        header.setBackground(new Color(0xf4f4f4));

        sceneTitle = new JLabel(titleName, JLabel.CENTER);
        sceneTitle.setSize(1000, 40);
        sceneTitle.setLocation(0, 0);
        header.add(sceneTitle);
    }

    protected void initWindows() {
        main = new JPanel();
        main.setSize(1000, 560);
        main.setLocation(0, 40);
        this.add(main);
        main.setBackground(new Color(0xFFFFFF));
    }

    protected void initBack() {
        back = new JButton("Back");
        back.setSize(60, 20);
        back.setLocation(10, 10);
        this.add(back);
    }

    protected void initSave() {
        save = new JButton("Save");
        save.setSize(60, 20);
        save.setLocation(930, 10);
        this.add(save);
    }

    protected void initSubviews(){

    }

}
