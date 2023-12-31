package br.com.devblack.logging.facade;

import br.com.devblack.logging.configuration.Configuration;
import br.com.devblack.logging.facade.Logger;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LoggerTest {

	@Test
	public void shouldLogInfo() {
		
		final String nameMethod = "shouldLogInfo";

		Logger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> Logger.info("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStartWithPayload() {

		final String nameMethod = "shouldLogWarningStartWithPayload";

		Logger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> Logger.logWarningStart("TESTING", nameMethod, Map.of("key", "value")))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningStart() {

		final String nameMethod = "shouldLogWarningStart";

		Logger.configure(new Configuration(nameMethod, "testing", false));

		assertThatCode(() -> Logger.logWarningStart("TESTING", nameMethod, null))
				.doesNotThrowAnyException();
	}

	@Test
	public void shouldLogWarningFinish() {

		final String nameMethod = "shouldLogWarningFinish";

		Logger.configure(new Configuration(nameMethod, "testing", false));
		assertThatCode(() -> {
			Logger.logInfoStart("TESTING", nameMethod, null);
			Logger.logWarningFinish("TESTING", nameMethod, null);
		})
		.doesNotThrowAnyException();
	}

}
