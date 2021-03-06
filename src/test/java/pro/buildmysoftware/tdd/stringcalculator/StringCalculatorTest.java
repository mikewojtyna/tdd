package pro.buildmysoftware.tdd.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class StringCalculatorTest {
	@DisplayName("should calculate sum according to the specification")
	@ParameterizedTest(name = "given numbers: \"{0}\", expected sum: {1}")
	// @formatter:off
	@CsvSource({
		"'', 0",
		"'1', 1",
		"'2', 2",
		"'1,2', 3",
		"'1,2,3', 6",
		"'1\n2,3', 6",
		"'//;\n1;2', 3",
		"'//%\n1%2', 3",
		"'2,1001', 2",
		"'//%\n1%2%1000%1001%1002', 1003",
	})
	// @formatter:on
	void test0(String numbers, int expectedSum) throws Exception {
		// when
		int sum = StringCalculator.add(numbers);

		// then
		assertThat(sum).isEqualTo(expectedSum);
	}

	@DisplayName("should throw exception when negative numbers are given")
	@ParameterizedTest(name = "given numbers: \"{0}\", expected ex msg: "
		+ "{1}")
	// @formatter:off
	@CsvSource({
		"'1,4,-1', 'negatives not allowed: -1'",
		"'1,-1,-2', 'negatives not allowed: -1,-2'"
	})
	// @formatter:on
	void test1(String numbers, String expectedExMsg) throws Exception {
		// when
		Throwable thrownException = catchThrowable(() ->
			StringCalculator.add(numbers));

		// then
		assertThat(thrownException).isInstanceOf
			(IllegalArgumentException.class).hasMessage
			(expectedExMsg);
	}
}
