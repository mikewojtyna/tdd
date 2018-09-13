package pro.buildmysoftware.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;

class TemplateTest {
	@DisplayName("test")
	@Test
	void test() throws Exception {
		// given
		Template template = new Template();

		// when
		template.yourMethod();

		// then
		fail("Write your test");
	}
}
