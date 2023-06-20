import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestCode {
    public class Individual {
        int IndividualIndex;

        public Individual(int i) {
            this.IndividualIndex = i;
        }

        public void setIndividualIndex(int i) {
            this.IndividualIndex = i;
        }

        public int getIndividualIndex() {
            return this.IndividualIndex;
        }
    }

    public class IndividualofSPEA2 extends Individual {
        /**
         * row fitness
         */
        private int R;
        /**
         * density
         */
        private double D;

        public IndividualofSPEA2(int i) {
            super(i);
            this.R = 0;
            this.D = 0.0;
        }

        public void setD(double D) {
            this.D = D;
        }
        public void setR(int R) {
            this.R = R;
        }

        public int getR() {
            return this.R;
        }
        public double getD() {
            return this.D;
        }
    }

    public class Pop {
        /**
         * population size
         */
        private int popsize;
        /**
         * population
         */
        private Individual[] individuals;

        public Pop(int popsize) {
            this.popsize = popsize;
        }

        public void setIndividuals(Individual[] individuals) {
            this.individuals = individuals;
        }
        public void setIndividual(int i, Individual individual) {
            this.individuals[i] = individual;
        }

        public int getPopsize() {
            return this.popsize;
        }
        public Individual[] getIndividuals() {
            return this.individuals;
        };
        public Individual getIndividual(int i) {
            return this.individuals[i];
        };
    }

    public class PopofSPEA2 extends Pop{
        // /**
        //  * population
        //  */
        // private IndividualofSPEA2[] individuals;

        public PopofSPEA2(int popsize) {
            super(popsize);
            IndividualofSPEA2[] individuals = new IndividualofSPEA2[popsize];
            for (int i = 0; i < popsize; i++) {
                individuals[i] = new IndividualofSPEA2(i+3);
                individuals[i].setD(i+(new Random(i).nextDouble()));
                individuals[i].setR(i+(new Random(i).nextInt()));
            }
            super.setIndividuals(individuals);
        }

        public void setIndividual(int i, IndividualofSPEA2 individual) {
            super.setIndividual(i, individual); 
        }
        public void setD(int i, double d) {
            getIndividual(i).setD(d);
        }

        public IndividualofSPEA2[] getIndividuals() {
            return (IndividualofSPEA2[])super.getIndividuals();
        }
        public IndividualofSPEA2 getIndividual(int i) {
            return (IndividualofSPEA2)super.getIndividual(i);
        }
    }
    

    @Test
    public void test() {
        PopofSPEA2 pop = new PopofSPEA2(4);
        System.out.println(pop.getIndividual(0).getD());
        pop.setD(0, 3.3333);
        System.out.println(pop.getIndividual(0).getD());
    }
}