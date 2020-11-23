package com.HW.Tree;

public class Tree {

    private int key;
    private Tree root;
    private Tree left_child = null;
    private Tree right_child = null;

    Tree (int key){
        this.key = key;
        this.root = null;
        this.left_child = null;
        this.right_child = null;
    }

    public Tree getRoot() {
        return root;
    }

    public void setRoot(Tree root) {
        this.root = root;
    }

    public void insert_left(Tree new_node){
        if (this.left_child == null){
            this.left_child = new_node;
        }
        else{
            Tree t = new_node;
            t.left_child = this.left_child;
            this.left_child = t;
        }
    }

    public void insert_right(Tree new_node){
        if (this.right_child == null){
            this.right_child = new_node;
        }
        else{
            Tree t = new_node;
            t.right_child = this.right_child;
            this.right_child = t;
        }
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Tree getLeft_child() {
        return this.left_child;
    }

    public Tree getRight_child() {
        return this.right_child;
    }

    public void input(int elem){
//        if (this.root == null){
//            this.setRoot(new Tree(elem));
//        }
//        else
        if (this.getKey() <= elem){
            if (this.getRight_child() == null)
                this.insert_right(new Tree(elem));
            else
                this.getRight_child().input(elem);
        }
        else if (this.getKey() > elem){
            if (this.getLeft_child() == null)
                this.insert_left(new Tree(elem));
            else
                this.getLeft_child().input(elem);
        }
    }

    public void printTree(){
//        if (this.root != null) {
            System.out.println(this.key);
            if (this.getLeft_child() != null) {
                System.out.print("L ");
                this.getLeft_child().printTree();
            }
        if (this.getRight_child() != null) {
            System.out.print("R ");
            this.getRight_child().printTree();
        }
//        }

    }


}
