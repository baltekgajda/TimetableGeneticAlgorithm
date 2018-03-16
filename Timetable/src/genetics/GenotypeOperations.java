package genetics;

import java.util.ArrayList;

public interface GenotypeOperations<T> {
	ArrayList<T> createRandomGenotype();
	ArrayList<T> crossover(ArrayList<T> firstGenotype, ArrayList<T> secondGenotype);
	ArrayList<T> mutate(ArrayList<T> genotype);
}
