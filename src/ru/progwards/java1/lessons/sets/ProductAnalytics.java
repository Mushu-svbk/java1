package ru.progwards.java1.lessons.sets;

import java.util.*;

import static java.lang.System.*;

public class ProductAnalytics {
    static class Product {
        private final String code; //уникальный артикул товара

        public Product(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    static class Shop {
        @Override
        public String toString() {
            return "Магазин { " +
                    "продукты = " + products +
                    '}';
        }

        private final List<Product> products; //товары имеющиеся в магазине

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }
    }


    private static List<Shop> shops = null; //список магазинов
    private static List<Product> allProducts = null; //список всех товаров

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        ProductAnalytics.shops = shops;
        allProducts = products;
    }

    public static Set<Product> existInAll() {    //товары из products, которые имеются во всех магазинах
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();
        if (shops == null || shops.size() == 0) return new HashSet<>();

        Set<Product> products = new HashSet<>(allProducts);

        for (Shop shop : shops) {
            products.retainAll(new HashSet<>(shop.getProducts()));
        }
        return products;
    }

    public static Set<Product> existAtListInOne() { //товары из products, которые имеются хотя бы в одном магазине
        if (shops == null || shops.size() == 0) return new HashSet<>();

        Iterator<Shop> it = shops.iterator();
        Set<Product> products = new HashSet<>(it.next().getProducts());
        while (it.hasNext()) {
            products.addAll(new HashSet<>(it.next().getProducts()));
        }
        products.retainAll(allProducts);
        return products;
    }

    public static Set<Product> notExistInShops() { //товары из products, которых нет ни в одном магазине
        if (allProducts == null || allProducts.size() == 0) return new HashSet<>();
        Set<Product> products = new HashSet<>(allProducts);
        if (shops == null || shops.size() == 0) return products;

        for (Shop shop : shops) {
            products.removeAll(new HashSet<>(shop.getProducts()));
        }
        return products;
    }

    public static Set<Product> existOnlyInOne() {     //товары из products, которые есть только в одном магазине
        Set<Product> products = new HashSet<>();
        if (allProducts == null || allProducts.size() == 0) return products;
        if (shops == null || shops.size() == 0) return products;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> productsBefore = new HashSet<>();
            Set<Product> products1 = new HashSet<>();
            Set<Product> productsNow;
            Iterator<Shop> it = shops.iterator();
            for (int k = 0; k < shops.size(); k++) {
                productsNow = new HashSet<>(it.next().getProducts());
                productsNow.retainAll(allProducts);
                if (k < i) {
                    productsBefore.addAll(productsNow);
                } else if (k == i) {
                    products1 = productsNow;
                    products1.removeAll(productsBefore);
                } else {
                    products1.removeAll(productsNow);
                }
            }
            products.addAll(products1);
        }

        return products;
    }

    public static void main(String[] args) {
        Product p1 = new Product("SF-001");
        Product p2 = new Product("SF-002");
        Product p3 = new Product("SF-003");
        Product p4 = new Product("SF-004");
        Product p5 = new Product("SF-005");
        Product p6 = new Product("SF-006");
        Product p7 = new Product("SF-007");
        Product p8 = new Product("SF-008");
        Product p9 = new Product("SF-009");
        Product p10 = new Product("SF-010");
        Shop s1 = new Shop(new ArrayList<>(Arrays.asList(p2, p7, p8, p10)));
        Shop s2 = new Shop(new ArrayList<>(Arrays.asList(p1, p4, p6, p10)));
        Shop s3 = new Shop(new ArrayList<>(Arrays.asList(p1, p4, p5, p10)));
        List<Shop> ss = new ArrayList<>(Arrays.asList(s1, s2, s3));
        List<Product> pa = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
        new ProductAnalytics(pa, ss);
        out.println("Только в одном магазине: " + existOnlyInOne());
        out.println("Во всех магазинах: " + existInAll());
        out.println("Хотя бы в одном магазине" + existAtListInOne());
        out.println("Нет ни в одном магазине " + notExistInShops());
        out.println("Магазин 1: " + s1);
        out.println("Магазин 2: " + s2);
        out.println("Список магазинов: " + ss);
        out.println("Магазин 3: " + s3);

    }
}
