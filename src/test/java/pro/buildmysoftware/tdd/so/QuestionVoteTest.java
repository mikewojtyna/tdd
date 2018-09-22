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

	@DisplayName("should throw exception when downvote by author")
	@Test
	void test3() throws Exception {
		// given
		String author = "goobar";
		Question question = Question.post(author);

		// when
		Throwable exception = catchThrowable(() -> question.downvote
			(author));

		// then
		assertThat(exception).isInstanceOf(QuestionException.class);
	}

	@DisplayName("should throw exception when user upvotes the same " +
		"question twice")
	@Test
	void test4() throws Exception {
		// given
		String author = "goobar";
		String user = "foobar";
		Question question = Question.post(author);

		// when
		question.upvote(user);
		Throwable exception = catchThrowable(() -> question.upvote
			(user));

		// then
		assertThat(exception).isInstanceOf(QuestionException.class);
		assertThat(question.getScore()).isEqualTo(1);
	}

	@DisplayName("should allow to upvote the same question two times" + " " +
		"" + "" + "" + "" + "" + "" + "" + "" + "" + "by different " +
		"users")
	@Test
	void test5() throws Exception {
		// given
		String author = "goobar";
		Question question = Question.post(author);

		// when
		question.upvote("foobar");
		question.upvote("hoobar");

		// then
		assertThat(question.getScore()).isEqualTo(2);
	}

	@DisplayName("should throw exception when user downvotes the same " +
		"question twice")
	@Test
	void test6() throws Exception {
		// given
		String author = "goobar";
		String user = "foobar";
		Question question = Question.post(author);

		// when
		question.downvote(user);
		Throwable exception = catchThrowable(() -> question.downvote
			(user));

		// then
		assertThat(exception).isInstanceOf(QuestionException.class);
		assertThat(question.getScore()).isEqualTo(-1);
	}

	@DisplayName("should allow to downvote the same question two times by"
		+ " different users")
	@Test
	void test7() throws Exception {
		// given
		String author = "goobar";
		Question question = Question.post(author);

		// when
		question.downvote("foobar");
		question.downvote("hoobar");

		// then
		assertThat(question.getScore()).isEqualTo(-2);
	}

	@DisplayName("should allow a user to change her vote from upvote to "
		+ "neutral")
	@Test
	void test8() throws Exception {
		// given
		Question question = Question.post("goobar");
		String user = "foobar";
		question.upvote(user);

		// when
		question.downvote(user);

		// then
		assertThat(question.getScore()).isEqualTo(0);
	}

	@DisplayName("should allow a user to change her vote from upvote to "
		+ "downvote")
	@Test
	void test9() throws Exception {
		// given
		Question question = Question.post("goobar");
		String user = "foobar";
		question.upvote(user);

		// when
		question.downvote(user);
		question.downvote(user);

		// then
		assertThat(question.getScore()).isEqualTo(-1);
	}
}
