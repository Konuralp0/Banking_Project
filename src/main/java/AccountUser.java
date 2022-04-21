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
        String cutterStr = "";
        String cutterStrHead = "";
        int valueOfCutter= 0;
        for(int i = 0; i<idStatic.length(); i++){
            if(idStatic.charAt(i) == 0){
                continue;
            }else{
                cutterStrHead = idStatic.substring(0,i);
                cutterStr = idStatic.substring(i);
                valueOfCutter = Integer.parseInt(cutterStr);
            }

        }
        int plusValueCutter = valueOfCutter+1;
        String plusValStr = String.valueOf(plusValueCutter);
        String newValId = cutterStrHead.concat(plusValStr);
        idStatic = newValId;


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

    public String toString() {
        return "AccountUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }
}
