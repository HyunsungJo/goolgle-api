package models

import play.api.libs.json._

/**
 * Created by kakao on 10/7/14.
 */
case class Media (
  mediaId: Long,
  uploader: Long,
  featured: Long,
  groupId: Long,
  url: String,
  description: String,
  tags: JsValue,
  category: Long,
  score: Long,
  created: Long,
  updated: Long,
  size: JsValue,
  otls: Int
)

object Media {
  implicit val writer: Writes[Media] = Json.writes[Media]
  implicit val reader: Reads[Media] = Json.reads[Media]
}


