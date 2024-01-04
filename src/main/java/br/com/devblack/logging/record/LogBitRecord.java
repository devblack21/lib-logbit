package br.com.devblack.logging.record;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogBitRecord implements Serializable {
	
	private String correlationId = null;
	private String transactionId = null;
	private String threadId = null;
	private String logCode = null;
	private String message = null;
	private Object payload = null;
	private Throwable throwable = null;
	private ZonedDateTime start = null;
	private ZonedDateTime finish = null;
	private ZonedDateTime current = null;
	private long timeExecution = 0;
	private String severity = null;
	private String host = null;
	
	private LogBitRecord() {}
	
	public String getCorrelationId() {
		return correlationId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	
	public String getLogCode() {
		return logCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getThreadId() {
		return threadId;
	}
	
	public Object getPayload() {
		return payload;
	}
	
	public Throwable getThrowable() {
		return throwable;
	}
	
	public String getHost() {
		return host;
	}
	
	public String getStart() {
		if (Objects.nonNull(start)) return  String.valueOf(this.start.toLocalDateTime());
		return null;
	}
	
	public String getFinish() {
		if (Objects.nonNull(finish)) return String.valueOf(this.finish.toLocalDateTime());
		return null;
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public String getCurrent() {
		if (Objects.nonNull(current)) return String.valueOf(this.current.toLocalDateTime());
		return null;
	}
	
	public String getTimeExecution() {
		if (timeExecution <= 0) return null;
		return TimeUnit.MILLISECONDS.convert(timeExecution, TimeUnit.NANOSECONDS) + "ms";
	}
	
	public static LogBitRecord init() {
		return new LogBitRecord();
	}
	
	public LogBitRecord setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
		return this;
	}
	
	public LogBitRecord setTransationId(final String transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	public LogBitRecord setHost(final String host) {
		this.host = host;
		return this;
	}
	
	public LogBitRecord setThreadId(final String threadId) {
		this.threadId = threadId;
		return this;
	}
	
	public LogBitRecord setLogCode(final String logCode) {
		this.logCode = logCode;
		return this;
	}
	
	public LogBitRecord setMessage(final String message) {
		this.message = message;
		return this;
	}
	
	public LogBitRecord setPayload(final Object payload) {
		this.payload = payload;
		return this;
	}
	
	public LogBitRecord setCurrent(final ZonedDateTime current) {
		this.current = current;
		return this;
	}
	
	public LogBitRecord setTimeExecution(final long timeExecution) {
		this.timeExecution = timeExecution;
		return this;
	}
	
	public LogBitRecord setThrowable(final Throwable throwable) {
		this.throwable = throwable;
		return this;
	}
	
	public LogBitRecord setStart(final ZonedDateTime start) {
		this.start = start;
		return this;
	}
	
	public LogBitRecord setFinish(final ZonedDateTime finish) {
		this.finish = finish;
		return this;
	}
	
	public LogBitRecord setSeverity(final String severity) {
		this.severity = severity;
		return this;
	}
	
	public LogBitRecord build() {
		return this;
	}

	public String json() {
		try {
			return new JsonMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
