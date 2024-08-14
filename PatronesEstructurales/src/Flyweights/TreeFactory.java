package Flyweights;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;
import java.util.Map;

// Fábrica de Flyweights que gestiona los objetos Flyweight
class TreeFactory {
    private Map<String, TreeType> treeTypes = new HashMap<>();

    public TreeType getTreeType(String treeName) {
        TreeType tree = treeTypes.get(treeName);

        if (tree == null) {
            tree = new Tree(treeName);
            treeTypes.put(treeName, tree);
        }

        return tree;
    }
}