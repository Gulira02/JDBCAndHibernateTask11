package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        System.out.println( "<<<COMMANDS>>>"+
                "1 enter-> createUsersTable" +
                "2 enter-> saveUser" +
                "3 enter-> dropUsersTable" +
                "3 enter-> saveUser" +
                "4 enter-> removeUserById" +
                "5 enter-> getAllUsers" +
                "6 enter-> cleanUsersTable");
        Scanner scanner = new Scanner(System.in);
        while (true){
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    service.createUsersTable();
                    break;
                case 2:
                    service.dropUsersTable();
                    break;
                case 3:
                    service.saveUser("Dina", "Zeron", (byte)19 );
                    service.saveUser("Sena", "Marom", (byte)16 );
                    service.saveUser("Tima", "Merlin", (byte)17 );
                    service.saveUser("Ema", "Artur", (byte)18 );
                    break;
                case 4:
                    service.removeUserById(3);
                    break;
                case 5:
                    System.out.println(service.getAllUsers());
                    break;
                case 6:
                    service.cleanUsersTable();
                    break;
                default:
                    System.out.println("Your method is complete!");
            }
        }
        // реализуйте алгоритм здесь
    }
}
