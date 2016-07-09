package ngalert

import akka.actor.Actor
import akka.actor.Actor.Receive
import akka.event.Logging

/**
  * Created by SangDang on 7/9/16.
  */
class ConfigHandler(val config:String) extends Actor{
  val logger = Logging(context.system,this)
  logger.info("start ConfigHandler with " + config)
  getConfig

  override def receive: Receive = {
    case _ => println("Unknown")
  }
  def getConfig(): Unit ={

  }
}
