package Flyweights;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author pc1
 */
class Tree implements TreeType {
    private String treeName;

    public Tree(String treeName) {
        this.treeName = treeName;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + treeName + " tree at coordinates (" + x + ", " + y + ")");
    }
}