package com.github.w4o.boot.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @author frank
 * @date 2020/4/22
 */
public class DesUtils {

    private final static String ALGORITHM = "DES";

    /**
     * DES加密
     *
     * @param str  待加密字符串
     * @param pass 密码
     * @return 加密后字符串；当出现异常时，返回值为null
     */
    public static String encrypt(@NotNull String str, @NotNull String pass) {

        try {
            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, makeKey(pass), random);
            byte[] result = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密
     *
     * @param str  加密字符串
     * @param pass 密码
     * @return 解密后字符串；当出现异常时，返回值为空字符串
     */
    public static String decrypt(@NotNull String str, @NotNull String pass) {

        try {
            SecureRandom random = new SecureRandom();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, makeKey(pass), random);
            byte[] result = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Key makeKey(String str) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        DESKeySpec desKey = new DESKeySpec(str.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(desKey);
    }


}
