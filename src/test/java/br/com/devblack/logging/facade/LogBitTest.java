package br.com.devblack.logging.facade;

import br.com.devblack.logging.configuration.LogBitConfiguration;
import br.com.devblack.logging.enginer.AbstractEngineLogBit;
import br.com.devblack.logging.enginer.EngineLogBit;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LogBitTest {

	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", false);
		final AbstractEngineLogBit engineLogger = new EngineLogBit(logBitConfiguration);
		
		LogBit.configure(engineLogger);

		assertThatCode(() -> LogBit.info("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStartWithPayload() {

		final String nameMethod = "shouldLogWarningStartWithPayload";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", false);
		final AbstractEngineLogBit engineLogger = new EngineLogBit(logBitConfiguration);
		LogBit.configure(engineLogger);

		assertThatCode(() -> LogBit.logWarningStart("TESTING", nameMethod, Map.of("key", "value")))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStart() {

		final String nameMethod = "shouldLogWarningStart";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", false);
		final AbstractEngineLogBit engineLogger = new EngineLogBit(logBitConfiguration);
		LogBit.configure(engineLogger);

		assertThatCode(() -> LogBit.logWarningStart("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningFinish() {

		final String nameMethod = "shouldLogWarningFinish";

		final LogBitConfiguration logBitConfiguration = new LogBitConfiguration(nameMethod, "testing", false);
		final AbstractEngineLogBit engineLogger = new EngineLogBit(logBitConfiguration);
		LogBit.configure(engineLogger);

		assertThatCode(() -> {
			LogBit.logInfoStart("TESTING", nameMethod, null);
			LogBit.logWarningFinish("TESTING", nameMethod, null);
		})
		.doesNotThrowAnyException();
	}

}
