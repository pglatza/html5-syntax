/*
 * Copyright (c) 2007 Mozilla Foundation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a 
 * copy of this software and associated documentation files (the "Software"), 
 * to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Software, and to permit persons to whom the 
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */

package org.whattf.datatype;

import java.util.List;

import org.relaxng.datatype.DatatypeException;

public class Circle extends AbstractInt {

    /**
     * The singleton instance.
     */
    public static final Circle THE_INSTANCE = new Circle();
    
    /**
     * 
     */
    private Circle() {
        super();
    }

    @Override
    public void checkValid(CharSequence literal) throws DatatypeException {
        List<CharSequenceWithOffset> list = splitOnComma(literal);
        if (list.size() != 3) {
            throw newDatatypeException("A circle must have three comma-separated integers.");
        }
        CharSequenceWithOffset withOffset = list.get(0);
        checkInt(withOffset.getSequence(), withOffset.getOffset());
        withOffset = list.get(1);
        checkInt(withOffset.getSequence(), withOffset.getOffset());
        withOffset = list.get(2);
        checkIntNonNegative(withOffset.getSequence(), withOffset.getOffset());
    }

    @Override
    public String getName() {
        return "circle";
    }

}
