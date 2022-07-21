package org.example;
import org.example.servise.UserServiceImpl;
import java.util.Scanner;

public class App{
    public static void main( String[] args ) {

//        Util.getSession();
        UserServiceImpl userService = new UserServiceImpl();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            JalpyMaalymat();

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    userService.createUsersTable();
                    break;
                case 2:
                    userService.saveUser("Sadyr", "Japarov", (byte) 50);
                    userService.saveUser("Tynchtykbek", "Akmatov", (byte) 30);
                    userService.saveUser("Timur", "Akmatov", (byte) 20);
                    userService.saveUser("Adilet", "Akmatov", (byte) 19);
                    userService.saveUser("Asan", "Usonov", (byte) 18);
                case 3:
                    System.out.println(userService.getAllUsers());
                    break;
                case 4:
                    System.out.println("┌——————————————————————————————————┐");
                    System.out.println("│ КОЛДОНУУЧУНУН ID НОМЕРИН ЖАЗЫНЫЗ │");
                    System.out.println("└——————————————————————————————————┘");
                    Long l = scanner.nextLong();
                        System.out.println(userService.getById(l));
                    break;
                case 5:
                    System.out.println("┌——————————————————————————————————┐");
                    System.out.println("│ КОЛДОНУУЧУНУН ID НОМЕРИН ЖАЗЫНЫЗ │");
                    System.out.println("└——————————————————————————————————┘");
                    Long n = scanner.nextLong();

                        userService.removeUserById(n);
                        break;
                case 6:
                    userService.updateUser(idMethod(), nameMethod(), lastNameMethod(), userAge());
                    System.out.println("┌——————————————————————————————————————————————————————————————————————————┐");
                    System.out.println("│ СИЗ ТАНДАГАН БОЮНЧА КОЛДОНУУЧУ АЛМАШТЫРЫЛДЫ. ТАБЛИЦАНЫ ТЕКШЕРИП КОЙУНУЗ! │");
                    System.out.println("└——————————————————————————————————————————————————————————————————————————┘");
                    break;
                case 7:
                    userService.cleanUsersTable();
                    break;
                case 8:
                    userService.dropUsersTable();
                    break;
            }
        }
    }
    public static void JalpyMaalymat(){
        System.out.println("┌————————————————————————————————————┬———┬—————————┐");
        System.out.println("│      ЖАНЫ ТАБЛИЦА ТУЗУУ УЧУН:      │ 1 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│   ТАБЛИЦАГА МААЛЫМАТ КОШУУ УЧУН:   │ 2 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│ МААЛЫМАТТАРДЫН БАРЫН ЧЫГАРУУ УЧУН: │ 3 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│    ID БОЮНЧА МААЛЫМАТ АЛУУ УЧУН:   │ 4 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│ ID БОЮНЧА МААЛЫМАТТЫ ОЧУРУУ УЧУН:  │ 5 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│ ID БОЮНЧА МААЛЫМАТТЫ ОЗГОРТУУ УЧУН:│ 6 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│ МААЛЫМАТТАРДЫН БАРЫН ТАЗАЛОО УЧУН: │ 7 │ БАСЫНЫЗ │");
        System.out.println("├————————————————————————————————————┼———┼—————————┤");
        System.out.println("│ ТАБЛИЦАНЫ ТОЛУГУ МЕНЕН ОЧУРУУ УЧУН:│ 8 │ БАСЫНЫЗ │");
        System.out.println("└————————————————————————————————————┴———┴—————————┘");
    }
    public static Long idMethod() {
        UserServiceImpl userService1 = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("┌—————————————————————————————————————————————————————————┐");
        System.out.println("│  СИЗ ID БОЮНЧА МААЛЫМАТТЫ ОЗГОРТУУ БОЛУМУН ТАНДАДЫНЫЗ   │");
        System.out.println("├—————————————————————————————————————————————————————————┤");
        System.out.println("│ АЗЫРКЫ УЧУРДА ТАБЛИЦАДА БАР БОЛГОН БИР ID НОМЕР ЖАЗЫНЫЗ │");
        System.out.println("└—————————————————————————————————————————————————————————┘");
        Long idL = scanner.nextLong();

        return idL;
    }

    public static String nameMethod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("┌——————————————————————————————————————————————————————————┐");
        System.out.println("│      CИЗ КОШУУНУ КААЛАГАН КОЛДОНУУЧУНУН АТЫН ЖАЗЫНЫЗ     │");
        System.out.println("└——————————————————————————————————————————————————————————┘");
        String name = scanner.nextLine();

        return name;
    }

    public static String lastNameMethod(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("┌——————————————————————————————————————————————————————————┐");
        System.out.println("│   CИЗ КОШУУНУ КААЛАГАН КОЛДОНУУЧУНУН ФАМИЛИЯСЫН ЖАЗЫНЫЗ  │");
        System.out.println("└——————————————————————————————————————————————————————————┘");
        String lastNameM = scanner.nextLine();

        return lastNameM;
    }

    public static int userAge(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("┌—————————————————————————————┐");
        System.out.println("│ КОЛДОНУУЧУНУН ЖАШЫН ЖАЗЫНЫЗ │");
        System.out.println("└—————————————————————————————┘");

        int age = scanner.nextInt();
        return age;
    }

}
//        userService.saveUser("Tynchtykbek", "Akmatov", (byte) 30);
//        userService.saveUser("Timur", "Akmatov", (byte) 20);
//        userService.createUsersTable();
//        userService.dropUsersTable();
//        userService.removeUserById(3);
//        System.out.println(userService.getAllUsers());
//        userService.updateUser(1L,"Asan", "Usonov", 25); // 1-id degi user ushuga ozgordu
//        userService.cleanUsersTable();
