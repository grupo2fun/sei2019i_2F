package com.example.ahorcado1.BusinessLogic.controllers;

import com.example.ahorcado1.DataAccess.models.Category;
import com.example.ahorcado1.DataAccess.models.Round;
import com.example.ahorcado1.DataAccess.models.User;
import com.example.ahorcado1.DataAccess.repositories.RoundRepository;
import com.example.ahorcado1.DataAccess.repositories.UserRepository;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class gameController
{
    public gameController() { }

    public static void createRound(User user, Category category, long puntaje)
    {
        //Creación de objeto 'Round'
        RoundRepository roundRepo = Globals.roundRepository;
        //Instancia del objeto ronda: Usuario, categoría, puntaje
        Round round1 = new Round(user, category, puntaje);
        //Creación del registro a partir del objeto
        roundRepo.create(round1);

        //Actualización de 'user'
        UserRepository userRepo = Globals.userRepository;
        long puntajeAcumulado = round1.getScore() + Globals.user.getPuntaje(); //Puntaje de la ronda + puntaje del usuario
        userRepo.update(Globals.user).setPuntaje((int)puntajeAcumulado);


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
