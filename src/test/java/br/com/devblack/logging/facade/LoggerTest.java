package br.com.devblack.logging.facade;

import br.com.devblack.logging.bitlogger.AbstractEngineBitLogger;
import br.com.devblack.logging.bitlogger.EngineBitLogger;
import br.com.devblack.logging.configuration.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LoggerTest {

	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		final Configuration configuration = new Configuration(nameMethod, "testing", false);
		final AbstractEngineBitLogger engineLogger = new EngineBitLogger(configuration);
		
		Logger.configure(engineLogger);

		assertThatCode(() -> Logger.info("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStartWithPayload() {

		final String nameMethod = "shouldLogWarningStartWithPayload";

		final Configuration configuration = new Configuration(nameMethod, "testing", false);
		final AbstractEngineBitLogger engineLogger = new EngineBitLogger(configuration);
		Logger.configure(engineLogger);

		assertThatCode(() -> Logger.logWarningStart("TESTING", nameMethod, Map.of("key", "value")))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStart() {

		final String nameMethod = "shouldLogWarningStart";

		final Configuration configuration = new Configuration(nameMethod, "testing", false);
		final AbstractEngineBitLogger engineLogger = new EngineBitLogger(configuration);
		Logger.configure(engineLogger);

		assertThatCode(() -> Logger.logWarningStart("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningFinish() {

		final String nameMethod = "shouldLogWarningFinish";

		final Configuration configuration = new Configuration(nameMethod, "testing", false);
		final AbstractEngineBitLogger engineLogger = new EngineBitLogger(configuration);
		Logger.configure(engineLogger);

		assertThatCode(() -> {
			Logger.logInfoStart("TESTING", nameMethod, null);
			Logger.logWarningFinish("TESTING", nameMethod, null);
		})
		.doesNotThrowAnyException();
	}

}
