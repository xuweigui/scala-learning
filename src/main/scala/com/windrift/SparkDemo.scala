package com.windrift

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by gary on 15/06/15.
 */
object SparkDemo {

  def main (args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(conf)
    val input = sc.parallelize(List("I am Gary", "Who are you", "I am Kevin"))
    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y}

    println(counts.count())
  }

}
