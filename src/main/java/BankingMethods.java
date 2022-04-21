import java.util.ArrayList;
import java.util.Scanner;

public class BankingMethods  {

    public static void Execution(){ // log1: banka interface i icin dynamik olan metod kodlanicak (para cekme para yatirma vb.)
        AccountUser a = accountCreation();


    }



    public static AccountUser accountCreation(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please type in your name: ");
        String name = scan.nextLine();
        System.out.print("Please type in your surname: ");
        String surname = scan.nextLine();
        String password = passCreatation();




        System.out.print("Please input the balance you want to start with: ");
        long balance = scan.nextLong();
        System.out.println("Your account has been successfully created!");

        AccountUser a = new AccountUser(name,surname, password,balance);

        return a;







    }

    public static String passCreatation() {
        Scanner scanner = new Scanner(System.in);
        boolean passwordOk = false;

        String password;
        do {
            System.out.print("Please create your password:  ");
            password = scanner.nextLine();
            char firstChar = password.charAt(0);
            int firstCharAscii = (int) firstChar;
            int lenPassword = password.length();
            char lastChar = password.charAt(lenPassword - 1);
            int lastCharAscii = (int) lastChar;
            boolean isSpace = password.contains(" ");

            if ((firstCharAscii >= 65 && firstCharAscii <= 90) && (lastCharAscii >= 97 && lastCharAscii <= 122) && lenPassword >= 8 && isSpace == false) {
                System.out.println("Your password has been succesfully created");
                passwordOk = true;


            } else {
                System.out.println("Your password does not provide the requirements!!\n" +
                        "- Please ensure that your password starts with a capital letter\n" +
                        "- ends with a small case letter\n" +
                        "- does not contain space\n" +
                        "- should contain at leat 8 characters");

            }


        } while (!passwordOk);

        return password;
    }



}
