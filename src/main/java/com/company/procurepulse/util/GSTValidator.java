package com.company.procurepulse.util;

public class GSTValidator {

    public static boolean isValid(String gst) {
        return gst != null && gst.matches("\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}[A-Z\\d]{1}Z[A-Z\\d]{1}");
    }
}
