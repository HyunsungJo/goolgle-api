package models.dao

import com.sksamuel.elastic4s.ElasticClient
import com.sksamuel.elastic4s.ElasticDsl._
import play.api.libs.json.{Writes, Json, Reads}

object MediaESDao {
  private val client = ElasticClient.local
  private val searchIndex = "goolgle"
  private val searchType = "media"

  def putMedia(media: Media ) = {
    client.execute { index into s"$searchIndex/$searchType" doc media }
  }

  def getMedia(docId: Int) = {
    client.execute { get id docId from s"$searchIndex/$searchType" }
  }

  def searchMedia(q: String) = {
    client.execute { search in searchIndex -> searchType query q }
  }

}

case class Media(
  mediaId: Long,
  uploader: Long,
  features: Seq[Long],
  groupId: Long,
  url: String,
  description: String,
  tags: Seq[String],
  category: Int,
  score: Float,
  created: Long,
  updated: Long,
  width: Int,
  height: Int,
  otls: Long
)

object Media {
  implicit val reader: Reads[Media] = Json.reads[Media]
  implicit val writer: Writes[Media] = Json.writes[Media]
}
