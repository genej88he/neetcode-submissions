class DynamicArray {
    private int size;
    private int capacity;
    private int[] array;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can't be 0 or negative");
        }
        this.size = 0;
        this.array = new int[capacity];
        this.capacity = capacity;

    }

    public int get(int i) {
        return array[i];

    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        array[size] = n;
        size++;   
    }

    public int popback() {
        int popped = array[size - 1];
        size--;
        return popped;
    }

    private void resize() {
        capacity *= 2;
        int[] doubleArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            doubleArray[i] = array[i];
        }
        array = doubleArray;
    }

    public int getSize() {
        return this.size;

    }

    public int getCapacity() {
        return this.capacity;
    }
}
