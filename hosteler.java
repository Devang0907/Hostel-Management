import java.util*;
public class hosteler {
    public static void main(String args[]){
        Hostel h=new Hostel();
                
}
    
}

class Hostel{
    String name;
    String surname;
    int age;
    String collage;
    String city;
    String mobile_no;
    String email_id;
    char room;
    int flag=0;
    Scanner sc=new Scanner(System.in);
    

Hostel(){
        While(flag==0){
        System.out.println("Welcome to Hostel portal");
        
        System.out.println("press 1:to get information about us");
        System.out.println("press 2:to take Admission to Hostel");
        System.out.println("press 3:to pay fees");
        System.out.println("press 4:to pay feedback");
        System.out.println("press 5:to exit");

        int choice=s.nextInt();
   
        if(choice==1){infoUs();}
        if(choice==2){admission();}
        if(choice==3){fees();}
        if(choice==4){feedback();}
        if(choice==5){flag=1;}
        else{   
            System.out.println("Enter valid choice.");
            }  
        }
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
            System.out.println("  Room type     No. of Sharing     Fees/month    A.C./Non A.C.");
            System.out.println("______________________________________________________________");
            System.out.println("    A        2               12,000                  A.C.   ");
            System.out.println("    B        2               10,000                Non A.C. ");
            System.out.println("    C        4               9,000                   A.C.   ");
            System.out.println("    D        4               8,000                 Non A.C  ");
            System.out.println("    G        6               6,000                 Non A.C  ");

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
        if(choice_1==4){
            System.out.println("Smoking, Alcohol & Narcotic consumption is strictly prohibited in and around the Hostel premises.");
            System.out.println("The Management & Staff will not be responsible for personal belongings.");
            System.out.println("Students must keep the Campus & Rooms clean. Defacing walls, equipment, furniture etc., is strictly prohibited.");
            System.out.println("Birthday/Other Celebrations are strictly prohibited in Hostel.");
            System.out.println("Students must turn off all the electrical equipments & lights before leaving their rooms."); 
            System.out.println("Students are not allowed to use electric stoves, heaters etc in rooms except in designated places.");
            
                                
                       }
            else{
               System.out.println("Enter valid choice.");
           }
        }
    
}

        void admission(){
            System.out.println("Enter your name :");
            name=sc.next();
            System.out.println("Enter your surname :");
            surname=sc.next();
            System.out.println("Enter your age :");
            age=sc.nextInt();
            System.out.println("Enter your collage :");
            collage=sc.next();
            System.out.println("Enter your city :");
            city=sc.next();
            System.out.println("Enter your phone no. :");
            mobile_no=sc.next();
            System.out.println("Enter your email id :");
            email_id=sc.next();
            System.out.println("Enter room type :");
            room=sc.nextLine();
               
            

}


       void fees(){
           System.out.println("Enter 1:for online payment ");
           System.out.println("Enter 2:for offline payment(cash only) ");
           int c=sc.nextInt();
           
           if(c==1){
               System.out.println("You can pay using upi by given upi id");
               System.out.println("hosteler@123");
           }
           if(c==2){
               System.out.println("You can pay fees to our office.");
           }
           else{
               System.out.println("Enter valid choice.");
           }
       }
           
           void feedback(){
               
               System.out.println("Enter your feedback below :");
               String feedback=sc.next();
               
               
    

       

    
}
