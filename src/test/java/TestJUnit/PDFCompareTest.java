package TestJUnit;

import in.testonics.omni.utils.OmniFiles;
import org.junit.Test;

import java.io.File;

public class PDFCompareTest {

    @Test
    public void main() throws Exception {

        OmniFiles omniFiles = new OmniFiles();
        File file1 = new File(".\\src\\test\\resources\\TestData\\Doc1.docx");
        File file2 = new File(".\\src\\test\\resources\\TestData\\Doc2.docx");

        omniFiles.CompareFiles(file1,file2,1);

        System.out.println(omniFiles.getFileText(file1));
    }

}
