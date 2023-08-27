package com.sao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author saozd
 * @project com.sao.annotation javaworkspace
 * @date 28.08.2023 Ağu 2023
 * <p>
 * @description:
 */
@Target(ElementType.TYPE)
public @interface doc_class {
    String name();

    String function();
}
