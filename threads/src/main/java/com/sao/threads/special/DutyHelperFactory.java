package com.sao.threads.special;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 20 May 2024
 * <p>
 * @description:
 */
public class DutyHelperFactory {
    static IDutyHelper createInstance(){
        return new DutyHelperAdapter();
    }
}
