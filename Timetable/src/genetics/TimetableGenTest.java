package genetics;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimetableGenTest {

	private TimetableGen gen;

	@BeforeEach
	void setUp() {
		gen = new TimetableGen(5, 3);
	}

	@Test
	public void firstConstructorShouldThrowInvalidParameterException() {
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(55, -2);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(55, 100);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(-5, 57);
		});
	}

	@Test
	public void firstConstructorShouldInitializeHourCount() {
		assertEquals(3, gen.getHourCount());
	}

	@Test
	public void randomCreatedChromosomeShouldHaveProperSize() {
		assertNotNull(gen.getChromosome());
		assertEquals(5, gen.getChromosome().size());
	}

	@Test
	void randomCreatedChromosomeShouldHaveProperArrayList() {
		assertNotNull(gen.getChromosome());
		Collections.sort(gen.getChromosome());
		assertEquals(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 2, 3)), gen.getChromosome());
	}

}
