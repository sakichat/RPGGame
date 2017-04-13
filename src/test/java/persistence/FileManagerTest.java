package persistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author GU_HAN
 * @version 0.3
 *
 * This class tests the fileManager method, to see if it can successfully transfer between file name and typing name.
 */
public class FileManagerTest {
    /**
     * This case tests the nameToFileName() method.
     * @throws Exception
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
     * @throws Exception
     */
    @Test
    public void fileNameToName() throws Exception {
        String testIt = "ab___cde";
        String after = FileManager.fileNameToName(testIt);
        String shouldBe = "ab   cde";

        Assert.assertEquals(shouldBe, after);
    }
}