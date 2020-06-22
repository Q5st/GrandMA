package com.company;

import java.util.Scanner;

public class Number {
    static final String[] BELOW_TENS = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static final String[] BETWEEN_TENS_TWENTY = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    static final String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double in = scanner.nextDouble();
        System.out.println(getNumAsString(in));
    }

    private static String getNumAsString(double num) {
        StringBuilder stringBuilder = new StringBuilder();
        int million =(int) num / 1000000;
        int thousand = ((int) num - million*1000000)/ 1000;
        int just = (int) num - million*1000000 -  thousand*1000;
        int fractional = (int) ((num - million*1000000 - thousand*1000 - just) * 100);
        int temp;

        if(num==1000000000){
            return "one billion";
        }

        if(million!=0){
            if(million%100==0){
                stringBuilder.append(BELOW_TENS[million/100]).append(" hundred million ");
            }else {
                if (million / 100 != 0) {
                    stringBuilder.append(BELOW_TENS[million / 100]).append(" hundred ");
                }
                    temp = million-million/100*100;
                    if(temp%10==0){
                        stringBuilder.append(TENS[temp/10]).append(" million ");
                    }else {
                        if(temp<20&&temp>10){
                            stringBuilder.append(BETWEEN_TENS_TWENTY[temp-(temp/10*10)]).append(" million ");
                        }else{
                            if(temp>9) {
                                stringBuilder.append(TENS[temp / 10]).append("-");
                            }
                            temp=temp-(temp/10*10);
                            stringBuilder.append(BELOW_TENS[temp]).append(" million ");
                        }
                    }
                }
            }

        if(thousand!=0){
            if(thousand%100==0){
                stringBuilder.append(BELOW_TENS[thousand/100]).append(" hundred thousand ");
            }else {
                if (thousand / 100 != 0) {
                    stringBuilder.append(BELOW_TENS[thousand / 100]).append(" hundred ");
                }
                temp = thousand-thousand/100*100;
                if(temp%10==0){
                    stringBuilder.append(TENS[temp/10]).append(" thousand ");
                }else {
                    if(temp<20&&temp>10){
                        stringBuilder.append(BETWEEN_TENS_TWENTY[temp-(temp/10*10)]).append(" thousand ");
                    }else{
                        if(temp>9) {
                            stringBuilder.append(TENS[temp / 10]).append("-");
                        }
                        temp=temp-(temp/10*10);
                        stringBuilder.append(BELOW_TENS[temp]).append(" thousand ");
                    }
                }
            }
        }

        if(just!=0){
            if(just%100==0){
                stringBuilder.append(BELOW_TENS[just/100]).append(" hundred ");
            }else {
                if (just / 100 != 0) {
                    stringBuilder.append(BELOW_TENS[just / 100]).append(" hundred ");
                }
                temp = just-just/100*100;
                if(temp%10==0){
                    stringBuilder.append(TENS[temp/10]);
                }else {
                    if(temp<20&&temp>10){
                        stringBuilder.append(BETWEEN_TENS_TWENTY[temp-(temp/10*10)]);
                    }else{
                        if(temp>9) {
                            stringBuilder.append(TENS[temp / 10]).append("-");
                        }
                        temp=temp-(temp/10*10);
                        stringBuilder.append(BELOW_TENS[temp]);
                    }
                }
            }
        }

        if(million!=0||thousand!=0||just!=0){
            stringBuilder.append(" dollars ");
        }

        if(fractional!=0){
            if(fractional%10==0){
                stringBuilder.append(BELOW_TENS[fractional/10]).append(" cent");
            }
            if(fractional<20&&fractional>10){
                stringBuilder.append(BETWEEN_TENS_TWENTY[fractional-fractional/10*10]).append(" cent ");
            }
            if(fractional>10){
                stringBuilder.append(TENS[fractional/10]).append("-");
            }
            stringBuilder.append(BELOW_TENS[fractional-fractional/10*10]).append(" cent ");
        }

        return stringBuilder.toString();
    }
}