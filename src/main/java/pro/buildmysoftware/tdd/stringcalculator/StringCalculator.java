package pro.buildmysoftware.tdd.stringcalculator;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 1) {
			return Integer.valueOf(numbersArray[0]) + Integer
				.valueOf(numbersArray[1]);
		}
		return Integer.valueOf(numbers);
	}
}
