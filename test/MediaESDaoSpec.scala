import models.dao.{MediaESDao, Media}
import org.specs2.mutable.Specification
import scala.concurrent._
import scala.concurrent.duration._

class MediaESDaoSpec extends Specification {
  section("Media")
  "MediaESDaoSpec" should {
    "be able to putMedia, getMedia and searchMedia" in {
      val timeout = 5000L
      val id = 11
      val media = Media(id, 1, Seq(1), 1, "http://stuffpoint.com/kate-upton/image/298407-kate-upton-kate-upton-2.jpg", "picture of Kate Upton", Seq("melons"), 1, 0, 1418565692, 1418565692, 1024, 1024, 1)

      Await.result(MediaESDao.putMedia(media), timeout milli).isCreated must equalTo(true) // put
      Await.result(MediaESDao.getMedia(id), timeout milli).getId must equalTo(id.toString) // get
      Await.result(MediaESDao.searchMedia("Kate Upton"), timeout milli).getSuccessfulShards must not equalTo(0) // search
    }
  }
}