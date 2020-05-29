package by.bsu.functional;

import by.bsu.figure.Line;
import by.bsu.figure.Point;
import by.bsu.figure.Polygon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scaling {
    Logger log = LogManager.getLogger();

    public Line scaleLine(Line line, double c){
        double diffX=line.getxStart();
        double diffY=line.getyStart();
        Point vLine = ComputeVector.getVector(line);
        Point vxAxis=ComputeVector.getVector(new Line(new Point(line.getxStart(),line.getyStart())
                                                     ,new Point(line.getxStart()+12,line.getyStart()))
        );
        double cosLinexAxis=ComputeCos.cos(vLine,vxAxis);
        double lineLength = line.length()*c;
        double xAxisLine = lineLength*cosLinexAxis;
        double yAxisLine=Math.sqrt(lineLength*lineLength-xAxisLine*xAxisLine);
        return new Line(line.getPointStart(), new Point(diffX+xAxisLine,diffY+yAxisLine));
    }

    public Polygon scalePolygon(Polygon polygon, double c){
        Polygon poly = new Polygon();
        Point vertex;
        for (int i = 1; i < 4; i++) {
            vertex=poly.getVertex(i);
            if(i==1){
                poly.setVertex(new Point(vertex.getpX(), vertex.getpY()*c),i);
            }
            if(i==2) {
                poly.setVertex(new Point(vertex.getpX() * c, vertex.getpY() * c), i);
            }
            if(i==3){
                poly.setVertex(new Point(vertex.getpX()*c, vertex.getpY()),i);
            }
        }
        return poly;
    }
}



















/*
double difX = line.getxStart();
        double difY = line.getyStart();
        Line StockLine = new Line(line.getxEnd()-difX, line.getyEnd()-difY);
        Point vStockLine = ComputeVector.getVector(StockLine);
        Point vector = ComputeVector.getVector(new Line(0,StockLine.getxEnd()));
        double cos = ComputeCos.cos(vStockLine,vector);
        double lineLength = Math.hypot(line.getxEnd()-difX, line.getyEnd()-difY);
        lineLength=lineLength*c;
 */