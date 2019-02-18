package edu.uark.models.api;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordSha256 {

    public static void main(String[] args) {

        String password = "logmein";

        String result = DigestUtils.sha256Hex(password);
        System.out.println(result);

    }

}