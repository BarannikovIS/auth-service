package com.vsu.authservice.utils;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Encoder {

    public static String code(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String result="";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes("UTF-8"));
        byte[] digest = md.digest();
        result = String.format("%064x", new BigInteger(1,digest));
        return result;
    }
}
