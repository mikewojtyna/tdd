package pro.buildmysoftware.tdd.so;

class Question {
	private int score;

	private Question(String author) {
	}

	static Question post(String author) {
		return new Question(author);
	}

	int getScore() {
		return score;
	}

	void upvote() {
		score++;
	}
}
