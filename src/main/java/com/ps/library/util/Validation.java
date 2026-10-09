package com.ps.library.util;

public final class Validation {
    private Validation() {}
    public static void checkNotBlank(String name, String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException(name + " cannot be blank");
    }
    public static void checkPositive(String name, int value) {
        if (value <= 0) throw new IllegalArgumentException(name + " must be positive");
    }
}
