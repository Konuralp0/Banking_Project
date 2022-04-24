import java.util.Scanner;

public class AccountUser {
    private final String name;
    private final String surname;
    private String password;
    private static String idStatic = "00001";
    private final String id;
    private double balance;


    public AccountUser(String name, String surname, String password, double balance) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.balance = balance;
        id = idStatic;                                                      // NOT: Integer ile 0000001 gibi bir id consola sadece 1 olarak yazdirir onun icin Id yi String bir degiskene atamak gerekti
        String cutterStr;                                                   // Her bir AccountUser Instance i icin ID hep 1 artirmasi lazim ki hepsi ayni ID ye sahip olmasin. Bunun icin statik olan bir sayac gorevi goren degisken gerek
        String cutterStrHead = "";                                          // Bu statik degisken her bu constructor cagrildiginda statik olmayan ID ye atanip 1 artiralacak. Id statik bir degisken olamazdi cunku bu constructor ne kadar cagirilirsa o kadar artacak ve olusan butun hesaplarda ayni ID olacak
        int valueOfCutter= 0;
        for(int i = 0; i<idStatic.length(); i++){
            if(idStatic.charAt(i) == 0){
            }else{
                cutterStrHead = idStatic.substring(0,i);
                cutterStr = idStatic.substring(i);
                valueOfCutter = Integer.parseInt(cutterStr);
            }

        }
        int plusValueCutter = valueOfCutter+1;
        String plusValStr = String.valueOf(plusValueCutter);
        idStatic = cutterStrHead.concat(plusValStr);



    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        boolean bError = false;
        boolean isBig = false;
        do {                                                                  // NOT: Para cekiminde normal bakiyeden daha buyuk, 0 veya negatif bir sayi giriminde uyari vermesi gerek ve tekrar input istenmesi gerekecek bunun icin do while loop u ideal
            try {                                                             // Bir baska sikinti girilen inputun rakam disinda bir karakter olmasi programin Input exception vermemesi icinse try catch gerekli
                                                                            // Bunun icin scannerden gelen degeri String olarak alip double a parselemek gerekli eger girilen inputun icinde rakamdan baska bir karakter varsa  Exception atacak ve uyari verecek, atmassa boolean degere false atanip while loopdan cikilcak
                System.out.print("Please input the amount you want to withdraw: ");
                while(!isBig){


                    double bal = Double.parseDouble(scanner.nextLine());
                    if(bal > balance ){
                        System.out.println("******ERROR******\n" +
                                "Your balance is lower than what you are trying to withdraw. Please input a valid amount !");

                    }else if (bal<0 || bal == 0 ){
                        System.out.println("******ERROR******\n" +
                                "Please input a valid amount !");

                    }else{
                        balance = balance - bal;
                        System.out.println("Your new balance is: " + balance+"€");
                        isBig = true;
                        bError = true;

                    }


                }
            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9]");
            }
        }while (!bError);

    }

    public void deposit(){                                                             //Not: Depositte ayni sekilde rakamdan baska bir karakter girilince uyari verip tekrar girmemizi istemesi icin do while icinde try catch blogu kullanildi
        Scanner scanner = new Scanner(System.in);
        boolean bError = true;
        do {
            try {
                System.out.print("Please input the amount you want to deposit: ");
                double amountDep = Double.parseDouble(scanner.nextLine());
                balance += amountDep;
                System.out.println("Your new balance is: " + balance+"€");
                bError = false;

            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9]");


            }
        }while(bError);


    }





    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void showInfo() {
        System.out.println("Your personal banking account details: \n" +
                "Name = " + name + "\n" +
                "Surname = " + surname + "\n" +
                "Password = " + password + "\n" +
                "Id = " + id +"\n"+
                "Balance= " + balance +
                "€");
    }
}
