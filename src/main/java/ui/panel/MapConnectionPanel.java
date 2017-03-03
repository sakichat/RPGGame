package ui.panel;

import logic.Campaign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Kai QI
 * @version 0.1
 */
public class MapConnectionPanel extends Panel {

    /**
     * property campaign and getter & setter
     */
    private Campaign campaign;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    /**
     * Layout
     */

    JPanel mapSequencePanel;

    @Override
    protected void init() {
        super.init();

        setSize(640, 500);
        title = "Map Connection";

        dataToView();
    }

    protected void initSubviews() {

        JLabel label;

        label = new JLabel("Start", JLabel.LEFT);
        label.setSize(100, 40);
        label.setLocation(140, 30);
        add(label);

        mapSequencePanel = new JPanel();
        mapSequencePanel.setLayout(null);
        mapSequencePanel.setSize(640, 420);
        mapSequencePanel.setLocation(0, 80);
        add(mapSequencePanel);

    }

    /**
     * This is a method makes data transfer to view
     */
    public void dataToView() {

        mapSequencePanel.removeAll();

        JButton jButton;
        JLabel jLabel;

        int y = 0;

        for (String s : campaign.getMapNames()) {

            jButton = new JButton("Remove");
            jButton.setSize(100, 40);
            jButton.setLocation(20, y);
            mapSequencePanel.add(jButton);
            JButton removeButton = new JButton();
            removeButton = jButton;

            jLabel = new JLabel("", JLabel.LEFT);
            jLabel.setSize(180, 40);
            jLabel.setLocation(140, y);
            mapSequencePanel.add(jLabel);
            jLabel.setText(s);
            JLabel mapNameLabel = new JLabel();
            mapNameLabel = jLabel;

            y += 50;

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    campaign.addMapName(s);
                }
            });

        }

        jLabel = new JLabel("End", JLabel.LEFT);
        jLabel.setSize(100, 40);
        jLabel.setLocation(140, y);
        mapSequencePanel.add(jLabel);
        JLabel endNameLabel = new JLabel();
        endNameLabel = jLabel;
        y += 50;

        jButton = new JButton("Validate");
        jButton.setSize(160, 40);
        jButton.setLocation(140, y);
        mapSequencePanel.add(jButton);
        JButton validateButton = new JButton();
        validateButton = jButton;
        y += 50;

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campaign.validate();
            }
        });


    }
}
