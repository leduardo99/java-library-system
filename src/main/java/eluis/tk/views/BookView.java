package eluis.tk.views;

import de.vandermeer.asciitable.AsciiTable;
import eluis.tk.controllers.BooksController;
import eluis.tk.models.Books;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookView extends BaseView {
    BooksController booksController = new BooksController();
    Books books = new Books();

    AsciiTable at = new AsciiTable();

    @Override
    public void init(int op, Scanner sc) {

        try {
            System.out.println();
            System.out.println("<---- MENU LIVRO ---->");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Buscar livro");
            System.out.println("3 - Listar todos os livros");
            System.out.println("4 - Editar livro");
            System.out.println("5 - Remover livro");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            op = sc.nextInt();

            System.out.println();

            sc.nextLine();

            switch (op) {
                case 1: {
                    System.out.println("Titulo: ");
                    books.setTitle(sc.nextLine());

                    sc.nextLine();

                    System.out.println("Ibsn: ");
                    books.setIBSN(sc.nextLine());

                    System.out.println("Editora (ID): ");
                    books.setPublisherId(sc.nextInt());

                    System.out.println("Preço: ");
                    books.setPrice(sc.nextFloat());

                    booksController.Add(books);
                    break;
                }
                case 2: {
                    System.out.print("IBSN do livro (apenas números): ");

                    books = booksController.Get(sc.nextInt());

                    System.out.println();

                    at.addRule();
                    at.addRow("ID", "IBSN", "TITULO", "PREÇO", "PUBLISHER_ID");
                    at.addRule();
                    at.addRow(books.getId(), books.getIBSN(), books.getTitle(), books.getPrice(), books.getPublisherId());
                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 3: {
                    System.out.println("Todos os livros: ");
                    List<Books> books = booksController.GetAll();

                    at.addRule();
                    at.addRow("ID", "IBSN", "TITULO", "PREÇO", "PUBLISHER_ID");

                    for (Books book : books) {
                        at.addRule();
                        at.addRow(book.getId(), book.getIBSN(), book.getTitle(), book.getPrice(), book.getPublisherId());
                    }

                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 4: {
                    System.out.println("IBSN do livro: ");
                    books = booksController.Get(sc.nextInt());
                    sc.nextLine();

                    System.out.println("DADOS ATUAIS, DEIXE EM BRACO CASO NÃO QUEIRA REALIZAR ALTERAÇÃO");
                    at.addRule();
                    at.addRow("ID", "IBSN", "TITULO", "PREÇO", "PUBLISHER_ID");
                    at.addRule();
                    at.addRow(books.getId(), books.getIBSN(), books.getTitle(), books.getPrice(), books.getPublisherId());
                    at.addRule();

                    System.out.println(at.render());

                    System.out.println("Titulo: ");
                    String title = sc.nextLine();
                    books.setTitle(title.isEmpty() ? books.getTitle() : title);

                    System.out.println("Editora (ID): ");
                    String publisherId = sc.nextLine();
                    books.setPublisherId(publisherId.isEmpty() ? books.getPublisherId() : Integer.parseInt(publisherId));

                    System.out.println("Preço: ");
                    String price = sc.nextLine();
                    books.setPrice(price.isEmpty() ? books.getPrice() : Float.parseFloat(price));

                    booksController.Update(books);

                    System.out.println("LIVRO ATUALIZADO COM SUCESSO!");

                    break;
                }
                case 5: {
                    System.out.println("IBSN do livro: ");

                    booksController.Delete(sc.nextInt());

                    System.out.println("LIVRO REMOVIDO COM SUCESSO");

                    break;
                }
                case 0: {
                    new MainView().init();
                    break;
                }
                default:
                    break;
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }
}
