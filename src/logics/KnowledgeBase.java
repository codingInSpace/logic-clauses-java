package logics;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by jonathan on 5/11/17.
 */
public class KnowledgeBase {
    private Vector<Clause> data;

    public KnowledgeBase() {
        data = new Vector<>();
    }

    public void add(Clause clause) {
        data.add(clause);
    }

    @Override
    public String toString() {
        Iterator it = data.iterator();
        StringBuilder sb = new StringBuilder("");

        while (it.hasNext()) {
            sb.append(it.next().toString() + "\n");
        }

        return sb.toString();
    }
}
