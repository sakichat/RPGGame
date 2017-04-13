package persistence;

import logic.map.*;
import logic.player.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author GU_HAN
 * @version 0.3
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
        GameMap testMap = MapFileManager.read("testmap1");
        Cell cell1 = testMap.getCell(new Point(0, 0));
        Cell cell2 = testMap.getCell(new Point(0, 1));
        Cell cell3 = testMap.getCell(new Point(6, 0));
        Cell cell4 = testMap.getCell(new Point(3, 2));
        Cell cell5 = testMap.getCell(new Point(1, 3));
        Cell cell6 = testMap.getCell(new Point(10,11));

        Assert.assertTrue(cell1 instanceof Entrance);
        Assert.assertTrue(cell2 == null);
        Assert.assertTrue(cell3 instanceof Player);
        Assert.assertTrue(cell4 instanceof Obstacle);
        Assert.assertTrue(cell5 instanceof Chest);
        Assert.assertTrue(cell6 instanceof Exit);

    }
}