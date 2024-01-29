package jp.co.seattle.library.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jp.co.seattle.library.dto.UserInfo;
@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {
	/** メールアドレス */
	private static final String EMAIL = "tomohiro.sasaki+01@metateam.co.jp";
	/** パスワード */
	private static final String PASSWORD = "PassWord$99";
	// SQL生成
	private static final String INSERT_SQL = "INSERT INTO users (email, password,reg_date,upd_date) VALUES ('" + EMAIL + "','"
			+ PASSWORD + "',now(),now()" + ")";
	@Mock
	private JdbcTemplate jdbcTemplate;
	@InjectMocks
	private UsersService userService;
	@Before
	public void setup() {
	}
	@Test
	public void selectUserInfo() {
		final String sql = "SELECT email, password FROM users WHERE email = '" + EMAIL + "' AND password = '" + PASSWORD
				+ "'";
		final UserInfo userInfo = new UserInfo(1,EMAIL, PASSWORD, null);
		System.out.println("Test Start");
	    // モックの戻り値を設定する
	    when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class))).thenReturn(userInfo);
		UserInfo userInfoResult = this.userService.selectUserInfo(EMAIL, PASSWORD);
		System.out.println(userInfoResult);
		assertEquals(userInfo, userInfoResult);
		System.out.println("Test End");
	}
	@Test
	public void registUser() {
	}
}