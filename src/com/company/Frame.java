package com.company;

import java.util.Arrays;

public class Frame {

    public static void main(String[] args) {
        int frame_width = 20, pic_width = 6, pic_x = 1, frame_height = 10, pic_height = 4, pic_y = 3;
        int[][] arr = new int[frame_width][frame_height];
        for (int i=pic_y; i<pic_height+pic_y ; i++) {
            for (int j=pic_x; j<pic_width+pic_x ; j++){
                arr[i][j] = (int) (Math.random() * (200 + 1)) - 100;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        Sort(arr, pic_x, pic_width, pic_y, pic_height );
        System.out.println(Arrays.deepToString(arr));
    }
     static int[][] Sort(int[][] arrsort, int w1, int w2, int h1, int h2) {
        int k = 0, l = 0;
        for(int i = h1;i< h1+ h2; i++){
            for(int j = w1;j< w1+ w2; j++) {
                arrsort[k][l] = arrsort[i][j];
                arrsort[i][j] = 0;
                l++;
            }
            k++;
            l=0;
        }
        return arrsort;
    }
}
