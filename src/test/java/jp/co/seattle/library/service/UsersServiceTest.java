package jp.co.seattle.library.service;

import static org.junit.Assert.assertEquals;

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
import jp.co.seattle.library.dto.UserInfo;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class UsersServiceTest {

	/** ログ */
	final static Logger logger = LoggerFactory.getLogger(UsersServiceTest.class);

	/** メールアドレス */
	private static final String EMAIL = "test-address+01@metateam.co.jp";

	/** パスワード */
	private static final String PASSWORD = "PassWord$99";

	@Autowired
	private UsersService userService;

	@Autowired
	private WebApplicationContext wac;

	MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void selectUserInfo() {

		// 開始ログを出力
		StartEndLogUtil.startLog(logger);

	    // 想定戻り値を設定
		final UserInfo userInfo = new UserInfo(0 ,EMAIL, PASSWORD, null);

	    // 実績戻り値を設定
		final UserInfo userInfoResult = userService.selectUserInfo(EMAIL, PASSWORD);

		// 想定戻り値と実績戻り値を評価する
		assertEquals(userInfo, userInfoResult);

		// 終了ログを出力
		StartEndLogUtil.endLog(logger);
	}

// 	ユーザー情報を登録する場合のみコメントアウトを外す
//	@Test
//	public void registUser() {
//		// 開始ログを出力
//		StartEndLogUtil.startLog(logger);
//
//		// 登録処理を実行
//		final UserInfo userInfo = new UserInfo(0 ,EMAIL, PASSWORD, null);
//		userService.registUser(userInfo);
//
//		// 終了ログを出力
//		StartEndLogUtil.endLog(logger);
//	}
}