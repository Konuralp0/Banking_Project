
import java.util.InputMismatchException;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class BankingMethods  {

    public static void execution() throws InterruptedException{ // log1: banka interface i icin dynamik olan metod kodlanicak (para cekme para yatirma vb.)
        System.out.println("****** Welcome to Online Banking System!! Please follow the instructions to create an online banking account ******\n");
        sleep(1900);
        AccountUser a = accountCreation();
        sleep(1500);
        spaces(50);
        operations(a);


    }

    private static void operations(AccountUser a) throws InterruptedException {
        a.showInfo();
        a.withdraw();
        a.deposit();

    }




    private static AccountUser accountCreation() throws InterruptedException{

        String name = nameCreation();
        String surname = surnameCreation();
        String password = passCreation();

        long balance;
        try {
             balance = balCreation();
        }catch (InputMismatchException e){
            System.out.println("Please input only numerical values [0-9]");
             balance = balCreation();

        }
        System.out.println("Creating your account. This can take up to 30 seconds !!");
        sleep(1500);
        System.out.println("Your account has been successfully created!");

        return new AccountUser(name,surname, password,balance);







    }

    private static String passCreation() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean passwordOk = false;

        String password;
        do {
            System.out.print("Please create your password:  ");
            password = scanner.nextLine();
            char firstChar = password.charAt(0);
            int lenPassword = password.length();
            char lastChar = password.charAt(lenPassword - 1);
            boolean isSpace = password.contains(" ");

            if (((int) firstChar >= 65 && (int) firstChar <= 90) && ((int) lastChar >= 97 && (int) lastChar <= 122) && lenPassword >= 8 && !isSpace) {
                System.out.println("Validating your password. Please be patient!");
                sleep(1500);
                System.out.println("Your password has been successfully created");
                passwordOk = true;


            } else {
                System.out.println("Validating your password. Please be patient!");
                sleep(1500);
                System.out.println("""
                        Your password does not provide the requirements!!
                        - Please ensure that your password starts with a capital letter
                        - ends with a small case letter
                        - does not contain space
                        - should contain at leat 8 characters""");

            }


        } while (!passwordOk);

        return password;
    }

    private static long balCreation(){
        Scanner scanner = new Scanner(System.in);
        boolean bError = true;
        long balance = 0;
        do {
            try {
                System.out.print("Please input the balance you want to start with: ");
                balance = Long.parseLong(scanner.nextLine());
                bError = false;

            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9] !");
            }
        }while (bError);
        return balance;
    }




    private static String nameCreation(){
        Scanner scanner = new Scanner(System.in);
        String name;
        int counter;


        do {
            counter = 0;
            System.out.print("Please type in your name: ");

             name = scanner.nextLine();
            for(int i = 0; i< name.length(); i++){
                int a = name.charAt(i);
                if(( a >=65 && a <= 90) || (a >= 97 && a <= 122)){
                    counter ++;


                }else {
                    counter--;

                }

            }
            if(counter < name.length()){
                System.out.println("Do not use any characters [!-*] or numerical values [0-9]!!!");
            }
        }while(counter < name.length());

        String name2 = name.toLowerCase();
        return name.substring(0,1).toUpperCase().concat(name2);

    }




    private static String surnameCreation(){
        Scanner scanner = new Scanner(System.in);
        String surname;
        int counter;


        do {
            System.out.print("Please type in your surname: ");
            counter = 0;
            surname = scanner.nextLine();
            for(int i = 0; i< surname.length(); i++){
                int a = surname.charAt(i);
                if(( a >=65 && a <= 90) || (a >= 97 && a <= 122)){
                    counter++;


                }else {
                    counter--;
                }

            }
            if(counter < surname.length()){
                System.out.println("Do not use any characters [!-*] or numerical values [0-9]!!!");
            }
        }while(counter < surname.length());

        String surname2 = surname.toLowerCase();
        return surname.substring(0,1).toUpperCase().concat(surname2);

    }

    private static void spaces(int a){
        for(int i = a; i>=0;i--){
            System.out.print("\n");
        }

    }



}
