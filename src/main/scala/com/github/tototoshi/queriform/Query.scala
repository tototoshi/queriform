package com.github.tototoshi.queriform

import com.github.tototoshi.queriform.Tokens._

case class SelectQuery(select: Select, columns: List[Column], from: From, table: Table)

object SelectQuery {

  val indent = " " * 2

  implicit val formatter: Format[SelectQuery] = new Format[SelectQuery] {
    def format(query: SelectQuery): String =
      s"""|SELECT
          |${query.columns.map(c => indent + c.raw).mkString(",\n")}
          |FROM
          |${indent}${query.table.raw}
          |""".stripMargin
  }
}

