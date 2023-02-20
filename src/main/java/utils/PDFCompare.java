package utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.TestException;

import java.io.File;
import java.io.IOException;

public class PDFCompare {

    public static void main(String[] args) throws IOException {
        File file1 = new File("C:\\Projects\\Testonics\\Omni\\Omni\\src\\test\\resources\\TestData\\PDF1.pdf");
        File file2 = new File("C:\\Projects\\Testonics\\Omni\\Omni\\src\\test\\resources\\TestData\\PDF2.pdf");
        comparePDF(file1,file2);
    }

    private static void comparePDF(File pdfFile1, File pdfFile2) throws IOException {
        System.out.println("Comparing PDF files ("+pdfFile1+","+pdfFile2+")");
        PDDocument pdf1 = PDDocument.load(pdfFile1);
        PDDocument pdf2 = PDDocument.load(pdfFile2);
        PDPageTree pdf1pages = pdf1.getDocumentCatalog().getPages();
        PDPageTree pdf2pages = pdf2.getDocumentCatalog().getPages();
        try {
            if (pdf1pages.getCount() != pdf2pages.getCount()) {
                String message = "Number of pages in the files ("+pdfFile1+","+pdfFile2+") do not match. pdfFile1 has "+pdf1pages.getCount()+" no pages, while pdf2pages has "+pdf2pages.getCount()+" no of pages";
                System.out.println(message);
                throw new TestException(message);
            }
            PDFTextStripper pdfStripper = new PDFTextStripper();
            System.out.println("pdfStripper is :- " + pdfStripper);
            System.out.println("pdf1pages.size() is :- " + pdf1pages.getCount());
            for (int i = 0; i < pdf1pages.getCount(); i++) {
                pdfStripper.setStartPage(i + 1);
                pdfStripper.setEndPage(i + 1);
                String pdf1PageText = pdfStripper.getText(pdf1);
                String pdf2PageText = pdfStripper.getText(pdf2);
                String[] pdf1PageTextLines = pdf1PageText.split("\n");
                String[] pdf2PageTextLines = pdf2PageText.split("\n");
                if (!pdf1PageText.equals(pdf2PageText)) {
                    if (pdf1PageTextLines.length != pdf2PageTextLines.length){
                        throw new TestException("Number of lines are not on same on page # " + (i+1) + ". Hence no further validation done");
                    }else{
                     for (int j=0;j<pdf1PageTextLines.length;j++){
                         if (!pdf1PageTextLines[j].equals(pdf2PageTextLines[j])){
                             System.out.println("Validation Failed For Page# " + (i+1) + " and line# " + (j+1));
                             System.out.println("PDF 1 Text : " + pdf1PageTextLines[j]);
                             System.out.println("PDF 2 Text : " + pdf2PageTextLines[j]);
                         }
                     }
                    }
                }
            }
            System.out.println("Returning True , as PDF Files ("+pdfFile1+","+pdfFile2+") get matched");
        } finally {
            pdf1.close();
            pdf2.close();
        }
    }
}
