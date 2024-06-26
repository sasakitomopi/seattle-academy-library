package jp.co.seattle.library.commonutil;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.List;

import org.junit.Test;

import jp.co.seattle.library.dto.BookDetailsInfo;

public class BookUtilTest {
	
	private static final String REQUIRED_ERROR = "未入力の必須項目があります";
	private static final String ISBN_ERROR = "ISBNの桁数または半角数字が正しくありません";
	private static final String PUBLISHDATE_ERROR = "出版日は半角数字のYYYYMMDD形式で入力してください";

	BookUtil bookUtil = new BookUtil();
	
	
	@Test
	public void test01() {
		// パラメータで受け取った書籍情報をDtoに格納する
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("著者");
		bookInfo.setPublisher("出版社");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList.isEmpty(), is(true));
		
	}
	
	@Test
	public void test02() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList, hasItem(REQUIRED_ERROR));
		
	}

	@Test
	public void test03() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList, hasItem(REQUIRED_ERROR));
		
	}

	@Test
	public void test04() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList, hasItem(REQUIRED_ERROR));
		
	}

	@Test
	public void test05() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("");
		bookInfo.setPublishDate("あああ");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList, hasItem(REQUIRED_ERROR));
		assertThat(resultList, hasItem(PUBLISHDATE_ERROR));
		
	}

	@Test
	public void test06() {
		// パラメータで受け取った書籍情報をDtoに格納する。
		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("11");
		bookInfo.setDescription("");
		
		List<String> resultList = bookUtil.checkBookInfo(bookInfo);
		assertThat(resultList, hasItem(ISBN_ERROR));
		
	}
}