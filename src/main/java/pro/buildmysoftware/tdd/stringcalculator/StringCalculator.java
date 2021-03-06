package pro.buildmysoftware.tdd.stringcalculator;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringCalculator {
	private static final String NUMBERS_DELIMITER = ",";

	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		Collection<Integer> parsedNumbers = parseNumbers(numbers);
		validateNonNegativeNumbers(parsedNumbers);
		return parsedNumbers.stream().filter(n -> n <= 1000).reduce(0,
			Integer::sum);
	}

	private static void validateNonNegativeNumbers(Collection<Integer>
							       parsedNumbers) {
		String negativesNumbersString = parsedNumbers.stream().filter
			(n -> n < 0).map(String::valueOf).collect(Collectors
			.joining(","));
		if (!negativesNumbersString.isEmpty()) {
			throw new IllegalArgumentException("negatives not " +
				"allowed: " + negativesNumbersString);
		}
	}

	private static Collection<Integer> parseNumbers(String numbers) {
		String extractedNumbers = extractNumbersAfterDelimiter
			(numbers).replace("\n", NUMBERS_DELIMITER);
		return Stream.of(extractedNumbers.split(NUMBERS_DELIMITER))
			.map(Integer::valueOf).collect(Collectors.toList());
	}

	private static String extractNumbersAfterDelimiter(String numbers) {
		if (numbers.matches("^//.\n.*$")) {
			String delimiter = String.valueOf(numbers.charAt(2));
			String numbersAfterDelimiter = numbers.substring(4);
			return numbersAfterDelimiter.replace(delimiter,
				NUMBERS_DELIMITER);
		}
		return numbers;
	}
}
