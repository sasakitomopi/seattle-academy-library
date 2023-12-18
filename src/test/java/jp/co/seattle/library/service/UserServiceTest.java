package jp.co.seattle.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.seattle.library.dto.UserInfo;
import jp.co.seattle.library.rowMapper.UserCountRowMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	/** メールアドレス */
	private static final String EMAIL = "test@example.com";

	/** パスワード */
	private static final String PASSWORD = "1234567890";


	/** 取得用SQL */
	private static final String SELECT_SQL = "SELECT email, password FROM users WHERE email = '" + EMAIL + "' AND password = '" + PASSWORD
			+ "'";

	// SQL生成
	private static final String INSERT_SQL = "INSERT INTO users (email, password,reg_date,upd_date) VALUES ('" + EMAIL + "','"
			+ PASSWORD + "',now(),now()" + ")";

	/** ユーザー情報 */
	private UserInfo userInfo;

	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private UsersService userService;

	@Before
	private void setup() {
		this.userInfo = new UserInfo(0, EMAIL, PASSWORD, null);
	}

	@Test
	private void selectUserInfo() {
		System.out.println("Test Start");

		when(this.jdbcTemplate.queryForObject(SELECT_SQL, new UserCountRowMapper()));

		UserInfo userInfo = this.userService.selectUserInfo(EMAIL, PASSWORD);
		assertEquals(userInfo, this.userInfo);

		System.out.println("Test End");
	}

	@Test
	private void registUser() {
		this.userService.registUser(userInfo);
	}
}
