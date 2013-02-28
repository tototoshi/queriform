package com.github.tototoshi.queriform

import org.scalatest.FunSpec
import org.scalatest.matchers._

class SQLParserSpec extends FunSpec with ShouldMatchers {
  def fixture = new {

  }

  describe("SQLParser") {

    it("should format simple SQL") {

      val sql =
        """SELECT
      a as
      aaa
      ,
      b
      as bbb, c as
      ccc FROM
      table"""

      val res = SQLParser.parse(sql)

      res.successful should be(true)

      val expected =
        """|SELECT
           |  a as aaa,
           |  b as bbb,
           |  c as ccc
           |FROM
           |  table
           |""".stripMargin

      Formatter.format(res.get) should be(expected)
    }

  }
}

