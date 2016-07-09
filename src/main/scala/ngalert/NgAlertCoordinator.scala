package ngalert

import akka.actor.{Actor, Props}
import akka.event.Logging


/**
  * Created by SangDang on 7/9/16.
  */
case class START(config: String)
case object STOP

class NgAlertCoordinator extends Actor {


  val log = Logging(context.system, this)

  override def receive: Receive = {
    case START(config) => {
      log.info("start ng-alert coordinator")
      sender() ! start(config)
    }
    case STOP => {
      log.info("stop ng-alert coordinator")
    }
  }

  def start(config: String): Boolean = {
    val configActor = context.actorOf(Props(new ConfigHandler(config)), "ngalert-config")
    true
  }
}
