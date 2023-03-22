package com.knoldus.map

class MapClass {

  private var mapStorage: Map[String, String] = Map.empty[String, String]

  // store the new map key-values in  storage, already defined,  return the size
  def store(map: Map[String, String]): Int = {
    val newMap = map
    mapStorage = mapStorage ++ newMap
    mapStorage.size
  }

  //simply get the value for a given key from storage
  def getValue(key: String): String = {
      mapStorage.getOrElse(key, throw new NoSuchElementException())
  }

  // return all the key-values of the db
  def getAllValues: Map[String, String] = {
    mapStorage
  }

  // update the value if key is present, else do nothing,  return the size
  def updateMap(key: String, value:String): Int = {
    if(mapStorage.contains(key)) {
      val newMapStorage = mapStorage + (key -> value)
      mapStorage = newMapStorage
    }
    mapStorage.size
  }

  // check all the keys in db and figure out how many of them can be converted into int , filter them out by odd values and return them
  def getOddValue: Map[String, String] = {
    try {
      mapStorage.filter(entry => {
        try {
          val intValue = entry._1.toInt
          intValue % 2 != 0
        } catch {
          case _: Exception => false
        }
      })
    }
  }

  // get the value for a given key from storage, if key is not present return empty string
  def getValuesSafely(key: String): String = {
    if(mapStorage.contains(key)) mapStorage(key) else ""
  }

}
