package com.codecool.dynamicArrayDojo;

public class ArrayHandler {

    private final int ONE_INDEX = 1;
    private final float ARRAY_SIZE_MULTIPLIER = 1.5f;
    private final int ZERO = 0;


    public ArrayHandler() {}

    public int getFreeSpaceCount(int currentSize, int lastOccupiedIndex) {
        return currentSize - lastOccupiedIndex - this.ONE_INDEX;
    }

    public int[] expandInternalArray(int[] internalArray,
                                     int currentSize,
                                     int lastOccupiedIndex) {
        int[] expandedInternalArray = getExpandedArray(currentSize);

        for (int index = this.ZERO; index < lastOccupiedIndex + this.ONE_INDEX; index++) {
            expandedInternalArray[index] = internalArray[index];
        }

        return expandedInternalArray;
    }

    public int[] resetInternalArrayWithoutItem(int[]internalArray,
                                              int currentSize,
                                              int lastOccupiedIndex,
                                              int valueIndex) {
        int[] newArrayWithoutRemovedItem = new int[currentSize];

        for (int index = this.ZERO; index <= lastOccupiedIndex; index++) {
            if (index < valueIndex) {
                newArrayWithoutRemovedItem[index] = internalArray[index];
            } else if (index > valueIndex){
                newArrayWithoutRemovedItem[index - this.ONE_INDEX] = internalArray[index];
            }
        }
        return newArrayWithoutRemovedItem;

    }

    public int[] resetInternalArrayWithNewItem(int[] internalArray,
                                               int currentSize,
                                               int lastOccupiedIndex,
                                               int valueIndex,
                                               int value) {
        int[] internalArrayWithNewItem = new int[currentSize];
        return getCopyOfAnArrayWithNewItem(internalArray,
                internalArrayWithNewItem,
                lastOccupiedIndex,
                valueIndex,
                value);
    }

    public int[] expandInternalArrayWithNewItem(int[] internalArray,
                                                int currentSize,
                                                int lastOccupiedIndex,
                                                int valueIndex,
                                                int value) {
        int[] expandedInternalArray = getExpandedArray(currentSize);
        return getCopyOfAnArrayWithNewItem(internalArray,
                expandedInternalArray,
                lastOccupiedIndex,
                valueIndex,
                value);
    }

    private int[] getCopyOfAnArrayWithNewItem(int[] internalArray,
                                              int[] newArray,
                                              int lastOccupiedIndex,
                                              int valueIndex,
                                              int value) {

        for (int index = this.ZERO; index <= lastOccupiedIndex + this.ONE_INDEX; index++) {
            if (index < valueIndex) {
                newArray[index] = internalArray[index];
            } else if (index == valueIndex) {
                newArray[index] = value;
            } else {
                newArray[index] = internalArray[index - this.ONE_INDEX];
            }
        }

        return newArray;
    }

    private int[] getExpandedArray(int currentSize) {
        currentSize = (int) (currentSize * this.ARRAY_SIZE_MULTIPLIER);
        return new int[currentSize];
    }
}
