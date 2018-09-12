package pro.buildmysoftware.tdd.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

class StringCalculatorTest {
	@DisplayName("should return 0 when input is empty")
	@Test
	void test0() throws Exception {
		// given
		String numbers = "";

		// when
		int sum = StringCalculator.add(numbers);

		// then
		assertThat(sum).isEqualTo(0);
	}
}
