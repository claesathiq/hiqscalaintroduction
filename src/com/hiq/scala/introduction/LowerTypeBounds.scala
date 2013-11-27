package com.hiq.scala.introduction

/**
 * Lower Type Bounds
 */
object LowerTypeBounds extends App {

  // case class ListNode[T](h: T, t: ListNode[T]) {...} is invariant
  //      so ListNode[String] is NOT a subtype of ListNode[Any]
  // case class ListNode[+T](h: T, t: ListNode[T]) {...} is kovariant  //     Invariance +T means that ListNode[Null] is a subtype of ListNode[String] is a subtype of ListNode[Any]

  case class ListNode[+T](h: T, t: ListNode[T]) {
    def head: T = h
    def tail: ListNode[T] = t
    def prepend[U >: T](elem: U): ListNode[U] =  ListNode(elem, this)
  }
  val empty: ListNode[Null] = ListNode(null, null)
  val strList: ListNode[String] = empty.prepend("hello").prepend("world")
  val anyList: ListNode[Any] = strList.prepend(12345)
}
