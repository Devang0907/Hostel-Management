import java.sql.*;
import java.util.*;

class hostel {
    Scanner sc = new Scanner(System.in);
    int[] ar = new int[150];

    int std_id = 1;

    String registation() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement sp = con.createStatement();
        ResultSet set = sp.executeQuery("select std_id from student_details order by std_id desc limit 1");
        while (set.next()) {
            std_id = set.getInt(1);
            std_id++;
        }
        PreparedStatement st = con.prepareStatement(
                "insert into student_details(std_id,first_name,name,last_name,fees,admission_date,phone_no,address,percentage) values(?,?,?,?,0,current_date,?,?,?)");
        System.out.println("Enter Your surname");
        String fname = sc.next();
        System.out.println("Enter Your name");
        String name = sc.next();
        System.out.println("Enter Your Father name");
        String lname = sc.next();
        System.out.println("Enter Your Phone number");
        String phoneno = sc.next();

        while (phoneno.length() != 10) {
            System.out.println("Enter Valid Phone number");
            phoneno = sc.next();
        }
        long phone = Long.parseLong(phoneno);

        System.out.println("Enter Your address");
        String address = sc.next();

        System.out.println("Enter Your LastCourse percentage");
        double pr = sc.nextDouble();
        if (pr < 55 || pr > 100) {

            return "-----You Are Not Aligeble For Hostel-----";

        }
        st.setInt(1, std_id);
        st.setString(2, fname);
        st.setString(3, name);
        st.setString(4, lname);
        st.setLong(5, phone);
        st.setString(6, address);
        st.setDouble(7, pr);
        int rs = st.executeUpdate();
        allotRoom(std_id);
        stdroom();

        con.close();
        if (rs > 0) {
            return "-----resitation succesfully-----";
        } else
            return "resitation not succesfull";
    }

    void adminFunction() {
        System.out.println("1....Add Student");
        System.out.println("2....Serch Student Details");
        System.out.println("3....Remove Student");
        System.out.println("4....Add Student fees");
        System.out.println("5....EXIT");
    }

    void stdroom() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement st = con.createStatement();
        ResultSet set = st.executeQuery("select * from room where std_id=" + std_id);
        set.next();
        System.out.println("Your Student id is : " + std_id);
        System.out.println("Your Alloted Room no is : " + set.getInt(2) + " And Bed no is : " + set.getString(3));
        con.close();
    }

    void allotRoom(int std_id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement st = con.createStatement();
        for (int i = 0; i < 150; i++) {
            ar[i] = i + 1;
        }
        for (int i = 0; i < 150; i++) {
            ResultSet set = st.executeQuery("select * from room");
            int n = ar[i];
            int dummy = 0;
            while (set.next()) {
                dummy = set.getInt(2);
                if (dummy == n) {
                    break;
                }
            }
            if (dummy == n) {
                ResultSet dset = st.executeQuery("select bed_no from room where room_no=" + n);
                if (dset.next()) {
                    if (dset.getString(1).equals("A")) {
                        if (dset.next()) {
                            if (dset.getString(1).equals("B")) {
                                if (dset.next()) {
                                    if (dset.getString(1).equals("C")) {
                                        if (dset.next()) {
                                            if (dset.getString(1).equals("D")) {

                                            }
                                        } else {
                                            st.executeUpdate("insert into room values(" + std_id + "," + n + ",'D')");
                                            break;
                                        }
                                    }
                                } else {
                                    st.executeUpdate("insert into room values(" + std_id + "," + n + ",'C')");
                                    break;
                                }
                            }
                        } else {
                            st.executeUpdate("insert into room values(" + std_id + "," + n + ",'B')");
                            break;
                        }
                    }
                } else {
                    st.executeUpdate("insert into room values(" + std_id + "," + n + ",'A')");
                    break;
                }
            } else {
                st.executeUpdate("insert into room values(" + std_id + "," + n + ",'A')");
                break;
            }
        }
        con.close();
    }

    void serchStudent() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement sp = con.createStatement();
        System.out.println("Enter Student Id");
        int n = sc.nextInt();
        ResultSet set = sp.executeQuery("select * from student_details where std_id=" + n + ";");
        boolean b = true;
        while (set.next()) {
            int tstd = set.getInt(1);
            if (tstd == n) {
                System.out.println("student id is : " + tstd + "\nstudent name : " + set.getString(2) + " "
                        + set.getString(3) + " " + set.getString(4) + "\nstudent phone no : " + set.getLong(7)
                        + "\nstudent address is : " + set.getString(8) + "\nstudent percentage is : " + set.getDouble(9)
                        + "%");
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("-----Student Is Not Found-----");
        }
        con.close();
    }

    void addFees() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement sp = con.createStatement();
        ResultSet set = sp.executeQuery("select * from student_details");
        System.out.println("Enter Student Id");
        int n = sc.nextInt();
        boolean b = true;
        while (set.next()) {
            int tstd = set.getInt(1);
            if (tstd == n) {
                System.out.println("Enter Fees :");
                int fees = sc.nextInt();
                sp.executeUpdate("Update student_details set fees=" + fees + " where std_id =" + n);
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("-----Student Is Not Found-----");
        } else {
            System.out.println("-----Fees Add Successfully-----");
        }
        con.close();
    }

    void removestd() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        Statement sp = con.createStatement();
        ResultSet set = sp.executeQuery("select * from student_details");
        System.out.println("Enter Student Id");
        int n = sc.nextInt();
        boolean b = true;
        while (set.next()) {
            int tstd = set.getInt(1);
            if (tstd == n) {
                sp.executeUpdate("delete from student_details where std_id=" + n);
                b = false;
                break;
            }
        }
        if (b) {
            System.out.println("-----Student Is Not Found-----");
        } else {
            System.out.println("-----Student Remove Sucessfully-----");
        }
        con.close();
    }

    void admin() throws Exception {
        System.out.print("ENTER PASSWORD:");
        int password = sc.nextInt();
        if (password != 1234) {
            System.out.println("-->Incorrect Password");
            System.out.println("-->Note:Only 5 Attempts");
            for (int i = 1; i < 5 && password != 1234; i++) {
                if (i >= 2) {
                    System.out.println("-->Incorrect Password");
                }
                System.out.print("ENTER PASSWORD:");
                password = sc.nextInt();
            }
        }
        if (password == 1234) {
            adminFunction();
            System.out.println("Enter Your Choice");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println(registation());
                    break;
                case 2:
                    serchStudent();
                    break;
                case 3:
                    removestd();
                    break;
                case 4:
                    addFees();
                    break;
                case 5:
                    break;

            }
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "");
        if (con != null) {
            System.out.println("connection establish");
        } else {
            System.out.println("connectio failed");
        }
        Scanner sc = new Scanner(System.in);
        hostel H = new hostel();
        int n = 0;
        System.out.println("................................................");
        System.out.println("                    Hostel                      ");
        System.out.println("................................................");
        do {
            System.out.println();
            System.out.println("1....STUDENT REGISTRTION");
            System.out.println("2....ADMIN PANEL");
            System.out.println("3....EXIT");
            System.out.print("Enter Your Choice:");
            n = sc.nextInt();
            if (n > 3) {
                for (int i = 1; n > 3; i++) {
                    System.out.println("------!Invalid Chice!------");
                    System.out.print("Enter Your Choice:");
                    n = sc.nextInt();
                }
            }
            switch (n) {
                case 1:
                    System.out.println(H.registation());
                    break;
                case 2:
                    H.admin();
                    break;
                case 3:
                    break;
            }
        } while (n != 3);
    }
}
