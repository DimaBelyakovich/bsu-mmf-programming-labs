package by.bsu.service;

import by.bsu.dao.PolygonDao;
import by.bsu.figure.Point;
import by.bsu.figure.Polygon;
import by.bsu.service.functional.ComputeRotateCoords;

public class PolygonService extends Service<Polygon, PolygonDao>{
    public PolygonService() {
        super.dao = new PolygonDao();
        super.data = dao.load();
    }

    public void rotatePolygon(Polygon polygon, int alf){
        Point vertex;
        for (int i = 0; i < 4; i++) {
            vertex=polygon.getVertex(i);
            vertex.setpX(ComputeRotateCoords.getX(alf,vertex.getpX(),vertex.getpY()));
            vertex.setpY(ComputeRotateCoords.getY(alf,vertex.getpX(),vertex.getpY()));
            polygon.setVertex(vertex,i);
        }
        log.info("rotate successfully");
        super.dao.save(data);
    }

    public void scalePolygon(Polygon polygon, double c){
        Point vertex;
        for (int i = 1; i < 4; i++) {
            vertex=polygon.getVertex(i);
            if(i==1){
                polygon.setVertex(new Point(vertex.getpX(), vertex.getpY()*c),i);
            }
            if(i==2) {
                polygon.setVertex(new Point(vertex.getpX() * c, vertex.getpY() * c), i);
            }
            if(i==3){
                polygon.setVertex(new Point(vertex.getpX()*c, vertex.getpY()),i);
            }
        }
        log.info("scale successfully");
        super.dao.save(data);
    }
}
