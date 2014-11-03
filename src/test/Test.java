package test;

import java.math.BigInteger;
import java.util.*;
import java.util.Objects;

/**
 * Created by admin on 2014/10/20.
 */


class P{
    public P(){
        play();
    }

    public void play(){
        System.out.println("Ppppp");
    }
}

class C extends P{


    public void play(){
        System.out.println("CCCCCC");
    }
}


public class Test {
    public static void main(String args[]){
        /*List<Integer> ilist = new ArrayList<Integer>();
        List olist = ilist;
        BigInteger bi;*/
        new C();
    }


}
