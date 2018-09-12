package pro.buildmysoftware.tdd.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String numbersWithReplacedNewlineChars = numbers.replace('\n',
			',');
		return Stream.of(numbersWithReplacedNewlineChars.split(","))
			.mapToInt(Integer::valueOf).sum();
	}
}
