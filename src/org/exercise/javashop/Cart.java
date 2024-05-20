package org.exercise.javashop;

import org.exercise.javashop.subclasses.Headphone;
import org.exercise.javashop.subclasses.Smartphone;
import org.exercise.javashop.subclasses.Television;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cart {
    private Product[] products;
    private int productCount;

    public Cart(int maxSize) {
        this.products = new Product[maxSize];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Il carrello è pieno. Impossibile aggiungere altri prodotti.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < productCount; i++) {
            sb.append(products[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart(10);

        while (true) {
            System.out.println("Inserisci il tipo di prodotto (smartphone, televisori, cuffie) o 'esci' per terminare:");
            String productType = scanner.nextLine().trim().toLowerCase();

            if (productType.equals("esci")) {
                break;
            }

            System.out.println("Nome del prodotto:");
            String name = scanner.nextLine();
            System.out.println("Descrizione del prodotto:");
            String description = scanner.nextLine();
            System.out.println("Prezzo del prodotto (utilizza la virgola per distinguere i decimali):");
            BigDecimal price = scanner.nextBigDecimal();
            System.out.println("IVA del prodotto:");
            BigDecimal vat = scanner.nextBigDecimal();
            scanner.nextLine();

            switch (productType) {
                case "smartphone":
                    System.out.println("Codice IMEI:");
                    String imei = scanner.nextLine();
                    System.out.println("Quantità di memoria (GB):");
                    int memory = Integer.parseInt(scanner.nextLine());
                    Smartphone smartphone = new Smartphone(name, description, price, vat, imei, memory);
                    cart.addProduct(smartphone);
                    break;

                case "televisori":
                    System.out.println("Dimensioni (in pollici):");
                    int size = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("È una smart TV? (Y/N):");
                    String isSmartInput = scanner.nextLine().trim().toUpperCase();
                    boolean isSmart = isSmartInput.equals("Y");
                    Television television = new Television(name, description, price, vat, size, isSmart);
                    cart.addProduct(television);
                    break;

                case "cuffie":
                    System.out.println("Colore:");
                    String color = scanner.nextLine();
                    System.out.println("È wireless? (Y/N):");
                    String isWirelessInput = scanner.nextLine().trim().toUpperCase();
                    boolean isWireless = isWirelessInput.equals("Y");
                    Headphone headphone = new Headphone(name, description, price, vat, color, isWireless);
                    cart.addProduct(headphone);
                    break;

                default:
                    System.out.println("Tipo di prodotto non riconosciuto. Riprova.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Contenuto del carrello:");
        System.out.println(cart);
    }
}
