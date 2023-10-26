package com.sao.lambda.syntax;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.lambda.syntax
 * @date 26.Eki.2023
 * <p>
 * @description:
 */
@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
