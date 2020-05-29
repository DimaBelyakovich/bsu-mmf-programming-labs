package by.bsu.service;

import by.bsu.dao.LineDao;
import by.bsu.figure.Line;
import by.bsu.figure.Point;
import by.bsu.service.functional.ComputeCos;
import by.bsu.service.functional.ComputeRotateCoords;
import by.bsu.service.functional.ComputeVector;

public class LineService extends Service<Line, LineDao> {
    public LineService() {
        super.dao = new LineDao();
        super.data = dao.load();
    }

    public void scaleLine(Line line, double c){
        double diffX=line.getxStart();
        double diffY=line.getyStart();
        Point vLine = ComputeVector.getVector(line);
        Point vxAxis=ComputeVector.getVector(new Line(new Point(line.getxStart(),line.getyStart())
                ,new Point(line.getxStart()+12,line.getyStart()))
        );
        double cosLinexAxis= ComputeCos.cos(vLine,vxAxis);
        double lineLength = line.length()*c;
        double xAxisLine = lineLength*cosLinexAxis;
        double yAxisLine=Math.sqrt(lineLength*lineLength-xAxisLine*xAxisLine);
        line.setPointStart(line.getPointStart());
        line.setPointEnd(new Point(diffX+xAxisLine,diffY+yAxisLine));
        log.info("scale successfully");
        super.dao.save(data);
    }

    public void rotateLine(Line line, int alf){
        double xCoordStart= ComputeRotateCoords.getX(alf,line.getxStart(),line.getyStart());
        double yCoordStart=ComputeRotateCoords.getY(alf,line.getxStart(),line.getyStart());
        double xCoordEnd=ComputeRotateCoords.getX(alf,line.getxEnd(),line.getyEnd());
        double yCoordEnd=ComputeRotateCoords.getY(alf,line.getxEnd(),line.getyEnd());

        line.setPointStart(new Point(xCoordStart,yCoordStart));
        line.setPointEnd(new Point(xCoordEnd,yCoordEnd));
        log.info("rotate successfully");
        super.dao.save(data);
    }
}
