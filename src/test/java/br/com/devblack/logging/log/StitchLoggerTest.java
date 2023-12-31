package br.com.devblack.logging.log;

import br.com.devblack.logging.configuration.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

public class StitchLoggerTest {

	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		StitchLogger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> StitchLogger.info("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStartWithPayload() {

		final String nameMethod = "shouldLogWarningStartWithPayload";

		StitchLogger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> StitchLogger.logWarningStart("TESTING", nameMethod, Map.of("key", "value")))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStart() {

		final String nameMethod = "shouldLogWarningStart";

		StitchLogger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> StitchLogger.logWarningStart("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningFinish() {

		final String nameMethod = "shouldLogWarningFinish";

		StitchLogger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			StitchLogger.logInfoStart("TESTING", nameMethod, null);
			StitchLogger.logWarningFinish("TESTING", nameMethod, null);
		})
		.doesNotThrowAnyException();
	}

}
