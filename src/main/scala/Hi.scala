/**
 * Created by gary on 2/06/15.
 */
object Hi {
  def main (args: Array[String]) {
//    for(i <- 30 to 15 by -1) println(fact(i))
    for(i <- 30 to 15 by -1 par) println(fact(i))

    Java1.callScala();
  }

  def somefunc(x: Double) : Double = x * x

  def readInts:List[Int] = {
    var lst=List[Int]()
    var input=readLine()
    while(input!="quit") {
      lst ::= input.toInt
      input=readLine()
    }
    lst
  }

  def fact(n:BigInt):BigInt = if(n<2) 1 else n*fact(n-1)

}
