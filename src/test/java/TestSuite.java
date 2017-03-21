import logic.*;
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
@Suite.SuiteClasses({CampaignTest.class,
                    EquipmentTest.class ,
                    MapValidatorTest.class,
                    PlayerTest.class,
                    PlayTest.class,
                    FileManagerTest.class,
                    MapFileManagerTest.class})
public class TestSuite {
}
