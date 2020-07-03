package com.dsi.currence;

import java.util.HashMap;

import org.openjdk.jol.info.GraphLayout;

/**
 * @author xiaoy
 * @date 2020/06/17
 */
public class StringLimits {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "";
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
            s += "i";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("flydean", "www.flydean.com");
        System.out.println(GraphLayout.parseInstance(hashMap).toPrintable());
        // log.info("{}", GraphLayout.parseInstance(hashMap).toPrintable());
        // System.out.println(GraphLayout.parseInstance(s).toPrintable());
    }

}
