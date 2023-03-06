package TestJUnit;

import utils.ComparePDF;

import java.io.File;

public class PDFCompareTest {

    public static void main(String[] args) throws Exception {
        ComparePDF comparePDF = new ComparePDF();

        File file1 = new File(".\\src\\test\\resources\\TestData\\PDF1.pdf");
        File file2 = new File(".\\src\\test\\resources\\TestData\\PDF2.pdf");

        comparePDF.comparePDF(file1,file2,1);
    }

}
