package logics;

import java.util.ArrayList;

/**
 * Created by jonathan on 5/11/17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Clause> clauses = new ArrayList<>();
        clauses.add(new Clause("A u -B u C"));
        clauses.add(new Clause("-A u B"));

        KnowledgeBase kb = new KnowledgeBase(clauses);

        System.out.println(kb);

        kb.calculate();
    }
}
