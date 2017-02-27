package persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-27.
 */
public class FileManagerTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void nameToFileName() throws Exception {
        String testIt = "AB CDE";
        String after = FileManager.nameToFileName(testIt);
        String shouldBe = "ab_cde";

        Assert.assertEquals(shouldBe, after);
    }

    @Test
    public void fileNameToName() throws Exception {

    }

}