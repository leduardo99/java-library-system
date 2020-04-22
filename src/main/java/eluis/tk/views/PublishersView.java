package eluis.tk.views;

import de.vandermeer.asciitable.AsciiTable;
import eluis.tk.controllers.PublishersController;
import eluis.tk.models.Publishers;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PublishersView extends BaseView {
    PublishersController publishersController = new PublishersController();
    Publishers publishers = new Publishers();

    AsciiTable at = new AsciiTable();

    @Override
    public void init(int op, Scanner sc) {
        try {
            System.out.println();
            System.out.println("<---- MENU EDITORA ---->");
            System.out.println("1 - Adicionar editora");
            System.out.println("2 - Buscar editora");
            System.out.println("3 - Listar todos as editoras");
            System.out.println("4 - Editar editora");
            System.out.println("5 - Remover editora");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            op = sc.nextInt();

            System.out.println();

            sc.nextLine();

            switch (op) {
                case 1: {
                    System.out.println("Nome: ");
                    publishers.setName(sc.nextLine());
                    sc.nextLine();
                    System.out.println("URL: ");
                    publishers.setURL(sc.nextLine());

                    publishersController.Add(publishers);
                    break;
                }
                case 2: {
                    System.out.print("ID da editora: ");

                    publishers = publishersController.Get(sc.nextInt());

                    System.out.println();

                    at.addRule();
                    at.addRow("ID", "NOME", "URL");
                    at.addRule();
                    at.addRow(publishers.getId(), publishers.getName(), publishers.getURL());
                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 3: {
                    System.out.println("Todos as editores: ");
                    List<Publishers> publishers = publishersController.GetAll();

                    at.addRule();
                    at.addRow("ID", "NOME", "URL");

                    for (Publishers publisher : publishers) { // 201
                        at.addRule();
                        at.addRow(publisher.getId(), publisher.getName(), publisher.getURL());
                    }

                    at.addRule();

                    System.out.println(at.render());

                    break;
                }
                case 4: {
                    System.out.println("ID da editora: ");
                    int id = sc.nextInt();

                    publishers = publishersController.Get(id);
                    publishers.setId(id);
                    sc.nextLine();

                    System.out.println("DADOS ATUAIS, DEIXE EM BRACO CASO NÃO QUEIRA REALIZAR ALTERAÇÃO");
                    at.addRule();
                    at.addRow("ID", "NOME", "URL");
                    at.addRule();
                    at.addRow(publishers.getId(), publishers.getName(), publishers.getURL());
                    at.addRule();

                    System.out.println(at.render());

                    System.out.println("Nome da editora: ");
                    String name = sc.nextLine();
                    publishers.setName(name.isEmpty() ? publishers.getName() : name);

                    System.out.println("URL: ");
                    String URL = sc.nextLine();
                    publishers.setURL(URL.isEmpty() ? publishers.getURL() : URL);

                    publishersController.Update(publishers);

                    break;
                }
                case 5: {
                    System.out.println("ID da editora: ");

                    publishersController.Delete(sc.nextInt());

                    System.out.println("EDITORA REMOVIDA COM SUCESSO!");

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
