package in.testonics.omni.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;

public class OmniDoc {

    public void compareText(String fileOrFolderPath1, String fileOrFolderPath2) throws Exception {
        compareText(fileOrFolderPath1,fileOrFolderPath2,0);
    }

    public void compareText(File file1, File file2) throws Exception {
        compareText(file1,file2,0);
    }

    //Compares the PDF files or all the files in 2 folders provided the file with the same names are present
    public void compareText(String fileOrFolderPath1, String fileOrFolderPath2, int pageNumber) throws Exception {
        File file1 = new File(fileOrFolderPath1);
        File file2 = new File(fileOrFolderPath2);

        if (file1.isDirectory() && file2.isDirectory()) {
            File[] files = file1.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    compareText(file, new File(fileOrFolderPath2 + "//" + fileName),pageNumber);
                }
            }
        } else {
            compareText(file1, file2, pageNumber);
        }

    }

    public void compareText(File file1, File file2, int pageNumber) throws Exception {
        System.out.println("Comparing Doc files (" + file1 + "," + file2 + ")");
        String doc1 = getText(file1);
        String doc2 = getText(file2);
        String[] doc1Lines =  doc1.split("\n");
        String[] doc2Lines =  doc2.split("\n");
        for (int i=0; i<doc1Lines.length;i++) {
            if (!doc1Lines[i].equals(doc2Lines[i])) {
                System.out.println("Validation Failed For line# " + i);
                System.out.println("File 1 Text : " + doc1Lines[i]);
                System.out.println("File 2 Text : " + doc2Lines[i]);
            }
        }

    }

    //Fetches the PDF Text
    public String getText(String file) throws Exception {
        return getText(new File(file));
    }

    public String getText(File file) throws Exception {
        return getText(file,0);
    }

    public String getText(String file, int pageNumber) throws Exception{
        return getText(new File(file),0);
    }

    public String getText(File file, int pageNumber) throws Exception{
        // Create a FileInputStream to read the DOC file
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
        String text = "";

        if (file.getName().endsWith(".doc")){
            // Create a HWPFDocument object
            HWPFDocument document = new HWPFDocument(fis);
            // Create a WordExtractor to extract text from the document
            WordExtractor extractor = new WordExtractor(document);
            // Get the text from the document
            text = extractor.getText();
        } else {
            // Create a HWPFDocument object
            XWPFDocument  document = new XWPFDocument(fis);
            // Create a WordExtractor to extract text from the document
            XWPFWordExtractor extractor = new XWPFWordExtractor (document);
            // Get the text from the document
            text = extractor.getText();
        }

        // Close the FileInputStream
        fis.close();
        return text;
    }
}
