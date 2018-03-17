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
	public void setUp() {
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
	public void randomCreatedChromosomeShouldHaveProperArrayList() {
		assertNotNull(gen.getChromosome());
		Collections.sort(gen.getChromosome());
		assertEquals(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 2, 3)), gen.getChromosome());
	}

	@Test
	public void secondConstructorParametersShouldNotBeNull() {
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(null, gen, 0.5);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, null, 0.5);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(null, null, 0.5);
			;
		});
	}

	@Test
	public void secondConstructorParametersChromosomesShouldBeNotNull() {
		TimetableGen gen1 = new TimetableGen(5, 3);
		gen.setChromosome(null);
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen1, 0.5);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen1, gen, 0.5);
		});
	}

	@Test
	public void secondConstructorParametersChromosomesSizeShouldNotBeZero() {
		TimetableGen gen1 = new TimetableGen(5, 3);
		gen.setChromosome(new ArrayList<Integer>(0));
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen1, 0.5);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen1, gen, 0.5);
		});
	}

	@Test
	public void secondConstructorMutationRateShouldBeBetweenZeroAndOne() {
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen, -1);
		});
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen, 2);
		});
	}
	
	@Test
	public void secondConstructorParametersShouldHaveTheSamePositiveHourCount() {
		TimetableGen gen1 = new TimetableGen(5, 2);
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen1, 0.5);
		});
		gen.setHourCount(-10);
		gen1.setHourCount(-10);
		assertThrows(InvalidParameterException.class, () -> {
			new TimetableGen(gen, gen1, 0.5);
		});
	}
	
	@Test
	public void createdChildShouldNotBeNull() {
		TimetableGen gen1 = new TimetableGen(gen, gen, 0.3);
		assertNotNull(gen1);
		assertNotNull(gen1.getChromosome());
	}
	
	@Test
	public void createdChildChromosomeShouldNotBeSizedZero() {
		assertNotEquals(0, new TimetableGen(gen, gen, 0.3).chromosome.size());
	}
	
	@Test 
	public void createdChildShouldHaveProperHourCount() {
		TimetableGen gen1 = new TimetableGen(gen, gen, 0.3);
		assertTrue(gen1.getHourCount()>0);
		assertTrue(gen1.getChromosome().size()>=gen1.getHourCount());
	}
}
