package persistence;

import logic.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-03-19.
 * @author GU_HAN
 * @version 0.2
 *
 * This class tests map loading.
 */
public class MapFileManagerTest {
    /**
     * This case tests if the map can be got from a json file,
     * if yes, then the cell inside the map can be reached, too.
     * @throws Exception
     */
    @Test
    public void readMapFromJson() throws Exception {
        GameMap testMap = MapFileManager.read("lava mountain");
        Cell cell = testMap.getCell(new Point(3, 4));
        Chest testChest = (Chest) cell;
        Equipment weapon = testChest.getEquipments().get(0);
        String enhancedAttribute = weapon.getEnhancedAttribute();

        Assert.assertEquals(Player.ABILITY_WIS, enhancedAttribute);
    }
}