package ru.geekbrains.shop.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalFormatter {
    private static DecimalFormat format = new DecimalFormat("# ###.00");

    public static String format(BigDecimal n) {
        return format.format(n);
    }
}
