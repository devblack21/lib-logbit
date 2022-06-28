package br.com.devblack.logging;

import br.com.devblack.logging.configuration.Configuration;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StitchLoggerTest {
	
	@Test
	@Order(1)
	public void shouldExceptionNotConfigurationLog() {
		StitchLogger.configure(null);
		final RuntimeException runtimeException = new RuntimeException();
		final Exception exception = assertThrows(RuntimeException.class, () -> StitchLogger.error("","", null, runtimeException));
		assertThat(exception, notNullValue());
	}
	
	@Test
	@Order(2)
	public void shouldConfigureLog() {
	
		final Configuration configuration = new Configuration("testing", "stitch", false);
		
		StitchLogger.configure(configuration);
		
		assertThat(configuration.getCorrelationId(), nullValue());
		assertThat(configuration.getTransactionId(), nullValue());
		assertThat(configuration.getApplicationName(), is("testing"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	@Order(3)
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
	@Order(4)
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
	@Order(5)
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
	@Order(6)
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
	@Order(7)
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
	@Order(8)
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
	@Order(9)
	public void shouldConfigureEnableCorrelationAndTransactinLog() {
		
		final Configuration configuration = new Configuration("shouldConfigureEnableCorrelationAndTransactinLog", "stitch", false);
		StitchLogger.configure(configuration);
		StitchLogger.enableAutoCorrelation();
		StitchLogger.enableAutoTransaction();
		
		assertThatCode(() -> {
			final LogObject logObject = StitchLogger.info("TESTING", "shouldConfigureEnableCorrelationAndTransactinLog", Map.of("key", "value"));
			
			final String json = "{\"correlationId\":\""+logObject.getCorrelationId()+"\",\"transactionId\":\""+logObject.getTransactionId()+"\",\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\"shouldConfigureEnableCorrelationAndTransactinLog\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(json));
			
		}).doesNotThrowAnyException();
		
		assertThat(configuration.getCorrelationId(), notNullValue());
		assertThat(configuration.getTransactionId(), notNullValue());
		assertThat(configuration.getApplicationName(), is("shouldConfigureEnableCorrelationAndTransactinLog"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	@Order(10)
	public void shouldConfigureDisableCorrelationAndTransactinLog() {
		
		final Configuration configuration = new Configuration("shouldConfigureDisableCorrelationAndTransactinLog", "stitch", false);
		configuration.enableRandomCorrelation();
		configuration.enableRandomTransaction();
		StitchLogger.configure(configuration);
		StitchLogger.disableAutoTransaction();
		StitchLogger.disableAutoCorrelation();
		
		assertThatCode(() -> StitchLogger.info("TESTING", "shouldConfigureDisableCorrelationAndTransactinLog", Map.of("key", "value"))).doesNotThrowAnyException();
		
		assertThat(configuration.getCorrelationId(), nullValue());
		assertThat(configuration.getTransactionId(), nullValue());
		assertThat(configuration.getApplicationName(), is("shouldConfigureDisableCorrelationAndTransactinLog"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	@Order(11)
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
	@Order(12)
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
	@Order(13)
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
	@Order(14)
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
	@Order(15)
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
	@Order(16)
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
	@Order(17)
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
	@Order(18)
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
	@Order(19)
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
	@Order(20)
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
	@Order(21)
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

			logObject = StitchLogger.info("TESTING", nameMethod, Map.of("key", "value"));

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
			assertThat(logObject.getCorrelationId(), notNullValue());
			assertThat(logObject.getTransactionId(), notNullValue());
			assertThat(logObject.getTimeExecution(), nullValue());
			assertThat(logObject.getThrowable(), nullValue());

			final String jsonInserted = "{\"correlationId\":\""+logObject.getCorrelationId()+"\",\"transactionId\":\""+logObject.getTransactionId()+"\",\"threadId\":\""+logObject.getThreadId()+"\",\"logCode\":\"TESTING\",\"message\":\""+nameMethod+"\",\"payload\":{\"key\":\"value\"},\"current\":\""+logObject.getCurrent()+"\",\"severity\":\"INFO\",\"host\":\""+logObject.getHost()+"\"}";
			assertThat(logObject.toString(), is(jsonInserted));
			
		}).doesNotThrowAnyException();
	}
	
	
	@Test
	@Order(22)
	public void shouldConfigureInsertHostAddress() {
		
		final String nameMethod = "shouldConfigureInsertHostAddress";
		
		StitchLogger.configure(new Configuration(nameMethod, "testing", "168.192.152.1", false));
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
