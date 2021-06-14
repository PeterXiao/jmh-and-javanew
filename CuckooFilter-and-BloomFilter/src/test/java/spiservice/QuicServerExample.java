/**
 * Project Name:CuckooFilter-vs-BloomFilter File Name:QuicServerExample.java Package Name:spiservice
 * Date:2021年6月13日下午7:36:59 Copyright (c) 2021, xiaoyulong07@outlook.com All Rights Reserved.
 */
/**
 * @Title: QuicServerExample.java @Package spiservice @Description: TODO(用一句话描述该文件做什么)
 *
 * @author xiao xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午7:36:59
 * @version V1.0
 */
package spiservice;

/**
 * @ClassName: QuicServerExample @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author xiaoyulong xiaoyulong07@outlook.com
 * @date 2021年6月13日 下午7:36:59
 * @version
 * @since JDK 1.8
 */
// import io.netty.bootstrap.Bootstrap;
// import io.netty.buffer.ByteBuf;
// import io.netty.channel.Channel;
// import io.netty.channel.ChannelHandler;
// import io.netty.channel.ChannelHandlerContext;
// import io.netty.channel.ChannelInboundHandlerAdapter;
// import io.netty.channel.ChannelInitializer;
// import io.netty.channel.nio.NioEventLoopGroup;
// import io.netty.channel.socket.nio.NioDatagramChannel;
// import io.netty.handler.codec.LineBasedFrameDecoder;
// import io.netty.handler.ssl.util.SelfSignedCertificate;
// import io.netty.incubator.codec.quic.InsecureQuicTokenHandler;
// import io.netty.incubator.codec.quic.QuicChannel;
// import io.netty.incubator.codec.quic.QuicServerCodecBuilder;
// import io.netty.incubator.codec.quic.QuicSslContext;
// import io.netty.incubator.codec.quic.QuicSslContextBuilder;
// import io.netty.incubator.codec.quic.QuicStreamChannel;
// import io.netty.util.CharsetUtil;
// import io.netty.util.internal.logging.InternalLogger;
// import io.netty.util.internal.logging.InternalLoggerFactory;
//
// public final class QuicServerExample {
//
//  private static final InternalLogger LOGGER =
//      InternalLoggerFactory.getInstance(QuicServerExample.class);
//
//  private QuicServerExample() {}
//
//  public static void main(String[] args) throws Exception {
//    SelfSignedCertificate selfSignedCertificate = new SelfSignedCertificate();
//    QuicSslContext context =
//        QuicSslContextBuilder.forServer(
//                selfSignedCertificate.privateKey(), null, selfSignedCertificate.certificate())
//            .applicationProtocols("http/0.9")
//            .build();
//    NioEventLoopGroup group = new NioEventLoopGroup(1);
//    ChannelHandler codec =
//        new QuicServerCodecBuilder()
//            .sslContext(context)
//            .maxIdleTimeout(5000, TimeUnit.MILLISECONDS)
//            // Configure some limits for the maximal number of streams (and the data) that we want
//            // to handle.
//            .initialMaxData(10000000)
//            .initialMaxStreamDataBidirectionalLocal(1000000)
//            .initialMaxStreamDataBidirectionalRemote(1000000)
//            .initialMaxStreamsBidirectional(100)
//            .initialMaxStreamsUnidirectional(100)
//
//            // Setup a token handler. In a production system you would want to implement and
// provide
//            // your custom
//            // one.
//            .tokenHandler(InsecureQuicTokenHandler.INSTANCE)
//            // ChannelHandler that is added into QuicChannel pipeline.
//            .handler(
//                new ChannelInboundHandlerAdapter() {
//                  @Override
//                  public void channelActive(ChannelHandlerContext ctx) {
//                    QuicChannel channel = (QuicChannel) ctx.channel();
//                    // Create streams etc..
//                  }
//
//                  @Override
//                  public void channelInactive(ChannelHandlerContext ctx) {
//                    ((QuicChannel) ctx.channel())
//                        .collectStats()
//                        .addListener(
//                            f -> {
//                              if (f.isSuccess()) {
//                                LOGGER.info("Connection closed: {}", f.getNow());
//                              }
//                            });
//                  }
//
//                  @Override
//                  public boolean isSharable() {
//                    return true;
//                  }
//                })
//            .streamHandler(
//                new ChannelInitializer<QuicStreamChannel>() {
//                  @Override
//                  protected void initChannel(QuicStreamChannel ch) {
//                    // Add a LineBasedFrameDecoder here as we just want to do some simple HTTP 0.9
//                    // handling.
//                    ch.pipeline()
//                        .addLast(new LineBasedFrameDecoder(1024))
//                        .addLast(
//                            new ChannelInboundHandlerAdapter() {
//                              @Override
//                              public void channelRead(ChannelHandlerContext ctx, Object msg) {
//                                ByteBuf byteBuf = (ByteBuf) msg;
//                                try {
//                                  if (byteBuf
//                                      .toString(CharsetUtil.US_ASCII)
//                                      .trim()
//                                      .equals("GET /")) {
//                                    ByteBuf buffer = ctx.alloc().directBuffer();
//                                    buffer.writeCharSequence(
//                                        "Hello World!\r\n", CharsetUtil.US_ASCII);
//                                    // Write the buffer and shutdown the output by writing a FIN.
//                                    ctx.writeAndFlush(buffer)
//                                        .addListener(QuicStreamChannel.SHUTDOWN_OUTPUT);
//                                  }
//                                } finally {
//                                  byteBuf.release();
//                                }
//                              }
//                            });
//                  }
//                })
//            .build();
//    try {
//      Bootstrap bs = new Bootstrap();
//      Channel channel =
//          bs.group(group)
//              .channel(NioDatagramChannel.class)
//              .handler(codec)
//              .bind(new InetSocketAddress(9999))
//              .sync()
//              .channel();
//      channel.closeFuture().sync();
//    } finally {
//      group.shutdownGracefully();
//    }
//  }
// }
