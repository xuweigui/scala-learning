package com.windrift

import java.io.StringReader

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by gary on 15/06/15.
 */
object Something {

  val conf = new SparkConf().setMaster("local").setAppName("some app")
  val sc = new SparkContext(conf)

  def main (args: Array[String]) = {

    val input = sc.textFile("/Users/gary/data.txt")
    val pairs = input.flatMap(line => line.split(" "))

    pairs.foreach(println)
//    input.reduce(something)

  }

  def something(a:String, b:String):String = {
    return a
  }


}
