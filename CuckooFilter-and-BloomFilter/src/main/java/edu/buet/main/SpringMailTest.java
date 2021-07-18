/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:SpringMailTest.java Package Name:edu.buet.main
 * Date:2021年3月22日下午9:17:37 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: SpringMailTest.java @Package edu.buet.main @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年3月22日 下午9:17:37
 * @version V1.0
 */
package edu.buet.main;
/**
 * ClassName:SpringMailTest <br>
 * Function: TODO ADD FUNCTION. <br>
 * Reason: TODO ADD REASON. <br>
 * Date: 2021年3月22日 下午9:17:37 <br>
 *
 * @author xiaoy
 * @version
 * @since JDK 1.8
 * @see
 */

/**
 * @ClassName: SpringMailTest @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年3月22日 下午9:17:37
 * @version
 * @since JDK 1.8
 */
public class SpringMailTest {
}

// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(WebMain.class)
// public class SpringMailTest {
//
// @Autowired
// private JavaMailSenderImpl mailSender;
//
/// **
// * 发送包含简单文本的邮件
// */
// @Test
// public void sendTxtMail() {
// SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//// 设置收件人，寄件人
// simpleMailMessage.setTo(new String[] {"lianggzone@163.com"});
// simpleMailMessage.setFrom("lianglevel@163.com");
// simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
// simpleMailMessage.setText("这里是一段简单文本。");
//// 发送邮件
// mailSender.send(simpleMailMessage);
//
// System.out.println("邮件已发送");
// }
//
/// **
// * 发送包含HTML文本的邮件
// * @throws Exception
// */
// @Test
// public void sendHtmlMail() throws Exception {
// MimeMessage mimeMessage = mailSender.createMimeMessage();
// MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
// mimeMessageHelper.setTo("lianggzone@163.com");
// mimeMessageHelper.setFrom("lianglevel@163.com");
// mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");
//
// StringBuilder sb = new StringBuilder();
// sb.append("<html><head></head>");
// sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
// sb.append("</html>");
//
//// 启用html
// mimeMessageHelper.setText(sb.toString(), true);
//// 发送邮件
// mailSender.send(mimeMessage);
//
// System.out.println("邮件已发送");
//
// }
//
/// **
// * 发送包含内嵌图片的邮件
// * @throws Exception
// */
// @Test
// public void sendAttachedImageMail() throws Exception {
// MimeMessage mimeMessage = mailSender.createMimeMessage();
//// multipart模式
// MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
// mimeMessageHelper.setTo("lianggzone@163.com");
// mimeMessageHelper.setFrom("lianglevel@163.com");
// mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【图片】");
//
// StringBuilder sb = new StringBuilder();
// sb.append("<html><head></head>");
// sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
//// cid为固定写法，imageId指定一个标识
// sb.append("<img src=\"cid:imageId\"/></body>");
// sb.append("</html>");
//
//// 启用html
// mimeMessageHelper.setText(sb.toString(), true);
//
//// 设置imageId
// FileSystemResource img = new FileSystemResource(new File("D:/images/01.jpg"));
// mimeMessageHelper.addInline("imageId", img);
//
//// 发送邮件
// mailSender.send(mimeMessage);
//
// System.out.println("邮件已发送");
// }
//
/// **
// * 发送包含附件的邮件
// * @throws Exception
// */
// @Test
// public void sendAttendedFileMail() throws Exception {
// MimeMessage mimeMessage = mailSender.createMimeMessage();
//// multipart模式
// MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
// mimeMessageHelper.setTo("lianggzone@163.com");
// mimeMessageHelper.setFrom("lianglevel@163.com");
// mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【附件】");
//
// StringBuilder sb = new StringBuilder();
// sb.append("<html><head></head>");
// sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
// sb.append("</html>");
//
//// 启用html
// mimeMessageHelper.setText(sb.toString(), true);
//// 设置附件
// FileSystemResource img = new FileSystemResource(new File("D:/images/01.jpg"));
// mimeMessageHelper.addAttachment("image.jpg", img);
//
//// 发送邮件
// mailSender.send(mimeMessage);
//
// System.out.println("邮件已发送");
// }
// }
