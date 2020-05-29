package by.bsu.entities;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Port {
    SHANGHAI("China"),
    SINGAPORE("Singapore"),
    HONG_KONG("China"),
    SHENZHEN("China"),
    BUSAN("South_Korea"),
    QINGDAO("China"),
    DUBAI("UAE"),
    BREMEN("Germany"),
    HUMBURG("Germany"),
    WELLINGTON("New_Zeland"),
    LONDON("UK"),
    BOSTON("USA"),
    LOS_ANGELES("USA"),
    HALIFAX("Canada");

    private String country;

    Port(String name){
        this.country = name;
    }

    private static final List<Port> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random random = new Random();

    public String getCountry() {
        return country;
    }

    public static Port randomPort(){
        return VALUES.get(random.nextInt(SIZE));
    }

}
