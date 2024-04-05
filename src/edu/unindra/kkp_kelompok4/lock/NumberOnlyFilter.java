package edu.unindra.kkp_kelompok4.lock;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberOnlyFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (isNumber(text)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException {
        if (isNumber(text)) {
            super.replace(fb, offset, length, text, attr);
        }
    }

    private boolean isNumber(String text) {
        return text.matches("\\d+");
    }

    public static String formatCurrency(int value) {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator(',');
    DecimalFormat decimalFormat = new DecimalFormat("#,##0", symbols);
    return decimalFormat.format(value);
}

}
