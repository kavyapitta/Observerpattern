import java.util.*;
interface Media 
{
public void update(float interest_rate);
}

interface Bank 
{
public void regMedia(Media observer); 
public void removeMedia(Media observer); 
public void notifyMedias(); 
}

class BankLoan implements Bank
{
private ArrayList<Media> observers = new ArrayList<Media>();
private String loanType;
private float interest_rate;
private String name;

public BankLoan(String loanType, float interest_rate, String name)
{
this.loanType = loanType;
this.interest_rate = interest_rate;
this.name = name;
}

public float getInterestRate()
{
return interest_rate;
}

public void setInterestRate(float interest_rate)
{
this.interest_rate = interest_rate;
notifyMedias();
}

public String getName()
{
return this.name;
}

public String getloanType()
{
return this.loanType;
}

@Override
public void removeMedia(Media observer) 
{
observers.remove(observer);
}


@Override
public void regMedia(Media observer) 
observers.add(observer);
}


@Override
public void notifyMedias()
{
for (Media ob : observers)
{
System.out.println("\n To inform you that your interest rate has been changed.!!");
ob.update(this.interest_rate);
}

}

}

class Newspaper implements Media
{
@Override
public void update(float interest_rate)
{
System.out.println("Media Name:Newspaper \nMessage:New Interest Rate is: "+ interest_rate);
System.out.println("\n____________________________________");

}
}

class TV implements Media
{
@Override
public void update(float interest_rate)
{
System.out.println("media name:TV \nmessage:new i nterest rate is: " + interest_rate);
System.out.println("\n____________________________________");
}
}

public class Main 
{
public static void main(String args[]) 
{
  
Newspaper n = new Newspaper();
TV t = new TV();

BankLoan bl = new BankLoan("Personal Loan", 10.7f, "Citi");
bl.regMedia(n);
bl.regMedia(t);
bl.setInterestRate(5.5f);

}
}

