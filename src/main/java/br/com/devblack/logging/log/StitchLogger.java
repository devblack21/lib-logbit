package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.record.LogObject;

import java.util.Objects;
import java.util.logging.Level;

public class StitchLogger extends AbstractStitchLogger {

	public static void configure(final Configuration configuration) {
		if (Objects.isNull(configuration)){
			throw new IllegalArgumentException("");
		}
		setConfig(configuration);
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
		startTimer();
		return info(logCode, msg, payload);
	}
	
	public static LogObject logWarningStart(final String logCode, final String msg, final Object payload) {
		startTimer();
		return logWarningStart(logCode, msg, payload, null);
	}
	
	public static LogObject logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		startTimer();
		return warning(logCode, msg, payload, throwable);
	}
	
	public static LogObject logInfoFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return info(logCode, msg, payload);
	}
	
	public static LogObject logWarningFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return logWarningFinish(logCode, msg, payload, null);
	}
	
	public static LogObject logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		stopTimer();
		return warning(logCode, msg, payload, throwable);
	}

	
}