package com.mzaart.aquery.interfaces;

import android.view.View;

/**
 * This interface is to be implemented by classes that listen to View click events.
 *
 * @see View
 */
public interface OnClickListener {

    /**
     * This method is called when the view is clicked
     * @param view The view that is clicked
     */
    void onClick(View view);
}
