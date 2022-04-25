


import java.util.Scanner;

import static java.lang.Thread.sleep;

public abstract class BankingMethods  {

    public static void execution() throws InterruptedException{
        System.out.println("\n****** Welcome to Online Banking System!! Please follow the instructions to create an online banking account ******\n");
        sleep(1900);
        AccountUser a = accountCreation();
        sleep(1500);
        operations(a);


    }

    private static void operations(AccountUser a) throws InterruptedException {
        spaces(30);
        System.out.println("--------------------------------------------- Welcome to your dashboard " + a.getName() +" " + a.getSurname()+"! ---------------------------------------------");
        boolean looping = true;
        boolean defaultLooping = true;
        do {                                                                                                    //NOT: --------> Her seyin dinamik bir sekilde olmasi icin yapilacak butun islemler bir dongunun icinde olmasi lazim  ve her hatada bu dongu exception vererek bozulmamasi lazim. Bu exceptionlari AccountUser classinda ve asagidaki metodlarda handling yaotigim icin sikinti olmadi
                                                                                                                // Birden fazla yapilabilcek operasyon olasiligi oldugu icin switch case kullanimi en uygundu
            spaces(2);
            sleep(1000);                                                                                   // Birden fazla boolean degerleri kullanmamin nedeni donguleri daha iyi kontrol edebilmek icindi
            System.out.println("\nPlease select from the operations below what you want to do!");
            System.out.println("""
                    -To withdraw money press 1 !
                    -To deposit money press 2 !
                    -To view your account details press 3 !
                    -To modify your account password press 4 !
                    -To log out from the system press 5 !""");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    System.out.println("Redirecting you to withdraw page....");
                    sleep(1500);
                    spaces(15);
                    a.withdraw();
                    break;
                case "2":
                    System.out.println("Redirecting you to deposit page....");
                    sleep(1500);
                    spaces(15);
                    a.deposit();
                    break;
                case "3":
                    System.out.println("To view your account details you have to type in your password!!");
                    boolean checkPass = false;
                    int counterForPass = 0;
                    do {
                        Scanner scanner1 = new Scanner(System.in);
                        String contrPass = scanner1.nextLine();
                        if (contrPass.equals(a.getPassword())){
                            checkPass = true;
                            System.out.println("Redirecting you to account details page....");
                            sleep(1500);
                            spaces(15);
                            a.showInfo();
                            sleep(1000);
                            break;
                        }else{
                            counterForPass++;
                            if(counterForPass == 3){
                                System.out.println("You have exceeded the amount of tries!! Your account has been locked. Please contact your local bank branch!! ");
                                System.exit(0);


                            }
                            System.out.print("Invalid Password!! Please try again: ");



                        }
                    }while (!checkPass);



                    break;
                case "4":
                    System.out.println("Please type in your current password!!");
                    boolean checkPass2 = false;
                    int counterForPass2 = 0;
                    do {
                        Scanner scanner1 = new Scanner(System.in);
                        String contrPass = scanner1.nextLine();
                        if (contrPass.equals(a.getPassword())){
                            checkPass2 = true;
                            System.out.println("Redirecting you to password creation page....");
                            spaces(15);
                            sleep(1500);
                            a.setPassword(passCreation());

                            sleep(1000);
                            break;
                        }else{
                            counterForPass2++;
                            if(counterForPass2 == 3){
                                System.out.println("You have exceeded the amount of tries!! Your account has been locked. Please contact your local bank branch!! ");
                                System.exit(0);


                            }
                            System.out.print("Invalid Password!! Please try again: ");



                        }
                    }while (!checkPass2);

                    break;

                case "5":
                    spaces(20);
                    System.out.println("Loging out....");
                    System.exit(0);
                default:
                    System.out.println("*****ERROR*****\n"+"That is not a valid operation!!");
                    defaultLooping = false;
            }



            if(defaultLooping){
            sleep(1000);
            boolean checkCon = false;
            System.out.println("Press 0 if you want to continue from your dashboard or 1 to exit from the system");
            while(!checkCon){
            Scanner scanner1 = new Scanner(System.in);
            String choice1 = scanner1.nextLine();
            if ("1".equals(choice1)) {
                looping = false;
                checkCon = true;
            }else if ("0".equals(choice1)){
                System.out.println("You are being redirected....");
                sleep(1500);
                spaces(20);
                checkCon = true;
                System.out.println("--------------------------------------------- Welcome back to your dashboard " + a.getName() +" " + a.getSurname()+"! ---------------------------------------------");
            }else {
                System.out.println("Please input a valid number!!");
            }
            }}

        }while (looping);

        spaces(10);
        System.out.println("Loging out....");
        System.exit(0);



    }




    private static AccountUser accountCreation() throws InterruptedException{       //NOT: Burda asagida yazdigim metodlarin returnlerini degisklenlere atayip yeni bir AccountUser instanci olusuyor ve bu sayede yukardaki operations metodlarinda bu kullanicinin bilgilerini kullanima sunabilirim
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
        Scanner scanner = new Scanner(System.in);                                     // Tek farki do while loopun icinde cunku gereksinimlere uygun bir sifre olusmadiysa tekrar girilmesi istenecek.
        boolean passwordOk = false;                                                   // Metod InterruptedExceptionlari atiyor cunki isin icine biraz gercekcilik katsin diye internette dolum suresini canladiran sleep metodunu kullandim

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
        System.out.print("\nPlease input the balance you want to start with(€): ");
        do {
            try {

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
        String name;                                                // Bunun icinde do while dongusu en uygunu. Harf kontrolu yapmak icin for loop kullandim ve bir sayc degiskenim var.
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
