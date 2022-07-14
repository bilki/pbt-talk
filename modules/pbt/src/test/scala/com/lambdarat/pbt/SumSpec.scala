package com.lambdarat.pbt

import munit.ScalaCheckSuite
import org.scalacheck._
import org.scalacheck.Prop._

import Sum.add

class SumSpec extends ScalaCheckSuite {

  test("Sum commutativity") {
    forAll { (x: Int, y: Int) =>
      val sum         = add(x, y)
      val reversedSum = add(y, x)

      assertEquals(sum, reversedSum)
    }
  }

  test("Sum associativity") {
    forAll { (x: Int, y: Int, z: Int) =>
      val firstPairSum  = add(add(x, y), z)
      val secondPairSum = add(x, add(y, z))

      assertEquals(firstPairSum, secondPairSum)
    }
  }

  test("Sum identity") {
    forAll { x: Int =>
      val sumZero  = add(x, 0)
      val expected = x

      assertEquals(sumZero, expected)
    }
  }

}
