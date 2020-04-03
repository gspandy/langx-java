package com.jn.langx.expression.value;


import com.jn.langx.expression.Expression;

public class ValueExpression<E> implements Expression<E> {
    private E value;

    public ValueExpression(){}
    public ValueExpression(E value){
        setValue(value);
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public E execute() {
        return value;
    }

    @Override
    public String toString() {
        return value == null ? "" : value.toString();
    }
}