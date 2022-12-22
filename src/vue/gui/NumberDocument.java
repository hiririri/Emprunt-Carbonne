package vue.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

/**
 * The type Number document.
 *
 * @author Qinming JIANG
 * @version 1.0
 */
public class NumberDocument extends PlainDocument {
    /**
     * Instantiates a new Number document.
     */
    public NumberDocument() {
    }

    /**
     * Insert a string type into NuberDocument
     *
     * @param var1 var1
     * @param var2 var2
     * @param var3 var3
     * @throws BadLocationException
     * @see PlainDocument
     */
    public void insertString(int var1, String var2, AttributeSet var3) throws BadLocationException {
        if (this.isNumeric(var2)) {
            super.insertString(var1, var2, var3);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }

    }

    /**
     * Check an input is numeric.
     *
     * @param var1 input
     * @return true if it's numeric, else false.
     */
    private boolean isNumeric(String var1) {
        try {
            Long.valueOf(var1);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }
}