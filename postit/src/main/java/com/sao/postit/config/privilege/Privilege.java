package com.sao.postit.config.privilege;

/**
 * @author saozd
 * @project com.sao.postit.config.privilege courseexample
 * 3.06.2023 Haz 2023
 */
public final class Privilege {
    private Privilege() {
    }

    public static final int SUPER_USER = 1;
    public static final int GROUP_ADMIN = 2;
    public static final int GROUP_MODERATOR = 3;
    public static final int GROUP_MEMBERS = 4;

}
