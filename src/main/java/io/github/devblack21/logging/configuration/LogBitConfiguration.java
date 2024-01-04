package io.github.devblack21.logging.configuration;

import java.net.InetAddress;

public class LogBitConfiguration {

	private static final String EMPTY = "";
	private final String applicationName;
	private final String organizationName;
	private final String workflowName;
	private final String hostAddress;
	private boolean isCorrelationRandom = false;
	private boolean isTransactionRandom = false;

	public LogBitConfiguration(final String applicationName,
							   final String organizationName,
							   final String hostAddress,
							   final String workflowName) {

		this.applicationName = applicationName;
		this.organizationName = organizationName;
		this.hostAddress = hostAddress;
		this.workflowName = workflowName;
	}
	
	public LogBitConfiguration(final String applicationName, final String organizationName, final String  workflowName) {
		this.applicationName = applicationName;
		this.organizationName = organizationName;
		this.workflowName = workflowName;
		this.hostAddress = getHost();
	}
	
	private String getHost() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (final Exception e){
			return EMPTY;
		}
	}
	
	public String getApplicationName() {
		return this.applicationName;
	}
	
	public String getOrganizationName() {
		return this.organizationName;
	}

	
	public String getHostAddress() {
		return this.hostAddress;
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

	public boolean isCorrelationRandom() {
		return isCorrelationRandom;
	}

	public boolean isTransactionRandom() {
		return isTransactionRandom;
	}

	public String getWorkflowName() {
		return workflowName;
	}
}