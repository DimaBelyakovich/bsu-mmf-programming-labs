package by.bsu.city;

public enum CityTypes {
    SMALL, MIDDLE, BIG, LARGE, THE_LARGEST;


    public static CityTypes getType(int population){

        if(population <= 50_000 && population>0){
            return SMALL;
        } else
            if(population<=100_000 && population>50_000){
                return MIDDLE;
            } else
                if(population <= 250_000 && population>100_000){
                    return BIG;
                } else
                    if(population <= 1_000_000 && population> 250_000){
                        return LARGE;
                    }else
                        if(population > 1_000_000 && population>0){
                            return THE_LARGEST;
                        }
                        return null;
    }
}
