/**
 * Adapter
 * It is the interface layer which connects one interface to another.
 * Ada[ter facilitates communication between two entities which naturally don't fit together.
 */

/**
 * What is the need for this Adapter Design Pattern?
 * 1. Interface compatibility (When interface are not compatible to each other then we need this design pattern)
 * 2. Third party intergration (Most common reason of using Adapter)
 */

/**
 * Examples
 */
// Client (Step 1)
Itarget target = new Adapter (new Adaptee);
target.request();


// Step 2
interface ITarget{
    void request();
} 

// Step 3
class Adapter implements ITarget {
    Adaptee adaptee;
    public Adapter(Adapter adapter){
        this.adaptee = adapter;
    }

    public void request(){
        this.adaptee.SpecificRequest();
    }
}

// step 4
class Adaptee{
    public void SpecificRequest(){

    }
}

// ......................................


// Step One

public class App {
    public static void main(String[] args) {
        PhonePe phonePe = new PhonePe(new HDFCBankAdapter());

        System.out.println("Account Balance :" + phonePe.getBalance("1233455"));

    }
}

// step Two
public class PhonePe {
    BankAdapter bank;

    public PhonePe(BankAdapter bank){
        this.bank = bank;
    }

    public Integer getBalance(String JWT){
        //User user = fetchUser(JWT);
        //user.id, user.account
        BalanceRequest blReq = new BalanceRequest("12345", "Akash123");
        BalanceResponse blRes = bank.getBalance(blReq);
        return blRes.getAmount();
    };
}

// step three
public interface BankAdapter {
    BalanceResponse getBalance(BalanceRequest balanceRequest);    
}

// step four
public class HDFCBankAdapter implements BankAdapter{
    BalanceResponse getBalance(BalanceRequest balanceRequest){
        return new BalanceResponse();
    }
}

// Step 5
public class BalanceRequest{
    String userId;
    String userAccount;

    // add getter and setter
}

// Step 6
public class BalanceResponse{
    String userId;
    String accountName;
    Integer amount;

     // add getter and setter
}


// Step 5 (Third Party Library, example : YesBank, HDFC, ICICI, SBI etc)

// Example One (Step 6)
public class HDFCBank {
    HDFCBalanceResponse fetchBalance(HDFCBalanceRequest hdfcRequest){
        // Api call takes place
        HDFCBalanceResponse hdfcBalanceResponse = new HDFCBalanceResponse();
        return hdfcBalanceResponse;
    }
}

public class HDFCBalanceRequest {
    String userID;
}

public class HDFCBalanceResponse {
    Integer amount;
    boolean isBelowMin;
}


// Step 7
public class HDFCBankAdapter implements BankAdapter{
    BalanceResponse getBalance(BalanceRequest balanceRequest){
        return new BalanceResponse();
    }
}

public class BalanceResponse {
    String userID;
}

public class BalanceRequest {
    Integer amount;
    boolean isBelowMin;
}


// Example Two
public class YesBank{

}

{}