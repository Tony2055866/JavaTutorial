package guava;

import com.google.common.collect.ImmutableSet;

/**
 * Created by admin on 2014/10/26.
 */
public class CollectionsTest {
    public static  ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");
    public static void main(String args[]){

        System.out.println(COLOR_NAMES);
    }
}
