package com.example.demo;
/*Написать конвертер температур для конвертации градусов по Цельсию в Кельвины и Фаренгейты.
Используйте интерфейс Converter с одним методом covert.
Пользователь должен вводить в консоли градусы и какую систему он хотел бы их сконвертировать,
а программа должна определять по вводу какую имплементацию использовать, конвертировать и выводить результат*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main implements Converter {
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    public static int inputToConvertSystem;
    public static float inputToConvert;

    public static void main(String[] args) throws IOException {

        System.out.println("Choose a system you would like to convert from(input a number corresponding to your choose)");
        System.out.println("1, 2 or 3");
        System.out.println("""
                Where:
                1 - Celsius
                2 - Kelvin
                3 - Fahrenheit
                Your choose:""");
        //Asking user to input a system from
        int inputInitialSystem = Integer.parseInt(READER.readLine());
        //Validation to enter corresponding number
        if (inputInitialSystem > 3 || inputInitialSystem < 1) {
            System.out.println("Please, enter corresponding number");
        } else {
            System.out.println("Choose a system you would like to convert to");
            System.out.println("""
                1 - Celsius
                2 - Kelvin
                3 - Fahrenheit
                Your choose:""");
            inputToConvertSystem = Integer.parseInt(READER.readLine());
            System.out.println("Enter degree that you would like to convert to");
            inputToConvert = Integer.parseInt(READER.readLine());
            //validation to have everything corresponding to Physic laws
            if (inputInitialSystem == 1 && inputToConvert < -273.15f) {
                System.out.println("Impossible, lower degrees are not present in our universe");
            } else if (inputInitialSystem == 2 && inputToConvert < 0) {
                System.out.println("Impossible, lower degrees are not present in our universe");
            } else if (inputInitialSystem == 3 && inputToConvert < -459.67f) {
                System.out.println("Impossible, lower degrees are not present in our universe");
            } else {
                Main x = new Main();
                //Calling method to convert
                x.convert(inputInitialSystem);
            }
        }
    }
    @Override
    //Method to convert
    public void convert(int inputInitialSystem) {
        float answer;
        if (inputInitialSystem == 1 && inputToConvertSystem == 1) {
            System.out.println(inputToConvert + "Celsius degree");
        } else if (inputInitialSystem == 1 && inputToConvertSystem == 2) {
            answer = inputToConvert + 273.15f;
            System.out.println(answer + " Kelvin degree");
        } else if (inputInitialSystem == 1 && inputToConvertSystem == 3) {
            answer = inputToConvert*(9f/5f) + 32f;
            System.out.println(answer + " Fahrenheit degree");
        } else if (inputInitialSystem == 2 && inputToConvertSystem == 1) {
            answer = inputToConvert - 273.15f;
            System.out.println(answer + " Celsius degree");
        } else if (inputInitialSystem == 2 && inputToConvertSystem == 2) {
            System.out.println(inputToConvert + " Kelvin degree");
        } else if (inputInitialSystem == 2 && inputToConvertSystem == 3) {
            answer = (inputToConvert - 273.15f)*(9f/5f) + 32f;
            System.out.println(answer + " Fahrenheit degree");
        } else if (inputInitialSystem == 3 && inputToConvertSystem == 1) {
            answer = (inputToConvert - 32f)*(5f/9f);
            System.out.println(answer + " Celsius degree");
        } else if (inputInitialSystem == 3 && inputToConvertSystem == 2) {
            answer = (inputToConvert - 32f)*(5f/9f);
            System.out.println(answer + " Kelvin degree");
        } else if (inputInitialSystem == 3 && inputToConvertSystem == 3) {
            System.out.println(inputToConvert + " Fahrenheit degree");
        }
    }
}
