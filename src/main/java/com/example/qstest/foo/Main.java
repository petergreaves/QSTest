package com.example.qstest.foo;

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args){

        List<A> aList = new ArrayList<>();

        aList.add(new A());

        List<B> bList = new ArrayList<>();
        bList.add(new B());
        bList.add(new B());

        Container<A> aContainer = Container
                .<A>builder()
                .contained(aList)
                .total(aList.size())
                .build();

        Container<B> bContainer = Container
                .<B>builder()
                .contained(bList)
                .total(bList.size())
                .build();

        System.out.println("bList size : " + bContainer.getTotal());
        System.out.println("bList elements : " + bContainer.getContained());

        System.out.println("aList size : " + aContainer.getTotal());
        System.out.println("aList elements : " + aContainer.getContained());
    }
}
