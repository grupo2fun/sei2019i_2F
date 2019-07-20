package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Round;
import com.example.ahorcado1.DataAccess.repositories.RoundRepository;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class gameController
{
    public gameController() { }

    public static void createRound(char letra, boolean[] usedLetters)
    {
        RoundRepository roundRepo = Globals.roundRepository;
        Round round1 = new Round();


        /*

        usedLetters.push(letra);
        boolean[] prevMask = Arrays.copyOf(mask, mask.length);

        mask = gameController.guess(wordc,mask,letra);

        if(Arrays.equals(mask,prevMask)){
            lives -= 1;
        }else {
            char[] gWord = new char[mask.length];
            for(int i = 0;i < mask.length;i++)
            {
                if (mask[i]==false)
                {
                    gWord[i] = '_';
                }else{
                    gWord[i] = wordc[i];
                }
            }
            StringBuilder gpalabra = new StringBuilder(gWord.length);
            for (char c : gWord){
                gpalabra.append(c).append(" ");
            }
            gpalabra.toString();
            palabra.setText(gpalabra);
        }
        updateHangman(lives);
        updateLetters(usedLetters);
    }
    */

    }

    /*funcion que recibe una letra a adivinar*/
    static public boolean[] guess(char[] palabra,boolean[] mask,char letter){
        Stack<Integer> guesses = find(palabra,letter);
        if (!guesses.isEmpty()){
            while (!guesses.empty()){
                mask[guesses.pop()]=true;
            }
        }
        return mask;
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
            if(mask[number]==false){
                numberF=true;
            }
        }
        return palabra[number];
    }
}
