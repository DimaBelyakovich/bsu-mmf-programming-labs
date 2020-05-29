package by.bsu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int size = 30;
    public static void main( String[] args ) {
        Set<Integer> set1 = new HashSet<>(size);
        Set<Integer> set2 = new HashSet<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            set1.add(random.nextInt(100));
            set2.add(random.nextInt(100));
        }
        System.out.println(set1 + " size:" + set1.size());
        System.out.println(set2 + " size:" + set2.size());

        Set<Integer> intersect = set1.stream().filter(e->set2.contains(e)).collect(Collectors.toSet());
        System.out.println("Intersection:" + intersect + " size:" + intersect.size());

        Set<Integer> union = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        System.out.println("Union:" + union + " size:" + union.size());
    }
}
