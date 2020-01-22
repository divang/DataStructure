    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package edu.sort;

    public class QuickSort {

        public void sort(int[] data, int startIndex, int endIndex) {
            if (startIndex >= endIndex) {
                return;
            }

            int pivot = data[endIndex];
            int lastSmallerIndex = -1;

            for (int curIndex = startIndex; curIndex < endIndex; curIndex++) {
                if (pivot > data[curIndex]) {
                    if (lastSmallerIndex == -1) {
                        lastSmallerIndex = curIndex;
                    } else if (curIndex - lastSmallerIndex == 1) {
                        lastSmallerIndex = curIndex;
                    } else {
                        lastSmallerIndex = lastSmallerIndex + 1;
                        int tmp = data[curIndex];
                        data[curIndex] = data[lastSmallerIndex];
                        data[lastSmallerIndex] = tmp;
                    }
                }
            }

            if (lastSmallerIndex == -1) {
                lastSmallerIndex = startIndex;
            } else {
                lastSmallerIndex = lastSmallerIndex + 1;
            }
            //take care of Pivot element swap
            int tmp = data[endIndex];
            data[endIndex] = data[lastSmallerIndex];
            data[lastSmallerIndex] = tmp;
            
            sort(data, startIndex, lastSmallerIndex - 1);
            sort(data, lastSmallerIndex + 1, endIndex);
        }
    }
