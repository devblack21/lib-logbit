package io.github.devblack21.logging.enginer;

import io.github.devblack21.logging.configuration.LogBitConfiguration;
import io.github.devblack21.logging.record.LogBitRecord;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EngineBitLoggerTest {

	@Test
	public void shouldExceptionNotConfigurationLog() {
		final RuntimeException runtimeException = new RuntimeException();
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(null);
			concreteLogger.error("","", null, runtimeException);
		});
		assertThat(exception, notNullValue());
	}
	
	@Test
	public void shouldConfigureLog() {
	
		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration("testing", "stitch", "workflow");

		assertThat(logBitConfiguration.getApplicationName(), is("testing"));
		assertThat(logBitConfiguration.getOrganizationName(), is("stitch"));
		assertThat(logBitConfiguration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));

		assertThatCode(() -> {

			concreteLogger.setFlowName("flowTesting");
			final LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, null);
			concreteLogger.setFlowName(null);

			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFlowName(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfo\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"flowName\":\"flowTesting\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\"shouldLogInfo\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
		}).doesNotThrowAnyException();

	}
	
	@Test
	public void shouldLogInfoWithPayload() {
		
		final String nameMethod = "shouldLogInfoWithPayload";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));

		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfoWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStartWithPayload() {
		
		final String nameMethod = "shouldLogInfoStartWithPayload";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));

		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfoStartWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStart() {
		
		final String nameMethod = "shouldLogInfoStart";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.logInfoStart("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfoStart\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinish() {
		
		final String nameMethod = "shouldLogInfoFinish";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, null);
			final LogBitRecord logBitRecord = concreteLogger.logInfoFinish("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), notNullValue());
			assertThat(logBitRecord.getStart(), notNullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), notNullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfoFinish\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"start\":\""+ logBitRecord.getStart()+"\",\"finish\":\""+ logBitRecord.getFinish()+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"timeExecution\":\""+ logBitRecord.getTimeExecution()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinishWithPayload() {
		
		final String nameMethod = "shouldLogInfoFinishWithPayload";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogBitRecord logBitRecord = concreteLogger.logInfoFinish("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), notNullValue());
			assertThat(logBitRecord.getStart(), notNullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), notNullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogInfoFinishWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"start\":\""+ logBitRecord.getStart()+"\",\"finish\":\""+ logBitRecord.getFinish()+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"timeExecution\":\""+ logBitRecord.getTimeExecution()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}

	
	@Test
	public void shouldConfigureDisableCorrelationAndTransactinLog() {
		
		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration("shouldConfigureDisableCorrelationAndTransactinLog", "stitch", "workflow");

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(logBitConfiguration);
		
		assertThatCode(() -> concreteLogger.info("TESTING", "shouldConfigureDisableCorrelationAndTransactinLog", Map.of("key", "value"))).doesNotThrowAnyException();

		assertThat(logBitConfiguration.getApplicationName(), is("shouldConfigureDisableCorrelationAndTransactinLog"));
		assertThat(logBitConfiguration.getOrganizationName(), is("stitch"));
		assertThat(logBitConfiguration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogWarning() {
		
		final String nameMethod = "shouldLogWarning";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {

			final LogBitRecord logBitRecord = concreteLogger.warning("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWarning\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningWithPayload() {
		
		final String nameMethod = "shouldLogWarningWithPayload";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.warning("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());

			final String json = "{\"applicationName\":\"shouldLogWarningWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStartWithPayload() {
		
		final String nameMethod = "shouldLogWarningStartWithPayload";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.logWarningStart("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWarningStartWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStart() {
		
		final String nameMethod = "shouldLogWarningStart";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.logWarningStart("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWarningStart\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinish() {
		
		final String nameMethod = "shouldLogWarningFinish";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, null);
			final LogBitRecord logBitRecord = concreteLogger.logWarningFinish("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), notNullValue());
			assertThat(logBitRecord.getStart(), notNullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), notNullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWarningFinish\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"start\":\""+ logBitRecord.getStart()+"\",\"finish\":\""+ logBitRecord.getFinish()+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"timeExecution\":\""+ logBitRecord.getTimeExecution()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinishWithPayload() {
		
		final String nameMethod = "shouldLogWarningFinishWithPayload";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogBitRecord logBitRecord = concreteLogger.logWarningFinish("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("WARNING"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), notNullValue());
			assertThat(logBitRecord.getStart(), notNullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), notNullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWarningFinishWithPayload\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"start\":\""+ logBitRecord.getStart()+"\",\"finish\":\""+ logBitRecord.getFinish()+"\",\"current\":\""+ logBitRecord.getCurrent()+"\",\"timeExecution\":\""+ logBitRecord.getTimeExecution()+"\",\"severity\":\"WARNING\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogError() {
		
		final String nameMethod = "shouldLogError";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.error("TESTING", nameMethod, null, new RuntimeException("erro"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("ERROR"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());

		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogErrorWithPayload() {
		
		final String nameMethod = "shouldLogErrorWithPayload";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.error("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("ERROR"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogDebug() {
		
		final String nameMethod = "shouldLogDebug";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.debug("TESTING", nameMethod, null, new RuntimeException("erro"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("DEBUG"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogDebugWithPayload() {
		
		final String nameMethod = "shouldLogDebugWithPayload";
		
		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.debug("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("DEBUG"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWhenInsertCorrelationAndTransaction() {

		final String nameMethod = "shouldLogWhenInsertCorrelationAndTransaction";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));

			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWhenInsertCorrelationAndTransaction\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));

			concreteLogger.setCorrelationId(UUID.randomUUID().toString());
			concreteLogger.setTransactionId(UUID.randomUUID().toString());

			final LogBitRecord logBitRecord2 = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));

			assertThat(logBitRecord2, notNullValue());
			assertThat(logBitRecord2.getMessage(), is(nameMethod));
			assertThat(logBitRecord2.getLogCode(), is("TESTING"));
			assertThat(logBitRecord2.getSeverity(), is("INFO"));
			assertThat(logBitRecord2.getThreadId(), notNullValue());
			assertThat(logBitRecord2.getHost(), notNullValue());
			assertThat(logBitRecord2.getPayload(), notNullValue());
			assertThat(logBitRecord2.getFinish(), nullValue());
			assertThat(logBitRecord2.getStart(), nullValue());
			assertThat(logBitRecord2.getCurrent(), notNullValue());
			assertThat(logBitRecord2.getCorrelationId(), notNullValue());
			assertThat(logBitRecord2.getTransactionId(), notNullValue());
			assertThat(logBitRecord2.getTimeExecution(), nullValue());
			assertThat(logBitRecord2.getThrowable(), nullValue());

			final String jsonInserted = "{\"applicationName\":\"shouldLogWhenInsertCorrelationAndTransaction\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"correlationId\":\""+ logBitRecord2.getCorrelationId()+"\",\"transactionId\":\""+ logBitRecord2.getTransactionId()+"\",\"threadId\":\""+ logBitRecord2.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord2.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord2.getHost()+"\"}";
			assertThat(logBitRecord2.json(), is(jsonInserted));
			
		}).doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWhenInsertCorrelationAndSubCorrelationId() {

		final String nameMethod = "shouldLogWhenInsertCorrelationAndSubCorrelationId";

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(new LogBitConfiguration(nameMethod, "testing", "workflow"));
		assertThatCode(() -> {
			LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));

			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), notNullValue());
			assertThat(logBitRecord.getPayload(), notNullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			final String json = "{\"applicationName\":\"shouldLogWhenInsertCorrelationAndSubCorrelationId\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"threadId\":\""+ logBitRecord.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord.getHost()+"\"}";
			assertThat(logBitRecord.json(), is(json));

			concreteLogger.setCorrelationId(UUID.randomUUID().toString());
			concreteLogger.setSubCorrelationId(UUID.randomUUID().toString());
			concreteLogger.setTransactionId(UUID.randomUUID().toString());

			final LogBitRecord logBitRecord2 = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));



			assertThat(logBitRecord2, notNullValue());
			assertThat(logBitRecord2.getMessage(), is(nameMethod));
			assertThat(logBitRecord2.getLogCode(), is("TESTING"));
			assertThat(logBitRecord2.getSeverity(), is("INFO"));
			assertThat(logBitRecord2.getThreadId(), notNullValue());
			assertThat(logBitRecord2.getHost(), notNullValue());
			assertThat(logBitRecord2.getPayload(), notNullValue());
			assertThat(logBitRecord2.getFinish(), nullValue());
			assertThat(logBitRecord2.getStart(), nullValue());
			assertThat(logBitRecord2.getCurrent(), notNullValue());
			assertThat(logBitRecord2.getCorrelationId(), notNullValue());
			assertThat(logBitRecord2.getSubCorrelationId(), notNullValue());
			assertThat(logBitRecord2.getTransactionId(), notNullValue());
			assertThat(logBitRecord2.getTimeExecution(), nullValue());
			assertThat(logBitRecord2.getThrowable(), nullValue());

			final String jsonInserted = "{\"applicationName\":\"shouldLogWhenInsertCorrelationAndSubCorrelationId\",\"organizationName\":\"testing\",\"workloadName\":\"workflow\",\"correlationId\":\""+ logBitRecord2.getCorrelationId()+"\",\"subCorrelationId\":\""+ logBitRecord2.getSubCorrelationId()+"\",\"transactionId\":\""+ logBitRecord2.getTransactionId()+"\",\"threadId\":\""+ logBitRecord2.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+ logBitRecord2.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+ logBitRecord2.getHost()+"\"}";
			assertThat(logBitRecord2.json(), is(jsonInserted));

		}).doesNotThrowAnyException();
	}
	
	
	@Test
	public void shouldConfigureInsertHostAddress() {
		
		final String nameMethod = "shouldConfigureInsertHostAddress";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", "168.192.152.1", "workflow");

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(logBitConfiguration);

		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, null);
			
			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), is("168.192.152.1"));
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());
			
		}).doesNotThrowAnyException();
	}

	@Test
	public void shouldConfigureRandomCorrelationIdAndTransactionId() {

		final String nameMethod = "shouldConfigureRandomCorrelationIdAndTransactionId";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", "168.192.152.1", "workflow");

		logBitConfiguration.enableRandomCorrelation();
		logBitConfiguration.enableRandomTransaction();

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(logBitConfiguration);

		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, null);

			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), is("168.192.152.1"));
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), notNullValue());
			assertThat(logBitRecord.getTransactionId(), notNullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());

		}).doesNotThrowAnyException();
	}

	@Test
	public void shouldConfigureNotRandomCorrelationIdAndTransactionId() {

		final String nameMethod = "shouldConfigureRandomCorrelationIdAndTransactionId";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", "168.192.152.1", "workflow");

		logBitConfiguration.disableRandomCorrelation();
		logBitConfiguration.disableRandomTransaction();

		final DefaultEngineLogBit concreteLogger = new DefaultEngineLogBit(logBitConfiguration);

		assertThatCode(() -> {
			final LogBitRecord logBitRecord = concreteLogger.info("TESTING", nameMethod, null);

			assertThat(logBitRecord, notNullValue());
			assertThat(logBitRecord.getMessage(), is(nameMethod));
			assertThat(logBitRecord.getLogCode(), is("TESTING"));
			assertThat(logBitRecord.getSeverity(), is("INFO"));
			assertThat(logBitRecord.getThreadId(), notNullValue());
			assertThat(logBitRecord.getHost(), is("168.192.152.1"));
			assertThat(logBitRecord.getPayload(), nullValue());
			assertThat(logBitRecord.getFinish(), nullValue());
			assertThat(logBitRecord.getStart(), nullValue());
			assertThat(logBitRecord.getCurrent(), notNullValue());
			assertThat(logBitRecord.getCorrelationId(), nullValue());
			assertThat(logBitRecord.getTransactionId(), nullValue());
			assertThat(logBitRecord.getTimeExecution(), nullValue());
			assertThat(logBitRecord.getThrowable(), nullValue());

		}).doesNotThrowAnyException();
	}
	
}
