import akka.actor.{ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout
import ngalert.{NgAlertCoordinator, START}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by SangDang on 7/9/16.
  */

object NgAlert extends App {
  System.out.println("Start NgAlert")
  val config = System.getProperty("config", "config/ng-alert.json")
  val system = ActorSystem.create("NgAlert-System")
  val coordinator = system.actorOf(Props[NgAlertCoordinator], name = "coordinator")
  implicit val timeout: Timeout = Timeout(5 seconds)
  val result = coordinator ? START(config)
//  Await.result(result, 5 seconds)
//  result onFailure {
//    case t => {
//      t.printStackTrace()
//      System.err.println("Shutdown NgAlert")
//      system.shutdown()
//    }
//  }
//  result onSuccess {
//    case _ => println("Start NgAlert Successful")
//  }
}
