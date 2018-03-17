package genetics;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Genotype<T> {

	private ArrayList<T> chromosome;
	private int chromosomeSize;

	protected abstract ArrayList<T> createRandomChromosome(int chromosomeSize);

	protected abstract boolean isValid(ArrayList<T> chromosome);

	protected abstract ArrayList<T> repairChromosome(ArrayList<T> chromosome);

	protected abstract ArrayList<T> crossover(ArrayList<T> firstParent, ArrayList<T> secondParent);

	protected abstract ArrayList<T> mutateChromosome(ArrayList<T> chromosome, double mutationRate);

	public Genotype(int chromosomeSize) throws InvalidParameterException {
		if (chromosomeSize > 0)
			this.setChromosomeSize(chromosomeSize);
		else
			throw new InvalidParameterException("ChromosomeSize less or equal to zero");

		ArrayList<T> chrom = createRandomChromosome(chromosomeSize);
		if (!isValid(chrom))
			this.chromosome = repairChromosome(chrom); // if chromosome is not valid after repair there will be a
														// penalty points
	}

	public Genotype(ArrayList<T> firstParent, ArrayList<T> secondParent, double mutationRate)
			throws InvalidParameterException {
		int size = firstParent.size();
		if (secondParent.size() == size && size > 0)
			this.chromosomeSize = size;
		else
			throw new InvalidParameterException("Invalid parent's ChromosomeSize");

		if (mutationRate < 0 || mutationRate > 1)
			throw new InvalidParameterException("Invalid mutationRate");

		ArrayList<T> chrom = crossover(firstParent, secondParent);
		chrom = mutateChromosome(chrom, mutationRate);
		if (!isValid(chrom))
			this.chromosome = repairChromosome(chrom);
	}

	public int getChromosomeSize() {
		return chromosomeSize;
	}

	public void setChromosomeSize(int chromosomeSize) {
		this.chromosomeSize = chromosomeSize;
	}

	public ArrayList<T> getChromosome() {
		return chromosome;
	}

	public void setChromosome(ArrayList<T> chromosome) {
		this.chromosome = chromosome;
	}
}
