package com.windrift

/**
 * Created by gary on 16/06/15.
 */
object Ratio {
  def main (args: Array[String]) {
    val p1 = new Pair[Int, Int](2279, 3400)
    val p2 = new Pair[Int, Int](3052, 4572)
    val p3 = new Pair[Int, Int](4099, 5178)
    val p3_1 = new Pair[Int, Int](4431, 5178)
    println(ratio(p3_1))
    println(ratio(p3))

  }

  def ratio(input: Pair[Int, Int]): (Int, Int, Int) = {
    val v1 = input._1 + (input._2 - input._1) * 0.382
    val v2 = input._1 + (input._2 - input._1) * 0.5
    val v3 = input._1 + (input._2 - input._1) * 0.618
    (v1.toInt, v2.toInt, v3.toInt)
  }
}
