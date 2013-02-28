package com.github.tototoshi.queriform

import com.github.tototoshi.queriform.Tokens._
import scala.util.parsing.combinator._

object SQLParser extends RegexParsers {

  val SELECT = """(?i)SELECT""".r
  val FROM = """(?i)FROM""".r
  val WHERE = """(?i)WHERE""".r
  val ORDER = """(?i)ORDER""".r
  val LIMIT = """(?i)LIMIT""".r
  val OFFSET = """(?i)OFFSET""".r
  val AS = """(?i)AS""".r

  val space = " "

  def column = """[^\s,]+""".r
  def columnAlias = AS ~ """[^\s,]+""".r ^^ {
    case as ~ alias =>
      As(alias, as + space + alias)
  }
  def columns = repsep(column ~ opt(columnAlias), ",") ^^ {
    cs =>
      cs.map {
        case c ~ alias => Column(c, alias, c + space + alias.map(_.raw).getOrElse(""))
      }
  }

  def table = """[^\s,]+""".r ^^ { t => Table(t, None, t) }

  def lines = SELECT ~ columns ~ FROM ~ table ^^ {
    case select ~ columns ~ from ~ table => SelectQuery(Select(select), columns, From(from), table)
  }

  def parse(in: String) = parseAll(lines, in)

}

