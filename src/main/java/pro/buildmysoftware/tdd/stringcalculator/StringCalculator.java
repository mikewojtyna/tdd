package pro.buildmysoftware.tdd.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {
	private static final String NUMBERS_DELIMITER = ",";

	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return Stream.of(normalizeString(numbers).split
			(NUMBERS_DELIMITER)).mapToInt(Integer::valueOf).sum();
	}

	private static String normalizeString(String numbers) {
		String extractedNumbers = extractNumbers(numbers);
		return extractedNumbers.replace("\n", NUMBERS_DELIMITER);
	}

	private static String extractNumbers(String numbers) {
		if (numbers.matches("^//.\n.*$")) {
			String delimiter = String.valueOf(numbers.charAt(2));
			String numbersAfterDelimiter = numbers.substring(4);
			return numbersAfterDelimiter.replace(delimiter,
				NUMBERS_DELIMITER);
		}
		return numbers;
	}
}
