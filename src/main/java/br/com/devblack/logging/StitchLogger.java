package br.com.devblack.logging;

import br.com.devblack.logging.configuration.Configuration;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Logger.getLogger;

public class StitchLogger {
	
	private static final Map<Level, String> mapLevels = new HashMap<>();

	private static Configuration configuration = null;
	private static ZonedDateTime start = null;
	private static long startNano = 0;
	private static ZonedDateTime finish = null;
	private static long finishNano = 0;
	private static long execution = 0;
	
	static {
		mapLevels.put(Level.SEVERE, "ERROR");
		mapLevels.put(Level.ALL, "DEBUG");
		mapLevels.put(Level.INFO, "INFO");
		mapLevels.put(Level.WARNING, "WARNING");
	}
	
	private StitchLogger() {}
	
	public static void configure(final Configuration configuration) {
		StitchLogger.configuration = configuration;
	}
	
	public static void enableAutoCorrelation() {
		configuration.enableRandomCorrelation();
	}
	
	public static void enableAutoTransaction() {
		configuration.enableRandomTransaction();
	}
	
	public static void disableAutoCorrelation() {
		configuration.disableRandomCorrelation();
	}
	
	public static void disableAutoTransaction() {
		configuration.disableRandomTransaction();
	}
	
	public static void setCorrelationId(final String correlationId) {
		configuration.setCorrelationId(correlationId);
	}
	
	public static void setTransactionId(final String transactionId) {
		configuration.setTransactionId(transactionId);
	}
	
	private static LogObject log(final Level level, final String logCode, final String message, final Object payload, final Throwable throwable) {
		
		StitchLogger.configuration.refresh();
		
		final LogRecord logRecord = new LogRecord(level, logCode);
		final LogObject logObject = createObject(level, logCode, message, payload, throwable);
		
		logRecord.setLoggerName(logCode);
		logRecord.setThreadID(Integer.parseInt(String.valueOf(Thread.currentThread().getId())));
		logRecord.setInstant(Instant.now());
		logRecord.setMessage(logObject.toString());
		if (configuration.isThrowable()) logRecord.setThrown(throwable);
		getLogger(logCode).log(logRecord);
		
		if (Objects.nonNull(finish)) {
			cleanTime();
		}
		
		return logObject;
	}
	
	public static LogObject info(final String logCode, final String msg, final Object payload) {
		return log(Level.INFO, logCode, msg, payload, null);
	}
	
	public static LogObject warning(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	public static LogObject warning(final String logCode, final String msg, final Object payload) {
		return log(Level.WARNING, logCode, msg, payload, null);
	}
	
	public static LogObject error(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.SEVERE, logCode, msg, payload, throwable);
	}
	
	public static LogObject debug(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.ALL, logCode, msg, payload, throwable);
	}
	
	public static LogObject debug(final String logCode, final String msg, final Object payload) {
		return debug(logCode, msg, payload, null);
	}
	
	public static LogObject logInfoStart(final String logCode, final String msg, final Object payload) {
		startTime();
		return info(logCode, msg, payload);
	}
	
	public static LogObject logWarningStart(final String logCode, final String msg, final Object payload) {
		startTime();
		return logWarningStart(logCode, msg, payload, null);
	}
	
	public static LogObject logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		startTime();
		return warning(logCode, msg, payload, throwable);
	}
	
	public static LogObject logInfoFinish(final String logCode, final String msg, final Object payload)  {
		stopTime();
		return info(logCode, msg, payload);
	}
	
	public static LogObject logWarningFinish(final String logCode, final String msg, final Object payload)  {
		stopTime();
		return logWarningFinish(logCode, msg, payload, null);
	}
	
	public static LogObject logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		stopTime();
		return warning(logCode, msg, payload, throwable);
	}
	
	private static void startTime() {
		start = ZonedDateTime.now();
		startNano = System.nanoTime();
	}
	
	private static void stopTime() {
		finish = ZonedDateTime.now();
		finishNano = System.nanoTime();
		execution = getTimeExecution();
	}
	
	private static void cleanTime() {
			finish = null;
			finishNano = 0;
			execution = 0;
			start = null;
			startNano = 0;
	}
	
	private static long getTimeExecution() {
		return finishNano - startNano;
	}
	
	private static LogObject createObject(final java.util.logging.Level level, final String logCode, final String message, final Object payload, final Throwable throwable) {
		return LogObject.init()
				.setLogCode(logCode)
				.setCorrelationId(configuration.getCorrelationId())
				.setTransationId(configuration.getTransactionId())
				.setMessage(message)
				.setSeverity(mapLevels.get(level))
				.setThreadId(String.valueOf(Thread.currentThread().getId()))
				.setPayload(payload)
				.setThrowable(throwable)
				.setHost(configuration.getHostAddress())
				.setTimeExecution(execution)
				.setCurrent(ZonedDateTime.now())
				.setStart((Objects.nonNull(finish)) ? start : null)
				.setFinish(finish)
				.build();
	}
	
}