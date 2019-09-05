package com.company.binarytree;

import java.util.Optional;

public class BinaryTree<K extends Comparable<K>, V >{

    private Node<K, V > root = null;

    public void insert(Node<K, V> node) {
        if(root == null) root = node;
        else root.insert(node);
    }

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public Optional<Node<K, V>> find(K key) {
        return search(root, key);
    }

    public Optional<V> getValue(K key) {
        return search(root, key).map(node -> node.value);
    }

    public Optional<Node<K, V>> remove(K key) {
        return delete(root, key);
    }

    private Optional<Node<K, V>> search(Node<K, V> node, K key) {
        if(node == null)
            return Optional.empty();
        if(node.key.compareTo(key) == 0)
            return Optional.of(node);
        if(node.key.compareTo(key) > 0)
            return search(node.leftChild, key);
        else
            return search(node.rightChild, key);
    }

    private Optional<Node<K, V>> delete(Node<K, V> node, K key) {
        if(node == null)
            return Optional.empty();
        if(node.key.compareTo(key) > 0) {
            node.leftChild = delete(node.leftChild, key).orElse(null);
        } else if(node.key.compareTo(key) < 0) {
            node.rightChild = delete(node.rightChild, key).orElse(null);
        } else if(node.leftChild != null && node.rightChild != null) {
            node.key = minimum(node.rightChild).get().key;
            node.rightChild = delete(node.rightChild, node.key).orElse(null);
        } else {
            if(node.leftChild != null)
                node = node.leftChild;
            else
                node = node.rightChild;
        }
        return node == null ? Optional.empty() : Optional.of(node);
    }

    private Optional<Node<K, V>> minimum(Node<K, V> node) {
        if(node.leftChild == null)
            return Optional.of(node);
        return minimum(node.leftChild);
    }
}

