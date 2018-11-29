package com.fantasy.xxutil.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 密码工具类
 *
 * @author li.fang
 * @since 2017/02/19
 */
public final class XXCodecUtils {

    private static Logger logger = LoggerFactory.getLogger(XXCodecUtils.class);

    //指定DES加密解密所用密钥
    private static Key key;

    private static final String DEFAULT_SALT = "XX-FANTASY";

    private static final String GENERATOR_DES = "DES";

    private static final String ENCODING_UTF8 = "UTF-8";

    private static final int CIPHER_COUNT = 3;

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance(GENERATOR_DES);
            generator.init(new SecureRandom(DEFAULT_SALT.getBytes()));
            key = generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            logger.warn("Cryptographic failure");
            throw new RuntimeException(e);
        }
    }

    /**
     * 对明文进行加密
     * 加密规则为对应明文多次MD5加密 + 时间戳MD5,形成64位
     *
     * @param plaintext
     * @return
     */
    public static String getTime64MD5(String plaintext) {
        return getTime64MD5(plaintext, DEFAULT_SALT);
    }


    public static String getTime64MD5(String plaintext, String salt) {
        String nano = String.valueOf(System.nanoTime());

        String password = DigestUtils.md5Hex(plaintext);

        String timestamp = DigestUtils.md5Hex(nano);

        String p = append(password, timestamp);

        if(logger.isDebugEnabled()) {
            logger.debug("plaintext : {}", plaintext);
            logger.debug("     salt : {}", salt);
            logger.debug(" password : {}\n", p);
        }
        return p;
    }

    private static String append(String str1, String str2) {
        char[] b1 = str1.toCharArray();
        char[] b2 = str2.toCharArray();

        StringBuffer sb = new StringBuffer(b1.length + b2.length);

        for (int i = 0, len = b1.length; i < len; i++) {
            sb.append(b1[i]).append(b2[i]);
        }
        return sb.toString();
    }


    /**
     * 比较两个MD5是否相等(只需要比较后32未)
     *
     * @param md5Str1 数据库中密码
     * @param md5Str2 输入的密码
     * @return
     */
    public static boolean isMD5Equal(String md5Str1, String md5Str2) {
        if (md5Str1 == null || md5Str2 == null) {
            return false;
        } else if (md5Str2.length() != 64) {
            return false;
        }

        char[] b1 = md5Str1.toCharArray();
        char[] b2 = md5Str2.toCharArray();

        if(b1.length != b2.length) return false;

        for (int i = 0, len = b1.length; i < len; i += 2) {
            if(b1[i] != b2[i]) return false;
        }

        return true;
    }

    /**
     * 对字符串进行DES加密,返回BASE64编码的加密字符串
     *
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String getDesEncryptText(String str) {
        try {
            byte[] strBytes = str.getBytes(ENCODING_UTF8);
            Cipher cipher = Cipher.getInstance(GENERATOR_DES);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return Base64.encodeBase64String(encryptStrBytes);
        } catch (Exception e) {
            logger.warn("Cryptographic failure");
            throw new RuntimeException(e);
        }
    }

    /**
     * 对BASE64编码的加密字符串进行解密,返回解密后的字符串
     *
     * @param str BASE64加密字符串
     * @return 解密后的字符串
     */
    public static String getDesDecryptText(String str) {
        try {
            byte[] strBytes = Base64.decodeBase64(str);
            Cipher cipher = Cipher.getInstance(GENERATOR_DES);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, ENCODING_UTF8);
        } catch (Exception e) {
            logger.warn("Decryption failure");
            throw new RuntimeException(e);
        }
    }

}
