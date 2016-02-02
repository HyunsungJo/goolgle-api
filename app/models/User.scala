package models

import play.api.libs.json.{Writes, Reads, Json}

/**
 * Created by Jo on 2/3/16.
 */
case class User (
  userId: Long,
  userName: String,
  profileImage: String,
  bio: String,
  email: String
)

object User {
  implicit val writer: Writes[User] = Json.writes[User]
  implicit val reader: Reads[User] = Json.reads[User]
}


