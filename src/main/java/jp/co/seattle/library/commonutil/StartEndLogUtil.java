package jp.co.seattle.library.commonutil;

import org.slf4j.Logger;

public class StartEndLogUtil {

	/**
	 * 開始MSGを出力する
	 * 
	 * @param logger ロガー
	 * @param methodName メソッド名
	 */
	public static void startLog(final Logger logger) {
		final StringBuilder startMsg = new StringBuilder();
		startMsg.append("START: ");
		startMsg.append(Thread.currentThread().getStackTrace()[2].getMethodName());
		logger.info(startMsg.toString());
	}

	/**
	 * 終了MSGを出力する
	 * 
	 * @param logger ロガー
	 * @param methodName メソッド名
	 */
	public static void endLog(final Logger logger) {
		final StringBuilder endMsg = new StringBuilder();
		endMsg.append("END:");
		endMsg.append(Thread.currentThread().getStackTrace()[2].getMethodName());
		logger.info(endMsg.toString());
	}
}