package CBuilder.objects.functions;

import CBuilder.Expression;
import CBuilder.Statement;

/**
 * A return statement inside a function.
 */
public class ReturnStatement implements Statement {

    private Expression returnValue;
    private String returnType;

    /**
     * Create a new return statement.
     *
     * @param returnValue return value of this return statement
     */
    public ReturnStatement(Expression returnValue) {
        this.returnValue = returnValue;
        this.returnType = null;
    }

    public ReturnStatement(Expression returnValue, String returnType) {
        this.returnValue = returnValue;
        this.returnType = returnType;
    }

    @Override
    public String buildStatement() {
        // Note: retVal and goto ret depend on the implementation of
        // Function#buildCFunction
        // I'm sorry for all the hidden interdependencies in this stuff, but I have no
        // idea
        // how this could have been solved better
        if (returnType != null) {
            return "__MPyObj *tmp_ret" + " = __mpy_obj_init_object_w_type(" + "\"" + returnType + "\"" + ");\n" +
                    "retValue = " + "__mpy_type_check(tmp_ret, " + returnValue.buildExpression() + ");\n" +
                    "goto ret;\n";
        }
        return "retValue = " + returnValue.buildExpression() + ";\n" +
                "goto ret;\n";
    }
}
