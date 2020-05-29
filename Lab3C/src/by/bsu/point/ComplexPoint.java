package by.bsu.point;

import java.util.StringJoiner;

public class ComplexPoint {
    private int x;
    private int y;

    public ComplexPoint(){
        super();
    }

    public ComplexPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        if(y >0){
            return new StringJoiner(", ", ComplexPoint.class.getSimpleName() + "[", "]")
                    .add(x+"+"+y+"i")
                    .toString();
        }else {
            return new StringJoiner(", ", ComplexPoint.class.getSimpleName() + "[", "]")
                    .add(x + "" + y + "i")
                    .toString();
        }
    }


}
