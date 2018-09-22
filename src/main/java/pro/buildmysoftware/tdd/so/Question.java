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
		if (author.equals(user)) {
			throw new QuestionException();
		}
		score++;
	}

	public void downvote(String anotherUser) {
		score--;
	}
}
