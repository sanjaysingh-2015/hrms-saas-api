package com.hewhorizon.hrms.saas.configs;

public class UserContext {

    private static final ThreadLocal<Long> CURRENT = new ThreadLocal<>();

    public static void set(Long userId) { CURRENT.set(userId); }

    public static Long get() { return CURRENT.get(); }

    public static void clear() { CURRENT.remove(); }
}
