package com.company;

import board.*;


public class Main
{
//https://app.diagrams.net/#G1C7toeBBTK2cHlAdchu6F7SlsDHEw2N6W
    public static void main(String[] args)
    {
        //начнем поездку на такси
        BoardTaxi boardTaxi1 = new BoardTaxi();
        boardTaxi1.startTheRide();


        //начнем поездку в автобусе
        BoardBus boardBus1 = new BoardBus();
        boardBus1.startTheRide();

        //начнем поездку для цветочков
        BoardFlowersMachine boardFlowersMachine1 = new BoardFlowersMachine();
        boardFlowersMachine1.startTheRide();

    }
}