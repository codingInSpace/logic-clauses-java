package logics;

/**
 * Created by jonathan on 5/11/17.
 */
public class Main {

    public static void main(String[] args) {
        KnowledgeBase kb = new KnowledgeBase();

        Clause c1 = new Clause("A u B u C");
        Clause c2 = new Clause("-A u B");

        kb.add(c1);
        kb.add(c2);

        System.out.println(kb);

        kb.calculate();
    }
}
