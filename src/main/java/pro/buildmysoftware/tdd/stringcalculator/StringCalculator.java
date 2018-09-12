package pro.buildmysoftware.tdd.stringcalculator;

class StringCalculator {
	static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		return Integer.valueOf(numbers);
	}
}
