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
		boolean startsWithDelimiter = numbers.startsWith("//;\n");
		if (startsWithDelimiter) {
			char delimiter = numbers.charAt(2);
			String numbersAfterDelimiter = numbers.substring(4);
			return numbersAfterDelimiter.replace(delimiter, ',');
		}
		return numbers.replace('\n', ',');
	}
}
