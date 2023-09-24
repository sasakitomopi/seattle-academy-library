package jp.co.seattle.library.commonutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jp.co.seattle.library.dto.BookDetailsInfo;

@Service
public class BookUtil {
	final static Logger logger = LoggerFactory.getLogger(BookUtil.class);
	private static final String REQUIRED_ERROR = "未入力の必須項目があります";
	private static final String ISBN_ERROR = "ISBNの桁数または半角数字が正しくありません";
	private static final String PUBLISHDATE_ERROR = "出版日は半角数字のYYYYMMDD形式で入力してください";
	private static final String ZENKAKU_ERROR = "入力項目は全角文字で入力してください";
	private static final String ZENKAKU_REGREX = "^[^ -~｡-ﾟ]+$";
	/**
	 * 登録前のバリデーションチェック
	 *
	 * @param bookInfo 書籍情報
	 * @return errorList エラーメッセージのリスト
	 */
	public List<String> checkBookInfo(BookDetailsInfo bookInfo) {
		List<String> errorList = new ArrayList<>();
		System.out.println(isEmptyBookInfo(bookInfo));
		// 必須チェック
		if (isEmptyBookInfo(bookInfo)) {
			errorList.add(REQUIRED_ERROR);
		}

		// 全角文字チェック
		if (!isZenkaku(bookInfo)) {
			errorList.add(ZENKAKU_ERROR);
		}

		String isbn = String.valueOf(bookInfo.getIsbn());
		// ISBNのバリデーションチェック
		if (!isbn.isEmpty() && !isValidIsbn(isbn)) {
			errorList.add(ISBN_ERROR);
		}

		// 出版日の形式チェック
		if (!checkDate(bookInfo.getPublishDate())) {
			errorList.add(PUBLISHDATE_ERROR);
		}

		return errorList;
	}

	/**
	 * 日付の形式が正しいかどうか
	 * 
	 * @param publishDate
	 * @return
	 */
	private static boolean checkDate(String publishDate) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			formatter.setLenient(false); // ←これで厳密にチェックしてくれるようになる
			String parseDate = formatter.format(formatter.parse(publishDate));
			return publishDate.equals(parseDate);
		} catch (ParseException p) {
			p.printStackTrace();
			return false;
		}
	}

	/**
	 * ISBNの形式チェック
	 * 
	 * @param isbn
	 * @return ISBNが半角数字で10文字か13文字かどうか
	 */
	private static boolean isValidIsbn(String isbn) {
		boolean result = isbn.matches("[0-9]{10}|[0-9]{13}");
		return result;
	}

	/**
	 * 必須項目の存在チェック
	 * 
	 * @param bookInfo
	 * @return タイトル、著者、出版社、出版日のどれか一つでもなかったらtrue
	 */
	private static boolean isEmptyBookInfo(BookDetailsInfo bookInfo) {
		boolean result = bookInfo.getTitle().isEmpty() || bookInfo.getAuthor().isEmpty()
				|| bookInfo.getPublisher().isEmpty() || bookInfo.getPublishDate().isEmpty();
		return result;
	}

	/**
	 * 必須項目の全角文字チェック
	 * 
	 * @param bookInfo
	 * @return タイトル、著者、出版社のどれか一つでもなかったらfalse
	 */
	private static boolean isZenkaku(BookDetailsInfo bookInfo) {
		boolean result = bookInfo.getTitle().matches(ZENKAKU_REGREX) && bookInfo.getAuthor().matches(ZENKAKU_REGREX)
			&& bookInfo.getPublisher().matches(ZENKAKU_REGREX); 
		return result;
	}
}