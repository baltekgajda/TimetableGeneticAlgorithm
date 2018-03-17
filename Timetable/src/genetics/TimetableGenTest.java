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

	@BeforeEach
	void setUp() throws Exception {
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
	public void createdChromosomeShouldHaveProperSize() {
		TimetableGen gen = new TimetableGen(5, 3);
		assertNotNull(gen.getChromosome());
		assertEquals(5, gen.getChromosome().size());
	}

	@Test
	void createdChromosomeShouldHaveProperHourCount() {
		TimetableGen gen = new TimetableGen(5, 3);
		assertNotNull(gen.getChromosome());
		Collections.sort(gen.getChromosome());
		assertEquals(new ArrayList<Integer>(Arrays.asList(0,0,1,2,3)), gen.getChromosome());
	}

	@Test
	void testCreateRandomChromosomeInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testIsValidArrayListOfInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRepairChromosomeArrayListOfInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testCrossoverArrayListOfIntegerArrayListOfInteger() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testMutateChromosomeArrayListOfIntegerDouble() {
		fail("Not yet implemented"); // TODO
	}

}
