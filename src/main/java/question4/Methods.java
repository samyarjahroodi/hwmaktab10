package question4;

import java.util.Arrays;

//@SuppressWarnings("unused")
public class Methods<K, V> {
    private static final int INITIAL_CAPACITY = 50;
    private Entry<K, V>[] table;
    private int size;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Methods{");
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            if (entry != null) {
                sb.append("table[").append(i).append("]=").append(entry).append(", ");
            }
        }
        sb.append("size=").append(size).append('}');
        return sb.toString();
    }


    public Methods() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void replace(K key, V newValue) {
        int index = findIndex(key);
        if (table[index] != null && table[index].key.equals(key)) {
            table[index].value = newValue;
        }
    }

    public boolean containsValue(V value) {
        int index = findIndexValue(value);
        while (table[index] != null) {
            if (table[index].value.equals(value)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }


    public boolean containKey(K key) {
        int index = findIndex(key);
        if (table[index] != null && table[index].key.equals(key)) {
            return true;
        } else {
            return false;
        }
    }

    private int findIndexValue(V value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].value.equals(value)) {
                return i;
            }
        }
        return -1;
    }


    public V[] getAllValues() {
        V[] values = (V[]) new Object[size];
        int index = 0;
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                values[index++] = entry.value;
            }
        }
        return values;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        if (size >= 0.75 * table.length) {
            resize();
        }
        int index = findIndex(key);
        table[index] = new Entry<>(key, value);
        size++;
    }

    public void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                int index = findIndex(entry.key);
                table[index] = entry;
            }
        }
    }

    private int findIndex(K key) {
        // Calculate the initial index based on the key's hash code and table size.
        int initialIndex = key.hashCode() % table.length;

        // Start with the initial index and probe linearly until we find an empty slot
        // or a slot with a matching key.
        int index = initialIndex;
        while (true) {
            // If the current slot is empty or contains a key that matches the given key, we've found the right place.
            if (table[index] == null || table[index].key.equals(key)) {
                return index;
            }

            // If the current slot is occupied by a different key, we move to the next slot.
            // We use the modulo operation to wrap around to the beginning if we reach the end of the table.
            index = (index + 1) % table.length;

            // If we have probed the entire table and haven't found the key, we will have to resize the table.
            if (index == initialIndex) {
                throw new IllegalStateException("Hash table is full.");
            }
        }
    }


}
