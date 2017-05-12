package logics;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by jonathan on 5/11/17.
 */
public class Clause {
    private HashSet<Atom> atoms;

    public Clause() {
        atoms = new HashSet<>();
    }

    public Clause(String inputString) {
        atoms = new HashSet<>();

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

    public void add(Atom atom) {
        atoms.add(atom);
    }

    public HashSet<Atom> getAtoms() {
        return atoms;
    }

    @Override
    public String toString() {
        Iterator it = atoms.iterator();
        StringBuilder sb = new StringBuilder("");

        while (it.hasNext()) {
            sb.append(it.next().toString() + "\n");
        }

        return sb.toString();
    }
}
