import processing.core.PApplet;
import java.util.*;
import processing.dxf.*;
import java.util.Calendar;

public class PAppletSvgExport extends PApplet {
    boolean bExportSVG = false;

    @Override
    public void keyPressed()
    {
        if (key == 'e')
        {
            bExportSVG = true;
        }
    }

    public void beforeDraw() {
        background(255);
        if (bExportSVG)
        {
            //beginRaw(DXF, "data/exports/dxf/export_"+timestamp()+".dxf");
            beginRecord(SVG, "data/exports/svg/export_"+timestamp()+".svg");
        }

        // Drawing options : no fill and stroke set to black
        noFill();
    }

    public void afterDraw() {
        if (bExportSVG)
        {
            endRecord();
            //endRaw();
            bExportSVG = false;
        }
    }

    String timestamp()
    {
        Calendar now = Calendar.getInstance();
        return String.format("%1$ty%1$tm%1$td_%1$tH%1$tM%1$tS", now);
    }

}
