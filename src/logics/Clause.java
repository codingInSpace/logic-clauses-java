package logics;

import java.util.ArrayList;

/**
 * Created by jonathan on 5/11/17.
 */
public class Clause {
    private ArrayList<Atom> atoms;
    public boolean pruned;

    public Clause(String inputString) {
        atoms = new ArrayList<>();
        pruned = false;

        // Split input into parts separated by capital letters
        String[] parts = inputString.split("(?<=[A-Z])");

        // Remove whitespaces from parts
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replaceAll("\\s+","");
        }

        // Make atom objects out of parts
        for (int i = 0; i < parts.length; i++) {
            Atom a = new Atom(parts[i]);
            add(a);
        }
    }

    public Clause(ArrayList<Atom> list) {
        atoms = new ArrayList<>();
        pruned = false;

        for (Atom a : list) {
            add(a);
        }
    }

    public void add(Atom atom) {
        atoms.add(atom);
    }

    public void prune() {
        pruned = true;
    }

    public ArrayList<Atom> list() {
        return atoms;
    }

    public boolean isSubset(Clause c2) {
        for (Atom atom : atoms)
            if (!c2.list().contains(atom))
                return false;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Clause: ");

        for (int i = 0; i < atoms.size(); i++) {
            sb.append(atoms.get(i).prettyPrint(i > 0) + " ");
        }

        return sb.toString();
    }
}
