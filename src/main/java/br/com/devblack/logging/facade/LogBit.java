package br.com.devblack.logging.facade;

import br.com.devblack.logging.enginer.AbstractEngineLogBit;

public class LogBit {

	public static AbstractEngineLogBit logger;

	public static void configure(final AbstractEngineLogBit engineBitLogger) {
		logger = engineBitLogger;
	}

	public static void setCorrelation(final String value) {
		logger.setCorrelationId(value);
	}
	public static void setTransaction(final String value) {
		logger.setTransactionId(value);
	}
	
	public static void info(final String logCode, final String msg, final Object payload) {
		logger.info(logCode, msg, payload);
	}
	
	public static void warning(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		logger.warning(logCode, msg, payload, throwable);
	}
	
	public static void warning(final String logCode, final String msg, final Object payload) {
		logger.warning(logCode, msg, payload, null);
	}
	
	public static void error(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		logger.error(logCode, msg, payload, throwable);
	}
	
	public static void debug(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		logger.debug(logCode, msg, payload, throwable);
	}
	
	public static void debug(final String logCode, final String msg, final Object payload) {
		logger.debug(logCode, msg, payload, null);
	}
	
	public static void logInfoStart(final String logCode, final String msg, final Object payload) {
		logger.logInfoStart(logCode, msg, payload);
	}
	
	public static void logWarningStart(final String logCode, final String msg, final Object payload) {
		logger.logWarningStart(logCode, msg, payload, null);
	}
	
	public static void logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		logger.logWarningStart(logCode, msg, payload, throwable);
	}
	
	public static void logInfoFinish(final String logCode, final String msg, final Object payload)  {
		logger.logInfoFinish(logCode, msg, payload);
	}
	
	public static void logWarningFinish(final String logCode, final String msg, final Object payload)  {
		logger.logWarningFinish(logCode, msg, payload, null);
	}
	
	public static void logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		logger.logWarningFinish(logCode, msg, payload, throwable);
	}

}