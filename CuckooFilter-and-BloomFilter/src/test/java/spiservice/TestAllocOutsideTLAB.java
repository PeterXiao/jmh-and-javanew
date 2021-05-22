/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:TestAllocOutsideTLAB.java Package
 * Name:spiservice Date:2021年5月4日下午1:50:21 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights
 * Reserved.
 */
/**
 * @Title: TestAllocOutsideTLAB.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:50:21
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:TestAllocOutsideTLAB <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月4日 下午1:50:21 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: TestAllocOutsideTLAB @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月4日 下午1:50:21
 * @version
 * @since JDK 1.8
 */
public class TestAllocOutsideTLAB {}

/*

import jdk.jfr.Recording;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedFrame;
import jdk.jfr.consumer.RecordingFile;
import sun.hotspot.WhiteBox;

import java.io.File;
import java.nio.file.Path;

public class TestAllocOutsideTLAB {

    //对于字节数组对象头占用16字节
    private static final int BYTE_ARRAY_OVERHEAD = 16;
    //我们要测试的对象大小是100kb
    private static final int OBJECT_SIZE = 1024;
    //字节数组对象名称
    private static final String BYTE_ARRAY_CLASS_NAME = new byte[0].getClass().getName();

    //需要使用静态field，而不是方法内本地变量，否则编译后循环内的new byte[]全部会被省略，只剩最后一次的
    public static byte[] tmp;

    public static void main(String[] args) throws Exception {
        WhiteBox whiteBox = WhiteBox.getWhiteBox();
        //初始化 JFR 记录
        Recording recording = new Recording();
        //启用 jdk.ObjectAllocationOutsideTLAB 事件监控
        recording.enable("jdk.ObjectAllocationOutsideTLAB");
        // JFR 记录启动
        recording.start();
        //强制 fullGC 防止接下来程序发生 GC
        //同时可以区分出初始化带来的其他线程的TLAB相关的日志
        whiteBox.fullGC();
        //分配对象，大小1KB
        for (int i = 0; i < 2048; ++i) {
            tmp = new byte[OBJECT_SIZE - BYTE_ARRAY_OVERHEAD];
        }
        //强制 fullGC，回收所有 TLAB
        whiteBox.fullGC();
        //分配对象，大小100KB
        for (int i = 0; i < 10; ++i) {
            tmp = new byte[OBJECT_SIZE * 100 - BYTE_ARRAY_OVERHEAD];
        }
        whiteBox.fullGC();
        //将 JFR 记录 dump 到一个文件
        Path path = new File(new File(".").getAbsolutePath(), "recording-" + recording.getId() + "-pid" + ProcessHandle.current().pid() + ".jfr").toPath();
        recording.dump(path);
        int countOf1KBObjectAllocationOutsideTLAB = 0;
        int countOf100KBObjectAllocationOutsideTLAB = 0;
        //读取文件中的所有 JFR 事件
        for (RecordedEvent event : RecordingFile.readAllEvents(path)) {
            //获取分配的对象的类型
            String className = event.getString("objectClass.name");

            if (
                //确保分配类型是 byte[]
                    BYTE_ARRAY_CLASS_NAME.equalsIgnoreCase(className)
            ) {
                RecordedFrame recordedFrame = event.getStackTrace().getFrames().get(0);
                //同时必须是咱们这里的main方法分配的对象，并且是Java堆栈中的main方法
                if (recordedFrame.isJavaFrame()
                        && "main".equalsIgnoreCase(recordedFrame.getMethod().getName())
                ) {
                    //获取分配对象大小
                    long allocationSize = event.getLong("allocationSize");
                    //统计各种事件个数
                    if ("jdk.ObjectAllocationOutsideTLAB".equalsIgnoreCase(event.getEventType().getName())) {
                        if (allocationSize == 102400) {
                            countOf100KBObjectAllocationOutsideTLAB++;
                        } else if (allocationSize == 1024) {
                            countOf1KBObjectAllocationOutsideTLAB++;
                        }
                    } else {
                        throw new Exception("unexpected size of TLAB event");
                    }
                    System.out.println(event);
                }
            }
        }
        System.out.println("countOf1KBObjectAllocationOutsideTLAB: " + countOf1KBObjectAllocationOutsideTLAB);
        System.out.println("countOf100KBObjectAllocationOutsideTLAB: " + countOf100KBObjectAllocationOutsideTLAB);
        //阻塞程序，保证所有日志输出完
        Thread.currentThread().join();
    }

*/
