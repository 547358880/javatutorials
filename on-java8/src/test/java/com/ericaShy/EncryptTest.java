package com.ericaShy;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.Test;

public class EncryptTest {

//    @Test
    /**
     * salt = 78bb6456be9052a068ced84c7f6bc86a70d99e1f4680367446d27cdf2b7c54f3
     * 明文: 123456
     * 加密: $2y$10$KAvOE0wF.6O6l0GXEAHaXe3JzhmtjMXUueSEuiXi95xkPnDSTrWQC
     */
    public void test() {


        String hash = "$2y$10$KAvOE0wF.6O6l0GXEAHaXe3JzhmtjMXUueSEuiXi95xkPnDSTrWQC";
        BCrypt.Result res = BCrypt.verifyer().verify("123456".toCharArray(), hash);
        System.out.println(res.verified);

//        System.out.println(hash);

//        boolean s = BCrypt.checkpw("123456", "$2y$10$78bb6456be9052a068ceduY40Jtqtbid1CCgRNS2FJ/M0VNHuEnXu");
//
//        System.out.println(s);
    }

}
