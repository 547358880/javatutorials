package com.ericaShy.validating;

import com.google.common.base.VerifyException;
import static com.google.common.base.Verify.*;

public class GuavaAssertions {

    /**
     * 输出:
     * com.google.common.base.VerifyException
     * Bad match
     * Bad math: not 4
     * expected a non-null reference
     * Shouldn't be null: arg s
     */
    public static void main(String[] args) {
        verify(2 + 2 == 4);

        try {
            verify(1 + 2 == 4);
        } catch (VerifyException e) {
            System.out.println(e);
        }

        try {
            verify(1 + 2 == 4, "Bad match");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }


        try {
            verify(1 + 2 == 4, "Bad math: %s", "not 4");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        String s = "";
        s = verifyNotNull(s);
        s = null;
        try {
            verifyNotNull(s);
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }

        try {
            verifyNotNull(s, "Shouldn't be null: %s", "arg s");
        } catch (VerifyException e) {
            System.out.println(e.getMessage());
        }
    }

}
