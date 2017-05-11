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
