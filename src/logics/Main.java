package logics;

import java.util.ArrayList;

/**
 * Created by jonathan on 5/11/17.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Clause> clauses = new ArrayList<>();

        for (String s : args)
            clauses.add(new Clause(s));

        // Dev
        if (args.length == 0) {
            clauses.add(new Clause("A u -B u C"));
            clauses.add(new Clause("-A u C"));
            clauses.add(new Clause("B"));
        }

        KnowledgeBase kb = new KnowledgeBase(clauses);

        System.out.println(kb);

        kb.resolve();
    }
}
