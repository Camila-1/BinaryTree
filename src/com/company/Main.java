package com.company;

import com.company.binarytree.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer, Double> tree = new BinaryTree<Integer, Double>();

        tree.insert(new Node<Integer, Double>(34, 3.14));
        tree.insert(new Node<Integer, Double>(45, 0.2));
        tree.insert(new Node<Integer, Double>(5, 9.35));
        tree.insert(new Node<Integer, Double>(55, 32.43));
        tree.insert(new Node<Integer, Double>(13, 545.0));
        tree.insert(new Node<Integer, Double>(12, 9.54));
        tree.insert(new Node<Integer, Double>(49, 0.934));
        tree.insert(new Node<Integer, Double>(17, 23.9));
        tree.insert(new Node<Integer, Double>(7, 32.4));
        tree.insert(new Node<Integer, Double>(24, 55.48));
        tree.insert(new Node<Integer, Double>(37, 7.15));
        tree.insert(new Node<Integer, Double>(18, 55.96));
        tree.insert(new Node<Integer, Double>(29, 1.789));
        tree.insert(new Node<Integer, Double>(76, 0.144));

        String result = tree.getValue(7).map(Object::toString).orElse("not found");
        System.out.println(result);
        System.out.println(tree);
        tree.remove(7);
        System.out.println(tree);
    }
}
