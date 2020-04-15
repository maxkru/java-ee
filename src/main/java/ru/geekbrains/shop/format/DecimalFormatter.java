package ru.geekbrains.shop.format;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Named
@ApplicationScoped
public class DecimalFormatter {
    private static final DecimalFormat format = new DecimalFormat("# ###.00");

    public String format(BigDecimal n) {
        return format.format(n);
    }
}