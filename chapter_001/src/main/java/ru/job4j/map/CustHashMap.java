package ru.job4j.map;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustHashMap<K,V> implements Iterable<CustHashMap.HashNode> {
    private int modCount;
    @Override
    public Iterator <HashNode> iterator() {
        return new Iterator<>() {
            private int index;
            private int expectedModCount = modCount;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean res = false;
                for (int i = index; i < bucketArray.size(); i++) {
                    if (bucketArray.get(i) != null) {
                        index = i;
                        res = true;
                        break;
                    }
                }
                return res;
            }

            @Override
            public HashNode next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return bucketArray.get(index++);
            }
        };
    }

    class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }



    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;

    public CustHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;


        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
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

        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        HashNode<K, V> prev = null;
        while (head != null) {

            if (head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);
        return head.value;
    }


    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }


        return null;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    insert(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }


    public static void main(String[] args) {
        CustHashMap<String, Integer> map = new CustHashMap<>();
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
