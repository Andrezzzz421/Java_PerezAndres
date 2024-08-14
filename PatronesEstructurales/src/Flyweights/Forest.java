package Flyweights;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

// Clase cliente que utiliza los objetos Flyweight
class Forest {
    private List<TreeType> trees = new ArrayList<>();
    private TreeFactory treeFactory = new TreeFactory();

    public void plantTree(String treeName, int x, int y) {
        TreeType treeType = treeFactory.getTreeType(treeName);
        trees.add(treeType);
        treeType.draw(x, y);
    }
}
