package by.bsu.services;

import java.util.UUID;

public class GenerateId {
    public static long generateLongId(){
        UUID id = UUID.randomUUID();
        long highBits = id.getMostSignificantBits();
        long lowBits = id.getLeastSignificantBits();
        return highBits+lowBits;
    }

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }
}
