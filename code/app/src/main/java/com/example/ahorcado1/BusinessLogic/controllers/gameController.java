package com.example.ahorcado1.BusinessLogic.controllers;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class gameController
{
    /*funcion que recibe una letra a adivinar*/
    static public boolean[] guess(String word,boolean[] mask,char letter){
        char[] palabra = word.toCharArray();
        Stack<Integer> guesses = find(palabra,letter);
        if (!guesses.isEmpty()){
            while (!guesses.empty()){
                mask[guesses.pop()]=true;
            }
            return mask;
        }else{
            Arrays.fill(mask,false);//llena la mascara de false si el intento fue erroneo
            return mask;
        }
    }


    /*funcion que busca  donde se encuentra la letra en la palabra*/
    public static Stack<Integer> find(char[] word,char letter){
        int P = word.length;
        Stack<Integer> result = new Stack<>();
        for (int i = 0;i<P;i++){
            if(word[i]==letter){
                result.push(i);
            }else{

            }
        }
        return result;
    }


    /*funcion que da una pista, una letra no descubierta de la palabra*/
    static public char hint(String word,boolean[] mask){
        char[] palabra = word.toCharArray();
        Random rand = new Random();
        int number = 0;
        boolean numberF = false;
        while (numberF == false){
            number = rand.nextInt(mask.length);
            if(mask[number]==true){
                numberF=true;
            }
        }
        return palabra[number];
    }
}
