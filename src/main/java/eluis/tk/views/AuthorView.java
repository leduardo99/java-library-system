package eluis.tk.views;

import de.vandermeer.asciitable.AsciiTable;
import eluis.tk.controllers.AuthorController;
import eluis.tk.models.Author;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AuthorView extends BaseView {
    AuthorController authorController = new AuthorController();
    Author author = new Author();

    AsciiTable at = new AsciiTable();

    @Override
    public void init(int op, Scanner sc) {
        try {
            System.out.println();
            System.out.println("<---- MENU AUTOR ---->");
            System.out.println("1 - Adicionar autor");
            System.out.println("2 - Buscar autor");
            System.out.println("3 - Listar todos os autores");
            System.out.println("4 - Editar autor");
            System.out.println("5 - Remover autor");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            op = sc.nextInt();

            System.out.println();

            sc.nextLine();

            switch (op) {
                case 1: {
                    System.out.println("Nome: ");
                    String name = sc.nextLine();
                    author.setName(name);

                    sc.nextLine();

                    System.out.println("Sobrenome: ");
                    author.setFName(sc.nextLine());

                    authorController.Add(author);
                    break;
                }
                case 2: {
                    System.out.print("ID do autor: ");

                    author = authorController.Get(sc.nextInt());

                    System.out.println();

                    at.addRule();
                    at.addRow("ID", "NOME", "URL");
                    at.addRule();
                    at.addRow(author.getId(), author.getName(), author.getFName());
                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 3: {
                    System.out.println("Todos os autores: ");
                    List<Author> authors = authorController.GetAll();

                    at.addRule();
                    at.addRow("ID", "NOME", "URL");

                    for (Author value : authors) {
                        at.addRule();
                        at.addRow(value.getId(), value.getName(), value.getFName());
                    }

                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 4: {
                    System.out.println("ID do autor: ");
                    author = authorController.Get(sc.nextInt());
                    sc.nextLine();

                    System.out.println("DADOS ATUAIS, DEIXE EM BRACO CASO NÃO QUEIRA REALIZAR ALTERAÇÃO");
                    at.addRule();
                    at.addRow("ID", "NOME", "URL");
                    at.addRule();
                    at.addRow(author.getId(), author.getName(), author.getFName());
                    at.addRule();

                    System.out.println("Nome do autor: ");
                    String name = sc.nextLine();
                    author.setName(name.isEmpty() ? author.getName() : name);

                    System.out.println("Sobrenome do autor: ");
                    String fname = sc.nextLine();
                    author.setFName(fname.isEmpty() ? author.getFName() : fname);

                    authorController.Update(author);

                    break;
                }
                case 5: {
                    System.out.println("ID do autor: ");

                    authorController.Delete(sc.nextInt());

                    System.out.println("AUTOR EXCLUIDO COM SUCESSO!");

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
