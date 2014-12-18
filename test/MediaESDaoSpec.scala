import models.dao.{MediaESDao, Media}
import org.specs2.mutable.Specification
import scala.concurrent._
import scala.concurrent.duration._

class MediaESDaoSpec extends Specification {
  section("Media")
  "MediaESDaoSpec" should {
    "putMedia and getMedia" in {
      val timeout = 5000L
      val id = 0
      // put
      val media = Media(id, 1, Seq(1), 1, "http://stuffpoint.com/kate-upton/image/298407-kate-upton-kate-upton-2.jpg", "picture of Kate Upton", Seq("melons"), 1, 0, 1418565692, 1418565692, 1024, 1024, 1)
      val f1 = MediaESDao.putMedia(media)
      val putMediaResult = Await.result(f1, timeout milli)

      // get
      val f2 = MediaESDao.getMedia(id)
      val getMediaResult = Await.result(f2, timeout milli)

      getMediaResult.getId must equalTo(id.toString)
    }
  }
}