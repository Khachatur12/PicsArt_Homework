package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 9, 3, 6, 3, 2, 7, 654, 3};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    arr[i] += arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] -= arr[j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("\n___________________________________________________________________\n");

        Product milk = new Product();
        milk.setName("Milk");
        milk.setDescription("Coconut drink with rice, calcium, vitamins D2 և B12.");
        milk.setPrice(2.99);
        milk.setProduction_date(2021_09_04);
        milk.setShelf_life(2021_09_05);
        milk.setManufacturer("Mona Naturprodukte GmbH");
        milk.setIngredients("Water, coconut milk - 5.3%, rice, thickener․․․");

        System.out.println( milk.getDetails() );

        Product bread = new Product();
        milk.setName("Bread");
        milk.setDescription("Sandwich bread");
        milk.setPrice(0.45);
        milk.setProduction_date(2021_09_04);
        milk.setShelf_life(2021_13_04);
        milk.setManufacturer("Grupo Bimbo");
        milk.setIngredients(null);

        System.out.println( bread.getDetails() );
    }
}
