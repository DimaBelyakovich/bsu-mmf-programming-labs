package by.bsu;


import by.bsu.dao.Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        List<Item> items = Dao.reader(new File("data/in.txt"));
        System.out.println(items);
        List<Integer> sortedHash = items.stream().map(e->e.getItemHash()).sorted().collect(Collectors.toList());

        List<Item> sortedItems = new ArrayList<>();
        for (Integer hash: sortedHash) {
            for (Item item: items) {
                if(item.getItemHash() == hash){
                    sortedItems.add(item);
                    break;
                }else {
                    continue;
                }
            }
        }

        List<Item> distinct = sortedItems.stream().distinct().collect(Collectors.toList());

        System.out.println(sortedItems);
        System.out.println(distinct);

        Dao.saver(sortedItems,"data/sortedItems.txt");
        Dao.saver(distinct,"data/distinctItems.txt");
    }
}
