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

		this.hourCount = hourCount;
		ArrayList<Integer> chrom = createRandomChromosome(chromosomeSize);
		if (!isValid(chrom))
			this.chromosome = repairChromosome(chrom); // if chromosome is not valid
														// after repair there will be penalty points
	}

	public TimetableGen(TimetableGen firstParent, TimetableGen secondParent, double mutationRate)
			throws InvalidParameterException {
		super(firstParent, secondParent, mutationRate);

		int count = firstParent.hourCount;
		if (count != secondParent.hourCount || count < 0)
			throw new InvalidParameterException("Invalid hourCount");
		this.hourCount = count;
		
		ArrayList<Integer> chrom = crossover(firstParent.chromosome, secondParent.chromosome);
		chrom = mutateChromosome(chrom, mutationRate);
		if (!isValid(chrom))
			this.chromosome = repairChromosome(chrom);
	}

	@Override
	protected ArrayList<Integer> createRandomChromosome(int chromosomeSize) {

		ArrayList<Integer> chrom = new ArrayList<Integer>(chromosomeSize);
		for (int i = 1; i <= hourCount; i++)
			chrom.add(i);
		for (int i = hourCount + 1; i <= chromosomeSize; i++)
			chrom.add(0); // empty slots in chromosome
		Collections.shuffle(chrom, new Random());
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
		return chromosome;
	}

	@Override
	protected ArrayList<Integer> crossover(ArrayList<Integer> firstParent, ArrayList<Integer> secondParent) {
		// TODO Auto-generated method stub
		return chromosome;
	}

	@Override
	protected ArrayList<Integer> mutateChromosome(ArrayList<Integer> chromosome, double mutationRate) {
		// TODO Auto-generated method stub
		return chromosome;
	}

	@Override
	public String toString() {
		String string = new String("[");
		for (int i = 0; i < this.chromosome.size() - 1; i++) {
			string += this.chromosome.get(i);
			string += ", ";
		}
		string = string + this.chromosome.get(this.chromosome.size() - 1) + "]";
		return string;
	}

	public int getHourCount() {
		return hourCount;
	}

	public void setHourCount(int hourCount) {
		this.hourCount = hourCount;
	}
}
