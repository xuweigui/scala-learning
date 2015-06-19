package com.windrift

/**
 * Created by gary on 16/06/15.
 */
object Ratio {
  def main (args: Array[String]) {
    val p1 = new Pair[Int, Int](2279, 3400)
    val p2 = new Pair[Int, Int](3049, 4572)
    val p3 = new Pair[Int, Int](4099, 5178) //(4305,4511,4638,4765,4971)
    val p3_1 = new Pair[Int, Int](4432, 5178) //(4574,4716,4805,4893,5035)
    val p2p3 = new Pair[Int, Int](3052, 5178) //(3458,3864,4115,4365,4771)
    println(goldenSection(new Pair[Int, Int] (4432, 5178)))

  }

  def goldenSection(input: Pair[Int, Int]): (Int, Int, Int, Int, Int) = {
//    0.191、0．382、0．5、0．618、0．809
    val v1 = input._1 + (input._2 - input._1) * 0.191
    val v2 = input._1 + (input._2 - input._1) * 0.382
    val v3 = input._1 + (input._2 - input._1) * 0.5
    val v4 = input._1 + (input._2 - input._1) * 0.618
    val v5 = input._1 + (input._2 - input._1) * 0.809
    (v1.toInt, v2.toInt, v3.toInt, v4.toInt, v5.toInt)
  }
}
