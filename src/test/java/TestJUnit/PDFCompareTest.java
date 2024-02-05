package TestJUnit;

import in.testonics.omni.models.OmniImage;
import org.junit.Test;

public class PDFCompareTest {

    @Test
    public void main() throws Exception {

//        OmniFiles omniFiles = new OmniFiles();
//        File file1 = new File(".\\src\\test\\resources\\TestData\\PDF1.pdf");
//        File file2 = new File(".\\src\\test\\resources\\TestData\\PDF2.pdf");
//        omniFiles.CompareFiles(file1,file2,0);
//        System.out.println(omniFiles.getFileTextInMap(file1));

        OmniImage omniImage = new OmniImage();
        omniImage.CompareFiles(".\\src\\test\\resources\\TestData\\Image1.jpg", ".\\src\\test\\resources\\TestData\\Image2.jpg");
    }

}
