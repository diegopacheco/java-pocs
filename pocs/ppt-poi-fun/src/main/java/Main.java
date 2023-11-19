import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileOutputStream;

public class Main{
  public static void main(String args[]) throws Exception {
    XMLSlideShow ppt = new XMLSlideShow();
    ppt.createSlide();

    XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);

    XSLFSlideLayout layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
    XSLFSlide slide = ppt.createSlide(layout);

    XSLFTextShape titleShape = slide.getPlaceholder(0);
    XSLFTextShape contentShape = slide.getPlaceholder(1);
    contentShape.clearText();
    XSLFTextParagraph p = titleShape.addNewTextParagraph();

    XSLFTextRun r1 = p.addNewTextRun();
    r1.setText("Java on PPT");
    r1.setFontColor(new Color(78, 147, 89));
    r1.setFontSize(32.);

    layout = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
    XSLFSlide slide2 = ppt.createSlide(layout);

    XSLFTextShape title = slide2.getPlaceholder(0);
    title.clearText();
    XSLFTextRun r = title.addNewTextParagraph().addNewTextRun();
    r.setText("Google Link");

    XSLFHyperlink link = r.createHyperlink();
    link.setAddress("http://google.com");

    // setting the content
    XSLFTextShape content = slide2.getPlaceholder(1);
    content.clearText(); // unset any existing text
    content.addNewTextParagraph().addNewTextRun().setText("First paragraph");
    content.addNewTextParagraph().addNewTextRun().setText("Second paragraph");
    content.addNewTextParagraph().addNewTextRun().setText("Third paragraph");

    FileOutputStream out = new FileOutputStream("powerpoint.pptx");
    ppt.write(out);
    out.close();
    System.out.println("done");

  }
}
