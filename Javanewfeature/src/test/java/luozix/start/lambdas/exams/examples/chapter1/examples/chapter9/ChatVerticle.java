    /** 
	 * Project Name:java11_in_action 
	 * File Name:ChatVerticle.java 
	 * Package Name:luozix.start.lambdas.exams.examples.chapter1.examples.chapter9 
	 * Date:2021年2月15日下午9:43:15 
	 * Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved. 
	 * 
	*/  
	/**  
* @Title: ChatVerticle.java
* @Package luozix.start.lambdas.exams.examples.chapter1.examples.chapter9
* @Description: TODO(用一句话描述该文件做什么)
* @author xiao xiaoyulong07@outlook.com  
* @date 2021年2月15日 下午9:43:15
* @version V1.0  
*/  
	  
	package luozix.start.lambdas.exams.examples.chapter1.examples.chapter9;

/** 
	 * ClassName:ChatVerticle <br/> 
	 * Function: TODO ADD FUNCTION. <br/> 
	 * Reason:   TODO ADD REASON. <br/> 
	 * Date:     2021年2月15日 下午9:43:15 <br/> 
	 * @author   xiaoy 
	 * @version   
	 * @since    JDK 1.8
	 * @see       
	 */

/**
* @ClassName: ChatVerticle
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaoyulong xiaoyulong07@outlook.com
* @date 2021年2月15日 下午9:43:15
* @version  
*@since JDK 1.8
*/
//public class ChatVerticle extends Verticle {
//
//	public void start() {
//		vertx.createNetServer().connectHandler(socket -> {
//			container.logger().info("socket connected");
//			socket.dataHandler(new User(socket, this));
//		}).listen(10_000);
//
//		container.logger().info("ChatVerticle started");
//	}
//
//}
//public class User implements Handler<Buffer> {
//
//	private static final Pattern newline = Pattern.compile("\\n");
//
//	private final NetSocket socket;
//	private final Set<String> names;
//	private final EventBus eventBus;
//
//	private Optional<String> name;
//
//	public User(NetSocket socket, Verticle verticle) {
//		Vertx vertx = verticle.getVertx();
//
//		this.socket = socket;
//		names = vertx.sharedData().getSet("names");
//		eventBus = vertx.eventBus();
//		name = Optional.empty();
//	}
//
//	@Override     public void handle(Buffer buffer) {         newline.splitAsStream(buffer.toString())                .forEach(line -> {                    if (!name.isPresent())                        setName(line);                    else                        handleMessage(line);                 });     }
//
//// Class continues...
