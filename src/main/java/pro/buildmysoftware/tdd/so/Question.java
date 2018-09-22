package pro.buildmysoftware.tdd.so;

import java.util.HashMap;
import java.util.Map;

class Question {
	private int score;
	private String author;
	private Map<String, Integer> voters;

	private Question(String author) {
		this.author = author;
		voters = new HashMap<>();
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
		vote(user, 1);
	}

	private void vote(String user, int voteValue) {
		validateVote(user, voteValue);
		score += voteValue;
		voters.put(user, voteValue);
	}

	private void validateVote(String user, Integer voteValue) {
		boolean isAuthor = author.equals(user);
		boolean isTheSameVoteAlreadyGiven = voters.getOrDefault(user,
			0).equals(voteValue);
		if (isAuthor || isTheSameVoteAlreadyGiven) {
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
		vote(user, -1);
	}
}
