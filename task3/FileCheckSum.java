package edu.uark.models.api;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class FileCheckSum {

    public static void main(String[] args) throws IOException {

        String result = DigestUtils.sha256Hex(new FileInputStream("nameofserverlog"));
        System.out.println(result);

    }

}
