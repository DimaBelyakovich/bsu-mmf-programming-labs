package by.bsu;

import by.bsu.figure.Line;
import by.bsu.figure.Point;
import by.bsu.figure.Polygon;
import by.bsu.functional.Rotate;
import by.bsu.functional.Scaling;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger log = LogManager.getLogger();

    public static void main(String[] args) {
        Line line = new Line(new Point(1,2), new Point(2,4));
        log.info(line);

        Scaling sc = new Scaling();
        Line lineScal=sc.scaleLine(line,2);
        log.info(lineScal);

        Polygon polygon = new Polygon();
        log.info(polygon);

        Polygon polygonScale=sc.scalePolygon(polygon,2);
        log.info(polygonScale);

        Rotate rotate = new Rotate();
        Line lineRotate=rotate.rotateLine(line,30);
        log.info(lineRotate);

        Polygon polygonRotate=rotate.rotatePolygon(polygon,30);
        log.info(polygonRotate);
    }
}
