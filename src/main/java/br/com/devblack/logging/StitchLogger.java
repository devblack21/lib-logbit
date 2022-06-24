package br.com.devblack.logging;

import br.com.devblack.logging.configuration.Configuration;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Logger.getLogger;

public class StitchLogger {
	
	private static final Map<Level, String> mapLevels = new HashMap<>();

	private static Configuration configuration = null;
	private static Instant start = null;
	private static long startNano = 0;
	private static Instant finish = null;
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
	
	public static void setCorrelationId(final String correlationId) {
		configuration.setCorrelationId(correlationId);
	}
	
	public static void setTransactionId(final String transactionId) {
		configuration.setTransactionId(transactionId);
	}
	
	private static void log(final Level level, final String logCode, final String message, final Object payload, final Throwable throwable) {
		StitchLogger.configuration.refresh();
		getLogger(logCode).log(createRecord(level, logCode, message, payload, throwable));
	}
	
	public static void info(final String logCode, final String msg, final Object payload) {
		log(Level.INFO, logCode, msg, payload, null);
	}
	
	public static void warning(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	public static void warning(final String logCode, final String msg, final Object payload) {
		log(Level.WARNING, logCode, msg, payload, null);
	}
	
	public static void error(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		log(Level.SEVERE, logCode, msg, payload, throwable);
	}
	
	public static void error(final String logCode, final String msg, final Object payload) {
		log(Level.SEVERE, logCode, msg, payload, null);
	}
	
	public static void debug(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		log(Level.ALL, logCode, msg, payload, throwable);
	}
	
	public static void debug(final String logCode, final String msg, final Object payload) {
		log(Level.ALL, logCode, msg, payload, null);
	}
	
	public static void logInfoStart(final String logCode, final String msg, final Object payload) {
		start = Instant.now();
		startNano = System.nanoTime();
		log(Level.INFO, logCode, msg, payload, null);
	}
	
	public static void logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		start = Instant.now();
		startNano = System.nanoTime();
		log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	public static void logInfoFinish(final String logCode, final String msg, final Object payload)  {
		startTime();
		log(Level.INFO, logCode, msg, payload, null);
	}
	
	public static void logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		stopTime();
		log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	private static void startTime() {
		finish = Instant.now();
		finishNano = System.nanoTime();
		execution = getTimeExecution();
	}
	
	private static void stopTime() {
		finish = Instant.now();
		finishNano = System.nanoTime();
		execution = getTimeExecution();
	}
	
	private static long getTimeExecution() {
		return finishNano - startNano;
	}
	
	private static LogRecord createRecord(final java.util.logging.Level level, final String logCode, final String message, final Object payload, final Throwable throwable) {
		final LogObject logObject = LogObject.init()
				.setLogCode(logCode)
				.setCorrelationId(configuration.getCorrelationId())
				.setTransationId(configuration.getTransactionId())
				.setMessage(message)
				.setSeverity(mapLevels.get(level))
				.setThreadId(String.valueOf(Thread.currentThread().getId()))
				.setPayload(payload)
				.setThrowable(throwable)
				.setTimeExecution(execution)
				.setCurrent(Instant.now())
				.setStart((Objects.nonNull(finish)) ? start : null)
				.setFinish(finish)
				.build();
		
		final LogRecord logRecord = new LogRecord(level, logCode);
		logRecord.setLoggerName(logCode);
		logRecord.setThreadID(Integer.parseInt(String.valueOf(Thread.currentThread().getId())));
		logRecord.setInstant(Instant.now());
		logRecord.setMessage(logObject.toString());
		if (configuration.isThrowable()) logRecord.setThrown(throwable);
		
		return logRecord;
	}
	
}