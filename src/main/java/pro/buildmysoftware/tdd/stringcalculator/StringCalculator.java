package pro.buildmysoftware.tdd.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return Stream.of(numbers.split(",")).mapToInt
			(Integer::valueOf).sum();
	}
}
