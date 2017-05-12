package logics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

    public Clause(Collection<Atom> collection) {
        Iterator it = collection.iterator();
        System.out.println((Atom) it.next());

        while(it.hasNext()) {
            Atom a = (Atom) it.next();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Clause: ");

        for (int i = 0; i < atoms.size(); i++) {
            sb.append(atoms.get(i).toString() + " ");
        }

        return sb.toString();
    }
}
