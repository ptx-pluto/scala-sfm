package com.websfm

case class FeatureMatch(features1: Seq[Feature], features2: Seq[Feature], matches: Map[Int, Int]) {}
//case class EpipolarFeatureMatch() extends FeatureMatch {}

object FeatureMatcher {

  def bruteforce(features1: Seq[Feature], features2: Seq[Feature]): FeatureMatch = {
    FeatureMatch(features1, features2, Map())
  }

  def withEpipolarGeomotry(matches: FeatureMatch) = {

  }

  def withGlobalConnectivity() = {}

}
