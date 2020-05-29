package by.bsu.functional;

public class ComputeRotateCoords {
    public static double getX(int alf,double xCoord, double yCoord){
        double alfRad = Math.toRadians(alf);
        return xCoord*Math.cos(alfRad)-yCoord*Math.sin(alfRad);
    }

    public static double getY(int alf,double xCoord, double yCoord){
        double alfRad = Math.toRadians(alf);
        return xCoord*Math.sin(alfRad)+yCoord*Math.cos(alfRad);
    }
}
