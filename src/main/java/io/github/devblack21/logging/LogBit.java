package io.github.devblack21.logging;

import io.github.devblack21.logging.enginer.EngineLogBit;

import java.util.Objects;

public class LogBit {

	public static EngineLogBit logger;

	public static void configure(final EngineLogBit engineLogBit) {
		if (Objects.isNull(engineLogBit)) {
			throw new IllegalArgumentException("EngineLogBit value must not be null");
		}
		logger = engineLogBit;
	}

	public static void setCorrelation(final String value) {
		logger.setCorrelationId(value);
	}

	public static void setTransaction(final String value) {
		logger.setTransactionId(value);
	}

	public static void setFlowName(final String value) {
		logger.setFlowName(value);
	}

	public static void setSubCorrelationId(final String value) {
		logger.setSubCorrelationId(value);
	}

	public static void info(final String logCode,
							final String msg) {
		logger.info(logCode, msg);
	}

	public static void info(final String logCode,
							final String msg,
							final Object payload) {
		logger.info(logCode, msg, payload);
	}

	public static void warning(final String logCode,
							   final String msg,
							   final Throwable throwable) {
		logger.warning(logCode, msg, throwable);
	}

	public static void warning(final String logCode,
							   final String msg) {
		logger.warning(logCode, msg);
	}

	public static void warning(final String logCode,
							   final String msg,
							   final Object payload,
							   final Throwable throwable) {
		logger.warning(logCode, msg, payload, throwable);
	}
	
	public static void warning(final String logCode,
							   final String msg,
							   final Object payload) {
		logger.warning(logCode, msg, payload);
	}

	public static void error(final String logCode,
							 final String msg) {
		logger.error(logCode, msg);
	}

	public static void error(final String logCode,
							 final String msg,
							 final Throwable throwable) {
		logger.error(logCode, msg, throwable);
	}
	public static void error(final String logCode,
							 final String msg,
							 final Object payload,
							 final Throwable throwable) {
		logger.error(logCode, msg, payload, throwable);
	}

	public static void debug(final String logCode,
							 final String msg) {
		logger.debug(logCode, msg);
	}

	public static void debug(final String logCode,
							 final String msg,
							 final Throwable throwable) {
		logger.debug(logCode, msg, throwable);
	}
	public static void debug(final String logCode,
							 final String msg,
							 final Object payload,
							 final Throwable throwable) {
		logger.debug(logCode, msg, payload, throwable);
	}
	
	public static void debug(final String logCode,
							 final String msg,
							 final Object payload) {
		logger.debug(logCode, msg, payload);
	}

	public static void logInfoStart(final String logCode,
									final String msg) {
		logger.logInfoStart(logCode, msg);
	}

	public static void logInfoStart(final String logCode,
									final String msg,
									final Object payload) {
		logger.logInfoStart(logCode, msg, payload);
	}

	public static void logWarningStart(final String logCode,
									   final String msg) {
		logger.logWarningStart(logCode, msg);
	}
	
	public static void logWarningStart(final String logCode,
									   final String msg,
									   final Object payload) {
		logger.logWarningStart(logCode, msg, payload);
	}

	public static void logWarningStart(final String logCode,
									   final String msg,
									   final Throwable throwable) {
		logger.logWarningStart(logCode, msg, throwable);
	}
	
	public static void logWarningStart(final String logCode,
									   final String msg,
									   final Object payload,
									   final Throwable throwable) {
		logger.logWarningStart(logCode, msg, payload, throwable);
	}

	public static void logInfoFinish(final String logCode,
									 final String msg)  {
		logger.logInfoFinish(logCode, msg);
	}
	
	public static void logInfoFinish(final String logCode,
									 final String msg,
									 final Object payload)  {
		logger.logInfoFinish(logCode, msg, payload);
	}

	public static void logWarningFinish(final String logCode,
										final String msg)  {
		logger.logWarningFinish(logCode, msg);
	}

	public static void logWarningFinish(final String logCode,
										final String msg,
										final Throwable throwable)  {
		logger.logWarningFinish(logCode, msg, throwable);
	}

	public static void logWarningFinish(final String logCode,
										final String msg,
										final Object payload)  {
		logger.logWarningFinish(logCode, msg, payload);
	}
	
	public static void logWarningFinish(final String logCode,
										final String msg,
										final Object payload,
										final Throwable throwable)  {
		logger.logWarningFinish(logCode, msg, payload, throwable);
	}

}