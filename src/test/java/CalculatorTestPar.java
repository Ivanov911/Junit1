import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class CalculatorTestPar {
	@RunWith(Parameterized.class)
	public static class ParameterizeTest {
		private int valueA;
		private int valueB;
		private int expected;

		public ParameterizeTest(int valueA, int valueB, int expected) {
			this.valueA = valueA;
			this.valueB = valueB;
			this.expected = expected;
		}

		@Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
		public static Iterable<Object[]> dataForTest() {
			return Arrays.asList(new Object[][] { { 10, 11, 21 }, { 20, 20, 40 }, { 50, 50, 100 }, { 60, 70, 130 },
					{ 100, 200, 300 } });
		}

		@Test
		public void paramTest() {
			assertEquals(expected, new Calculator().getSum(valueA, valueB));
		}
	}
}
