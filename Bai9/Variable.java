public class Variable {
    public int SetNewUnitPrice(int amount,int kindOfCustomer){
        int NewUnitPrice=0;
        if(kindOfCustomer==1){

            if(amount<50){
                NewUnitPrice=1000;
            }
            else if(amount>=50 &&amount<100){
                NewUnitPrice = 1200;
            }
            else if(amount>=100 && amount<=200){
                NewUnitPrice =1500;
            }
            else if(amount>200){
                NewUnitPrice = 2000;
            }
        }
        else if(kindOfCustomer ==2){
            NewUnitPrice =2000;
        }

        return NewUnitPrice;
    }
}
