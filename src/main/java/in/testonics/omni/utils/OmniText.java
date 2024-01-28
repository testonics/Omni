package in.testonics.omni.utils;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;

public class OmniText {

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
        System.out.println("Comparing Text files (" + file1 + "," + file2 + ")");
        try (BufferedReader bf1 = Files.newBufferedReader(file1.toPath());
             BufferedReader bf2 = Files.newBufferedReader(file2.toPath())) {

            long lineNumber = 1;
            String line1 = "", line2 = "";
            while ((line1 = bf1.readLine()) != null) {
                line2 = bf2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    System.out.println("Validation Failed For line# " + lineNumber);
                    System.out.println("File 1 Text : " + line1);
                    System.out.println("File 2 Text : " + line2);
                }
                lineNumber++;
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
        try (BufferedReader bf = Files.newBufferedReader(file.toPath())) {
            String text = "";
            String line = "";
            while ((line = bf.readLine()) != null) {
                text = text + line + "\n";
            }
            return text;
        }
    }
}
