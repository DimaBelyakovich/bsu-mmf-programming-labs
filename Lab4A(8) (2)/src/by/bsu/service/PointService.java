package by.bsu.service;

import by.bsu.dao.PointDao;
import by.bsu.figure.Point;
import by.bsu.service.functional.ComputeRotateCoords;

public class PointService extends Service<Point, PointDao> {
    public PointService() {
        super.dao = new PointDao();
        super.data = dao.load();
    }

    public void rotatePoint(Point point, int alf){
        double xCoord= ComputeRotateCoords.getX(alf,point.getpX(),point.getpY());
        double yCoord=ComputeRotateCoords.getY(alf,point.getpX(),point.getpY());
        point.setpX(xCoord);
        point.setpY(yCoord);
        log.info("rotate successfully");
        super.dao.save(data);
    }
}
