package br.com.devblack.logging.bitlogger;

import br.com.devblack.logging.configuration.Configuration;
import org.slf4j.MDC;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class LogContext {
    public static final String APPLICATION_NAME = "applicationName";
    public static final String HOST_ADDRESS = "hostAddress";
    public static final String ORGANIZATION_NAME = "organizationName";
    public static final String CORRELATION_ID = "correlationId";
    public static final String TRANSACTION_ID = "transactionId";
    private ZonedDateTime startDateTime = null;
    private long startNano = 0;
    private ZonedDateTime finishDateTime = null;
    private long finishNano = 0;
    private String correlationId = null;
    private String transactionId = null;
    public LogContext() {}

    public long getExecutionDuration() {
        return finishNano - startNano;
    }

    public boolean isFinish() {
        return Objects.nonNull(finishDateTime);
    }

    public ZonedDateTime getStart() {
        return startDateTime;
    }

    public ZonedDateTime getFinishDateTime() {
        return finishDateTime;
    }

    protected void startTimer() {
        startDateTime = ZonedDateTime.now();
        startNano = startDateTime.getNano();
    }

    protected void stopTimer() {
        finishDateTime = ZonedDateTime.now();
        finishNano = finishDateTime.getNano();
    }

    public void clearDurationTime() {
        if (Objects.nonNull(finishDateTime)) {
            finishDateTime = null;
            finishNano = 0;
            startDateTime = null;
            startNano = 0;
        }
    }

    public void clear() {
        correlationId = null;
        transactionId = null;
        finishDateTime = null;
        finishNano = 0;
        startDateTime = null;
        startNano = 0;
    }

    public String getCorrelationId() {
        return Optional.ofNullable(MDC.get(CORRELATION_ID))
                .orElse(correlationId);
    }

    public String getTransactionId() {
        return Optional.ofNullable(MDC.get(TRANSACTION_ID))
                .orElse(transactionId);
    }

    public void setCorrelationId(final String value) {
        MDC.put(CORRELATION_ID, value);
        correlationId = value;
    }

    public void setTransactionId(String value) {
        MDC.put(TRANSACTION_ID, value);
        transactionId = value;
    }

    public void setConfigurationContext(final Configuration value) {
        MDC.put(APPLICATION_NAME, value.getApplicationName());
        MDC.put(ORGANIZATION_NAME, value.getOrganizationName());
        MDC.put(HOST_ADDRESS, value.getHostAddress());
    }
}
