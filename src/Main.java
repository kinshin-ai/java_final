import java.util.*;

class PhoneBook {
    private HashMap<String, HashSet<String>> contacts = new HashMap<>();

    // Метод для добавления контакта в телефонную книгу
    public void addContact(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Метод для вывода телефонной книги отсортированной по убыванию числа телефонов
    public void showPhoneBook() {
        // Создаем список записей (имя - количество телефонов)
        List<Map.Entry<String, HashSet<String>>> sortedEntries = new ArrayList<>(contacts.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, HashSet<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " phones");
            System.out.println(entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Пример добавления контактов
        phoneBook.addContact("Alice", "123456");
        phoneBook.addContact("Bob", "789012");
        phoneBook.addContact("Alice", "654321");
        phoneBook.addContact("Bob", "987654");
        phoneBook.addContact("Charlie", "123456");
        phoneBook.addContact("Alice", "111222");
        phoneBook.addContact("Dave", "333444");
        phoneBook.addContact("Eve", "555666");
        phoneBook.addContact("Dave", "777888");
        phoneBook.addContact("Eve", "999000");

        // Вывод отсортированной телефонной книги
        phoneBook.showPhoneBook();
    }
}
