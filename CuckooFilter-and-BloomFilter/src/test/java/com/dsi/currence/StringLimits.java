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
        for (int i = 0; i < 10; i++) { //0000
            System.out.println(i);
            s += "i";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("flydean", "www.flydean.com");
        System.out.println(GraphLayout.parseInstance(hashMap).toPrintable());
        // log.info("{}", GraphLayout.parseInstance(hashMap).toPrintable());
        // System.out.println(GraphLayout.parseInstance(s).toPrintable());
        hashMap.put("fly", s);
        System.out.println(GraphLayout.parseInstance(hashMap).toPrintable());
        
//        String unitAbbrev = "μs";                                // | 赞，即使没有注释也非常清晰
//        String unitAbbrev = "\u03bcs"; // "μs"                    | 允许，但没有理由要这样做
//        String unitAbbrev = "\u03bcs"; // Greek letter mu, "s"    | 允许，但这样做显得笨拙还容易出错
//        String unitAbbrev = "\u03bcs";                           // | 很糟，读者根本看不出这是什么
//        return '\ufeff' + content; // byte order mark             | Good，对于非打印字符，使用转义，并在必要时写上注释
    }

}
