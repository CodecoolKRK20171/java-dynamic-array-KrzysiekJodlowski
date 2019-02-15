package com.codecool.dynamicArrayDojo;


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

    public void add(int value) {
        if (this.internalArraySize == 1 && isEmpty) {
            this.internalArray[0] = value;
            this.isEmpty = false;
        } else {
            int[] expandedInternalArray = new int[this.internalArraySize + 1];
            for (int index = 0; index < this.internalArraySize; index++) {
                expandedInternalArray[index] = this.internalArray[index];
            }
            expandedInternalArray[this.internalArraySize] = value;
            this.internalArray = expandedInternalArray;
            this.internalArraySize++;
        }
    }

    public void remove(int valueIndex) {
        if (valueIndex >= this.internalArraySize) {
            throw new ArrayIndexOutOfBoundsException("No such index in an array!");
        }
        if (this.internalArraySize == 1 && valueIndex == 0) {
            this.internalArray[0] = 0;
            this.isEmpty = true;
        } else {
            int[] reducedInternalArray = new int[this.internalArraySize - 1];
            for (int index = 0; index < this.internalArraySize; index++) {
                if (index < valueIndex) {
                    reducedInternalArray[index] = this.internalArray[index];
                } else if (index > valueIndex){
                    reducedInternalArray[index - 1] = this.internalArray[index];
                }
            }
            this.internalArray = reducedInternalArray;
            this.internalArraySize--;
        }
    }

    public void insert(int valueIndex, int value) {
        if (isEmpty) {
            this.internalArray[0] = value;
            this.isEmpty = false;
        } else if (valueIndex >= this.internalArraySize) {
            this.add(value);
        } else {
            int[] expandedInternalArray = new int[++this.internalArraySize];
            for (int index = 0; index < this.internalArraySize; index++) {
                if (index < valueIndex) {
                    expandedInternalArray[index] = this.internalArray[index];
                } else if (index == valueIndex) {
                    expandedInternalArray[index] = value;
                } else {
                    expandedInternalArray[index] = this.internalArray[index - 1];
                }
            }
            this.internalArray = expandedInternalArray;
        }
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
