package logics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by jonathan on 5/11/17.
 */
public class KnowledgeBase {
    private LinkedList<Clause> data;

    public KnowledgeBase() {
        data = new LinkedList<>();
    }

    public KnowledgeBase(Collection<Clause> collection) {
        data = new LinkedList<>();
        data.addAll(collection);
    }

    public void add(Clause clause) {
        data.add(clause);
    }

    public void resolve() {
        boolean newConsequences = true;

        int counter = 0;

        while (newConsequences) {
            LinkedList<Clause> newData = new LinkedList<>();

            System.out.println("New iteration:");
            System.out.println(this);

            if (counter > 6) break;
            counter++;

            newConsequences = false;

            for (int i = 0; i < data.size() - 1; i++) {
                for (int j = i + 1; j < data.size(); j++) {
                    Clause c = infer(data.get(i), data.get(j));

                    if (c != null) {
                        newData.add(c);
                        newConsequences = true;
                    }
                }
                //System.out.println(i);
            }

            if (newData.size() > 0) {
                data.addAll(newData);

                // Simplify KB by pruning clauses for which there are subsets
                for (int i = 0; i < data.size() - 1; i++) {
                    for (int j = i + 1; j < data.size(); j++) {
                        if (data.get(i).isSubset(data.get(j)) && !data.get(j).pruned) {
                            data.get(j).prune();
                        }

                        else if (data.get(j).isSubset(data.get(i)) && !data.get(i).pruned)
                            data.get(i).prune();
                    }
                }

                // Remove pruned
                data.removeIf(clause -> clause.pruned);

                // Prune duplicates
                for (int i = 0; i < data.size() - 1; i++) {
                    for (int j = i + 1; j < data.size(); j++) {
                        if (data.get(i).equals(data.get(j))) {
                            if (data.get(i).pruned)
                                continue;

                            if (data.get(j).pruned)
                                continue;

                            data.get(j).prune();
                        }
                    }
                }

                // Remove pruned
                data.removeIf(clause -> clause.pruned);
            }
        }

        System.out.println("inference complete");
        System.out.println(this);
    }

    private Clause infer(Clause c1, Clause c2) {
        boolean nothingChanged = true;

        //System.out.println("comparing:");
        //System.out.println(c1);
        //System.out.println(c2);

        ArrayList<Atom> combinedAtoms = new ArrayList<>();

        combinedAtoms.addAll(c1.list());
        combinedAtoms.addAll(c2.list());

        for (int i = 0; i < c1.list().size(); i++) {
            for (int j = 0; j < c2.list().size(); j++) {
                Atom a1 = c1.list().get(i);
                Atom a2 = c2.list().get(j);

                // Check for neutralizing signs atoms
                if (a1.getValue().equals(a2.getValue()) && a1.getSign() != a2.getSign()) {
                    nothingChanged = false;

                    // Remove a1 and a2 from new clause
                    combinedAtoms.remove(a1);
                    combinedAtoms.remove(a2);
                }

                // Check for duplicated union atoms
                if (a1.getValue().equals(a2.getValue())
                        && a1.getSign() == a2.getSign()
                        && a1.getRule() == Rule.OR
                        && a2.getRule() == Rule.OR) {
                    nothingChanged = false;

                    // Remove one of the atoms from new clause
                    combinedAtoms.remove(a1);
                }
            }
        }

        if (nothingChanged) {
            return null;
        }
        else {
            return new Clause(combinedAtoms);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (Clause c : data) {
            if (!c.pruned)
                sb.append(c.toString() + "\n");
        }

        return sb.toString();
    }
}
