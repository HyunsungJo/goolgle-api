package models.dao

object MediaDao {
  def search(query: String) = {
    MediaESDao.searchMedia(query)
  }
}