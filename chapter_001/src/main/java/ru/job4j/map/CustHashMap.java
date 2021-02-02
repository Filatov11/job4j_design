package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustHashMap<K, V> implements Iterable<CustHashMap> {
    private int modCount;
    public static final float LOAD_FACTOR = 0.7f;
    private HashNode<K, V>[] map;

    @Override
    public Iterator<HashNode> iterator() {

        return new Iterator<>() {

            private int index;

            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean found = false;
                for (int i = index; i < map.length; i++) {
                    if (map[i] != null) {
                        index = i;
                        found = true;
                        break;
                    }
                }
                return found;
            }

            @Override
            public HashNode next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return map[index++];
            }
        };
    }


    private int numBuckets;
    private int size;

    public CustHashMap(int size) {
        this.size = size;
        this.map = new HashNode[size];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }


    public V delete(K key) {
        int h = doHashCode(key);
        if (map[h] == null || !(key == null || map[h].key.hashCode() == key.hashCode() && key.equals(map[h].key))) {
            return null;
        }
        V value = map[h].value;
        map[h] = null;
        modCount++;
        size--;
        return value;
    }

    public V get(K key) {
        int h = doHashCode(key);
        if (map[h] == null || !(key == null || map[h].key.hashCode() == key.hashCode() && key.equals(map[h].key))) {
            return null;
        }
        return map[h].value;
    }


    public boolean insert(K key, V value) {
        resize();
        int h = doHashCode(key);
        if (!(map[h] == null
                || ((key == map[h].key) || map[h].key.hashCode() == key.hashCode() && key.equals(map[h].key)))) {
            return false;
        }
        if (map[h] == null) {
            size++;
        }
        map[h] = new HashNode<>(key, value, h);
        modCount++;
        return true;
    }

    private int doHashCode(K key) {
        return (key == null) ? 0 : ((int) (key) >>> 32 + 31 + key.hashCode());
    }

    private void resize() {
        if (((float) size / numBuckets) > LOAD_FACTOR) {
            int oldNumBuckets = numBuckets;
            numBuckets = numBuckets * 2;
            HashNode<K, V>[] extMap = new HashNode[numBuckets];
            for (int i = 0; i < oldNumBuckets; i++) {
                if (map[i] != null) {
                    int h = doHashCode(map[i].key);
                    extMap[h] = new HashNode<>(map[i].key, map[i].value, h);
                }
            }
            this.map = extMap;
        }
    }


    public static void main(String[] args) {
        CustHashMap<String, Integer> map = new CustHashMap<>(10);
        map.insert("this", 1);
        map.insert("coder", 2);
        map.insert("this", 4);
        map.insert("hi", 5);
        System.out.println(map.size());
        System.out.println(map.delete("this"));
        System.out.println(map.delete("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }

}

class HashNode<K, V> {
    K key;
    V value;
    int hCode;

    public HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hCode = hashCode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int gethCode() {
        return hCode;
    }

    public void sethCode(int hCode) {
        this.hCode = hCode;
    }
}