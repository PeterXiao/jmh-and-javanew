/**
 * 
 */
package basics.encode;

/**
 * @author Office
 *
 */
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
 
public class Base64Test {
   public static void main(String args[]){
      try {
        
         // 使用基本编码
         String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
         System.out.println("Base64 比那么字符串 (基本) :" + base64encodedString);
        
         // 解码
         byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        
         System.out.println("原始字符串: " + new String(base64decodedBytes, "utf-8"));
         base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
         System.out.println("Base64 编码字符串 (URL) :" + base64encodedString);
        
         StringBuilder stringBuilder = new StringBuilder();
        
         for (int i = 0; i < 10; ++i) {
            stringBuilder.append(UUID.randomUUID().toString());
         }
        
         byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
         String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
         System.out.println("Base64 编码字符串 (MIME) :" + mimeEncodedString);
         
      }catch(UnsupportedEncodingException e){
         System.out.println("Error :" + e.getMessage());
      }
      
      double e = Math.E;
      System.out.format("%f%n", e);
      System.out.format(Locale.CHINA  , "%-10.4f%n%n", e);  //指定本地为中国（CHINA）
      
      String variables[] = new String[50000];      
      for( int i=0;i <50000;i++){
          variables[i] = "s"+i;
      }
      long startTime0 = System.currentTimeMillis();
      for(int i=0;i<50000;i++){
          variables[i] = "hello";
      }
      long endTime0 = System.currentTimeMillis();
      System.out.println("直接使用字符串： "+ (endTime0 - startTime0)  + " ms" );
      long startTime1 = System.currentTimeMillis();
          for(int i=0;i<50000;i++){
          variables[i] = new String("hello");
      }
      long endTime1 = System.currentTimeMillis();
      System.out.println("使用 new 关键字：" + (endTime1 - startTime1) + " ms");
      long startTime2 = System.currentTimeMillis();
      for(int i=0;i<50000;i++){
          variables[i] = new String("hello");
          variables[i] = variables[i].intern();          
      }
      long endTime2 = System.currentTimeMillis();
      System.out.println("使用字符串对象的 intern() 方法: " 
      + (endTime2 - startTime2)
      + " ms");
      
      Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
      System.out.println("格式化结果：" + sd);

      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
      String sd2 = sdf2.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
      System.out.println("格式化结果：" + sd2);
      SimpleDateFormat sdf1 = new SimpleDateFormat();// 格式化时间 
      sdf1.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记  
      Date date = new Date();// 获取当前时间 
      System.out.println("现在时间：" + sdf1.format(date)); // 输出已经格式化的现在时间（24小时制） 
      
      Date date1 = new Date();
      String strDateFormat = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat sdf11 = new SimpleDateFormat(strDateFormat);
      System.out.println(sdf11.format(date1));
   }
}
