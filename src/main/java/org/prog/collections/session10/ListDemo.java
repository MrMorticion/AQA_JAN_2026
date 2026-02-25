package org.prog.collections.session10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        arrayList.add("a");//0
        arrayList.add("b");//1
        //...
        arrayList.add("c");//500000
        //...
        arrayList.add("d");//999999
        arrayList.add("e");//100000

        //[START]
        linkedList.add("a");//[START]-[a]-[b]
        linkedList.add("b");//[a]-[b]-[c]
        linkedList.add("c");//[b]-[c]-[d->f]
        linkedList.add("f");//[c]-[f]-[d]
        linkedList.add("d");//[c->f]-[d]-[e]
        linkedList.add("e");//[d]-[e]-[END]
        //[START]
    }
}
