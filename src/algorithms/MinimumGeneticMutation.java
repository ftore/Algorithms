package algorithms;

import java.util.*;

public class MinimumGeneticMutation {
    class GeneNode {
        String gene;
        int numOfSteps;

        public GeneNode(String gene, int steps) {
            this.gene = gene;
            this.numOfSteps = steps;
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        if(bank == null || bank.length == 0) return -1;
        if(start == end) return 0;
        char[] geneSet = {'A', 'C', 'G', 'T'};

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        Queue<GeneNode> toExplore = new LinkedList<>();
        toExplore.add(new GeneNode(start, 0));

        while(!toExplore.isEmpty()) {
            GeneNode curr = toExplore.poll();

            if(curr.gene.equals(end)) {
                return curr.numOfSteps;
            }

            char[] word = curr.gene.toCharArray();
            for(int i = 0; i < word.length; i++) {
                for(int j = 0; j < geneSet.length; j++) {
                    char tmp = word[i];

                    if(word[i] != geneSet[j]) {
                        word[i] = geneSet[j];
                    }

                    String needle = new String(word);
                    if(bankSet.contains(needle)) {
                        toExplore.add(new GeneNode(needle, curr.numOfSteps + 1));
                        bankSet.remove(needle);
                    }

                    word[i] = tmp;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation gm = new MinimumGeneticMutation();
        System.out.println(gm.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
