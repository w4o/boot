package com.github.w4o.boot.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by Frank on 2018/6/26.
 *
 * @author Frank
 */
public class AesUtils {

    private final static String ALGORITHM = "AES";

    private final static String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static final byte[] IVK = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /**
     * AES加密
     *
     * @param str  待加密字符串
     * @param pass 密码
     * @return 加密后字符串；当出现异常时，返回值为null
     */
    public static String encrypt(@NotNull String str, @NotNull String pass) {

        try {
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, makeKey(pass), makeVi());
            byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            //此处使用BASE64做转码功能
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * AES解密
     *
     * @param str  加密字符串
     * @param pass 密码
     * @return 解密后字符串；当出现异常时，返回值为空字符串
     */
    public static String decrypt(@NotNull String str, @NotNull String pass) {

        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, makeKey(pass), makeVi());
            //先用BASE64解密
            byte[] decrypted = Base64.decodeBase64(str);
            return new String(cipher.doFinal(decrypted), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Key makeKey(String keyStr) {
        byte[] raw = keyStr.getBytes(StandardCharsets.US_ASCII);
        return new SecretKeySpec(raw, ALGORITHM);
    }

    private static AlgorithmParameterSpec makeVi() {
        return new IvParameterSpec(IVK);
    }
}
