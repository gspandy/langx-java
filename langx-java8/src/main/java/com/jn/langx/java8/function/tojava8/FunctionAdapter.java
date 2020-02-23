package com.jn.langx.java8.function.tojava8;

import java.util.function.Function;

public class FunctionAdapter<I, O> implements Function<I, O> {
    private com.jn.langx.util.function.Function<I, O> delegate;

    public FunctionAdapter(com.jn.langx.util.function.Function<I, O> delegate) {
        this.delegate = delegate;
    }

    @Override
    public O apply(I input) {
        return delegate.apply(input);
    }
}
