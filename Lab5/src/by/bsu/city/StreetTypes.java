package by.bsu.city;

public enum StreetTypes {
    STREET, AVENUE, SQUARE;

    public static StreetTypes getType(int numOfLanes){
        if(numOfLanes<=4 && numOfLanes>0){
            return STREET;
        }else
            if(numOfLanes<=12 && numOfLanes > 4){
                return AVENUE;
            } else
                if(numOfLanes == 0){
                    return SQUARE;
                }
        return null;
    }
}
