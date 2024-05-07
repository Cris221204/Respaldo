import java.util.*;
public class ControladorBook {
    public void Books() {
        ConsoleReader cons = new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        System.out.println("===Books===");
        System.out.println("1) Eliminar libro");
        System.out.println("2) Crear libro");
        System.out.println("3) Actualizar libro");
        System.out.println("4) Mostrar todos los libros");
        System.out.println("5) Mostrar libros prestados");
        System.out.println("6) Mostrar libros disponibles para prestamo");
        System.out.print("Seleccionar opcion: ");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                for (Book boors : RepositoryBook.books) {
                    if (boors.isAvailable) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                leer.nextLine();
                StringValidator in1 = s -> s.matches("\\d+");
                String isbn1 = cons.ReadString("Isbn", in1);
                for (int i = 0; i < RepositoryBook.books.size(); i++) {
                    if (RepositoryBook.books.get(i).isAvailable) {
                        if (RepositoryBook.books.get(i).isbn.equals(isbn1)) {
                            RepositoryBook.books.remove(i);
                        }
                    }
                }
                break;
            case 2:
                leer.nextLine();
                StringValidator in = s -> s.matches("\\d+");
                String isbn = cons.ReadString("Isbn", in);
                System.out.print("title: ");
                String title = leer.nextLine();
                IntegerValidator id=(value)-> value > 0 && value <=31;
                int D= cons.ReadInt("Day",id);
                IntegerValidator me=(value)-> value> 0&& value <=12;
                int M=cons.ReadInt("Month",me);
                IntegerValidator ye=(value)->value> 0&& value<=9999;
                int Y= cons.ReadInt("Year",ye);
                Date publish = new Date(D, M, Y);
                leer.nextLine();
                for (Author autors : RepositoryProfile.cl) {
                    String book2 = "";
                    for (Book autor : autors.getAuthor()) {
                        book2 += autor.title + "|";
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
                System.out.print("Name author: ");
                String s = leer.nextLine();
                System.out.print("Lastname author: ");
                String z = leer.nextLine();
                for (Author pes : RepositoryProfile.cl) {
                    if (pes.getProfile().name.equals(s) && pes.getProfile().lastName.equals(z)) {
                        Book book1 = new Book(isbn, title, publish, pes, true);
                        RepositoryBook.books.add(book1);
                        //   Author.Author.add(book1);
                        pes.setAuthor(book1);
                    }
                }
                break;
            case 3:
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
                StringValidator in2 = d -> d.matches("\\d+");
                String nisbn = cons.ReadString("Isbn", in2);
                for (Book see : RepositoryBook.books) {
                    if (see.isbn.equals(nisbn)) {
                        System.out.println("===Book Reboot===");
                        StringValidator in3 = l -> l.matches("\\d+");
                        String isbns = cons.ReadString("Isbn", in3);
                        System.out.println("Title: ");
                        String titles = leer.nextLine();
                        IntegerValidator id1=(value)-> value > 0 && value <=31;
                        int D1= cons.ReadInt("Day",id1);
                        IntegerValidator me1=(value)-> value> 0&& value <=12;
                        int M2=cons.ReadInt("Month",me1);
                        IntegerValidator ye1=(value)->value> 0&& value<=9999;
                        int Y3= cons.ReadInt("Year",ye1);
                        Date birth = new Date(D1, M2, Y3);
                        System.out.println("Author: ");
                        String name = leer.nextLine();
                        see.isbn = isbns;
                        see.title = titles;
                        see.publishDate = birth;
                        see.author.profile.name = name;
                        return;
                    } else {
                        System.out.println("Vuelva hacerlo");
                    }
                }
                break;
            case 4:
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
                break;
            case 5:
                for (Book boors : RepositoryBook.books) {
                    if (!boors.isAvailable) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                break;
            case 6:
                for (Book boors : RepositoryBook.books) {
                    if (boors.isAvailable) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                break;
        }
    }
}
