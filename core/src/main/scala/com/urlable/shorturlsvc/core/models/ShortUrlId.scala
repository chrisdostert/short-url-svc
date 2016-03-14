package com.urlable.shorturlsvc.core.models

import scala.language.implicitConversions

trait ShortUrlId {

  private[models] val value: Long

  override def toString: String = {

    def div(
      i: Long,
      res: List[Int] = Nil
    ): List[Int] = {
      i / ShortUrlId.base match {
        case q if q > 0 => div(
          q,
          (i % ShortUrlId.base).toInt :: res
        )
        case _ => i.toInt :: res
      }
    }

    div(value).map(x => ShortUrlId.base62String(x)).mkString

  }

  def toLong: Long = {
    value
  }

}

object ShortUrlId {

  private final val base62String = ((0 to 9) ++ ('A' to 'Z') ++ ('a' to 'z')).mkString
  private final val base = 62

  private case class ShortUrlIdImpl(private[models] val value: Long) extends ShortUrlId

  implicit def fromBase62String(shortUrlId: String): ShortUrlId = shortUrlId.zip(shortUrlId.indices.reverse)
    .map { case (c, p) => base62String.indexOf(c) * scala.math.pow(
      base,
      p
    ).toLong
    }
    .sum

  implicit def fromLong(shortUrlId: Long): ShortUrlId = ShortUrlIdImpl(shortUrlId)

}
