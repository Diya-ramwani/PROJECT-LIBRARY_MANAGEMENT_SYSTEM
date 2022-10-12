class account{
    private String ID;
    private String Name;
    private int balance=0;

    void account(String ID, String Name){
        this.ID=ID;
        this.Name=Name;
    }

    void account(String ID, String Name, int balance){
        this.ID=ID;
        this.Name=Name;
        this.balance=balance;

    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return Name;
    }
    public int getbalance(){
        return balance;
    }

    public int  credit(int amount){
        int balance=+amount;
        return balance;
    }
    public int debit(int amount){
        if (amount<=balance){
            int newAmount=amount-balance;
        }
        else
            System.out.println("Amount acceded balance");
            return balance;
    }
    public int transferTo(account another, int amount){
        if (amount<=balance){
            int newAmount=amount-balance;
        }
        else
            System.out.println("Amount acceded balance");
        return balance;
    }
}



public class projectClass {
}
