package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.record.LogObject;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StitchLoggerTest {

	@Test
	public void shouldExceptionNotConfigurationLog() {
		final RuntimeException runtimeException = new RuntimeException();
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			StitchLogger.configure(null);
			StitchLogger.error("","", null, runtimeException);
		});
		assertThat(exception, notNullValue());
	}
	
	@Test
	public void shouldConfigureLog() {
	
		final Configuration configuration = new Configuration("testing", "stitch", false);
		
		StitchLogger.configure(configuration);

		assertThat(configuration.getApplicationName(), is("testing"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", nameMethod, null);

			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\"shouldLogInfo\",\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoWithPayload() {
		
		final String nameMethod = "shouldLogInfoWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStartWithPayload() {
		
		final String nameMethod = "shouldLogInfoStartWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStart() {
		
		final String nameMethod = "shouldLogInfoStart";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.logInfoStart("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinish() {
		
		final String nameMethod = "shouldLogInfoFinish";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			StitchLogger.logInfoStart("TESTING", nameMethod, null);
			final LogObject logObject = StitchLogger.logInfoFinish("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), notNullValue());
			assertThat(logObject.getStart(), notNullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), notNullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"start\":\""+logObject.getStart()+"\",\"finish\":\""+logObject.getFinish()+"\",\"current\":\""+logObject.getCurrent()+"\",\"timeExecution\":\""+logObject.getTimeExecution()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinishWithPayload() {
		
		final String nameMethod = "shouldLogInfoFinishWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			StitchLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogObject logObject = StitchLogger.logInfoFinish("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), notNullValue());
			assertThat(logObject.getStart(), notNullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), notNullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"start\":\""+logObject.getStart()+"\",\"finish\":\""+logObject.getFinish()+"\",\"current\":\""+logObject.getCurrent()+"\",\"timeExecution\":\""+logObject.getTimeExecution()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}

	
	@Test
	public void shouldConfigureDisableCorrelationAndTransactinLog() {
		
		final Configuration configuration = new Configuration("shouldConfigureDisableCorrelationAndTransactinLog", "stitch", false);

		StitchLogger.configure(configuration);
		
		assertThatCode(() -> StitchLogger.info("TESTING", "shouldConfigureDisableCorrelationAndTransactinLog", Map.of("key", "value"))).doesNotThrowAnyException();

		assertThat(configuration.getApplicationName(), is("shouldConfigureDisableCorrelationAndTransactinLog"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogWarning() {
		
		final String nameMethod = "shouldLogWarning";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.warning("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningWithPayload() {
		
		final String nameMethod = "shouldLogWarningWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.warning("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStartWithPayload() {
		
		final String nameMethod = "shouldLogWarningStartWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.logWarningStart("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStart() {
		
		final String nameMethod = "shouldLogWarningStart";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.logWarningStart("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinish() {
		
		final String nameMethod = "shouldLogWarningFinish";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			StitchLogger.logInfoStart("TESTING", nameMethod, null);
			final LogObject logObject = StitchLogger.logWarningFinish("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), notNullValue());
			assertThat(logObject.getStart(), notNullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), notNullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"start\":\""+logObject.getStart()+"\",\"finish\":\""+logObject.getFinish()+"\",\"current\":\""+logObject.getCurrent()+"\",\"timeExecution\":\""+logObject.getTimeExecution()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinishWithPayload() {
		
		final String nameMethod = "shouldLogWarningFinishWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			StitchLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogObject logObject = StitchLogger.logWarningFinish("TESTING", nameMethod, Map.of("key", "value"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("WARNING"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), notNullValue());
			assertThat(logObject.getStart(), notNullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), notNullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"start\":\""+logObject.getStart()+"\",\"finish\":\""+logObject.getFinish()+"\",\"current\":\""+logObject.getCurrent()+"\",\"timeExecution\":\""+logObject.getTimeExecution()+"\",\"severity\":\"WARNING\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogError() {
		
		final String nameMethod = "shouldLogError";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.error("TESTING", nameMethod, null, new RuntimeException("erro"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("ERROR"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());

		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogErrorWithPayload() {
		
		final String nameMethod = "shouldLogErrorWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.error("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("ERROR"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogDebug() {
		
		final String nameMethod = "shouldLogDebug";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.debug("TESTING", nameMethod, null, new RuntimeException("erro"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("DEBUG"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogDebugWithPayload() {
		
		final String nameMethod = "shouldLogDebugWithPayload";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.debug("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("DEBUG"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), notNullValue());
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWhenInsertCorrelationAndTransaction() {

		final String nameMethod = "shouldLogWhenInsertCorrelationAndTransaction";

		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			LogObject logObject = StitchLogger.info("TESTING", nameMethod, Map.of("key", "value"));

			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), notNullValue());
			assertThat(logObject.getPayload(), notNullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			final String json = "{\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));

			StitchLogger.setCorrelationId(UUID.randomUUID().toString());
			StitchLogger.setTransactionId(UUID.randomUUID().toString());

			final LogObject logObject2 = StitchLogger.info("TESTING", nameMethod, Map.of("key", "value"));

			assertThat(logObject2, notNullValue());
			assertThat(logObject2.getMessage(), is(nameMethod));
			assertThat(logObject2.getLogCode(), is("TESTING"));
			assertThat(logObject2.getSeverity(), is("INFO"));
			assertThat(logObject2.getThreadId(), notNullValue());
			assertThat(logObject2.getHost(), notNullValue());
			assertThat(logObject2.getPayload(), notNullValue());
			assertThat(logObject2.getFinish(), nullValue());
			assertThat(logObject2.getStart(), nullValue());
			assertThat(logObject2.getCurrent(), notNullValue());
			assertThat(logObject2.getCorrelationId(), notNullValue());
			assertThat(logObject2.getTransactionId(), notNullValue());
			assertThat(logObject2.getTimeExecution(), nullValue());
			assertThat(logObject2.getThrowable(), nullValue());

			final String jsonInserted = "{\"correlationId\":\""+logObject2.getCorrelationId()+"\",\"transactionId\":\""+logObject2.getTransactionId()+"\",\"threadId\":\""+logObject2.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject2.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject2.getHost()+"\"}";
			assertThat(logObject2.toString(), is(jsonInserted));
			
		}).doesNotThrowAnyException();
	}
	
	
	@Test
	public void shouldConfigureInsertHostAddress() {
		
		final String nameMethod = "shouldConfigureInsertHostAddress";

		final Configuration configuration = new Configuration(nameMethod, "testing", "168.192.152.1", false);

		StitchLogger.configure(configuration);

		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", nameMethod, null);
			
			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), is("168.192.152.1"));
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());
			
		}).doesNotThrowAnyException();
	}

	@Test
	public void shouldConfigureRandomCorrelationIdAndTransactionId() {

		final String nameMethod = "shouldConfigureRandomCorrelationIdAndTransactionId";

		final Configuration configuration = new Configuration(nameMethod, "testing", "168.192.152.1", false);

		configuration.enableRandomCorrelation();
		configuration.enableRandomTransaction();

		StitchLogger.configure(configuration);

		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", nameMethod, null);

			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), is("168.192.152.1"));
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), notNullValue());
			assertThat(logObject.getTransactionId(), notNullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());

		}).doesNotThrowAnyException();
	}

	@Test
	public void shouldConfigureNotRandomCorrelationIdAndTransactionId() {

		final String nameMethod = "shouldConfigureRandomCorrelationIdAndTransactionId";

		final Configuration configuration = new Configuration(nameMethod, "testing", "168.192.152.1", false);

		configuration.disableRandomCorrelation();
		configuration.disableRandomTransaction();

		StitchLogger.configure(configuration);

		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", nameMethod, null);

			assertThat(logObject, notNullValue());
			assertThat(logObject.getMessage(), is(nameMethod));
			assertThat(logObject.getLogCode(), is("TESTING"));
			assertThat(logObject.getSeverity(), is("INFO"));
			assertThat(logObject.getThreadId(), notNullValue());
			assertThat(logObject.getHost(), is("168.192.152.1"));
			assertThat(logObject.getPayload(), nullValue());
			assertThat(logObject.getFinish(), nullValue());
			assertThat(logObject.getStart(), nullValue());
			assertThat(logObject.getCurrent(), notNullValue());
			assertThat(logObject.getCorrelationId(), nullValue());
			assertThat(logObject.getTransactionId(), nullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());

		}).doesNotThrowAnyException();
	}
	
}
