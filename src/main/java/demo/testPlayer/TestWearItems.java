package demo.testPlayer;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public enum TestWearItems {
    YES(true),
    NO(false);

    private boolean wearItem;

    TestWearItems(boolean wearItem) {
        this.wearItem = wearItem;
    }

    public boolean isWearItem() {
        return wearItem;
    }
}
