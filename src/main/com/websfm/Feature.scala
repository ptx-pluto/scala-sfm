package com.websfm

import spray.json._
import spray.json.DefaultJsonProtocol._

class Feature(val row: Double,
              val col: Double,
              val scale: Double,
              val direction: Double,
              val descriptor: Array[Double])


object JsonProtocol {

  implicit def vectorToJson(v: Array[Double]) = v.map(x=>JsNumber(x)).toList

  implicit def jsarrayToVector(vector: Seq[JsValue]): Array[Double] = vector.map {
    case JsNumber(n) => n.toDouble
    case _ => throw new DeserializationException("Vector is invalid!")
  }.toArray

  implicit object DescriptorJsonFormat extends RootJsonFormat[Feature] {

    def write(f: Feature) = JsObject(
      "row" -> JsNumber(f.row),
      "col" -> JsNumber(f.col),
      "scale" -> JsNumber(f.scale),
      "direction" -> JsNumber(f.direction),
      "vector" -> JsArray(f.descriptor)
    )

    def read(json: JsValue) = {
      json.asJsObject.getFields("row", "col", "scale", "direction", "vector") match {
        case Seq(JsNumber(row), JsNumber(col), JsNumber(scale), JsNumber(direction), JsArray(vector: Seq[JsValue])) =>
          new Feature(row.toDouble, col.toDouble, scale.toDouble, direction.toDouble, vector)
        case _ => throw new DeserializationException("value is invalid!")
      }
    }

  }

}
