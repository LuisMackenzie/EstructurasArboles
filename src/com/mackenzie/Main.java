package com.mackenzie;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Empleado e1 = new Empleado(10, "Pepito Perez", "Ventas", "A-247");
        Empleado e2 = new Empleado(44, "Ana Lopez", "RRHH", "B-489");
        Empleado e3 = new Empleado(78, "Elena Nito", "Ventas", "C-837");
        Empleado e4 = new Empleado(33, "Jose Gomez", "Contabilidad", "D-409");
        Empleado e5 = new Empleado(64, "Paco Clavel", "Marketing", "F-510");
        Empleado e6 = new Empleado(55, "Javier Suarez", "Informatica", "G-355");
        Empleado e7 = new Empleado(24, "Ana Lopez", "RRHH", "B-489");

        BST bst = new BST();

        Arrays.asList(e1, e2, e3, e4, e5, e6, e7).forEach(bst::insert);

        // bst.delete(20);

        System.out.println("Inorden");
        bst.inorden();
        System.out.println("");

        System.out.println("Preorden");
        bst.preorden();
        System.out.println("");

        System.out.println("Postorden");
        bst.postorden();
        System.out.println("");

        // System.out.println("Esta vacio:" + bst.esVacio() + " Es Hoja:" + bst.esHoja());
        // bst.insert(e1);
        // System.out.println("Esta vacio:" + bst.esVacio() + " Es Hoja:" + bst.esHoja());
        // bst.insert(e2);
        // System.out.println("Esta vacio:" + bst.esVacio() + " Es Hoja:" + bst.esHoja());
        // bst.insert(e3);
        // System.out.println("Esta vacio:" + bst.esVacio() + " Es Hoja:" + bst.esHoja());

        // localizar(bst, 44);
        // localizar(bst, 54);


    }

    private static void localizar(BST bst, int id) {
        if (bst.exists(id)) {
            System.out.println(bst.obtener(id));
        } else {
            System.out.println("No encuentro el empleado " + id);
        }
    }
}
