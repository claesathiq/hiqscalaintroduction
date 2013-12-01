package com.hiq.scala.introduction

import akka.actor.{Actor, ActorRef}
import scala.concurrent.duration._
import java.util.Date

/**
 * A very simple Auction system with actors
 */
object Auctioneer {

  abstract class AuctionMessage
  case class Offer(bid: Int, client: ActorRef) extends AuctionMessage
  case class Inquire(client: ActorRef) extends AuctionMessage

  abstract class AuctionSystemMessage
  case object AuctionClosed extends AuctionSystemMessage
  case object AuctionShutdown extends AuctionSystemMessage

  abstract class AuctionReply
  case class Status(asked: Int, expire: Date) extends AuctionReply
  case object BestOffer extends AuctionReply
  case class BeatenOffer(maxBid: Int) extends AuctionReply
  case class AuctionConcluded(seller: ActorRef, client: ActorRef) extends AuctionReply
  case object AuctionFailed extends AuctionReply
  case object AuctionOver extends AuctionReply

  class Auction(seller: ActorRef, minBid: Int, closing: Date) extends Actor {
    import context._

    val actionDuration = closing.getTime - new Date().getTime
    system.scheduler.scheduleOnce(actionDuration milliseconds) {
      self ! AuctionClosed
    }
    val timeToShutdown = 36000000 //msec
    val bidIncrement = 10
    var maxBid = minBid - bidIncrement
    var maxBidder: ActorRef = null

    def auctionOver: Receive = {
      case Offer(_, client) => client ! AuctionOver
      case AuctionShutdown => context.stop(self)
    }

    def receive = {
      case Offer(bid, client) =>
        if (bid >= maxBid + bidIncrement) {
          if (maxBid >= minBid) maxBidder ! BeatenOffer(bid)
          maxBid = bid; maxBidder = client; client ! BestOffer
        } else {
          client ! BeatenOffer(maxBid)
        }
      case Inquire(client) =>
        client ! Status(maxBid, closing)
      case AuctionClosed =>
        if (maxBid >= minBid) {
          val reply = AuctionConcluded(seller, maxBidder)
          maxBidder ! reply; seller ! reply
        } else {
          seller ! AuctionFailed
        }
        system.scheduler.scheduleOnce(actionDuration milliseconds) {
          self ! AuctionShutdown
        }
        become(auctionOver)
    }
  }
}
