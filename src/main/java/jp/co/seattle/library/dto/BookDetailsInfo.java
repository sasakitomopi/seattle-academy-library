package jp.co.seattle.library.dto;

/**
 * 書籍詳細情報格納DTO
 *
 */
public class BookDetailsInfo {

	private int bookId;

	private String title;

	private String author;

	private String publisher;

	private String publishDate;

	private String thumbnailUrl;

	private String thumbnailName;

	private String isbn;

	private String description;

	/**
	 * @return bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId セットする bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author セットする author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher セットする publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return publishDate
	 */
	public String getPublishDate() {
		return publishDate;
	}

	/**
	 * @param publishDate セットする publishDate
	 */
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	/**
	 * @return thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * @param thumbnailUrl セットする thumbnailUrl
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * @return thumbnailName
	 */
	public String getThumbnailName() {
		return thumbnailName;
	}

	/**
	 * @param thumbnailName セットする thumbnailName
	 */
	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}

	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn セットする isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}