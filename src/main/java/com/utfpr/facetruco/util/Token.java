package com.utfpr.facetruco.util;

public class Token{
    public static String generateToken(String tokenUser){
        return tokenUser + "_" + System.currentTimeMillis();
    }
}