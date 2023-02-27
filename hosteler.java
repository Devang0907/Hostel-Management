public class hosteler {
    public static void main(String args[]){
}
    
}

class Hostel{

Hostel(){
        System.out.println("Welcome to Hostel portal");
        
        System.out.println("press 1:to get information about us");
        System.out.println("press 2:to take Admission to Hostel");
        System.out.println("press 3:to pay fees");
        System.out.println("press 4:to pay feedback");
        System.out.println("press 5:to exit");

        int choice=s.nextInt();
   
        if(choice==1){infoUs();} 

}
        void infoUs(){
        System.out.println("press 1:to get information about fee Structure");
        System.out.println("press 2:to get information about Mess");
        System.out.println("press 3:to get information about Services");
        System.out.println("press 4:to get information about Rules & Regulations");
        System.out.println("press 5:to go Back");

        int choice_1=s.nextInt();
        if(choice_1==1){
            System.out.println("Fee Structure :");
            System.out.println("No. of Sharing     Fees/month    A.C./Non A.C.");
            System.out.println("_______________________________________________");
            System.out.println("    2               12,000             A.C.   ");
            System.out.println("    2               10,000           Non A.C. ");
            System.out.println("    4               9,000              A.C.   ");
            System.out.println("    4               8,000            Non A.C  ");
            System.out.println("    6               6,000            Non A.C  ");

        }
        if(choice_1==2){
            System.out.println("In our, Mess We are serve Healthy and Nutriton Food.");
            System.out.println("Including Breakfast,Lunch and Dinner,We also serve Evening Snacks.");
            System.out.println("There is Tea and Milk in Breakfact with poha/Idli/Upma/Gathiya...");
            System.out.println("In lunch,We serve 2 sabji,Roti,Rice-Dal,ButterMilk.");
            System.out.println("In Dinner,We serve Sabji-Roti and Khichadi-Kadhi.");
            
    }
        if(choice_1==3){
            System.out.println("Some of our services:");
            System.out.println("1)We have 10 Member Staff including Wathchmen.");
            System.out.println("2)Your Room will clean twice a week by our staff.");
            System.out.println("3)You have access to free wi-fi.");
            System.out.println("4)You can use Washing machine of Hostel.");
            System.out.println("5)You can enjoy indoor games in our Fun-zone area.");
        }
        if(choice_1==4){"*******"}
        if(choice_1==5){}


}

       

    
}
