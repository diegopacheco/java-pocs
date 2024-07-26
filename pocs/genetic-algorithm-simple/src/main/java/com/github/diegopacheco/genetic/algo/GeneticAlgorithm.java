package com.github.diegopacheco.genetic.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {
    // Number of individuals in each generation
    private static final int POPULATION_SIZE = 100;

    // Valid Genes
    private static final String GENES = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890, .-;:_!\"#%&/()=?@${[]}";

    // Target string to be generated
    private static final String TARGET = "I love Java 21 and Testing";

    // Function to generate random numbers in given range
    private static int randomNum(int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start + 1) + start;
    }

    // Create random genes for mutation
    private static char mutatedGenes() {
        int len = GENES.length();
        int r = randomNum(0, len - 1);
        return GENES.charAt(r);
    }

    // Create chromosome or string of genes
    private static String createGnome() {
        int len = TARGET.length();
        StringBuilder gnome = new StringBuilder();
        for (int i = 0; i < len; i++)
            gnome.append(mutatedGenes());
        return gnome.toString();
    }

    // Class representing individual in population
    private static class Individual implements Comparable<Individual> {
        String chromosome;
        int fitness;

        Individual(String chromosome) {
            this.chromosome = chromosome;
            fitness = calFitness();
        }

        // Perform mating and produce new offspring
        Individual mate(Individual par2) {
            StringBuilder childChromosome = new StringBuilder();

            int len = chromosome.length();
            for (int i = 0; i < len; i++) {
                // random probability
                float p = randomNum(0, 100) / 100f;

                // if prob is less than 0.45, insert gene from parent 1
                if (p < 0.45)
                    childChromosome.append(chromosome.charAt(i));

                    // if prob is between 0.45 and 0.90, insert gene from parent 2
                else if (p < 0.90)
                    childChromosome.append(par2.chromosome.charAt(i));

                    // otherwise insert random gene(mutate), for maintaining diversity
                else
                    childChromosome.append(mutatedGenes());
            }

            // create new Individual(offspring) using generated chromosome for offspring
            return new Individual(childChromosome.toString());
        }

        // Calculate fitness score, it is the number of characters in string which differ from target string
        private int calFitness() {
            int len = TARGET.length();
            int fitness = 0;
            for (int i = 0; i < len; i++) {
                if (chromosome.charAt(i) != TARGET.charAt(i))
                    fitness++;
            }
            return fitness;
        }

        @Override
        public int compareTo(Individual o) {
            return Integer.compare(this.fitness, o.fitness);
        }
    }

    // Driver code
    public static void main(String[] args) {
        // current generation
        int generation = 0;

        List<Individual> population = new ArrayList<>();
        boolean found = false;

        // create initial population
        for (int i = 0; i < POPULATION_SIZE; i++) {
            String gnome = createGnome();
            population.add(new Individual(gnome));
        }

        while (true) {
            // sort the population in increasing order of fitness score
            Collections.sort(population);

            // if the individual having lowest fitness score i.e. 0 then we know that we have reached to the target
            // and break the loop
            if (population.getFirst().fitness <= 0) {
                break;
            }

            // Otherwise generate new offsprings for new generation
            List<Individual> newGeneration = new ArrayList<>();

            // Perform Elitism, that mean 10% of fittest population goes to the next generation
            int s = (10 * POPULATION_SIZE) / 100;
            for (int i = 0; i < s; i++)
                newGeneration.add(population.get(i));

            // From 50% of fittest population, Individuals will mate to produce offspring
            s = (90 * POPULATION_SIZE) / 100;
            for (int i = 0; i < s; i++) {
                int len = population.size();
                int r = randomNum(0, 50);
                Individual parent1 = population.get(r);
                r = randomNum(0, 50);
                Individual parent2 = population.get(r);
                Individual offspring = parent1.mate(parent2);
                newGeneration.add(offspring);
            }
            population = newGeneration;
            System.out.print("Generation: " + generation + "\t");
            System.out.print("String: " + population.get(0).chromosome + "\t");
            System.out.println("Fitness: " + population.get(0).fitness);

            generation++;
        }
        System.out.print("Generation: " + generation + "\t");
        System.out.print("String: " + population.get(0).chromosome + "\t");
        System.out.println("Fitness: " + population.get(0).fitness);
    }
}