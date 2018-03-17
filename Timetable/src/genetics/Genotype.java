package genetics;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Genotype<T> {

	// TODO czy powinien byc private?
	protected ArrayList<T> chromosome;

	protected abstract ArrayList<T> createRandomChromosome(int chromosomeSize);

	protected abstract boolean isValid(ArrayList<T> chromosome);

	protected abstract ArrayList<T> repairChromosome(ArrayList<T> chromosome);

	protected abstract ArrayList<T> crossover(ArrayList<T> firstParent, ArrayList<T> secondParent);

	protected abstract ArrayList<T> mutateChromosome(ArrayList<T> chromosome, double mutationRate);

	public abstract String toString();

	public Genotype(int chromosomeSize) throws InvalidParameterException {

		if (chromosomeSize <= 0)
			throw new InvalidParameterException("Invalid chromosomeSize");
		this.chromosome = null;
	}

	public Genotype(Genotype<T> firstParent, Genotype<T> secondParent, double mutationRate)
			throws InvalidParameterException {

		if (firstParent == null || secondParent == null || firstParent.chromosome == null
				|| secondParent.chromosome == null || firstParent.chromosome.size() == 0
				|| secondParent.chromosome.size() == 0)
			throw new InvalidParameterException("Invalid parent's chromosomes");

		if (mutationRate < 0 || mutationRate > 1)
			throw new InvalidParameterException("Invalid mutationRate");
		this.chromosome = null;
	}

	public ArrayList<T> getChromosome() {
		return chromosome;
	}

	public void setChromosome(ArrayList<T> chromosome) {
		this.chromosome = chromosome;
	}
}
