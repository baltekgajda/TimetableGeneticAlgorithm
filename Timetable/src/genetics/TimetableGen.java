package genetics;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TimetableGen extends Genotype<Integer> {

	// number of hours in a timetable
	// TODO dodac w konstuktorach i sprawdzic czy nie moze static
	private int hourCount;

	public TimetableGen(int chromosomeSize, int hourCount) throws InvalidParameterException {
		super(chromosomeSize);
		if (hourCount < 0 || hourCount > chromosomeSize)
			throw new InvalidParameterException("Invalid hourCount");
	}

	public TimetableGen(TimetableGen firstParent, TimetableGen secondParent, double mutationRate)
			throws InvalidParameterException {
		super(firstParent, secondParent, mutationRate);

		int count = firstParent.hourCount;
		if (count != secondParent.hourCount || count < 0)
			throw new InvalidParameterException("Invalid hourCount");
	}

	@Override
	protected ArrayList<Integer> createRandomChromosome(int chromosomeSize) {

		ArrayList<Integer> chrom = new ArrayList<Integer>(chromosomeSize);
		for (int i = 1; i <= hourCount; i++)
			chrom.add(i);
		for (int i = hourCount + 1; i <= chromosomeSize; i++)
			chrom.add(0); // empty slots in chromosome

		Random generator = new Random(); // randomizer: Fisher-Yates shuffle
		for (int i = chromosomeSize - 1; i >= 1; i--)
			Collections.swap(chrom, generator.nextInt(i + 1), i);
		return chrom;
	}

	@Override
	protected boolean isValid(ArrayList<Integer> chromosome) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected ArrayList<Integer> repairChromosome(ArrayList<Integer> chromosome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ArrayList<Integer> crossover(ArrayList<Integer> firstParent, ArrayList<Integer> secondParent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ArrayList<Integer> mutateChromosome(ArrayList<Integer> chromosome, double mutationRate) {
		// TODO Auto-generated method stub
		return null;
	}

}
