package com.fya.haque.utils;

/**
 * Created by shanaulhaque on 10/09/16.
 */
public class Validator {

    public static Boolean validateQuestion(String question){
        if(question != null && !question.trim().equalsIgnoreCase(""))
            return false;
        return true;
    }


}
