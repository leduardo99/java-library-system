package eluis.tk.views;

import java.util.Scanner;

public class MainView extends BaseView {

    @Override
    public void init() {
        Scanner scanner = new Scanner(System.in);

        int operation;

        System.out.println("O QUE VOCÊ DESEJA FAZER?");
        System.out.println("1 - Autores");
        System.out.println("2 - Livros");
        System.out.println("3 - Editoras");
        System.out.println("0 - Sair");

        System.out.print("Opção: ");
        operation = scanner.nextInt();

        while (true) {
            switch (operation) {
                case 1: {
                    new AuthorView().init(operation, scanner);
                    break;
                }
                case 2: {
                    new BookView().init(operation, scanner);
                    break;
                }
                case 3: {
                    new PublishersView().init(operation, scanner);
                    break;
                }
                case 0:
                    System.exit(0);
                    return;
                default:
                    break;
            }
        }
    }
}
