/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv20yearsweather;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Melnikov
 */
public class JPTV20YearsWeather {
    static enum Month{
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // минимальная и максимальная температура
        int min=0, max=0;
        //Создаем зубчатый массив из 12 строк
        int[][] dayTempInYear = new int[12][];
        Random random = new Random();
        for(int i=0;i<dayTempInYear.length;i++){
            int n = 0;
            switch (i) {
                case 2: min = -5; max = 15; n=31; break;//Весна
                case 3: min = -5; max = 15; n=30; break;//Весна
                case 4: min = -5; max = 15; n=31; break;//Весна
                case 5: min =  5; max = 30; n=30; break;//Лето
                case 6: min =  5; max = 30; n=31; break;//Лето
                case 7: min =  5; max = 30; n=31; break;//Лето
                case 8: min =-10; max = 10; n=30; break;//Осень
                case 9: min =-10; max = 10; n=31; break;//Осень
                case 10:min =-10; max = 10; n=30; break;//Осень
                case 11:min =-30; max = 0;  n=31; break;//Зима
                case 0: min =-30; max = 0;  n=31; break;//Зима
                case 1: min =-30; max = 0;  n=28; break;//Зима
            }
            dayTempInYear[i] = new int[n];
            for(int j=0;j<dayTempInYear[i].length;j++){
                dayTempInYear[i][j]=random.nextInt(max-min+1)+min;
            }
        }
        for(int i=0;i<dayTempInYear.length;i++){
           // System.out.println(Arrays.toString(dayTempInYear[i]));
            System.out.printf("%-8s: ",Month.values()[i]);
            for(int j=0; j<dayTempInYear[i].length;j++){
                System.out.printf("%4d",dayTempInYear[i][j]);
            }
            System.out.println();
        }
        double[] averageTemperaturInMonth=new double[12];
        for(int i=0;i<dayTempInYear.length;i++){
            int daysInMonth=0;
            for(int j=0; j<dayTempInYear[i].length;j++){
                averageTemperaturInMonth[i]+=(double)dayTempInYear[i][j];
                daysInMonth=j+1;
            }
            averageTemperaturInMonth[i]=averageTemperaturInMonth[i]/daysInMonth;            
        }
        System.out.println();
        System.out.println("Средняя температура по месяцам:");
        for(int i=0;i<averageTemperaturInMonth.length;i++){
            System.out.printf("%-8s: %-4.2f%n",Month.values()[i], averageTemperaturInMonth[i]);
        }

        
    }
    
}
