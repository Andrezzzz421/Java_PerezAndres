/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Visitor;

/**
 *
 * @author camper
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book(20, "Design Patterns"),
                new Fruit(10, 2, "Banana"),
                new Fruit(5, 5, "Apple")
        };

        int totalCost = calculatePrice(items);
        System.out.println("Total Cost = " + totalCost);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
