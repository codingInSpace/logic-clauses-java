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
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < data.size(); i++) {
            sb.append(data.get(i).toString() + "\n");
        }

        return sb.toString();
    }
}
