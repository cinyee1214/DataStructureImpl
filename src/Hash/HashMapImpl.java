package Hash;

import java.util.Arrays;
import java.util.Objects;

public class HashMapImpl<V, K> {
    /** static nested class */
    public static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }

    }

    /** static final variable are global constants */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_CAPACITY = 16;
    private static final int SCALE_FACTOR = 2;


    private Entry<K, V>[] array;
    /** The number of keys-value pairs stored in the HashMap */
    private int size;
    private float loadFactor; // determine when to rehash

    public HashMapImpl() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }


    public HashMapImpl(int cap, float loadFactor) {
        if (cap <= 0 || loadFactor <= 0) {
            throw new IllegalArgumentException("Cap and loadFactor cannot be <= 0");
        }

        this.array = (Entry<K, V>[]) (new Entry[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    //eager computation
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    /** hash(key) to get the hash */
    //non-negative
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
//        int hashNumber = key.hashCode();
//        hashNumber = hashNumber < 0 ? 0 - hashNumber : hashNumber;
        //overflow   <-   -Integer.MIN_VALUE
        return key.hashCode() & 0X7FFFFFFF; // guarantee non-negative
    }

    /** from the hash#, mapped to the entry index */
    private int getIndex(K key) {
        return hash(key) % array.length;
    }


    private boolean equalsKey(K key1, K key2) {
        return key1 == key2 || (key1 != null && key1.equals(key2));
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            if (equalsKey(key, entry.key)) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    private boolean equalsValue(V v1, V v2) {
        return v1 == v2 || (v1 != null && v1.equals(v2));
    }

    //O(n), traverse the whole array, and traverse each of the linked list in the array
    public boolean containsValue(V value) {
        //special case
        if (isEmpty()) {
            return false;
        }
        for (Entry<K, V> entry : array) {
            while (entry != null) {
                if (equalsValue(value, entry.value)) {
                    return true;
                }
                entry = entry.next;
            }
        }
        return false;
    }

    // if key does not exist in the hashMap, return null
    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        while (entry != null) {
            if (equalsKey(key, entry.key)) {
                return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = array[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (equalsKey(key, entry.key)) {
                if (prev != null) {
                    prev.next = entry.next;
                } else {
                    array[index] = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    // insert / update
    // if the key already exists, return the old corresponding value.
    // if not, return null
    public V put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> head = array[index];
        Entry<K, V> entry = head;
        while (entry != null) {
            //key, entry.key all possible to be null
            //update value if key exists
            if (equalsKey(entry.key, key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
            entry = entry.next;
        }

        //append the new entry before the head and update the new head
        //insert operation
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.next = head;
        array[index] = newEntry;
        size++;
        if ((size + 0.0f) / array.length >= loadFactor) {
            rehash();
        }
        return null;
    }

    private void rehash() {
        Entry<K, V>[] oldArray = array;
        array = (Entry<K, V>[]) (new Entry[array.length * SCALE_FACTOR]);
        for (Entry<K, V> cur : oldArray) {
            while (cur != null) {
                Entry<K, V> next = cur.next;
                int index = getIndex(cur.key);
                cur.next = array[index];
                array[index] = cur;
                cur = next;
            }
        }
    }









}
