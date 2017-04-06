package demo.testPlayer;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public enum TestParty {
    FRIENDLY("Friendly"),
    HOSTILE("Hostile"),
    PLAYER("Player");

    private String party;

    public String getParty() {
        return party;
    }

    TestParty(String party) {

        this.party = party;
    }
}
