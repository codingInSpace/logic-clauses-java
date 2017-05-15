package logics;

/**
 * Created by jonathan on 5/11/17.
 */
public class Atom {
    private Rule mRule;
    private String mValue;
    private boolean signPositive;

    public Atom(Rule r, String s, boolean sign) {
        mRule = r;
        mValue = s;
        signPositive = sign;
    }

    public Atom(String input) {
        String[] parts = input.split("(?!^)");
        boolean initializedSign = false;

        for (int i = 0; i < parts.length; i++) {
            switch(parts[i]) {
                case "u":
                    mRule = Rule.OR;
                    break;
                case "^":
                    mRule = Rule.AND;
                    break;
                case "-":
                    signPositive = false;
                    initializedSign = true;
                    break;
                default:
                    if (parts[i].matches("[A-Z]"))
                        mValue = parts[i];
            }
        }

        if (mRule == null)
            mRule = Rule.OR;

        // If nothing else, sign is positive
        if (!initializedSign)
            signPositive = true;
    }

    public void setRule(Rule rule) { mRule = rule; }
    public void setValue(String value) { mValue = value; }
    public void setSign(boolean sign) { signPositive = sign; }

    public String getValue() { return mValue; }
    public boolean getSign() { return signPositive; }
    public Rule getRule() { return mRule; }

    public String prettyPrint(boolean showFirstRule) {
        StringBuilder sb = new StringBuilder("");

        sb.append(showFirstRule ? mRule + " ": "");
        sb.append(signPositive ? "" : "-");
        sb.append(mValue);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(mRule + " ");
        sb.append(signPositive ? "" : "-");
        sb.append(mValue);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        Atom a2 = (Atom) o;
        return (this.mRule == a2.mRule && this.mValue == a2.mValue && this.signPositive == a2.signPositive);
    }
}
