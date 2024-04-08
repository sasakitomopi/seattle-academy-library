package jp.co.seattle.library.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jp.co.seattle.library.commonutil.StartEndLogUtil;
import jp.co.seattle.library.dto.BookDetailsInfo;
import jp.co.seattle.library.dto.BookInfo;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class BooksServiceTest {

	/** ログ */
	final static Logger logger = LoggerFactory.getLogger(UsersServiceTest.class);

	@Autowired
	private BooksService booksService;

	@Autowired
	private WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getBookList() {
		// 開始ログを出力
		StartEndLogUtil.startLog(logger);

		// 想定戻り値を設定
		final BookInfo bookInfo = new BookInfo(1, "サンプル1", "サンプル1", "サンプル1", "11111111", null);

		// 実績戻り値を設定
		final List<BookInfo> bookInfoResultList = booksService.getBookList();
		assertThat(bookInfoResultList, hasItem(bookInfo));
		// 終了ログを出力
		StartEndLogUtil.endLog(logger);
	}

	@Test
	public void getBookInfo() {
		// 開始ログを出力
		StartEndLogUtil.startLog(logger);

		// 想定戻り値を設定
		final BookDetailsInfo bookInfo = new BookDetailsInfo(1, "サンプル1", "サンプル1", "サンプル1", "11111111", null, null, "12345678", "サンプル");

		// 実績戻り値を設定
		final BookDetailsInfo bookInfoResult = booksService.getBookInfo(1);

		// 想定戻り値と実績戻り値を評価する
		assertEquals(bookInfoResult, bookInfo);

		// 終了ログを出力
		StartEndLogUtil.endLog(logger);
	}

	@Test
	public void registBook () {
		
	}

	@Test
	public void deleteBook() {
		
	}

	@Test
	public void updateBook() {
		
	}
}