package persistence;

import logic.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-19.
 */
public class MapFileManagerTest {

    @Test
    public void read() throws Exception {
        GameMap testMap = MapFileManager.read("lava mountain");
        Cell cell = testMap.getCell(new Point(3, 4));
        Chest testChest = (Chest) cell;
        Equipment weapon = testChest.getEquipments().get(0);
        weapon.getEnhancedAttribute();

        Assert.assertEquals(Player.ABILITY_WIS, weapon.getEnhancedAttribute());
    }


}