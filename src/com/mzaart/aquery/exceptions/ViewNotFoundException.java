package com.mzaart.aquery.exceptions;

/**
 * Signals that an AQuery object is being constructed from an ID that doesn't correspond to
 * any view.
 *
 * <pre>
 *     {@code
 *     $(this, -1).click({
 *         $.toast(this, "This non-existent view is clicked"); // throws ViewNotFoundException
 *     });
 *     }
 * </pre>
 */
public class ViewNotFoundException extends RuntimeException {

    public ViewNotFoundException() {
        super("View not found. The id used doesn't correspond to any view");
    }
}
