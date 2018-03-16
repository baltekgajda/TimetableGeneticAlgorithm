package genetics;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Genotype<T> {
	
	private ArrayList<T> chromosome;
	private int chromosomeSize;
	abstract void createRandomChromosome();
	public Genotype(int chromosomeSize) throws InvalidParameterException {
		if(chromosomeSize>0)
			this.setChromosomeSize(chromosomeSize);
		else
			throw new InvalidParameterException("ChromosomeSize less or equal to zero");
		
		createRandomChromosome();
	}
	
	public Genotype(ArrayList<T> firstParent, ArrayList<T> secondParent) throws InvalidParameterException {
		int size = firstParent.size();
		if(secondParent.size()==size && size>0)
			this.chromosomeSize=size;
		else
			throw new InvalidParameterException("Wrong parent's ChromosomeSize");	
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
