package org.prog.collections.session11;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.add("d");


//        System.out.println(list);

        Set<String> set = new HashSet<>();
        set.addAll(list);
//        System.out.println(set.size());
//        System.out.println(set.size());

        System.out.println("===========SET CONTENT==============");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====================================");

//        List<String> list1 = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }
}
