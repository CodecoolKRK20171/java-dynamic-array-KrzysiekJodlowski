package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] internalArray;

    public DynamicIntArray() {
        int defaultArraySize = 10;
        this.internalArray = new int[defaultArraySize];
        fillArrayWithDefaultInts(defaultArraySize);
    }

    public DynamicIntArray(int initialSize) {
        this.internalArray = new int[initialSize];
        fillArrayWithDefaultInts(initialSize);
    }

    private void fillArrayWithDefaultInts(int initialSize) {
        for (int index = 0; index < initialSize; index++) {
            this.internalArray[index] = index;
        }
    }

    public void add(int number) {
        if (internalArray[internalArray.length - 1] == 0) {
            for (int i = 0; i < internalArray.length; i++) {
                if (internalArray[i] == 0) {
                    internalArray[i] = number;
                    break;
                }
            }
        } else {
            int[] expandedInternalArray = new int[internalArray.length + 1];
            for (int index = 0; index < internalArray.length; index++) {
                expandedInternalArray[index] = internalArray[index];
            }
            expandedInternalArray[internalArray.length + 1] = number;
            internalArray = expandedInternalArray;
        }

    }

}
