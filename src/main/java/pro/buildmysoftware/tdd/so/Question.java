package pro.buildmysoftware.tdd.so;

class Question {
	private int score;
	private String author;

	private Question(String author) {
		this.author = author;
	}

	static Question post(String author) {
		return new Question(author);
	}

	int getScore() {
		return score;
	}

	/**
	 * Upvotes this question by another user.
	 *
	 * @param user another user, cannot be the same as author
	 * @throws QuestionException if business constraint is violated
	 */
	void upvote(String user) throws QuestionException {
		validateUser(user);
		if (score > 0) {
			throw new QuestionException();
		}
		score++;
	}

	private void validateUser(String user) {
		if (author.equals(user)) {
			throw new QuestionException();
		}
	}

	/**
	 * Downvotes this question by another user.
	 *
	 * @param user another user, cannot be the same as author
	 * @throws QuestionException if business constraint is violated
	 */
	public void downvote(String user) {
		validateUser(user);
		score--;
	}
}
