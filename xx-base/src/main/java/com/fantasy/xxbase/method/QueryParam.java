package com.fantasy.xxbase.method;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class QueryParam{

    private String field;

    private String value;

    private Operator ops = Operator.EQ;

    public QueryParam(String field, String value, Operator ops) {
        this.field = field;
        this.value = value;
        this.ops = ops;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operator getOps() {
        return ops;
    }

    public void setOps(Operator ops) {
        this.ops = ops;
    }
}
