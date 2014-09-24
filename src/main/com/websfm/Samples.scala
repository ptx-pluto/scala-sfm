package com.websfm

import scala.io.Source
import spray.json._
import spray.json.DefaultJsonProtocol._
import JsonProtocol._

object Samples {

  val ROOT = "/home/sheep/Code/Project/web-sfm/demo/Hall-Demo"
  val SIFT_ROOT = ROOT + "/sift.json"

  def getFeatures(index: Int): Vector[Feature] ={
    val path = SIFT_ROOT + "/" + getFullName(index) + ".json"
    val ast = Source.fromFile(path).mkString.parseJson
    val features = ast.asJsObject.fields("features") match {
      case JsArray(fs: List[JsValue]) => fs
    }
    features.toVector.map(x=>x.asJsObject.convertTo[Feature])
  }

  def getFullName(index: Int): String ={
    "0" * (8-index.toString.length) + index.toString
  }

}
