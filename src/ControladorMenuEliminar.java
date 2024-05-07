import java.util.*;
public class ControladorMenuEliminar {
    public void eliminar() {
        ConsoleReader con=new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        int n;
        do {
            System.out.println("1) Eliminar clientes");
            System.out.println("2) Eliminar libros");
            System.out.println("3) Eliminar autores");
            System.out.println("4) Eliminar autor");
            System.out.print("Escoge una opcion:");
            n = leer.nextInt();
            switch (n) {
                case 1:
                    for (Client clients : RepositoryProfile.cr) {
                        String book = "";
                        for (Book client : clients.getBorrowedBoooks()) {
                            book += client.title + "|";
                        }
                        int day = clients.getProfile().birthdate.day;
                        int mon = clients.getProfile().birthdate.month;
                        int yea = clients.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                                clients.getProfile().name, clients.getProfile().lastName, Birthdate, clients.username, book);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    System.out.print("Name: ");
                    String namec1 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc1 = leer.nextLine();
                    for (int i = 0; i < RepositoryProfile.cr.size(); i++) {
                        if (RepositoryProfile.cr.get(i).getProfile().name.equals(namec1) && RepositoryProfile.cr.get(i).getProfile().lastName.equals(lastc1)) {
                            if (RepositoryProfile.cr.get(i).getBorrowedBoooks().isEmpty()) {
                                RepositoryProfile.cr.remove(i);
                            }
                        }
                    }
                    break;
                case 2:
                    for (Book boors : RepositoryBook.books) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                    leer.nextLine();
                    StringValidator in = s -> s.matches("\\d+");
                    String isbn1 = con.ReadString("Isbn", in);
                    for (int i = 0; i < RepositoryBook.books.size(); i++) {
                        if (RepositoryBook.books.get(i).isAvailable) {
                            if (RepositoryBook.books.get(i).isbn.equals(isbn1)) {
                                RepositoryBook.books.remove(i);
                            }
                        }
                    }
                    break;
                case 3:
                    for (Author autors : RepositoryProfile.cl) {
                        String book2 = "";
                        for (Book autore : autors.getAuthor()) {
                            book2 += autore.title + "|";
                        }
                        int day = autors.getProfile().birthdate.day;
                        int mon = autors.getProfile().birthdate.month;
                        int yea = autors.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                                autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
                        System.out.println("");
                        System.out.println("--------------------------------------------");
                    }
                    System.out.print("Name: ");
                    String namec2 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc2 = leer.nextLine();

                    for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
                        if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                            RepositoryProfile.cl.remove(i);
                        }
                    }
                    break;
                case 4:
                    Login login = new Login();
                    login.Login();
                    break;
            }
        }while (n!=5);
    }
}
