import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@JsonSerializableSchema
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogObject implements Serializable {
	
	
	private String correlationId = null;
	private String transactionId = null;
	private String threadId = null;
	private String logCode = null;
	private String message = null;
	private Object payload = null;
	private Throwable throwable = null;
	private Instant start = null;
	private Instant finish = null;
	private Instant current = null;
	private long timeExecution = 0;
	private String severity = null;
	
	private LogObject() {}
	
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

	public String getStart() {
		if (Objects.nonNull(start)) return  String.valueOf(this.start);
		
		return null;
	}
	
	public String getFinish() {
		if (Objects.nonNull(finish)) return String.valueOf(this.finish);
		
		return null;
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public String getCurrent() {
		if (Objects.nonNull(current)) return String.valueOf(this.current);
		return null;
	}
	
	public String getTimeExecution() {
		if (timeExecution <= 0) return null;
		return TimeUnit.MILLISECONDS.convert(timeExecution, TimeUnit.NANOSECONDS) + "ms";
	}
	
	public static LogObject init() {
		return new LogObject();
	}
	
	public LogObject setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
		return this;
	}
	
	public LogObject setTransationId(final String transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	public LogObject setThreadId(final String threadId) {
		this.threadId = threadId;
		return this;
	}
	
	public LogObject setLogCode(final String logCode) {
		this.logCode = logCode;
		return this;
	}
	
	public LogObject setMessage(final String message) {
		this.message = message;
		return this;
	}
	
	public LogObject setPayload(final Object payload) {
		this.payload = payload;
		return this;
	}
	
	public LogObject setCurrent(final Instant current) {
		this.current = current;
		return this;
	}
	
	public LogObject setTimeExecution(final long timeExecution) {
		this.timeExecution = timeExecution;
		return this;
	}
	
	public LogObject setThrowable(final Throwable throwable) {
		this.throwable = throwable;
		return this;
	}
	
	public LogObject setStart(final Instant start) {
		this.start = start;
		return this;
	}
	
	public LogObject setFinish(final Instant finish) {
		this.finish = finish;
		return this;
	}
	
	public LogObject setSeverity(final String severity) {
		this.severity = severity;
		return this;
	}
	
	public LogObject build() {
		return this;
	}
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
