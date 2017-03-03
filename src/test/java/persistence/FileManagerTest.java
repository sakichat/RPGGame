package persistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GU_HAN on 2017-02-27.
 */
public class FileManagerTest {

    /**
     * This case tests the nameToFileName() method.
     */
    @Test
    public void nameToFileName() throws Exception {
        String testIt = "AB CDE";
        String after = FileManager.nameToFileName(testIt);
        String shouldBe = "ab_cde";

        Assert.assertEquals(shouldBe, after);
    }

    /**
     * This case tests the fileNameToName() method.
     */
    @Test
    public void fileNameToName() throws Exception {
        String testIt = "AB___CDE";
        String after = FileManager.fileNameToName(testIt);
        String shouldBe = "AB   CDE";

        Assert.assertEquals(shouldBe, after);
    }

}