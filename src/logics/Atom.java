package logics;

/**
 * Created by jonathan on 5/11/17.
 */
public class Atom {
    private Rule mRule;
    private Character mValue;
    private boolean signPositive;

    public Atom(Rule r, Character c, boolean sign) {
        mRule = r;
        mValue = c;
        signPositive = sign;
    }

    public void setRule(Rule rule) { mRule = rule; }
    public void setValue(Character value) { mValue = value; }
    public void setSign(boolean sign) { signPositive = sign; }

    @Override
    public String toString() {
        String sign = signPositive ? "" : "-";
        return mRule + " " + sign + mValue;
    }

    @Override
    public boolean equals(Object o) {
        Atom a2 = (Atom) o;
        return (this.mRule == a2.mRule && this.mValue == a2.mValue && this.signPositive == a2.signPositive);
    }
}
