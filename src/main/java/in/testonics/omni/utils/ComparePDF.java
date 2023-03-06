package in.testonics.omni.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ComparePDF {

    public void comparePDF(String pdfFileOrFolderPath1, String pdfFileOrFolderPath2) throws Exception {
        comparePDF(pdfFileOrFolderPath1,pdfFileOrFolderPath2,0);
    }

    public void comparePDF(File pdfFile1, File pdfFile2) throws Exception {
        comparePDF(pdfFile1,pdfFile2,0);
    }

    //Compares the PDF files or all the files in 2 folders provided the file with the same names are present
    public void comparePDF(String pdfFileOrFolderPath1, String pdfFileOrFolderPath2, int pageNumber) throws Exception {
        File file1 = new File(pdfFileOrFolderPath1);
        File file2 = new File(pdfFileOrFolderPath2);

        if (file1.isDirectory() && file2.isDirectory()) {
            File[] files = file1.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    comparePDF(file, new File(pdfFileOrFolderPath2 + "//" + fileName),pageNumber);
                }
            }
        } else {
            comparePDF(file1, file2, pageNumber);
        }

    }

    public void comparePDF(File pdfFile1, File pdfFile2, int pageNumber) throws Exception {
        System.out.println("Comparing PDF files (" + pdfFile1 + "," + pdfFile2 + ")");
        PDDocument pdf1 = PDDocument.load(pdfFile1);
        PDDocument pdf2 = PDDocument.load(pdfFile2);
        PDPageTree pdf1pages = pdf1.getDocumentCatalog().getPages();
        PDPageTree pdf2pages = pdf2.getDocumentCatalog().getPages();
        int numberOfPages = pdf1pages.getCount();

        try {
            if (pdf1pages.getCount() != pdf2pages.getCount()) {
                String message = "Number of pages in the files (" + pdfFile1 + "," + pdfFile2 + ") do not match. pdfFile1 has " + pdf1pages.getCount() + " no pages, while pdf2pages has " + pdf2pages.getCount() + " no of pages";
                System.out.println(message);
                throw new Exception(message);
            }

            //Overwritten protected method to get font and size of the text
            PDFTextStripper pdfStripper1 = new PDFTextStripper() {
                String prevBaseFont = "";
                String prevBaseFontSize = "";

                protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
                    StringBuilder builder = new StringBuilder();

                    for (TextPosition position : textPositions) {
                        String baseFont = position.getFont().getFontDescriptor().getFontName();
                        String baseFontSize = String.valueOf(position.getFontSizeInPt());
                        if (baseFont != null && !baseFont.equals(prevBaseFont)) {
                            builder.append('[').append(baseFont).append(']');
                            prevBaseFont = baseFont;
                        }
                        if (!baseFontSize.equals(prevBaseFontSize)) {
                            builder.append('[').append(baseFontSize).append(']');
                            prevBaseFontSize = baseFontSize;
                        }
                        builder.append(position.getUnicode());
                    }
                    writeString(builder.toString());
                }
            };


            //Overwritten protected method to get font and size of the text
            PDFTextStripper pdfStripper2 = new PDFTextStripper() {
                String prevBaseFont = "";
                String prevBaseFontSize = "";

                protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
                    StringBuilder builder = new StringBuilder();

                    for (TextPosition position : textPositions) {
                        String baseFont = position.getFont().getFontDescriptor().getFontName();
                        String baseFontSize = String.valueOf(position.getFontSizeInPt());
                        if (baseFont != null && !baseFont.equals(prevBaseFont)) {
                            builder.append('[').append(baseFont).append(']');
                            prevBaseFont = baseFont;
                        }
                        if (!baseFontSize.equals(prevBaseFontSize)) {
                            builder.append('[').append(baseFontSize).append(']');
                            prevBaseFontSize = baseFontSize;
                        }
                        builder.append(position.getUnicode());
                    }
                    writeString(builder.toString());
                }
            };

            //To validate only a specific page in PDF
            if (!(pageNumber==0)) numberOfPages = 1;

            System.out.println("pdf1pages.size() is :- " + pdf1pages.getCount());
            for (int i = 0; i < numberOfPages; i++) {
                int pageNumberToValidate = (i+1);
                if (!(pageNumber==0)) pageNumberToValidate = pageNumber;
                pdfStripper1.setStartPage(pageNumberToValidate);
                pdfStripper1.setEndPage(pageNumberToValidate);
                pdfStripper2.setStartPage(pageNumberToValidate);
                pdfStripper2.setEndPage(pageNumberToValidate);
                String pdf1PageText = pdfStripper1.getText(pdf1);
                String pdf2PageText = pdfStripper2.getText(pdf2);
                String[] pdf1PageTextLines = pdf1PageText.split("\n");
                String[] pdf2PageTextLines = pdf2PageText.split("\n");
                if (!pdf1PageText.equals(pdf2PageText)) {
                    if (pdf1PageTextLines.length != pdf2PageTextLines.length) {
                        throw new Exception("Number of lines are not on same on page # " + pageNumberToValidate + ". Hence no further validation done");
                    } else {
                        for (int j = 0; j < pdf1PageTextLines.length; j++) {
                            if (!pdf1PageTextLines[j].equals(pdf2PageTextLines[j])) {
                                System.out.println("Validation Failed For Page# " + pageNumberToValidate + " and line# " + (j + 1));
                                System.out.println("PDF 1 Text : " + pdf1PageTextLines[j]);
                                System.out.println("PDF 2 Text : " + pdf2PageTextLines[j]);
                            }
                        }
                    }
                }
            }
            System.out.println("Returning True , as PDF Files (" + pdfFile1 + "," + pdfFile2 + ") get matched");
        } finally {
            pdf1.close();
            pdf2.close();
        }
    }

}
