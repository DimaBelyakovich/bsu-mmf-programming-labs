package by.bsu.functional;

import by.bsu.figure.Line;
import by.bsu.figure.Point;
import by.bsu.figure.Polygon;

public class Rotate {
    public Line rotateLine(Line line, int alf){
        double xCoordStart=ComputeRotateCoords.getX(alf,line.getxStart(),line.getyStart());
        double yCoordStart=ComputeRotateCoords.getY(alf,line.getxStart(),line.getyStart());
        double xCoordEnd=ComputeRotateCoords.getX(alf,line.getxEnd(),line.getyEnd());
        double yCoordEnd=ComputeRotateCoords.getY(alf,line.getxEnd(),line.getyEnd());

        return new Line(new Point(xCoordStart,yCoordStart),new Point(xCoordEnd,yCoordEnd));
    }
    public Polygon rotatePolygon(Polygon polygon, int alf){
        Polygon poly = new Polygon();
        Point vertex;
        for (int i = 0; i < 4; i++) {
            vertex=polygon.getVertex(i);
            vertex.setpX(ComputeRotateCoords.getX(alf,vertex.getpX(),vertex.getpY()));
            vertex.setpY(ComputeRotateCoords.getY(alf,vertex.getpX(),vertex.getpY()));
            poly.setVertex(vertex,i);
        }
        return poly;
    }
    public Point rotatePoint(Point point, int alf){
        double xCoord=ComputeRotateCoords.getX(alf,point.getpX(),point.getpY());
        double yCoord=ComputeRotateCoords.getY(alf,point.getpX(),point.getpY());
        return new Point(xCoord,yCoord);
    }
}
