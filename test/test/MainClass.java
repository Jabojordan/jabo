package test;

import java.util.Scanner;
import domain.PizzaConfig;

public class MainClass {

    PizzaConfig conf = new PizzaConfig();
    PizzaConfig pizza = new PizzaConfig();
    StringBuilder build = new StringBuilder();

    public static void main(String[] args) {
        new MainClass().startOrder();

    }

    public void startOrder() {
        System.out.println("\t Pizza Order System");
        System.out.println("\t--------------------");
        System.out.print("Pizza Name: ");
        double totalPrice = 0.0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String selected = scanner.nextLine();
        pizza.setName(selected);
        System.out.println();
        System.out.println("1) " + PizzaConfig.TYPE_LARGE + " (" + PizzaConfig.PRICE_LARGE + "RWF)");
        System.out.println("2) " + PizzaConfig.TYPE_MEDIUM + " (" + PizzaConfig.PRICE_MEDIUM + "RWF)");
        System.out.println("3) " + PizzaConfig.TYPE_SMALL + " (" + PizzaConfig.PRICE_SMALL + "RWF)");
        System.out.print("Choose pizza size:");
        double price = 0.0;
        int size = scanner.nextInt();

        switch (size) {
            case 1:
                pizza.setSize(PizzaConfig.TYPE_LARGE);
                pizza.setBaseprice(PizzaConfig.PRICE_LARGE);
                price = PizzaConfig.PRICE_LARGE;
                break;

            case 2:
                pizza.setSize(PizzaConfig.TYPE_MEDIUM);
                pizza.setBaseprice(PizzaConfig.PRICE_MEDIUM);
                price = PizzaConfig.PRICE_MEDIUM;
                break;

            case 3:
                pizza.setSize(PizzaConfig.TYPE_SMALL);
                pizza.setBaseprice(1000);
                price = 1000;
        }
        boolean terminate = false;
        while (!terminate) {
            System.out.println("Derivery Y or N (" + PizzaConfig.PRICE_DERIVERY + "RWF)");
            String delivery = scanner.next();
            if (delivery.toUpperCase().equals("Y")) {
                totalPrice = price + PizzaConfig.PRICE_DERIVERY;
                double amount = PizzaConfig.PRICE_DERIVERY;
                pizza.setDelivery(amount);
                System.out.println("Total Price is: " + totalPrice);
                terminate = true;
            } else if (delivery.toUpperCase().equals("N")) {
                totalPrice = price;
                double amount = 0.0;
                System.out.println("TotalPrice is : " + totalPrice);
                pizza.setDelivery(amount);
                terminate = true;
            } else {
                System.err.println("No match.");
                terminate = false;
            }
        }
        chooseOrderCategory(pizza, totalPrice);
    }

    public void chooseOrderCategory(PizzaConfig config, double totalPrice) {
        boolean terminated = false;
        Scanner scan = new Scanner(System.in);
        String category = "";
        while (!terminated) {
            System.out.println("1) Meat");
            System.out.println("2) Vegetable");
            System.out.print("Choose: ");
            switch (scan.nextInt()) {
                case 1:
                    String[] meatChoosen = addMeat();
                    category = "meat";
                    terminated = true;
                    config.setOptionsets(category, meatChoosen, totalPrice);
                    break;
                case 2:
                    String[] vegetableChoosen = addVegetable();
                    category = "vegetable";
                    terminated = true;
                    config.setOptionsets(category, vegetableChoosen, totalPrice);
                    completeOrder();
            }
        }
    }

    public String[] addMeat() {
        String arrayOfMeat[] = new String[12];
        boolean terminated = false;
        Scanner scan = new Scanner(System.in);
        while (!terminated) {
            System.out.println("1) Beef");
            System.out.println("2) Peperoni");
            System.out.println("3) Anchovy");
            System.out.println("4) Ham");
            System.out.println("5) Jump to Vegetable");
            System.out.print("Choose: ");
            switch (scan.nextInt()) {
                case 1:
                    build.append("Beef").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 2:
                    build.append("Peperoni").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 3:
                    build.append("Anchovy").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 4:
                    build.append("Ham").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 5:
                    terminated = true;
                    break;
                default:
                    System.err.println("wrong choice");
            }

        }
        return arrayOfMeat;

    }

    public String[] addVegetable() {
        int size = 1;
        String arrayOfVegetable[] = new String[12];
        int i = 0;
        boolean terminated = false;

        Scanner scan = new Scanner(System.in);
        while (!terminated) {
            System.out.println("1) Mushroom");
            System.out.println("2) Onion");
            System.out.println("3) Tomatoes");
            System.out.println("4) Return To Meat");
            System.out.println("5) Jump To Finish");
            switch (scan.nextInt()) {
                case 1:
                    build.append("Mushroom").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 2:
                    build.append("Onion").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 3:
                    build.append("Pineaple").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;
                case 4:
                    build.append("Tomatoes").append(" ");
                    completeOrder();
                    System.exit(0);
                    break;

                case 5:
                    addMeat();
                    break;

                case 6:

                    terminated = true;
                    break;
            }
        }
        return arrayOfVegetable;
    }

    public void completeOrder() {
        System.out.println("---------------------------------------------------------");
        System.out.println("Your Order have been completed");
        System.out.println("----------------------------------------------------------");
        System.out.println("\t Order Details");
        System.out.println("\t---------------");
        System.out.println("Pizza Name: " + pizza.getName());
        System.out.println("Pizza Size: " + pizza.getSize());
        System.out.println("Pizza Price: " + pizza.getBaseprice());
        System.out.println("Pizza Derivery Charge:" + pizza.getDelivery());
        System.out.println("Pizza Vegetable: " + build);
        System.out.println("Total Amount To Be Paid :" + pizza.getTotalAmount());
        System.out.println("----------------------------------------------------------");
        System.out.println("\tThank You!");
    }
}
