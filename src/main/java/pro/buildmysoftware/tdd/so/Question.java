package pro.buildmysoftware.tdd.so;

import java.util.HashSet;
import java.util.Set;

class Question {
	private int score;
	private String author;
	private Set<String> voters;

	private Question(String author) {
		this.author = author;
		voters = new HashSet<>();
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
		vote(user, () -> score++);
	}

	private void vote(String user, Runnable voteOperation) {
		validateUser(user);
		voteOperation.run();
		voters.add(user);
	}

	private void validateUser(String user) {
		if (author.equals(user) || voters.contains(user)) {
			throw new QuestionException();
		}
	}

	/**
	 * Downvotes this question by another user.
	 *
	 * @param user another user, cannot be the same as author
	 * @throws QuestionException if business constraint is violated
	 */
	void downvote(String user) {
		vote(user, () -> score--);
	}
}
