import logic.CampaignTest;
import logic.equipment.EquipmentTest;
import logic.interaction.InteractionTest;
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
 * @author GU_HAN
 * @version 0.3
 * This class is for testSuite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
                    EquipmentTest.class,
                    InteractionTest.class,
                    GameMapGraphTest.class,
                    GameMapTest.class,
                    MovementTest.class,
                    PathTest.class,
                    PlayerExplorerTest.class,
                    PlayerTest.class,
                    CampaignTest.class,
                    FileManagerTest.class,
                    MapFileManagerTest.class})
public class TestSuite {
}
