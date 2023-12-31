package br.com.devblack.logging.configuration;

import java.net.InetAddress;

public class Configuration {

	private static final String EMPTY = "";
	private final String applicationName;
	private final String organizationName;
	private final String hostAddress;
	private boolean isThrowable;
	private boolean isCorrelationRandom = false;
	private boolean isTransactionRandom = false;

	public Configuration(final String applicationName,
						 final String organizationName,
						 final String hostAddress,
						 final boolean isThrowable) {

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
	
	public boolean isThrowable() {
		return this.isThrowable;
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
	
	public void enableThrowable() {
		this.isThrowable = true;
	}
	
	public void disableThrowable() {
		this.isThrowable = false;
	}

	public boolean isCorrelationRandom() {
		return isCorrelationRandom;
	}

	public boolean isTransactionRandom() {
		return isTransactionRandom;
	}
}