package ru.job4j.map;

class   HashNode<K, V> {
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