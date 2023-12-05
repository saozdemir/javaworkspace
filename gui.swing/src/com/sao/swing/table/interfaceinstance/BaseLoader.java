package com.sao.swing.table.interfaceinstance;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.swing.table.interfaceinstance
 * @date 22.Kas.2023
 * <p>
 * @description:
 */
public class BaseLoader {
    public static BaseInterface getInstance() throws Throwable {
        String className = System.getProperty(BaseInterface.class.getName());
        Class<BaseInterface> clazz = (Class<BaseInterface>) Class.forName(className);
        return clazz.newInstance();
    }
}
