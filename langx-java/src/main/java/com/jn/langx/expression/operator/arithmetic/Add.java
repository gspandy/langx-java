package com.jn.langx.expression.operator.arithmetic;

import com.jn.langx.expression.operator.AbstractBinaryOperator;
import com.jn.langx.expression.value.NumberExpression;
import com.jn.langx.expression.value.NumberResultExpression;
import com.jn.langx.util.Numbers;

public class Add extends AbstractBinaryOperator<NumberResultExpression<Number>, NumberResultExpression<Number>, NumberResultExpression<Number>> {

    public Add() {
        setOperateSymbol("+");
    }

    @Override
    public NumberResultExpression<Number> execute() {
        NumberExpression<Number> expression = new NumberExpression<Number>();
        expression.setValue(Numbers.add(getLeft().execute(), getRight().execute()));
        return expression;
    }
}