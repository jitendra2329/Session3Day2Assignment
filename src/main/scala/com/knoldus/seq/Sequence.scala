package com.knoldus.seq

class Sequence {

  private var sequenceString: Seq[String] = Seq.empty[String]
  private var sequenceInt: Seq[Int] = Seq.empty[Int]

  // Check the type of element, if it is int save it to sequenceInt, if it is string save it to sequenceString, else return IllegalArgumentException,  return the size
  def store(element: Any): Int = {
    if(element.isInstanceOf[Int]) {
      val newSequenceInt = sequenceInt :+ element
      newSequenceInt.size
    } else if(element.isInstanceOf[String]){
      val newSequenceString = sequenceString :+ element
      newSequenceString.size
    }
    else throw new IllegalArgumentException
  }

  // Check the type of element, if it is int remove it from sequenceInt, if it is string remove it from sequenceString, else return IllegalArgumentException,  return the size
  def removeElement(element: Any): Int = {
    element match {
      case _: Int =>
        val newSequenceInt = sequenceInt.filter(_.isInstanceOf[Int])
        newSequenceInt.size
      case _: String =>
        val newSequenceString = sequenceString.filter(_.isInstanceOf[String])
        newSequenceString.size
      case _ => throw new IllegalArgumentException
    }
  }

}
