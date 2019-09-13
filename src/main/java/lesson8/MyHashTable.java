package lesson8;

import java.util.LinkedList;
import java.util.Optional;

public class MyHashTable<K, V> implements HashTable<K, V> {

    private static class Node<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }


    private LinkedList<Node<K, V>>[] data;
    private int size;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public MyHashTable(int maxSize) {
        this.maxSize = maxSize;
        this.data = new LinkedList[maxSize];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
//        putNode(Node)
//
//        LinkedList<Node<K, V>>[] list = new LinkedList[maxSize];
//        int index = hashFunc(node.key);
//        list[index].add(node);
//        while (list[index] != null) {
//            if (data[index].key.equals(node.key)) {
//                data[index].value = node.value;
//                list[index].add((Node<K, V>) node.value);
//
//                return true;
//            }
//
//        }
//
////        size++;
        return true;
    }

    Node<K, V> newNode(K key, V value) {
        return new Node<>(key, value);
    }

    public LinkedList<Node<K, V>> create() {

        for (int i = 0; i < maxSize; i++) {
            LinkedList<Node<K, V>> list_i = new LinkedList<>();
            data[i] = list_i;
        }
        return null;
    }

    public boolean putNode(K key, V value) {
        Node node = newNode(key, value);
        int index = hashFunc(key);
//        while (data[index] != null) {
//            return true;
//        }
        for (Node<K, V> kvNode : data[index]) {
            if (!kvNode.value.equals(value)) {
                data[index].push(node);
            }
            size++;
            return false;
        }
        while (!data[index].contains(node.value)) {
            data[index].push(node);
            size++;
            return true;
        }
        return true;
    }

    @Override
    public V get(K key) {
        return getEntry(key)
                .map(MyHashTable.Node::getValue)
                .orElse(null);

        //Entry entry = getEntry(key);
        //return entry != null ? entry.value : null;
    }

    private Optional<MyHashTable.Node<K, V>> getEntry(K key) {
        int index = indexOf(key);
        if (index != -1) {
            return Optional.of(data[index].element());
        }

        return Optional.empty();
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        while (data[index] != null) {
//            Node current = data[index].element();
//            if (current.getKey().equals(key)) {
            return index;
        }
//            index += getStep(key);
//            index %= data.length;
//        }

        return -1;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        Node current;
        for (Node<K, V> node : data[index]) {
            if (node.key.equals(key)) {
                current = node;
                V result = (V) current.value;
                data[index].remove(current);
                size--;
                return result;
            }
        }
        return null;
    }

//    public V remove(Node<K, V> node) {
//        int index = indexOf(node.key);
//        if (index == -1) {
//            return null;
//        }
//        for (Node<K, V> nodes : data[index]) {
//            if (!nodes.value.equals(node.value)) {
//                throw new IllegalArgumentException("Bad value");
//            }
//            V rezult = node.value;
//            data[index].remove(node);
//            size--;
//            return rezult;
//        }
//        return null;
//    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public void display() {
        System.out.println("---------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, data[i]);
            System.out.println();
        }
        System.out.println("---------");
    }

    protected int getStep(K key) {
        return 1;
    }


}
