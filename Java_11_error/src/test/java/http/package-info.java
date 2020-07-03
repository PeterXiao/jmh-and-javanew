/**
 *
 */
/**
 * @author LiY
 * @time 下午5:29:56
 */
package http;

/*
 * // 与 闭锁 结构一致 public class LatchTest {       public static void main(String[]
 * args) throws InterruptedException {           Runnable taskTemp = new
 * Runnable() {               private int iCounter;               @Override
 *             public void run() {                 // 发起请求 //             
 * HttpClientOp.doGet("https://www.baidu.com/");                 iCounter++;
 *                 System.out.println(System.nanoTime() + " [" +
 * Thread.currentThread().getName() + "] iCounter = " + iCounter);             }
 *         };           LatchTest latchTest = new LatchTest(); //       
 * latchTest.startTaskAllInOnce(5, taskTemp);
 *         latchTest.startNThreadsByBarrier(5, taskTemp);     }       public
 * void startNThreadsByBarrier(int threadNums, Runnable finishTask) throws
 * InterruptedException {         // 设置栅栏解除时的动作，比如初始化某些值         CyclicBarrier
 * barrier = new CyclicBarrier(threadNums, finishTask);         // 启动 n
 * 个线程，与栅栏阀值一致，即当线程准备数达到要求时，栅栏刚好开启，从而达到统一控制效果         for (int i = 0; i <
 * threadNums; i++) {             Thread.sleep(100);             new Thread(new
 * CounterTask(barrier)).start();         }
 *         System.out.println(Thread.currentThread().getName() +
 * " out over...");     } }   class CounterTask implements Runnable {       //
 * 传入栅栏，一般考虑更优雅方式     private CyclicBarrier barrier;       public
 * CounterTask(final CyclicBarrier barrier) {         this.barrier = barrier;
 *     }       public void run() {
 *         System.out.println(Thread.currentThread().getName() + " - " +
 * System.currentTimeMillis() + " is ready...");         try {             //
 * 设置栅栏，使在此等待，到达位置的线程达到要求即可开启大门             barrier.await();         } catch
 * (InterruptedException e) {             e.printStackTrace();         } catch
 * (BrokenBarrierException e) {             e.printStackTrace();         }
 *         System.out.println(Thread.currentThread().getName() + " - " +
 * System.currentTimeMillis() + " started...");     } }
 *
 */

/*
 * class HttpClientOp {     public static String doGet(String httpurl) {
 *         HttpURLConnection connection = null;         InputStream is = null;
 *         BufferedReader br = null;         String result = null;// 返回结果字符串
 *         try {             // 创建远程url连接对象             URL url = new
 * URL(httpurl);             // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
 *             connection = (HttpURLConnection) url.openConnection();
 *             // 设置连接方式：get             connection.setRequestMethod("GET");
 *             // 设置连接主机服务器的超时时间：15000毫秒
 *             connection.setConnectTimeout(15000);             //
 * 设置读取远程返回的数据时间：60000毫秒             connection.setReadTimeout(60000);
 *             // 发送请求             connection.connect();             //
 * 通过connection连接，获取输入流             if (connection.getResponseCode() == 200) {
 *                 is = connection.getInputStream();                 //
 * 封装输入流is，并指定字符集                 br = new BufferedReader(new
 * InputStreamReader(is, "UTF-8"));                 // 存放数据
 *                 StringBuffer sbf = new StringBuffer();                 String
 * temp = null;                 while ((temp = br.readLine()) != null) {
 *                     sbf.append(temp);                     sbf.append("\r\n");
 *                 }                 result = sbf.toString();             }
 *         } catch (MalformedURLException e) {             e.printStackTrace();
 *         } catch (IOException e) {             e.printStackTrace();         }
 * finally {             // 关闭资源             if (null != br) {
 *                 try {                     br.close();                 } catch
 * (IOException e) {                     e.printStackTrace();                 }
 *             }               if (null != is) {                 try {
 *                     is.close();                 } catch (IOException e) {
 *                     e.printStackTrace();                 }             }  
 *             connection.disconnect();// 关闭远程连接         }           return
 * result;     }       public static String doPost(String httpUrl, String param)
 * {           HttpURLConnection connection = null;         InputStream is =
 * null;         OutputStream os = null;         BufferedReader br = null;
 *         String result = null;         try {             URL url = new
 * URL(httpUrl);             // 通过远程url连接对象打开连接             connection =
 * (HttpURLConnection) url.openConnection();             // 设置连接请求方式
 *             connection.setRequestMethod("POST");             //
 * 设置连接主机服务器超时时间：15000毫秒             connection.setConnectTimeout(15000);
 *             // 设置读取主机服务器返回数据超时时间：60000毫秒
 *             connection.setReadTimeout(60000);               //
 * 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
 *             connection.setDoOutput(true);             //
 * 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
 *             connection.setDoInput(true);             // 设置传入参数的格式:请求参数应该是
 * name1=value1&name2=value2 的形式。
 *             connection.setRequestProperty("Content-Type",
 * "application/x-www-form-urlencoded");             // 设置鉴权信息：Authorization:
 * Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
 *             connection.setRequestProperty("Authorization",
 * "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");             // 通过连接对象获取一个输出流
 *             os = connection.getOutputStream();             //
 * 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的             os.write(param.getBytes());
 *             // 通过连接对象获取一个输入流，向远程读取             if
 * (connection.getResponseCode() == 200) {                   is =
 * connection.getInputStream();                 //
 * 对输入流对象进行包装:charset根据工作项目组的要求来设置                 br = new BufferedReader(new
 * InputStreamReader(is, "UTF-8"));                   StringBuffer sbf = new
 * StringBuffer();                 String temp = null;                 //
 * 循环遍历一行一行读取数据                 while ((temp = br.readLine()) != null) {
 *                     sbf.append(temp);                     sbf.append("\r\n");
 *                 }                 result = sbf.toString();             }
 *         } catch (MalformedURLException e) {             e.printStackTrace();
 *         } catch (IOException e) {             e.printStackTrace();         }
 * finally {             // 关闭资源             if (null != br) {
 *                 try {                     br.close();                 } catch
 * (IOException e) {                     e.printStackTrace();                 }
 *             }             if (null != os) {                 try {
 *                     os.close();                 } catch (IOException e) {
 *                     e.printStackTrace();                 }             }
 *             if (null != is) {                 try {
 *                     is.close();                 } catch (IOException e) {
 *                     e.printStackTrace();                 }             }
 *             // 断开与远程地址url的连接             connection.disconnect();         }
 *         return result;     } }
 * 
 */