package pro.buildmysoftware.tdd.so;

import java.awt.geom.Ellipse2D;
import java.util.HashSet;
import java.util.Set;

class Question {
	private int score;
	private String author;
	private Set<String> users;

	private Question(String author) {
		this.author = author;
		users = new HashSet<>();
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
		if (users.contains(user)) {
			throw new QuestionException();
		}
		score++;
		users.add(user);
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
		if(score < 0)
			throw new QuestionException();
		score--;
	}
}
