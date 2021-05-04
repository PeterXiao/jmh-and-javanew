/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:Main.java Package Name:spiservice
 * Date:2021年5月3日下午5:43:13 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: Main.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年5月3日 下午5:43:13
 * @version V1.0
 */
package spiservice;
/**
 * ClassName:Main <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年5月3日 下午5:43:13 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: Main @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年5月3日 下午5:43:13
 * @version
 * @since JDK 1.8
 */
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Main extends ClassLoader implements Opcodes {

  /**
   * @Title: main @Description: TODO(这里用一句话描述这个方法的作用)
   *
   * @param @param args 设定文件
   * @return void 返回类型 date: 2021年5月3日 下午5:43:13.<br>
   * @author xiaoy
   * @param args
   * @since JDK 1.8
   * @throws
   */
  public static void main(String[] args) throws Exception {
    // 创建ClassWriter，指定COMPUTE_MAXS和COMPUTE_FRAMES，分别表示计算最大局部变量表以及最深操作数栈
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
    // 通过ClassWriter设置类的基本信息，比如public访问标记，类名为Example
    cw.visit(V11, ACC_PUBLIC, "Example", null, "java/lang/Object", null);
    // 生成Example的构造方法
    MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
    mw.visitVarInsn(ALOAD, 0);
    mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
    mw.visitInsn(RETURN);
    mw.visitMaxs(0, 0);
    mw.visitEnd();

    // 生成public static void main(String []args)方法，并生成了main()方法的字节码
    // 要求运行时调用System.out.println()，并输出"Hello world"：
    mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    mw.visitLdcInsn("Hello world!");
    mw.visitMethodInsn(
        INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    mw.visitInsn(RETURN);
    mw.visitMaxs(0, 0);
    mw.visitEnd();

    // 获取二进制表示
    byte[] code = cw.toByteArray();
    Main m = new Main();
    // 将class文件载入系统，通过反射调用`main()`方法，输出结果
    Class<?> mainClass = m.defineClass("Example", code, 0, code.length);
    mainClass.getMethods()[0].invoke(null, new Object[] {null});
  }
}
