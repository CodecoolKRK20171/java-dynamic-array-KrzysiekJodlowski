package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {
    
    private int[] internalArray;

    public DynamicIntArray() {
        this.internalArray = new int[10];
    }

    public DynamicIntArray(int initialSize) {
        this.internalArray = new int[initialSize];
    }

}
