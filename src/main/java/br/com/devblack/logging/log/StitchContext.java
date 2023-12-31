package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import org.slf4j.MDC;

import java.time.ZonedDateTime;
import java.util.Objects;

public class StitchContext {
    public static final String APPLICATION_NAME = "applicationName";
    public static final String HOST_ADDRESS = "hostAddress";
    public static final String ORGANIZATION_NAME = "organizationName";
    public static final String CORRELATION_ID = "correlationId";
    public static final String TRANSACTION_ID = "transactionId";
    private static ZonedDateTime startDateTime = null;
    private static long startNano = 0;
    private static ZonedDateTime finishDateTime = null;
    private static long finishNano = 0;
    private static String correlationId = null;
    private static String transactionId = null;
    public StitchContext() {}

    public static long getExecutionDuration() {
        return finishNano - startNano;
    }

    public static boolean isFinish() {
        return Objects.nonNull(finishDateTime);
    }

    public static ZonedDateTime getStart() {
        return startDateTime;
    }

    public static ZonedDateTime getFinishDateTime() {
        return finishDateTime;
    }

    protected static void startTimer() {
        startDateTime = ZonedDateTime.now();
        startNano = System.nanoTime();
    }

    protected static void stopTimer() {
        finishDateTime = ZonedDateTime.now();
        finishNano = System.nanoTime();
    }

    public static void clearDurationTime() {
        if (Objects.nonNull(finishDateTime)) {
            finishDateTime = null;
            finishNano = 0;
            startDateTime = null;
            startNano = 0;
        }
    }

    public static void clear() {
        correlationId = null;
        transactionId = null;
        finishDateTime = null;
        finishNano = 0;
        startDateTime = null;
        startNano = 0;
    }

    public static String getCorrelationId() {
        return correlationId;
    }

    public static String getTransactionId() {
        return transactionId;
    }

    public static void setCorrelationId(final String value) {
        MDC.put(CORRELATION_ID, value);
        correlationId = value;
    }

    public static void setTransactionId(String value) {
        MDC.put(TRANSACTION_ID, value);
        transactionId = value;
    }

    public static void setConfigurationContext(final Configuration value) {
        MDC.put(APPLICATION_NAME, value.getApplicationName());
        MDC.put(ORGANIZATION_NAME, value.getOrganizationName());
        MDC.put(HOST_ADDRESS, value.getHostAddress());
    }
}
