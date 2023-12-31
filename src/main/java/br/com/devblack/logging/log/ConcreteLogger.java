package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.record.LogObject;

import java.util.logging.Level;

public class ConcreteLogger extends AbstractLogger {

	public ConcreteLogger(final Configuration configuration) {
        super(configuration);
	}

	public LogObject info(final String logCode, final String msg, final Object payload) {
		return log(Level.INFO, logCode, msg, payload, null);
	}
	
	public LogObject warning(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	public LogObject warning(final String logCode, final String msg, final Object payload) {
		return log(Level.WARNING, logCode, msg, payload, null);
	}
	
	public LogObject error(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.SEVERE, logCode, msg, payload, throwable);
	}
	
	public LogObject debug(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.ALL, logCode, msg, payload, throwable);
	}
	
	public LogObject debug(final String logCode, final String msg, final Object payload) {
		return debug(logCode, msg, payload, null);
	}
	
	public LogObject logInfoStart(final String logCode, final String msg, final Object payload) {
		startTimer();
		return info(logCode, msg, payload);
	}
	
	public LogObject logWarningStart(final String logCode, final String msg, final Object payload) {
		startTimer();
		return logWarningStart(logCode, msg, payload, null);
	}
	
	public LogObject logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		startTimer();
		return warning(logCode, msg, payload, throwable);
	}
	
	public LogObject logInfoFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return info(logCode, msg, payload);
	}
	
	public LogObject logWarningFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return logWarningFinish(logCode, msg, payload, null);
	}
	
	public LogObject logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		stopTimer();
		return warning(logCode, msg, payload, throwable);
	}

	
}