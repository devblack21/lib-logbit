package io.github.devblack21.logging.enginer;

import io.github.devblack21.logging.record.LogBitRecord;

public interface EngineLogBit {

    void startTimer();
    void stopTimer();
    void setCorrelationId(final String correlationId);
    void setSubCorrelationId(final String subCorrelationId);
    void setTransactionId(final String transactionId);
    void setFlowName(final String flowName);
    LogBitRecord info(final String logCode, final String msg);
    LogBitRecord info(final String logCode, final String msg, final Object payload);
    LogBitRecord warning(final String logCode, final String msg, final Object payload, final Throwable throwable);
    LogBitRecord warning(final String logCode, final String msg);
    LogBitRecord warning(final String logCode, final String msg, final Object payload);
    LogBitRecord error(final String logCode, final String msg);
    LogBitRecord error(final String logCode, final String msg, final Throwable throwable);
    LogBitRecord error(final String logCode, final String msg, final Object payload, final Throwable throwable);
    LogBitRecord debug(final String logCode, final String msg);
    LogBitRecord debug(final String logCode, final String msg, final Object payload, final Throwable throwable);
    LogBitRecord debug(final String logCode, final String msg, final Object payload);
    LogBitRecord logInfoStart(final String logCode, final String msg);
    LogBitRecord logInfoStart(final String logCode, final String msg, final Object payload);
    LogBitRecord logWarningStart(final String logCode, final String msg);
    LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload);
    LogBitRecord logWarningStart(final String logCode, final String msg, final Object payload, final Throwable throwable);
    LogBitRecord logInfoFinish(final String logCode, final String msg);
    LogBitRecord logInfoFinish(final String logCode, final String msg, final Object payload);
    LogBitRecord logWarningFinish(final String logCode, final String msg);
    LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload);
    LogBitRecord logWarningFinish(final String logCode, final String msg, final Object payload, final Throwable throwable);

}
