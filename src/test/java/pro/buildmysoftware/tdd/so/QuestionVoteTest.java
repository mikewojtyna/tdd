package pro.buildmysoftware.tdd.so;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Fail.fail;

public class QuestionVoteTest {
	@DisplayName("should increase score by 1 when upvote by another user")
	@Test
	void test0() throws Exception {
		// given
		String author = "goobar";
		String anotherUser = "foobar";
		Question question = Question.post(author);

		// when
		question.upvote(anotherUser);

		// then
		assertThat(question.getScore()).isEqualTo(1);
	}

	@DisplayName("should throw exception when upvote by author")
	@Test
	void test1() throws Exception {
		// given
		String author = "goobar";
		Question question = Question.post(author);

		// when
		Throwable exception = catchThrowable(() -> question.upvote
			(author));

		// then
		assertThat(exception).isInstanceOf(QuestionException.class);
	}

	@DisplayName("should decrease score by 1 when downvote by another " +
		"user")
	@Test
	void test2() throws Exception {
		// given
		String author = "goobar";
		String anotherUser = "foobar";
		Question question = Question.post(author);

		// when
		question.downvote(anotherUser);

		// then
		assertThat(question.getScore()).isEqualTo(-1);
	}
}
