package com.sao.swing.table.interfaceinstance;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.interfaceinstance
 * @date 22.Kas.2023
 * <p>
 * @description:
 */
public class AppInstance {
    public static void main(String[] args) throws Throwable {
        BaseInterface loader = BaseLoader.getInstance();
        loader.loadUtils();
    }
}
