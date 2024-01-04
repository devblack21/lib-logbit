package io.github.devblack21.logging.enginer;

import io.github.devblack21.logging.configuration.LogBitConfiguration;
import io.github.devblack21.logging.record.LogBitRecord;

import java.util.logging.Level;

public class DefaultEngineLogBit extends AbstractEngineLogBit {

	public DefaultEngineLogBit(final LogBitConfiguration logBitConfiguration) {
        super(logBitConfiguration);
	}

	@Override
	public LogBitRecord info(final String logCode,
							 final String msg) {
		return info(logCode, msg, null);
	}

	@Override
	public LogBitRecord info(final String logCode,
							 final String msg,
							 final Object payload) {
		return log(Level.INFO, logCode, msg, payload, null);
	}

	@Override
	public LogBitRecord warning(final String logCode,
								final String msg,
								final Object payload,
								final Throwable throwable) {
		return log(Level.WARNING, logCode, msg, payload, throwable);
	}

	@Override
	public LogBitRecord warning(final String logCode,
								final String msg) {
		return warning(logCode, msg, null);
	}

	@Override
	public LogBitRecord warning(final String logCode,
								final String msg,
								final Object payload) {
		return log(Level.WARNING, logCode, msg, payload, null);
	}

	@Override
	public LogBitRecord error(final String logCode,
							  final String msg) {
		return error(logCode, msg, null, null);
	}

	@Override
	public LogBitRecord error(final String logCode,
							  final String msg,
							  final Throwable throwable) {
		return error(logCode, msg, null, throwable);
	}

	@Override
	public LogBitRecord error(final String logCode,
							  final String msg,
							  final Object payload,
							  final Throwable throwable) {
		return log(Level.SEVERE, logCode, msg, payload, throwable);
	}

	@Override
	public LogBitRecord debug(final String logCode,
							  final String msg) {
		return debug(logCode, msg, null);
	}

	@Override
	public LogBitRecord debug(final String logCode,
							  final String msg,
							  final Object payload,
							  final Throwable throwable) {
		return log(Level.ALL, logCode, msg, payload, throwable);
	}

	@Override
	public LogBitRecord debug(final String logCode,
							  final String msg,
							  final Object payload) {
		return debug(logCode, msg, payload, null);
	}

	@Override
	public LogBitRecord logInfoStart(final String logCode,
									 final String msg) {
		return logInfoStart(logCode, msg, null);
	}

	@Override
	public LogBitRecord logInfoStart(final String logCode,
									 final String msg,
									 final Object payload) {
		startTimer();
		return info(logCode, msg, payload);
	}

	@Override
	public LogBitRecord logWarningStart(final String logCode,
										final String msg) {
		return logWarningStart(logCode, msg, null);
	}

	@Override
	public LogBitRecord logWarningStart(final String logCode,
										final String msg,
										final Object payload) {
		startTimer();
		return logWarningStart(logCode, msg, payload, null);
	}

	@Override
	public LogBitRecord logWarningStart(final String logCode,
										final String msg,
										final Object payload,
										final Throwable throwable) {
		startTimer();
		return warning(logCode, msg, payload, throwable);
	}

	@Override
	public LogBitRecord logInfoFinish(final String logCode,
									  final String msg) {
		return logInfoFinish(logCode, msg, null);
	}

	@Override
	public LogBitRecord logInfoFinish(final String logCode,
									  final String msg,
									  final Object payload)  {
		stopTimer();
		return info(logCode, msg, payload);
	}

	@Override
	public LogBitRecord logWarningFinish(final String logCode,
										 final String msg) {
		return logWarningFinish(logCode, msg, null);
	}

	@Override
	public LogBitRecord logWarningFinish(final String logCode,
										 final String msg,
										 final Object payload)  {
		stopTimer();
		return logWarningFinish(logCode, msg, payload, null);
	}

	@Override
	public LogBitRecord logWarningFinish(final String logCode,
										 final String msg,
										 final Object payload,
										 final Throwable throwable)  {
		stopTimer();
		return warning(logCode, msg, payload, throwable);
	}
	
}