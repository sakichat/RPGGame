import logic.CampaignTest;
import logic.PlayTest;
import logic.equipment.EquipmentTest;
import logic.map.GameMapGraphTest;
import logic.map.GameMapTest;
import logic.map.MovementTest;
import logic.map.PathTest;
import logic.player.PlayerExplorerTest;
import logic.player.PlayerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import persistence.FileManagerTest;
import persistence.MapFileManagerTest;

/**
 * Created by GU_HAN on 2017-03-19.
 * @author GU_HAN
 * @version 0.2
 *
 * This class is for testSuite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
                    EquipmentTest.class ,
                    GameMapGraphTest.class,
                    GameMapTest.class,
                    MovementTest.class,
                    PathTest.class,
                    PlayerExplorerTest.class,
                    PlayerTest.class,
                    CampaignTest.class,
                    PlayTest.class,
                    FileManagerTest.class,
                    MapFileManagerTest.class})
public class TestSuite {
}
