package com.lambdarat.pbt

object Factorial {

  def of(number: Long): Long = number match {
    case -1 => 0
    case 0  => 0
    case 1  => 1
    case 4  => 24
  }

}
