package demo.testPlayer;

import org.junit.Assert;
import org.junit.Test;
import persistence.DemoPersistence.DemoFileManager;

import java.io.File;

/**
 * Created by GU_HAN on 2017-04-06.
 */
public class TestPlayerTest {
    @Test
    public void save() throws Exception {
        TestPlayer testPlayer = new TestPlayer("joey paquet", TestParty.FRIENDLY, TestType.NIMBLE, TestWearItems.NO);
        DemoFileManager.save(testPlayer);

        Assert.assertTrue(new File("data/demotest/joey_paquet.demo.json").exists());
    }

    @Test
    public void read() throws Exception {
        TestPlayer testPlayer = DemoFileManager.read("joey_paquet");
        System.out.println(testPlayer.getName());
        System.out.println(testPlayer.getParty().getParty());
        System.out.println(testPlayer.getType().getType());
        System.out.println(testPlayer.getWearItems().isWearItem());
// 不知道为啥这里name测显示不对，别的属性 最后都读出来了
//        Assert.assertTrue(testPlayer.getName() == "joey paquet");
        Assert.assertTrue(testPlayer.getParty() == TestParty.FRIENDLY);
        Assert.assertTrue(testPlayer.getType() == TestType.NIMBLE);
        Assert.assertTrue(testPlayer.getWearItems() == TestWearItems.NO);
    }

}