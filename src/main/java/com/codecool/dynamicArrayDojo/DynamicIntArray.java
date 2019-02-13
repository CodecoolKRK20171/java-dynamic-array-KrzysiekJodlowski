package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    private int[] internalArray;
    private int internalArraySize;
    private boolean isEmpty;

    public DynamicIntArray() {
        this.internalArraySize = 1;
        this.internalArray = new int[internalArraySize];
        this.isEmpty = true;
    }

    public DynamicIntArray(int initialSize) {
        this.internalArraySize = initialSize;
        this.internalArray = new int[this.internalArraySize];
        this.isEmpty = true;
    }

    public void add(int number) {
        if (this.internalArraySize == 1 && isEmpty) {
            this.internalArray[0] = number;
            this.isEmpty = false;
        } else {
            int[] expandedInternalArray = new int[this.internalArraySize + 1];
            for (int index = 0; index < this.internalArraySize; index++) {
                expandedInternalArray[index] = this.internalArray[index];
            }
            expandedInternalArray[this.internalArraySize] = number;
            this.internalArray = expandedInternalArray;
            this.internalArraySize++;
        }

    }

    public void remove(int index) {

    }

    public void insert(int index, int value) {

    }

    @Override
    public String toString() {
        String arrayRepresentation = "";

        for(int index = 0; index < this.internalArraySize; index++) {
            arrayRepresentation += String.format(" %d", this.internalArray[index]);
        }
        return arrayRepresentation;
    }

}
