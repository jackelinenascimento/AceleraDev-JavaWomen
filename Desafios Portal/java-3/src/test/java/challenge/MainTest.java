package challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MainTest {

	@Test
	public void q1() throws Exception {
		int q1 = new Main().q1();
		assertEquals(164, q1);
		System.out.println(q1);
	}

	@Test
	public void q2() throws Exception {
		int q2 = new Main().q2();
		assertEquals(647, q2);
		System.out.println(q2);
	}

	@Test
	public void q3() throws Exception {
		List<String> result = new Main().q3();

		assertNotNull(result);
		assertEquals(20, result.size());
	}

	@Test
	public void q4() throws Exception {
		List<String> result = new Main().q4();

		assertNotNull(result);
		assertEquals(10, result.size());
	}

	@Test
	public void q5() throws Exception {
		List<String> result = new Main().q5();

		assertNotNull(result);
		assertEquals(10, result.size());
	}

	@Test
	public void q6() throws Exception {
		Map<Integer, Integer> result = new Main().q6();

		assertNotNull(result);
		assertNotEquals(0, result.size());
	}

}
