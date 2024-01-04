package br.com.devblack.logging.enginer;

import br.com.devblack.logging.configuration.LogBitConfiguration;
import br.com.devblack.logging.record.LogBitRecord;

import java.util.logging.Level;

public class EngineLogBit extends AbstractEngineLogBit {

	public EngineLogBit(final LogBitConfiguration logBitConfiguration) {
        super(logBitConfiguration);
	}

	public LogBitRecord info(final String logCode, final String msg, final Object payload) {
		return log(Level.INFO, logCode, msg, payload, null);
	}
	
	public LogBitRecord warning(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.WARNING, logCode, msg, payload, throwable);
	}
	
	public LogBitRecord warning(final String logCode, final String msg, final Object payload) {
		return log(Level.WARNING, logCode, msg, payload, null);
	}
	
	public LogBitRecord error(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.SEVERE, logCode, msg, payload, throwable);
	}
	
	public LogBitRecord debug(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		return log(Level.ALL, logCode, msg, payload, throwable);
	}
	
	public LogBitRecord debug(final String logCode, final String msg, final Object payload) {
		return debug(logCode, msg, payload, null);
	}
	
	public LogBitRecord logInfoStart(final String logCode, final String msg, final Object payload) {
		startTimer();
		return info(logCode, msg, payload);
	}
	
	public LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload) {
		startTimer();
		return logWarningStart(logCode, msg, payload, null);
	}
	
	public LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable) {
		startTimer();
		return warning(logCode, msg, payload, throwable);
	}
	
	public LogBitRecord logInfoFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return info(logCode, msg, payload);
	}
	
	public LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload)  {
		stopTimer();
		return logWarningFinish(logCode, msg, payload, null);
	}
	
	public LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable)  {
		stopTimer();
		return warning(logCode, msg, payload, throwable);
	}
	
}