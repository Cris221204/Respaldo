import java.util.*;

public class ControladorSuperAdministrator {
    public void Senad() {
        Scanner leer = new Scanner(System.in);
        ConsoleReader con = new ConsoleReader();
        int n;
        do {
            System.out.println("===Menu SuperAdmin===");
            System.out.println("1) Crear administrador");//si funciona
            System.out.println("2) Editar administrador");//si funciona
            System.out.println("3) Eliminar administrador");// si funciona
            System.out.println("4) Mostrar los administradores");//si funciona
            System.out.println("5) Client");
            System.out.println("6) Author");
            System.out.println("7) Book");
            System.out.println("8) Profile");
            System.out.println("9) Transaction");
            System.out.println("10) Cerrar sesion");
            System.out.println("11) Editar permisos");
            System.out.print("Elige:");
            n = leer.nextInt();
            switch (n) {
                case 1:
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc = leer.nextLine();
                    IntegerValidator id=(value)-> value > 0 && value <=31;
                    int D= con.ReadInt("Day",id);
                    IntegerValidator me=(value)-> value> 0&& value <=12;
                    int M=con.ReadInt("Month",me);
                    IntegerValidator ye=(value)->value> 0&& value<=9999;
                    int Y= con.ReadInt("Year",ye);
                    System.out.print("Username: ");
                    String user = leer.nextLine();
                    StringValidator pas = password -> password.length() >= 6;
                    String pass = con.ReadString("Password", pas);
                    Date fechad = new Date(D, M, Y);
                    Profile ad1 = new Profile(namec, lastc, fechad);
                    Administrator ulti = new Administrator(ad1, user, pass, false);
                    ulti.addPermissions();
                    RepositoryArrayAdClie.Adminycliente.add(ulti);
                    break;
                case 2:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
leer.nextLine();
                    System.out.print("Dame el nombre:");
                    String nombre2 = leer.nextLine();
                    System.out.print("Dame el username: ");
                    String un = leer.nextLine();
                    for (User mod : RepositoryArrayAdClie.Adminycliente) {
                        if(mod instanceof Administrator){
                            Administrator ad=(Administrator) mod;
                        if (ad.profile.name.equals(nombre2) && ad.username.equals(un)) {
                            StringValidator pa = password -> password.length() >= 6;
                            System.out.print("Nombre: ");
                            String names = leer.nextLine();
                            System.out.print("Last name: ");
                            String last = leer.nextLine();
                            IntegerValidator id2=(value)-> value > 0 && value <=31;
                            int D1= con.ReadInt("Day",id2);
                            IntegerValidator me2=(value)-> value> 0&& value <=12;
                            int M2=con.ReadInt("Month",me2);
                            IntegerValidator ye2=(value)->value> 0&& value<=9999;
                            int Y3= con.ReadInt("Year",ye2);
                            System.out.print("Username: ");
                            String user2 = leer.nextLine();
                            String pass2 = con.ReadString("Password", pa);
                            Date date = new Date(D1, M2, Y3);
                            mod.profile.name = names;
                            mod.profile.lastName = last;
                            mod.profile.birthdate = date;
                            mod.username = user2;
                            mod.password = pass2;
                        }
                    }}
                    break;
                case 3:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator las = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, las.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec1 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc1 = leer.nextLine();
                    System.out.print("Username:");
                    String Us = leer.nextLine();
                    boolean superexis = false;
                    for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
                        if (RepositoryArrayAdClie.Adminycliente.get(i).profile.name.equals(namec1) && RepositoryArrayAdClie.Adminycliente.get(i).profile.lastName.equals(lastc1) && RepositoryArrayAdClie.Adminycliente.get(i).username.equals(Us)) {
                            RepositoryArrayAdClie.Adminycliente.remove(i);
                            break;
                        }
                    }
                    if ((superexis)) {
                        System.out.println("No se puede eliminar");
                    }
                    break;
                case 4:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("===CLIENT===");
                    ControladorClient client = new ControladorClient();
                    client.pc();
                    break;
                case 6:
                    System.out.println("===AUTHOR===");
                    ControladorAuthor auti = new ControladorAuthor();
                    auti.ca();
                    break;
                case 7:
                    System.out.println("===BOOK===");
                    ControladorBook booki = new ControladorBook();
                    booki.Books();
                    break;
                case 8:
                    System.out.println("===PROFILE===");
                    ControladorProfile profils = new ControladorProfile();
                    profils.profiles();
                    break;
                case 9:
                    System.out.println("===TRANSACTION===");
                    ControladorTransaction teis = new ControladorTransaction();
                    teis.trans();
                    break;
                case 10:
                    Login login = new Login();
                    login.Login();
                    break;
                case 11:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    leer.nextLine();
                    System.out.print("Dame el username: ");
                    String dam = leer.nextLine();
                    for (User rep : RepositoryArrayAdClie.Adminycliente) {
                        if (rep instanceof Administrator) {
                            Administrator pres = (Administrator) rep;
                            if (rep.username.equals(dam)) {
                                if (pres.isSuperAdmin) {
                                    System.out.println("No puedes modificar los permisos");
                                    ControladorSuperAdministrator controladorSuperAdministrator = new ControladorSuperAdministrator();
                                    controladorSuperAdministrator.Senad();
                                }
                                System.out.println("===Permisos actuales del administrador===");
                                for (Permissions pes : pres.getPermissions()) {
                                    System.out.println(pes);
                                }
                                System.out.println("1) Eliminar");
                                System.out.println("2) Agregar");
                                System.out.print("Selecciona una opcion:");
                                int ag = leer.nextInt();
                                switch (ag) {
                                    case 1:
                                        pres.getPermissions().clear();
                                        System.out.println("Eliminados");
                                        break;
                                    case 2:
                                        System.out.println("===Permisos===");
                                        System.out.println("1) Agregar Eliminar");
                                        System.out.println("2) Agregar Leer");
                                        System.out.println("3) Agregar Escribir");
                                        System.out.println("4) Agregar todos los permisos anteriores");
                                        System.out.print("Seleccionar: ");
                                        int p = leer.nextInt();
                                        switch (p) {
                                            case 1:
                                                pres.addDelete();
                                                break;
                                            case 2:
                                                pres.addRead();
                                                break;
                                            case 3:
                                                pres.addWrite();
                                                break;
                                            case 4:
                                                pres.addPermissions();
                                                System.out.println("Agregados");
                                                break;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    break;
            }
        } while (n != 12);
    }
}//Resolver lo de el booleano de superadmin por que si no, no vas a poder avanzar a esta cosa