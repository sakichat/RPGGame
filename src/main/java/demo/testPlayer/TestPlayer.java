package demo.testPlayer;

import com.google.gson.annotations.Expose;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public class TestPlayer {
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Expose
    private TestParty party;
    @Expose
    private TestType type;
    @Expose
    private TestWearItems wearItems;

    public TestPlayer(String name, TestParty party, TestType type, TestWearItems wearItems) {
        this.name = name;
        this.party = party;
        this.type = type;
        this.wearItems = wearItems;
    }

    public TestParty getParty() {
        return party;
    }

    public TestType getType() {
        return type;
    }

    public TestWearItems getWearItems() {
        return wearItems;
    }
}
