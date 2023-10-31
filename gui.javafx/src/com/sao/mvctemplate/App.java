package com.sao.mvctemplate;

/**
 * @author xsaozdemir
 * @project javaworkspace com.sao.mvctemplate
 * @date 31.Eki.2023
 * <p>
 * @description: Main metoduna sahip bir classı başka bir main metoduna sahip class içinde çağırma.
 */
public class App {
    public static void main(String[] args) {
        AppMvc app = new AppMvc();
        app.main(args);
    }
}
