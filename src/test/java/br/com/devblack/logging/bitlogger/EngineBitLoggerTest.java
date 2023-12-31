package br.com.devblack.logging.bitlogger;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.bitlogger.EngineBitLogger;
import br.com.devblack.logging.record.LogObject;
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
			final EngineBitLogger concreteLogger = new EngineBitLogger(null);
			concreteLogger.error("","", null, runtimeException);
		});
		assertThat(exception, notNullValue());
	}
	
	@Test
	public void shouldConfigureLog() {
	
		final Configuration configuration = new Configuration("testing", "stitch", false);

		assertThat(configuration.getApplicationName(), is("testing"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {


			final LogObject logObject = concreteLogger.info("TESTING", nameMethod, null);

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
			assertThat(logObject.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoWithPayload() {
		
		final String nameMethod = "shouldLogInfoWithPayload";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStartWithPayload() {
		
		final String nameMethod = "shouldLogInfoStartWithPayload";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoStart() {
		
		final String nameMethod = "shouldLogInfoStart";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.logInfoStart("TESTING", nameMethod, null);
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinish() {
		
		final String nameMethod = "shouldLogInfoFinish";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, null);
			final LogObject logObject = concreteLogger.logInfoFinish("TESTING", nameMethod, null);
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogInfoFinishWithPayload() {
		
		final String nameMethod = "shouldLogInfoFinishWithPayload";

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogObject logObject = concreteLogger.logInfoFinish("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}

	
	@Test
	public void shouldConfigureDisableCorrelationAndTransactinLog() {
		
		final Configuration configuration = new Configuration("shouldConfigureDisableCorrelationAndTransactinLog", "stitch", false);

		final EngineBitLogger concreteLogger = new EngineBitLogger(configuration);
		
		assertThatCode(() -> concreteLogger.info("TESTING", "shouldConfigureDisableCorrelationAndTransactinLog", Map.of("key", "value"))).doesNotThrowAnyException();

		assertThat(configuration.getApplicationName(), is("shouldConfigureDisableCorrelationAndTransactinLog"));
		assertThat(configuration.getOrganizationName(), is("stitch"));
		assertThat(configuration.isThrowable(), is(Boolean.FALSE));
		assertThat(configuration.getHostAddress(), notNullValue());
	}
	
	@Test
	public void shouldLogWarning() {
		
		final String nameMethod = "shouldLogWarning";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {

			final LogObject logObject = concreteLogger.warning("TESTING", nameMethod, null);
			
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
			assertThat(logObject.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningWithPayload() {
		
		final String nameMethod = "shouldLogWarningWithPayload";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.warning("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStartWithPayload() {
		
		final String nameMethod = "shouldLogWarningStartWithPayload";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.logWarningStart("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningStart() {
		
		final String nameMethod = "shouldLogWarningStart";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.logWarningStart("TESTING", nameMethod, null);
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinish() {
		
		final String nameMethod = "shouldLogWarningFinish";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, null);
			final LogObject logObject = concreteLogger.logWarningFinish("TESTING", nameMethod, null);
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogWarningFinishWithPayload() {
		
		final String nameMethod = "shouldLogWarningFinishWithPayload";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			concreteLogger.logInfoStart("TESTING", nameMethod, Map.of("key", "value"));
			final LogObject logObject = concreteLogger.logWarningFinish("TESTING", nameMethod, Map.of("key", "value"));
			
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
			assertThat(logObject.json(), is(json));
			
		}).doesNotThrowAnyException();
	}
	
	@Test
	public void shouldLogError() {
		
		final String nameMethod = "shouldLogError";
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.error("TESTING", nameMethod, null, new RuntimeException("erro"));
			
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
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.error("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
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
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.debug("TESTING", nameMethod, null, new RuntimeException("erro"));
			
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
		
		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.debug("TESTING", nameMethod, Map.of("key", "value"), new RuntimeException("error"));
			
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

		final EngineBitLogger concreteLogger = new EngineBitLogger(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			LogObject logObject = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));

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
			assertThat(logObject.json(), is(json));

			concreteLogger.setCorrelationId(UUID.randomUUID().toString());
			concreteLogger.setTransactionId(UUID.randomUUID().toString());

			final LogObject logObject2 = concreteLogger.info("TESTING", nameMethod, Map.of("key", "value"));

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
			assertThat(logObject2.json(), is(jsonInserted));
			
		}).doesNotThrowAnyException();
	}
	
	
	@Test
	public void shouldConfigureInsertHostAddress() {
		
		final String nameMethod = "shouldConfigureInsertHostAddress";

		final Configuration configuration = new Configuration(nameMethod, "testing", "168.192.152.1", false);

		final EngineBitLogger concreteLogger = new EngineBitLogger(configuration);

		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.info("TESTING", nameMethod, null);
			
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

		final EngineBitLogger concreteLogger = new EngineBitLogger(configuration);

		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.info("TESTING", nameMethod, null);

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

		final EngineBitLogger concreteLogger = new EngineBitLogger(configuration);

		assertThatCode(() -> {
			final LogObject logObject = concreteLogger.info("TESTING", nameMethod, null);

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
