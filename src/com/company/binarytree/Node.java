package com.company.binarytree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.Comparable;

public class Node<K extends Comparable<K>, V >{
    K key;
    V value;
    Node<K, V> leftChild = null;
    Node<K, V> rightChild = null;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void insert(Node<K, V> node) {
        if(key.compareTo(node.key) > 0) {
            if(leftChild == null) leftChild = node;
            else leftChild.insert(node);
        } else {
            if(rightChild == null) rightChild = node;
            else rightChild.insert(node);
        }
    }

    @Override
    public String toString() {
        return toString(0);
    }

    private String toString(int depth) {
        String leftChStr = leftChild == null ? "" : leftChild.toString(depth + 1);
        String rightChStr = rightChild == null ? "" : rightChild.toString(depth + 1);
        return String.format("%s%s\n%s%s", "\t".repeat(depth), value, leftChStr, rightChStr);
    }


}
