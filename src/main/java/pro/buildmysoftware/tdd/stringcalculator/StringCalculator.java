package pro.buildmysoftware.tdd.stringcalculator;

import java.util.Optional;
import java.util.stream.Stream;

class StringCalculator {
	private static final String NUMBERS_DELIMITER = ",";

	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] parsedNumbers = normalizeString(numbers).split
			(NUMBERS_DELIMITER);
		Optional<Integer> negativeNumber = findNegativeNumber
			(parsedNumbers);
		negativeNumber.ifPresent(number -> {
			throw new IllegalArgumentException("negatives not " +
				"allowed: " + number);
		});
		return Stream.of(parsedNumbers).mapToInt(Integer::valueOf)
			.sum();
	}

	private static Optional<Integer> findNegativeNumber(String[]
								    parsedNumbers) {
		return Stream.of(parsedNumbers).map(Integer::valueOf).filter(n
			-> n < 0).findFirst();
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
