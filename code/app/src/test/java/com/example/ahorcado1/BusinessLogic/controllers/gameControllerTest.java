package com.example.ahorcado1.BusinessLogic.controllers;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class gameControllerTest {

    @Test
    public void find()
    {
        //Inputs
        String inputWord = "leon";
        char[] wordChar = inputWord.toCharArray();
        char charToFind = 'e';

        //Outputs
        Stack<Integer> output;

        //Resultado esperado
        Stack<Integer> expected = new Stack<>();
        expected.push(1);

        //For float values
        double delta = 0.1;

        gameController gameCont = new gameController();
        output = gameCont.find(wordChar,charToFind);

        assertEquals(expected, output);

    }

    //Tests.....
}