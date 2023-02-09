package Homework6;
import java.util.*;
public class Main {
    public static Integer FilterChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите число для поиска:
                1 -> по модели
                2 -> по процессору
                3 -> по оперативной памяти
                4 -> по жесткому диску
                5 -> по цвету
                6 -> посмотреть все модели""");
        System.out.print("Ввод -> ");
        return scanner.nextInt();
    }

    public static String FirstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void FindByFilter(Set<Notebook> products, String filter, String input) {
        int count = 1;
        Map<String, Notebook> result = new LinkedHashMap<>();
        for (Notebook PC : products) {
            if (PC.GetInfo(filter).contains(input)) {
                result.put(String.format("\n\nНоутбук №%d", count), PC);
                count++;
            }
        }
        if (result.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Вот что удалось найти:\n" + result);
        }
    }

    public static void main(String[] args) {
        Notebook PC1 = new Notebook("1", "HP 250", "Intel Core i5", "4 GB", "2T", "Black");
        Notebook PC2 = new Notebook("2", "ASUS Vivobook Go 14", "Intel Pentium Silver N6000", "4 GB", "1T", "Grey");
        Notebook PC3 = new Notebook("3", "Lenovo IdeaPad 1", "AMD Athlon Silver 3050e", "4 GB", "2T", "Black");
        Notebook PC4 = new Notebook("4", "Lenovo IdeaPad 1", "AMD Athlon Silver 3050e", "8 GB", "2T", "White");
        Notebook PC5 = new Notebook("5", "HP 250", "Intel Core i5", "4 GB", "1T", "Grey");
        Notebook PC6 = new Notebook("5", "HP 250", "Intel Core i5", "8 GB", "2T", "White");

        HashSet<Notebook> products = new HashSet<>(Arrays.asList(PC1, PC2, PC3, PC4, PC5, PC6));
        Map<Integer, String> filters = new HashMap<>();
        filters.put(1, "Model");
        filters.put(2, "Processor");
        filters.put(3, "RAM");
        filters.put(4, "HDD");
        filters.put(5, "Color");
        filters.put(6, "All products");
        int choice = FilterChoice();

        Scanner scanner = new Scanner(System.in);
        if (filters.containsKey(choice)) {
            switch (choice) {
                case 1 -> {
                    System.out.println("Введите наименование модели");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scanner.next());
                    FindByFilter(products, filters.get(1), input);
                }
                case 2 -> {
                    System.out.println("Введите наименование процессора");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scanner.next());
                    FindByFilter(products, filters.get(2), input);
                }
                case 3 -> {
                    System.out.println("Введите объём оперативной памяти");
                    System.out.print("Ввод -> ");
                    String input = scanner.next();
                    FindByFilter(products, filters.get(3), input);
                }
                case 4 -> {
                    System.out.println("Введите объём жёсткого диска");
                    System.out.print("Ввод -> ");
                    String input = scanner.next();
                    FindByFilter(products, filters.get(4), input);
                }
                case 5 -> {
                    System.out.println("Введите цвет");
                    System.out.print("Ввод -> ");
                    String input = FirstUpperCase(scanner.next());
                    FindByFilter(products, filters.get(5), input);
                }
                case 6 -> {
                    int count = 1;
                    System.out.println("\nНаш ассортимент:");
                    for (Notebook PC : products) {
                        System.out.println("\nНоутбук №" + count + PC);
                        count++;
                    }
                }
                default -> {
                }
            }
        }
    }
}
