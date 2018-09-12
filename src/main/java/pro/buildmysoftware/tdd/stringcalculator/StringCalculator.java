package pro.buildmysoftware.tdd.stringcalculator;

import java.util.stream.Stream;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 1) {
			int sum = 0;
			for (String number : numbersArray) {
				sum += Integer.valueOf(number);
			}
			return sum;
		}
		return Integer.valueOf(numbers);
	}
}
