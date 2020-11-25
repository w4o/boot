package com.github.w4o.boot.other;

import com.github.w4o.boot.util.AesUtils;
import com.github.w4o.boot.util.DesUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.text.translate.UnicodeEscaper;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author frank
 * @date 2020/4/21
 */
@Slf4j
public class Encryption {

    private final String str = "123456";
    private final String pass = "1234567890123456";
    private final String urlStr = "https://wuzhuti.cn";

    @Test

    public void md5() {
        String md5Str = DigestUtils.md5Hex(str);
        log.info(md5Str);
        assertEquals("e10adc3949ba59abbe56e057f20f883e", md5Str);
    }

    @Test
    public void sha1() {
        String sha1Str = DigestUtils.sha1Hex(str);
        log.info(sha1Str);
        assertEquals("7c4a8d09ca3762af61e59520943dc26494f8941b", sha1Str);
    }

    @Test
    public void sha224() {
        String sha224Str = DigestUtils.sha3_224Hex(str);
        log.info(sha224Str);
        assertEquals("f8cdb04495ded47615258f9dc6a3f4707fd2405434fefc3cbf4ef4e6", sha224Str);
    }

    @Test
    public void sha256() {
        String sha256Str = DigestUtils.sha256Hex(str);
        log.info(sha256Str);
        assertEquals("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92", sha256Str);
    }

    @Test
    public void sha384() {
        String sha384Str = DigestUtils.sha3_384Hex(str);
        log.info(sha384Str);
        assertEquals("0a989ebc4a77b56a6e2bb7b19d995d185ce44090c13e2984b7ecc6d446d4b61ea9991b76a4c2f04b1b4d244841449454", sha384Str);
    }

    @Test
    public void sha512() {
        String sha512Str = DigestUtils.sha512Hex(str);
        log.info(sha512Str);
        assertEquals("ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413", sha512Str);
    }

    @Test
    public void hmacMd5() {
        String hmacMd5Str = new HmacUtils(HmacAlgorithms.HMAC_MD5, pass).hmacHex(str);
        log.info(hmacMd5Str);
        assertEquals("8c7498982f41b93eb0ce8216b48ba21d", hmacMd5Str);
    }

    @Test
    public void hmacSha1() {
        String hmacSha1Str = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, pass).hmacHex(str);
        log.info(hmacSha1Str);
        assertEquals("55258d1577e99ab6485737b5948d8e22aad3452b", hmacSha1Str);
    }

    @Test
    public void hmacSha224() {
        String hmacSha224Str = new HmacUtils(HmacAlgorithms.HMAC_SHA_224, pass).hmacHex(str);
        log.info(hmacSha224Str);
        assertEquals("56f9c59fea3b8094bae31e4b953758354055879451b1cddef5e5c1da", hmacSha224Str);
    }

    @Test
    public void hmacSha256() {
        String hmacSha256Str = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, pass).hmacHex(str);
        log.info(hmacSha256Str);
        assertEquals("25eab476e7eb3ad282161b3aa8c03a63263cb9dacf6470ab1fa8dfc73f939481", hmacSha256Str);
    }

    @Test
    public void hmacSha384() {
        String hmacSha384Str = new HmacUtils(HmacAlgorithms.HMAC_SHA_384, pass).hmacHex(str);
        log.info(hmacSha384Str);
        assertEquals("57cf5176f26e01af6f2be5756ada79b77e310320cde5e09a4738cd7d9b1dbf1032fdb40defd93c80f926795292efa9bd", hmacSha384Str);
    }

    @Test
    public void hmacSha512() {
        String hmacSha512Str = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, pass).hmacHex(str);
        log.info(hmacSha512Str);
        assertEquals("d4821b05479d5de75f6404d596d1db622eae4f0acd360112bdb16eb62c0fe9051e5948b03c61f1da3b0d662fd7f84ddf588cdc2c55d29d85e9c51d71cc1a7644", hmacSha512Str);
    }

    @Test
    public void base64() {
        String base64EncodeStr = Base64.encodeBase64String(str.getBytes());
        assertEquals("MTIzNDU2", base64EncodeStr);
        String base64DecodeStr = new String(Base64.decodeBase64(base64EncodeStr));
        assertEquals(str, base64DecodeStr);
    }

    @Test
    public void aes() {

        // TODO Wrong IV length: must be 16 bytes long
        String encryptStr = AesUtils.encrypt(str, pass);
        log.info(encryptStr);
        String decryptStr = AesUtils.decrypt(encryptStr, pass);
        log.info(decryptStr);
        assertEquals(str, decryptStr);
    }

    @Test
    public void des() {
        // TODO Wrong key size
        String encryptStr = DesUtils.encrypt(str, pass);
        String decryptStr = DesUtils.decrypt(encryptStr, pass);

        assertEquals(str, decryptStr);
    }

    @Test
    public void bCrypt() {
        String encodeStr = new BCryptPasswordEncoder().encode(str);
        log.info(encodeStr);
        boolean result = new BCryptPasswordEncoder().matches(str, encodeStr);
        assertTrue(result);
    }

    @Test
    public void url() {
        String urlEncodeStr = URLEncoder.encode(urlStr, StandardCharsets.UTF_8);
        log.info(urlEncodeStr);
        assertEquals("https%3A%2F%2Fwuzhuti.cn", urlEncodeStr);
        String urlDecodeStr = URLDecoder.decode(urlEncodeStr, StandardCharsets.UTF_8);
        assertEquals(urlStr, urlDecodeStr);
    }

    @Test
    public void unicode() {
        String unicodeStr = new UnicodeEscaper().translate("中文");
        log.info(unicodeStr);
        String sourceStr = new UnicodeUnescaper().translate(unicodeStr);
        log.info(sourceStr);
    }


}
