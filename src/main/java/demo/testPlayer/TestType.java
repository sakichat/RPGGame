package demo.testPlayer;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public enum TestType {
    BULLY("Bully"),
    NIMBLE("Nimble"),
    TANL("Tank");

    private String type;

    TestType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
