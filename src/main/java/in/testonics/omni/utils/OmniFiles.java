package in.testonics.omni.utils;

import java.io.File;

public class OmniFiles {

    public void OmniFiles(String folderPath1, String folderPath2) throws Exception {
        OmniFiles(folderPath1,folderPath2,0);
    }

    public void OmniFiles(File file1, File file2) throws Exception {
        CompareFiles(file1,file2,0);
    }

    //Compares the files or all the files in 2 folders provided the file with the same names are present
    public void OmniFiles(String folderPath1, String folderPath2, int pageNumber) throws Exception {
        File file1 = new File(folderPath1);
        File file2 = new File(folderPath2);

        if (file1.isDirectory() && file2.isDirectory()) {
            File[] files = file1.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    CompareFiles(file, new File(folderPath2 + "//" + fileName),pageNumber);
                }
            }
        } else {
            CompareFiles(file1, file2, pageNumber);
        }

    }

    public void CompareFiles(File file1, File file2, int pageNumber) throws Exception {

        if (file1.getName().endsWith(".pdf"))
            new OmniPDF().comparePDF(file1,file2,pageNumber);
        else if (file1.getName().endsWith(".txt")  || file1.getName().endsWith(".aspx")  || file1.getName().endsWith(".ascx"))
            new OmniText().compareText(file1,file2,pageNumber);
        else if (file1.getName().endsWith(".docx") || file1.getName().endsWith(".doc"))
            new OmniDoc().compareText(file1,file2,pageNumber);

    }

    public String getFileText(File file) throws Exception {

        if (file.getName().endsWith(".pdf"))
            return new OmniPDF().getPdfText(file);
        else if (file.getName().endsWith(".txt") || file.getName().endsWith(".aspx")  || file.getName().endsWith(".ascx"))
            return new OmniText().getText(file);
        else if (file.getName().endsWith(".docx") || file.getName().endsWith(".doc"))
            return new OmniDoc().getText(file);
        else
            return "";
    }
}
