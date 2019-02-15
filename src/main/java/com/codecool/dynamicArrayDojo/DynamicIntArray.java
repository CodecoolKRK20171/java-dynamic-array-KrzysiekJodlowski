package com.codecool.dynamicArrayDojo;


public class DynamicIntArray {

    private int[] internalArray;
    private int currentSize;
    private boolean isEmpty;
    private ArrayHandler arrayHandler;

    private int initialSizeForEmptyArray = 10;
    private int lastOccupiedIndex = -1;
    private final int ZERO = 0;

    /*
    *   Constructors with helper method
     */
    public DynamicIntArray() {
        this.currentSize = this.initialSizeForEmptyArray;
        initializeArrayWithHandler(this.currentSize);
    }

    public DynamicIntArray(int customInitialSize) {
        this.currentSize = customInitialSize;
        initializeArrayWithHandler(this.currentSize);
    }

    private void initializeArrayWithHandler(int arraySize) {
        this.internalArray = new int[arraySize];
        this.isEmpty = true;
        this.arrayHandler = new ArrayHandler();
    }
    
    /*
     *   Add, remove & insert methods
     */
    public boolean add(int value) {

        if (isEmpty) {
            this.isEmpty = false;
        } else {
            int freeSpaceCount = this.arrayHandler.getFreeSpaceCount(this.currentSize, this.lastOccupiedIndex);
            if (freeSpaceCount <= this.ZERO) {
                this.internalArray = this.arrayHandler.expandInternalArray(
                        this.internalArray,
                        this.currentSize,
                        this.lastOccupiedIndex);
            }
        }

        this.internalArray[++this.lastOccupiedIndex] = value;
        return true;
    }

    public int remove(int valueIndex) {

        if (valueIndex > this.lastOccupiedIndex) {
            throw new ArrayIndexOutOfBoundsException("No such index in an array!");
        }

        int zeroIndex = this.ZERO;
        int removedItem = this.internalArray[zeroIndex];

        if (this.lastOccupiedIndex == zeroIndex) {
            this.internalArray[zeroIndex] = this.ZERO;
            this.isEmpty = true;
        } else {
            this.internalArray = this.arrayHandler.resetInternalArrayWithoutItem(
                    this.internalArray,
                    this.currentSize,
                    this.lastOccupiedIndex,
                    valueIndex);
            this.lastOccupiedIndex--;
        }

        return removedItem;
    }

    public boolean insert(int valueIndex, int value) {

        if (isEmpty) {
            this.internalArray[this.ZERO] = value;
            this.isEmpty = false;
            this.lastOccupiedIndex++;
        } else if (valueIndex > this.lastOccupiedIndex) {
            this.add(value);
        } else {
            int freeSpaceCount = this.arrayHandler.getFreeSpaceCount(this.currentSize, this.lastOccupiedIndex);
            if (freeSpaceCount <= this.ZERO) {
                this.internalArray = this.arrayHandler.expandInternalArrayWithNewItem(
                        this.internalArray,
                        this.currentSize,
                        this.lastOccupiedIndex,
                        valueIndex,
                        value);
            } else {
                this.internalArray = this.arrayHandler.resetInternalArrayWithNewItem(
                        this.internalArray,
                        this.currentSize,
                        this.lastOccupiedIndex,
                        valueIndex,
                        value);
            }
            this.lastOccupiedIndex++;
        }

        return true;
    }

    /*
     *   Other methods
     */
    @Override
    public String toString() {
        StringBuilder dynamicArrayStringBuilder = new StringBuilder();

        for(int index = this.ZERO; index <= this.lastOccupiedIndex; index++) {
            dynamicArrayStringBuilder.append(String.format(" %d", this.internalArray[index]));
        }

        return dynamicArrayStringBuilder.toString();
    }

}

