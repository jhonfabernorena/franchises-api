package com.example.franquiciasapi.utils;

public class ValidationUtils {

    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidStock(int stock) {
        return stock >= 0;
    }
}