package com.windrift

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by gary on 15/06/15.
 */
object SparkDemo {

  val conf = new SparkConf().setMaster("local").setAppName("some app")
  val sc = new SparkContext(conf)

  def main (args: Array[String]) = {

    val input = sc.parallelize(List("I am Gary", "Who are you", "I am Kevin"))
    val words = input.filter(line => line.contains("am")).flatMap(line => line.split(" "))
    words.persist()
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y}

    words.take(3).foreach(println)

    println(counts.count())

    aggregateExample
  }

  def squaring(): Unit = {
    val input = sc.parallelize(List(1, 2, 3, 4))
    val result = input.map(i => i * i)
    println(result.collect().mkString(", "))
  }

  def reduceExample(): Unit = {
    val input = sc.parallelize(List(1, 2, 3, 4))
    println("Sum: " + input.reduce((x, y) => x + y))
  }

  def aggregateExample(): Unit = {
    val input: RDD[Double] = sc.parallelize(List(1.4, 2, 3, 4))
    val result: (Double, Int) = input.aggregate((0.0, 0))((acc, value) => (acc._1 + value, acc._2 + 1),
      (acc1, acc2) => (acc1._1 + acc2._1, acc1._2 + acc2._2))

    println("Ave: " + result._1 / result._2.toDouble)
  }

  def setOperation() = {
    val input1 = sc.parallelize(List("coffee", "coffee", "panda", "monkey", "tea"))
    val input2 = sc.parallelize(List("coffee", "money", "kitty"))
    println(input1.distinct().collect().mkString(", "))
    println(input1.union(input2).collect().mkString(", "))
    println(input1.intersection(input2).collect().mkString(", "))
    println(input1.subtract(input2).collect().mkString(", "))
  }

}
