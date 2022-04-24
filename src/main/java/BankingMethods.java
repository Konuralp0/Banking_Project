
import java.util.InputMismatchException;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class BankingMethods  {

    public static void execution() throws InterruptedException{ // log1: banka interface i icin dynamik olan metod kodlanicak (para cekme para yatirma vb.)
        System.out.println("\n****** Welcome to Online Banking System!! Please follow the instructions to create an online banking account ******\n");
        sleep(1900);
        AccountUser a = accountCreation();
        sleep(1500);
        operations(a);


    }

    private static void operations(AccountUser a) throws InterruptedException {
        spaces(100);



        a.showInfo();
        a.withdraw();
        a.deposit();

    }




    private static AccountUser accountCreation() throws InterruptedException{        //NOT: Burda asagida yazdigim metodlarin returnlerini degisklenlere atayip yeni bir AccountUser instanci olusuyor ve bu sayede yukardaki operations metodlarinda bu kullanicinin bilgilerini kullanima sunabilirim
                                                                                    // Metod InterruptedExceptionlari atiyor cunki isin icine biraz gercekcilik katsin diye internette dolum suresini canladiran sleep metodunu kullandim
        String name = nameCreation();
        String surname = surnameCreation();
        String password = passCreation();

        double balance = balCreation();
        System.out.println("\nCreating your account. This can take up to 30 seconds !!");
        sleep(1500);
        System.out.println("Your account has been successfully created !\n");
        sleep(1000);
        System.out.println("\nYou are now being redirected to your dashboard.");

        return new AccountUser(name,surname, password,balance);







    }

    private static String passCreation() throws InterruptedException {                //NOT: Sifre olusumunda kullandigim kod blogu bize ilk haftalarda verilen sifre odevindeki kod bloguyla hemen hemen ayni.
        Scanner scanner = new Scanner(System.in);                                      // Tek farki do while loopun icinde cunku gereksinimlere uygun bir sifre olusmadiysa tekrar girilmesi istenecek.
        boolean passwordOk = false;                                                    // Metod InterruptedExceptionlari atiyor cunki isin icine biraz gercekcilik katsin diye internette dolum suresini canladiran sleep metodunu kullandim

        String password;
        System.out.print("Please create your password: ");
        do {

            password = scanner.nextLine();
            char firstChar = password.charAt(0);
            int lenPassword = password.length();
            char lastChar = password.charAt(lenPassword - 1);
            boolean isSpace = password.contains(" ");
            System.out.println("Validating your password. Please be patient!");
            if (((int) firstChar >= 65 && (int) firstChar <= 90) && ((int) lastChar >= 97 && (int) lastChar <= 122) && lenPassword >= 8 && !isSpace) {
                sleep(1500);
                System.out.println("Your password has been successfully created");
                passwordOk = true;


            } else {

                sleep(1500);
                System.out.println();
                System.out.println("""
                        Your password does not provide the requirements!!
                        - Please ensure that your password starts with a capital letter
                        - ends with a small case letter
                        - does not contain space
                        - should contain at leat 8 characters""" + "\n"+"Please create a new password!" );

            }


        } while (!passwordOk);

        return password;
    }

    private static double balCreation(){                                                           //Not: Bakiye olusumu icin de ayri bir metod yazdim. Bu metodda AccountUser Classindaki withdraw ve depositle ayni mantikla ilerliyor
        Scanner scanner = new Scanner(System.in);                                                  // Eger rakam disinda bir karakter girilse program direk exception kapanmayip consola uyari verip kullanicidan tekrar girilmesini istiyor
        boolean bError = true;
        double balance = 0;
        do {
            try {
                System.out.print("\nPlease input the balance you want to start with: ");
                balance = Double.parseDouble(scanner.nextLine());
                bError = false;

            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9] !");
            }
        }while (bError);
        return balance;
    }




    private static String nameCreation(){                           //NOT: Soyadi olusumu icin de ayri bir metod yazdim ki genele bakilinca okunakli bir kod olsun.
        Scanner scanner = new Scanner(System.in);                   //  Burda onemli olan kullanicinin harflerden baska bir karakter girmemesi ve eger kucuk buyuk harf dikkat etmeksizin soyadini yazarsa sadece ilk harfi buyuk harf yapip digerlerini kucultup soyadina atamak
        String name;                                                 // Bunun icinde do while dongusu en uygunu. Harf kontrolu yapmak icin for loop kullandim ve bir sayc degiskenim var.
        int counter;                                                // Eger girilen harfsa sayac arttiralacak degilse azaltilacak ve en sonda toplam karakter sayisi sayac ile ayni degilse tekrar girilmesi istenecek


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
        return name.substring(0,1).toUpperCase().concat(name2.substring(1));

    }




    private static String surnameCreation(){                            //NOT: Soyadi olusumu icin de ayri bir metod yazdim ki genele bakilinca okunakli bir kod olsun.
        Scanner scanner = new Scanner(System.in);                       //  Burda onemli olan kullanicinin harflerden baska bir karakter girmemesi ve eger kucuk buyuk harf dikkat etmeksizin soyadini yazarsa sadece ilk harfi buyuk harf yapip digerlerini kucultup soyadina atamak
        String surname;                                                 // Bunun icinde do while dongusu en uygunu. Harf kontrolu yapmak icin for loop kullandim ve bir sayc degiskenim var.
        int counter;                                                    // Eger girilen harfsa sayac arttiralacak degilse azaltilacak ve en sonda toplam karakter sayisi sayac ile ayni degilse tekrar girilmesi istenecek


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
        return surname.substring(0,1).toUpperCase().concat(surname2.substring(1));

    }

    private static void spaces(int a ){                                      // NOT: Terminalde olan cls komutu consolda olmadigi icin onun yerine alan bosluklar adli metod. Bu metodla istenilen kadar bosluk atilip sanki consol temizlenmis goruntusu veriliyor
        for(int i = a; i>=0;i--){
            System.out.print("\n");
        }

    }



}
