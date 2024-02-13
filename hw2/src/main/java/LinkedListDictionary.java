// Name: Duc Tran, UIN: 679876782
// Class: CS 342
// LinkedListDictionary.java: This file contains all implementation for linked list
// The file testing including case for zero element, many elements, and single element
// System: Window 11, Intellij Idea, Java 21
import java.util.Iterator;

public class LinkedListDictionary<K ,V> implements Dictionary<K,V>{

    private Node front;
    private Node back;
    private int size;

    private class Node{
        K key;
        V value;
        Node next;
        Node(K newKey, V newValue){
            super();
            key = newKey;
            value = newValue;
        }
    }

    private class LinkedListIterator implements Iterator<K> {
        Node cursor;
        int nodeTracking = 1;
        private LinkedListIterator() {
            cursor = front;
        }
        @Override
        public boolean hasNext() {
            if (front == null){
                return false;
            }
            return nodeTracking <= size;
        }
        @Override
        public K next() {
            if (front == null){
                return null;
            }
            K toRet = cursor.key;
            cursor = cursor.next;
            nodeTracking += 1;
            return toRet;
        }
    }

    @Override
    public void insert(K key, V value) {
        Node toAdd = new Node(key,value);
        if(front == null){
            front = toAdd;
            back = toAdd;
            size = 1;
        } else {
            back.next = toAdd;
            back = back.next;
            size++;
        }
    }

    @Override
    public V find(K key) {
        Node cursor = front;
        while(cursor != null){
            if (cursor.key.equals(key)){
                return cursor.value;
            }
            cursor = cursor.next;
        }
        return null;
    }

    @Override
    public boolean delete(K key) {
        Node cursor = front;
        if (size == 0){
            return false;
        }
        else if (size == 1){
            if (cursor.key.equals(key)){
                front = null;
                back = null;
                size--;
                return true;
            }
        }
        else {
            Node prev = null;
            Node current = front;

            while (current != null) {
                if (current.key.equals(key)) {
                    if (current == front) {
                        front = current.next;
                        if (front == null) {
                            back = null;
                        }
                    } else if (current == back) {
                        back = prev;
                        back.next = null;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return true;
                }
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new LinkedListIterator();
    }
}
