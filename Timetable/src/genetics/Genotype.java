package genetics;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public abstract class Genotype<T> {
	
	private ArrayList<T> chromosome;
	private int chromosomeSize;
	
	protected abstract ArrayList<T> createRandomChromosome(int chromosomeSize);
	protected abstract boolean isValid(ArrayList<T> chromosome);
	protected abstract ArrayList<T> repairChromosome(ArrayList<T> chromosome);
	
	public Genotype(int chromosomeSize) throws InvalidParameterException {
		if(chromosomeSize>0)
			this.setChromosomeSize(chromosomeSize);
		else
			throw new InvalidParameterException("ChromosomeSize less or equal to zero");
		
		 ArrayList<T> chrom = createRandomChromosome(chromosomeSize);
		do {
		 chrom = createRandomChromosome(chromosomeSize);
		 if(!isValid(chrom))
			 chrom=repairChromosome(chrom);
		} while(!isValid(chrom));
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
