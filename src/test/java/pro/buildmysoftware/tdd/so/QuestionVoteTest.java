package pro.buildmysoftware.tdd.so;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionVoteTest {
	@DisplayName("should increase score by 1 when upvote")
	@Test
	void test() throws Exception {
		// given
		String author = "goobar";
		Question question = Question.post(author);

		// when
		question.upvote();

		// then
		assertThat(question.getScore()).isEqualTo(1);
	}
}
