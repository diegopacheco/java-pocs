import org.apache.poi.xslf.usermodel.*;

import java.io.FileNotFoundException;
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

    FileOutputStream out = new FileOutputStream("powerpoint.pptx");
    ppt.write(out);
    out.close();

  }
}
