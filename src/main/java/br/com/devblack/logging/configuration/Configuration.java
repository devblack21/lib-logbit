package br.com.devblack.logging.configuration;

import org.slf4j.MDC;

import java.net.InetAddress;
import java.util.UUID;

public class Configuration {
	
	public static final String CORRELATION_ID = "correlationId";
	public static final String TRANSACTION_ID = "transactionId";
	public static final String APPLICATION_NAME = "applicationName";
	public static final String ORGANIZATION_NAME = "organizationName";
	public static final String HOST_ADDRESS = "hostAddress";
	private static final String EMPTY = "";
	
	private final String applicationName;
	private final String organizationName;
	private final String hostAddress;
	private String correlationId;
	private String transactionId;
	
	private boolean isThrowable = false;
	private boolean isCorrelationRandom = false;
	private boolean isTransactionRandom = false;
	
	/**
	 * @param applicationName : Nome da aplicação
	 * @param organizationName : Nome da organização
	 * @param hostAddress : Host da instancia de maquina
	 * @param isThrowable : Se verdadeiro, quando passar um objeto Throwable para o log será aprensentado o printStackTrace da exceção
	 */
	public Configuration(final String applicationName, final String organizationName, final String hostAddress, final boolean isThrowable) {
		this.applicationName = applicationName;
		this.organizationName = organizationName;
		this.hostAddress = hostAddress;
		this.isThrowable = isThrowable;
	}
	
	public Configuration(final String applicationName, final String organizationName, final boolean isThrowable) {
		this.applicationName = applicationName;
		this.organizationName = organizationName;
		this.isThrowable = isThrowable;
		this.hostAddress = getHost();
	}
	
	private String getHost() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (final Exception e){
			return EMPTY;
		}
	}
	
	public void refresh() {
		initContext();
	}
	
	private void initContext() {
		MDC.put(APPLICATION_NAME, this.applicationName);
		MDC.put(ORGANIZATION_NAME, this.organizationName);
		MDC.put(HOST_ADDRESS, this.hostAddress);
		MDC.put(CORRELATION_ID, (isCorrelationRandom) ? UUID.randomUUID().toString() : this.correlationId);
		MDC.put(TRANSACTION_ID, (isTransactionRandom) ? UUID.randomUUID().toString() : this.transactionId);
	}
	
	public boolean isThrowable() {
		return this.isThrowable;
	}
	
	public String getApplicationName() {
		return this.applicationName;
	}
	
	public String getOrganizationName() {
		return this.organizationName;
	}
	
	public String getCorrelationId() {
		return MDC.get(CORRELATION_ID) ;
	}
	
	public String getTransactionId() {
		return MDC.get(TRANSACTION_ID) ;
	}
	
	public String getHostAddress() {
		return this.hostAddress;
	}
	
	public void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}
	
	public void setTransactionId(final String transactionId) {
		this.transactionId = transactionId;
	}
	
	public void enableRandomCorrelation() {
		this.isCorrelationRandom = true;
	}
	
	public void disableRandomCorrelation() {
		this.isCorrelationRandom = false;
	}
	
	public void enableRandomTransaction() {
		this.isTransactionRandom = true;
	}
	
	public void disableRandomTransaction() {
		this.isTransactionRandom = false;
	}
	
	public void enableThrowable() {
		this.isThrowable = true;
	}
	
	public void disableThrowable() {
		this.isThrowable = false;
	}
	
}