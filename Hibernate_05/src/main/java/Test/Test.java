package Test;

import Dao.AuthorDAO;
import Dao.BookDAO;
import Model.Author;
import Model.Book;

public class Test {
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        AuthorDAO authorDAO = new AuthorDAO();
//        List<Book> list = bookDAO.selectAll();
//        for (Book b: list) {
//            System.out.println(b.getTitle());
//        }
//
//        Book book = new Book();
//        Book book1 = bookDAO.selectByID(book);
//        System.out.println(book1.getBook_id() + book1.getTitle());

        Book book = new Book();
//        bookDAO.insert(book);
//        bookDAO.delete(book);
//        bookDAO.update(book);

        Author author = new Author();
//        List<Author> list = authorDAO.selectAll();
//        for (Author author1:list) {
//            System.out.println(author1.getName());
//        }
//        authorDAO.insert(author);
//        authorDAO.delete(author);
        authorDAO.update(author);
    }
}
