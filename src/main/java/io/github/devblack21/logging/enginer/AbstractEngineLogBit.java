package io.github.devblack21.logging.enginer;

import io.github.devblack21.logging.configuration.LogBitConfiguration;
import io.github.devblack21.logging.record.LogBitRecord;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import static java.util.logging.Logger.getLogger;

public abstract class AbstractEngineLogBit implements EngineLogBit {

    private static final Map<Level, String> mapLevels = new HashMap<>();
    private static LogBitConfiguration logBitConfiguration = null;
    private static final LogContext logContext = new LogContext();

    static {
        mapLevels.put(Level.SEVERE, "ERROR");
        mapLevels.put(Level.ALL, "DEBUG");
        mapLevels.put(Level.INFO, "INFO");
        mapLevels.put(Level.WARNING, "WARNING");
    }

    AbstractEngineLogBit(final LogBitConfiguration value) {
        if (Objects.isNull(value)){
            throw new IllegalArgumentException("LogBitConfiguration value must not be null");
        }
        logBitConfiguration = value;
        logContext.clear();
        logContext.setApplicationName(logBitConfiguration.getApplicationName());
        logContext.setOrganizationName(logBitConfiguration.getOrganizationName());
        logContext.setHostAddress(logBitConfiguration.getHostAddress());
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
                .setSubCorrelationId(logContext.getSubCorrelationId())
                .setTransationId(getTransactionId())
                .setMessage(message)
                .setFlowName(logContext.getFlowName())
                .setApplicationName(logBitConfiguration.getApplicationName())
                .setOrganizationName(logBitConfiguration.getOrganizationName())
                .setWorkloadName(logBitConfiguration.getWorkflowName())
                .setSeverity(mapLevels.get(level))
                .setThreadId(String.valueOf(Thread.currentThread().getId()))
                .setPayload(payload)
                .setThrowable(throwable)
                .setHost(logBitConfiguration.getHostAddress())
                .setTimeExecution(logContext.getExecutionDuration())
                .setCurrent(ZonedDateTime.now())
                .setStart(logContext.isFinish() ? logContext.getStart() : null)
                .setFinish(logContext.getFinishDateTime())
                .build();
    }

    public void startTimer() {
        logContext.startTimer();
    }

    public void stopTimer() {
        logContext.stopTimer();
    }

    @Override
    public void setCorrelationId(final String correlationId) {
        logContext.setCorrelationId(correlationId);
    }

    @Override
    public void setTransactionId(final String transactionId) {
        logContext.setTransactionId(transactionId);
    }

    @Override
    public void setSubCorrelationId(String subCorrelationId) {
        logContext.setSubCorrelationId(subCorrelationId);
    }

    @Override
    public void setFlowName(final String flowName) {
        logContext.setFlowName(flowName);
    }

    public static String getCorrelationId() {

        final String correlationId = logContext.getCorrelationId();

        if (Objects.isNull(correlationId) && logBitConfiguration.isCorrelationRandom()) {
            return UUID.randomUUID().toString();
        }

        return correlationId;
    }

    public static String getTransactionId() {

        final String transactionId = logContext.getTransactionId();

        if (Objects.isNull(transactionId) && logBitConfiguration.isTransactionRandom()) {
            return UUID.randomUUID().toString();
        }

        return transactionId;
    }

}
