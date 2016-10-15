package com.wpi.service;

import java.util.Random;

public class RandomLetter {
    
    private static final String[] LETTER_SET={"A",
            "B","C","D","E","F","G","H","I","J","K",
            "L","M","N","O","P","Q","R","S","T","U",
            "V","W","X","Y","Z","Qu"};
    
    public String[] getRandomLetter(int len){
        String[] letterArray = new String[len];
        Random random = new Random();
        for(int i=0; i<len; i++){
            letterArray[i] = LETTER_SET[random.nextInt(26)+1];
        }
        return letterArray;
    }

}
