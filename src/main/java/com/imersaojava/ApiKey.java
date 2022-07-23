package com.imersaojava;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class ApiKey {

    private String tmdbKey = "18b28a0f741c6bb5155f7fd2438ab796";
    private String nasaKey = "aMxMXff4fK23QXv5wGhF9lKJaIaZGy4fdggZVtSv";
    private String marvelPublicKey = "b0c7fc8163cdaf499e949933dbebf10c";
    private String marvelPrivateKey = "b8932830e275a76b61c4c6692c79d4db8351c5f7";
    private long timeStamp = new Timestamp(System.currentTimeMillis()).getTime();

    public String getTmdbKey() {
        return tmdbKey;
    }

    public String getNasaKey() {
        return nasaKey;
    }

    public String getMarvelPublicKey() {
        return marvelPublicKey;
    }

    public String getMarvelPrivateKey() {
        return marvelPrivateKey;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String md5() {
        String input = this.timeStamp + this.marvelPrivateKey + this.marvelPublicKey;
        return getMd5(input);
    }

    private static String getMd5(String input) {

        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
