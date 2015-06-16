package com.windrift

import org.apache.spark.rdd.RDD

/**
 * Created by gary on 16/06/15.
 */
class SearchFunctions(val query: String) {
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }

  def getMachesFunctionReference(rdd: RDD[String]): RDD[String] = {
    rdd.filter(isMatch)
  }

  def getMatchesFieldReference(rdd: RDD[String]): RDD[String] = {
    rdd.flatMap(x => x.split(query))
  }

  def getMatcherNoReference(rdd: RDD[String]): RDD[String] = {
    val q = this.query
    rdd.flatMap(x => x.split(q))
  }
}
