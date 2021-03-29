package spiservice;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<Fruit> s = ServiceLoader.load(Fruit.class);
        Iterator<Fruit> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next().getName());
        }
    }


}
