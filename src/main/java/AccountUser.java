import java.util.Scanner;

public class AccountUser {
    private String name = null;
    private String surname = null;
    private String password = null;
    private static String idStatic = "00001";
    private String id;
    private long balance;

    public AccountUser() {

    }


    public AccountUser(String name, String surname, String password, long balance) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.balance = balance;
        id = idStatic;
        String cutterStr;
        String cutterStrHead = "";
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
        boolean bError = true;
        do {
            try {
                boolean isBig = false;
                System.out.print("Please input the amount you want to withdraw: ");
                while(!isBig){


                    long bal = Long.parseLong(scanner.nextLine());
                    if(bal > balance ){
                        System.out.println("******ERROR******\n" +
                                "Your balance is lower than what you are trying to withdraw. Please input a valid amount !");
                    }else if (bal<0 || bal == 0 ){
                        System.out.println("******ERROR******\n" +
                                "Please input a valid amount !");
                    }else{
                        balance = balance - bal;
                        System.out.println("Your new balance is: " + balance);
                        isBig = true;

                    }

                bError = false;
                }
            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9]");
            }
        }while (bError);

    }

    public void deposit(){
        Scanner scanner = new Scanner(System.in);
        boolean bError = true;
        do {
            try {
                System.out.print("Please input the amount you want to deposit: ");
                long amountDep = Long.parseLong(scanner.nextLine());
                balance += amountDep;
                System.out.println("Your new balance is: " + balance);
                bError = false;

            }catch (Exception e){
                System.out.println("Please input only numerical values [0-9]");


            }
        }while(bError);


    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getBalance() {
        return balance + "€";

    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void showInfo() {
        System.out.println("Your personal banking account information: " +
                "Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Password='" + password + '\'' +
                ", Id=" + id +
                ", Balance=" + balance +
                "€}");
    }
}
