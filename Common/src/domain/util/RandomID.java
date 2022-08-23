/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.util;

import java.util.Random;

/**
 *
 * @author Stefan
 */
public class RandomID { 
    
    private static int randomBroj(){
        Random rand = new Random();
        int i = rand.nextInt(10);
        return i;
    }
    
    public static String generisiID(){
        String ID = "";
        for(int i = 0; i < 10; i++){
            ID = ID + String.valueOf(randomBroj());
        }
        return ID;
    }
    
}
