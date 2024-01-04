package br.com.devblack.logging.bitlogger;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.record.LogBitRecord;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Logger.getLogger;

public abstract class AbstractEngineBitLogger {

    private static final Map<Level, String> mapLevels = new HashMap<>();
    private static Configuration configuration = null;
    private static final LogContext logContext = new LogContext();

    static {
        mapLevels.put(Level.SEVERE, "ERROR");
        mapLevels.put(Level.ALL, "DEBUG");
        mapLevels.put(Level.INFO, "INFO");
        mapLevels.put(Level.WARNING, "WARNING");
    }

    AbstractEngineBitLogger(final Configuration value) {
        if (Objects.isNull(value)){
            throw new IllegalArgumentException("Configuration value must not be null");
        }
        configuration = value;
        logContext.clear();
        logContext.setConfigurationContext(configuration);
    }
    protected static LogBitRecord log(final Level level,
                                      final String logCode,
                                      final String message,
                                      final Object payload,
                                      final Throwable throwable) {

        final LogRecord logRecord = new LogRecord(level, logCode);

        final LogBitRecord logBitRecord = createObject(level, logCode, message, payload, throwable);

        logRecord.setLoggerName(logCode);
        logRecord.setThreadID(Integer.parseInt(String.valueOf(Thread.currentThread().getId())));
        logRecord.setInstant(Instant.now());
        logRecord.setMessage(logBitRecord.json());

        if (configuration.isThrowable()) {
            logRecord.setThrown(throwable);
        }

        getLogger(logCode).log(logRecord);

        logContext.clearDurationTime();

        return logBitRecord;
    }


    private static LogBitRecord createObject(final java.util.logging.Level level,
                                             final String logCode,
                                             final String message,
                                             final Object payload,
                                             final Throwable throwable) {
        return LogBitRecord.init()
                .setLogCode(logCode)
                .setCorrelationId(getCorrelationId())
                .setTransationId(getTransactionId())
                .setMessage(message)
                .setSeverity(mapLevels.get(level))
                .setThreadId(String.valueOf(Thread.currentThread().getId()))
                .setPayload(payload)
                .setThrowable(throwable)
                .setHost(configuration.getHostAddress())
                .setTimeExecution(logContext.getExecutionDuration())
                .setCurrent(ZonedDateTime.now())
                .setStart(logContext.isFinish() ? logContext.getStart() : null)
                .setFinish(logContext.getFinishDateTime())
                .build();
    }

    void startTimer() {
        logContext.startTimer();
    }

    void stopTimer() {
        logContext.stopTimer();
    }

    public void setCorrelationId(final String correlationId) {
        logContext.setCorrelationId(correlationId);
    }


    public void setTransactionId(final String transactionId) {
        logContext.setTransactionId(transactionId);
    }

    public static String getCorrelationId() {

        final String correlationId = logContext.getCorrelationId();

        if (Objects.isNull(correlationId) && configuration.isCorrelationRandom()) {
            return UUID.randomUUID().toString();
        }

        return correlationId;
    }

    public static String getTransactionId() {

        final String transactionId = logContext.getTransactionId();

        if (Objects.isNull(transactionId) && configuration.isTransactionRandom()) {
            return UUID.randomUUID().toString();
        }

        return transactionId;
    }

    public abstract LogBitRecord info(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord warning(final String logCode, final String msg, final Object payload, final Throwable throwable);

    public abstract LogBitRecord warning(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord error(final String logCode, final String msg, final Object payload, final Throwable throwable);

    public abstract LogBitRecord debug(final String logCode, final String msg, final Object payload, final Throwable throwable);

    public abstract LogBitRecord debug(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord logInfoStart(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable);

    public abstract LogBitRecord logInfoFinish(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload);

    public abstract LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable);

}
