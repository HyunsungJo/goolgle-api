package models

import org.joda.time.DateTime
import play.api.libs.json.{Writes, Reads, Json}

/**
 * Created by Jo on 2/4/16.
 */
case class Group (
  groupId: Long,
  groupName: String,
  creator: String,
  profileImg: String,
  description: String,
  created: DateTime,
  updated: DateTime
)

object Group {
  implicit val writer: Writes[Group] = Json.writes[Group]
  implicit val reader: Reads[Group] = Json.reads[Group]
}


