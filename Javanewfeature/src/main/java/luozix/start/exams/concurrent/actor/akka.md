package com.smart

	import akka.actor.{Actor, ActorSystem, Props}

	class SayHelloActor extends Actor{
	  override def receive: Receive = {
	    case "hello" => println("收到hello，回应hello too")
	    case "ok" => println("收到ok，回应ok too")
	    case "exit" => {
	      println("收到退出指令")
	      context.stop(self)
	      context.system.terminate()
	    }
	    case _ => println("匹配不到")
	  }
	}
	
	object SayHelloActorDemo{
	  private val actorFactory = ActorSystem("actoryFactory")
	  private val sayHelloActorRef = actorFactory.actorOf(Props[SayHelloActor],"sayHelloActor")
	
	  def main(args: Array[String]): Unit = {
	    sayHelloActorRef ! "hello"
	    sayHelloActorRef ! "exit"
	  }
	}

	
监视器锁规则： 对一个锁的释放先于所有后续对同一个锁的获取

volatile变量规则: 对一个volatile变量的写操作先于所有对同一volatile变量的后续读操作


	