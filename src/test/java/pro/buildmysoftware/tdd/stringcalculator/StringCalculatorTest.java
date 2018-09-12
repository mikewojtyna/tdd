package pro.buildmysoftware.tdd.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
	@DisplayName("should calculate sum according to the specification")
	@ParameterizedTest(name = "given numbers: \"{0}\", expected sum: {1}")
	@CsvSource({
		// empty string
		"'', 0"})
	void test(String numbers, int expectedSum) throws Exception {
		// when
		int sum = StringCalculator.add(numbers);

		// then
		assertThat(sum).isEqualTo(expectedSum);
	}
}
