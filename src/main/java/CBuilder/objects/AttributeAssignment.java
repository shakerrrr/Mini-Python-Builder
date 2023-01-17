package CBuilder.objects;

import CBuilder.Expression;
import CBuilder.Statement;

/**
 * Assign a value to the attribute of an object.
 */
public class AttributeAssignment implements Statement {

    /**
     * The reference of the attribute in the object scope.
     */
    private AttributeReference attribute;

    /**
     * The value to assign to the attribute.
     */
    private Expression value;

    private String type;

    /**
     * Create a new attribute assignment.
     *
     * @param attribute The reference of the attribute in the object scope.
     * @param value     The value to assign to the attribute.
     */
    public AttributeAssignment(AttributeReference attribute, Expression value) {
        this.attribute = attribute;
        this.value = value;
        this.type = null;
    }

    public AttributeAssignment(AttributeReference attribute, Expression value, String type) {
        this.attribute = attribute;
        this.value = value;
        this.type = type;
    }

    @Override
    public String buildStatement() {
        return "tmp_attr_obj = __mpy_obj_init_object_w_type(" + "\"" + type + "\"" + ");\n" +
                "__mpy_obj_ref_inc(tmp_attr_obj);\n" +
                "tmp_attr_obj = __mpy_type_check(tmp_attr_obj, " + value.buildExpression() + ");\n" +
                "__mpy_obj_ref_inc(tmp_attr_obj);\n" +
                "__mpy_obj_set_attr(" + attribute.buildObject() + ", " + attribute.buildName() + ", tmp_attr_obj);\n";
    }
}
