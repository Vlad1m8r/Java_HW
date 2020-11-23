package com.HW.Tree;

public class main {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.input(3);
        tree.input(7);
        tree.input(8);
        tree.input(6);
        tree.input(4);
        tree.input(2);

        tree.printTree();
    }
}
