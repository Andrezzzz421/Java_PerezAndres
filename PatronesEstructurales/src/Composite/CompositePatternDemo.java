/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Composite;

/**
 *
 * @author pc1
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Crear archivos
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");

        // Crear directorios
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Agregar archivos a los directorios
        dir1.addComponent(file1);
        dir1.addComponent(file2);
        dir2.addComponent(file3);

        // Crear un directorio principal y agregar subdirectorios a él
        Directory mainDirectory = new Directory("mainDirectory");
        mainDirectory.addComponent(dir1);
        mainDirectory.addComponent(dir2);

        // Mostrar detalles de todos los archivos y directorios
        mainDirectory.showDetails();
    }
}
