package io.github.devblack21.logging.enginer;

import org.slf4j.MDC;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

public class LogContext {

    public static final String APPLICATION_NAME = "applicationName";
    public static final String HOST_ADDRESS = "hostAddress";
    public static final String ORGANIZATION_NAME = "organizationName";
    public static final String CORRELATION_ID = "correlationId";
    public static final String SUB_CORRELATION_ID = "subCorrelationId";
    public static final String TRANSACTION_ID = "transactionId";
    private ZonedDateTime startDateTime = null;
    private long startNano = 0;
    private ZonedDateTime finishDateTime = null;
    private long finishNano = 0;
    private String correlationId = null;
    private String subCorrelationId = null;
    private String transactionId = null;

    private String flowName = null;

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
        MDC.remove(CORRELATION_ID);
        subCorrelationId = null;
        MDC.remove(SUB_CORRELATION_ID);
        transactionId = null;
        MDC.remove(TRANSACTION_ID);
        finishDateTime = null;
        finishNano = 0;
        startDateTime = null;
        startNano = 0;
        MDC.remove(ORGANIZATION_NAME);
        MDC.remove(APPLICATION_NAME);
        MDC.remove(HOST_ADDRESS);
    }

    public String getCorrelationId() {
        return Optional.ofNullable(MDC.get(CORRELATION_ID))
                .orElse(correlationId);
    }

    public String getTransactionId() {
        return Optional.ofNullable(MDC.get(TRANSACTION_ID))
                .orElse(transactionId);
    }

    public String getSubCorrelationId() {
        return Optional.ofNullable(MDC.get(SUB_CORRELATION_ID))
                .orElse(subCorrelationId);
    }

    public String getFlowName() {
        return flowName;
    }


    public void setCorrelationId(final String value) {
        MDC.put(CORRELATION_ID, value);
        correlationId = value;
    }

    public void setSubCorrelationId(final String value) {
        MDC.put(SUB_CORRELATION_ID, value);
        subCorrelationId = value;
    }


    public void setTransactionId(String value) {
        MDC.put(TRANSACTION_ID, value);
        transactionId = value;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public void setApplicationName(final String value) {
        MDC.put(APPLICATION_NAME, value);
    }

    public void setOrganizationName(final String value) {
        MDC.put(ORGANIZATION_NAME, value);
    }

    public void setHostAddress(final String value) {
        MDC.put(HOST_ADDRESS, value);
    }

}
