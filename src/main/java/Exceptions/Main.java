package Exceptions;

import Exceptions.ExceptionsClasses.ItemNotFoundException;
import Exceptions.ExceptionsClasses.NoAvailableCopiesException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        Scanner sc = new Scanner(System.in);

        while (true){
            boolean esc = false;
            int input = 0;

            System.out.println(
                    "\n1. Посмотреть список всех доступных книг.\n" +
                    "2. Выдать (арендовать) книгу, если она есть в наличии.\n" +
                    "3. Вернуть (освободить) книгу.\n" +
                    "4. Добавить новую книгу в систему.\n" +
                    "5. Выйти из приложения.");

            try {
                input = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Ошибка: " + e.getClass() +
                        " Введите валидное (1-5) целое число\nПовторите ввод");
            }finally {
                sc.nextLine();
            }

            switch (input){
                case 1:
                    System.out.println(library.getAllBooks());
                    break;
                case 2:
                    System.out.println("Введите название книги, которую хотите взять: ");
                    String title = sc.nextLine();

                    try {
                        library.takeBook(title);
                    }catch (NoAvailableCopiesException e){
                        System.out.println("Ошибка: Все экземпляры заняты.");
                    }catch (ItemNotFoundException e){
                        System.out.println("Ошибка: такого названия нет в базе");
                    }
                    break;
                case 3:
                    System.out.println("Введите название возвращаемой книги: ");
                    String titleForReturn = sc.nextLine();

                    try {
                        library.returnBook(titleForReturn);
                    }catch (ItemNotFoundException e){
                        System.out.println("Ошибка: такого названия нет в базе");
                    }
                    break;
                case 4:
                    System.out.println("Введите название добавляемой книги: ");
                    String titleForAdd = sc.nextLine();
                    System.out.println("Введите автора добавляемой книги: ");
                    String author = sc.nextLine();

                    boolean validInput = false;
                    while (!validInput) {
                        System.out.println("Введите количество экземпляров добавляемой книги: ");
                        try {
                            int availableCopies = sc.nextInt();
                            library.addBook(titleForAdd, author, availableCopies);
                            System.out.println("Книга добавлена!");
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Ошибка: " + e.getClass() + " Введите целое число");
                            sc.nextLine();
                        }
                    }
                    break;
                case 5:
                    esc = true;
                    break;
            }
            if (esc){
                break;
            }

        }

    }

}