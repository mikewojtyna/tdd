package pro.buildmysoftware.tdd.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return Stream.of(normalizeString(numbers).split(",")).mapToInt
			(Integer::valueOf).sum();
	}

	private static String normalizeString(String numbers) {
		return numbers.replace('\n', ',');
	}
}
