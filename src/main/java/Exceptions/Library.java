package Exceptions;

import Exceptions.ExceptionsClasses.ItemNotFoundException;
import Exceptions.ExceptionsClasses.NoAvailableCopiesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> catalog = new ArrayList<>();

    public Library() {
    }

    public String getAllBooks() {
        StringBuilder result = new StringBuilder("Список книг:\n");
        for (Book book : catalog) {
            result.append(book.getTitle()).append("\n");
        }
        return result.toString();
    }

    public void takeBook (String title) throws NoAvailableCopiesException {
        int index = getIndexByTitle(title);

        if (catalog.get(index).getAvailableCopies() > 0){
            catalog.get(index).availableCopiesMinusOne();
            System.out.println("Вы успешно арендовали книгу!");
        }else {
            throw new NoAvailableCopiesException("Все экземпляры книги '" + title + "' заняты");
        }
    }

    public void returnBook (String title) throws ItemNotFoundException {
        int index = getIndexByTitle(title);

        try {
            catalog.get(index).availableCopiesPlusOne();
            System.out.println("Вы успешно вернули книгу!");
        }catch (ItemNotFoundException e ){
            throw new ItemNotFoundException("Книга '" + title + "' не найдена в базе");
        }
    }

    public void addBook (String title, String author, int availableCopies){
        Book book = new Book(title, author, availableCopies);
        catalog.add(book);
    }

    public int getIndexByTitle(String title) throws ItemNotFoundException{
        int index = -1;

        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getTitle().equals(title)){
                index = i;
                break;
            }
        }

        if (index < 0){
            throw new ItemNotFoundException("Книга '" + title + "' не найдена в базе");
        }

        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(catalog, library.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(catalog);
    }
}