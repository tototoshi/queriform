package com.github.tototoshi.queriform

object Tokens {

  case class Column(name: String, alias: Option[As], raw: String)
  case class Table(name: String, alias: Option[As], raw: String)
  case class Select(raw: String)
  case class From(raw: String)
  case class As(alias: String, raw: String)

}
