package TestJUnit;

import in.testonics.omni.utils.ComparePDF;
import org.junit.Test;

import java.io.File;

public class PDFCompareTest {

    @Test
    public void main() throws Exception {
        ComparePDF comparePDF = new ComparePDF();

        File file1 = new File(".\\src\\test\\resources\\TestData\\PDF1.pdf");
        File file2 = new File(".\\src\\test\\resources\\TestData\\PDF2.pdf");

        comparePDF.comparePDF(file1,file2,1);
    }

}
