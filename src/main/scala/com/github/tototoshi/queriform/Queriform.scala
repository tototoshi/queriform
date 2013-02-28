package com.github.tototoshi.queriform

import com.github.tototoshi.queriform.Tokens._

trait Format[T] {
  def format(query: T): String
}

object Formatter {

  def format[T](q: T)(implicit format: Format[T]): String = format.format(q)

}

