package CBuilder;

/**
 * Representation of a reference to a MiniPython variable, i. e. a variable
 * name.
 */
public class Reference implements Expression {

    /**
     * The name of the reference.
     */
    protected String name;

    /**
     * The datatype of the reference.
     */
    protected String type;

    /**
     * Create a new reference for the given name.
     *
     * @param name The name of the reference which should be created.
     * @param type The datatype of the reference which should be created.
     */
    public Reference(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Get the reference name.
     *
     * @return The name of the reference.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the reference type.
     *
     * @return The type of the reference.
     */
    public String getType() {
        return this.type;
    }

    @Override
    public String buildExpression() {
        return name;
    }

    @Override
    public String buildStatement() {
        return name + ";\n";
    }

}
