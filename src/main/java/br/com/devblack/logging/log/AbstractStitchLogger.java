package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.record.LogObject;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Logger.getLogger;

public abstract class AbstractStitchLogger {
    private static final Map<Level, String> mapLevels = new HashMap<>();
    private static Configuration configuration = null;

    static {
        mapLevels.put(Level.SEVERE, "ERROR");
        mapLevels.put(Level.ALL, "DEBUG");
        mapLevels.put(Level.INFO, "INFO");
        mapLevels.put(Level.WARNING, "WARNING");
    }

    static void setConfig(final Configuration value) {
        configuration = value;
        StitchContext.clear();
        StitchContext.setConfigurationContext(configuration);
    }
    protected static LogObject log(final Level level,
                                 final String logCode,
                                 final String message,
                                 final Object payload,
                                 final Throwable throwable) {

        final LogRecord logRecord = new LogRecord(level, logCode);

        final LogObject logObject = createObject(level, logCode, message, payload, throwable);

        logRecord.setLoggerName(logCode);
        logRecord.setThreadID(Integer.parseInt(String.valueOf(Thread.currentThread().getId())));
        logRecord.setInstant(Instant.now());
        logRecord.setMessage(logObject.toString());

        if (configuration.isThrowable()) {
            logRecord.setThrown(throwable);
        }

        getLogger(logCode).log(logRecord);

        StitchContext.clearDurationTime();

        return logObject;
    }


    private static LogObject createObject(final java.util.logging.Level level,
                                          final String logCode,
                                          final String message,
                                          final Object payload,
                                          final Throwable throwable) {
        return LogObject.init()
                .setLogCode(logCode)
                .setCorrelationId(getCorrelationId())
                .setTransationId(getTransactionId())
                .setMessage(message)
                .setSeverity(mapLevels.get(level))
                .setThreadId(String.valueOf(Thread.currentThread().getId()))
                .setPayload(payload)
                .setThrowable(throwable)
                .setHost(configuration.getHostAddress())
                .setTimeExecution(StitchContext.getExecutionDuration())
                .setCurrent(ZonedDateTime.now())
                .setStart(StitchContext.isFinish() ? StitchContext.getStart() : null)
                .setFinish(StitchContext.getFinishDateTime())
                .build();
    }

    static void startTimer() {
        StitchContext.startTimer();
    }
    static void stopTimer() {
        StitchContext.stopTimer();
    }
    public static void setCorrelationId(final String correlationId) {
        StitchContext.setCorrelationId(correlationId);
    }

    public static void setTransactionId(final String transactionId) {
        StitchContext.setTransactionId(transactionId);
    }

    public static String getCorrelationId() {

        final String correlationId = StitchContext.getCorrelationId();

        if (Objects.isNull(correlationId) && configuration.isCorrelationRandom()) {
            return UUID.randomUUID().toString();
        }

        return correlationId;
    }


    public static String getTransactionId() {

        final String transactionId = StitchContext.getTransactionId();

        if (Objects.isNull(transactionId) && configuration.isTransactionRandom()) {
            return UUID.randomUUID().toString();
        }

        return transactionId;
    }

}
