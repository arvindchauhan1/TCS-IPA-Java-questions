import java.util.Scanner;

public class CollegeSolution {

    static College findCollegeWithMaximumPincode(College[] arr) {

        if (arr.length == 0)
            return null;

        if (arr.length == 1)
            return arr[0];

        College res = arr[0];
        for (College college : arr) {
            if (college.getPincode() > res.getPincode()) {
                res = college;
            }
        }

        return res;
    }

    static College searchCollegeByAddress(College arr[], String key) {
        for (College college : arr) {
            if (college.getAddress().toLowerCase().equals(key.toLowerCase()))
                return college;
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        College obj[] = new College[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            int contact = sc.nextInt();
            sc.nextLine();
            String address = sc.nextLine();
            int pincode = sc.nextInt();
            sc.nextLine();
            obj[i] = new College(id, name, contact, address, pincode);
        }

        String add = sc.nextLine();
        College ans1 = findCollegeWithMaximumPincode(obj);

        if (ans1 != null) {
            System.out.println("id-" + ans1.getId() + "\nname-" + ans1.getName() + "\ncontactNo-" + ans1.getContact()
                    + "\naddress-" + ans1.getAddress()
                    + "\npincode-" + ans1.getPincode() + "\n");
        } else {
            System.out.println("No college found with mentioned attribute");
        }
        College ans2 = searchCollegeByAddress(obj, add);
        if (ans2 != null) {
            System.out.println("id-" + ans2.getId() + "\nname-" + ans2.getName() + "\ncontactNo-" + ans2.getContact()
                    + "\naddress-" + ans2.getAddress()
                    + "\npincode-" + ans2.getPincode() + "\n");
        } else {
            System.out.println("No college found with mentioned attribute");
        }

        sc.close();
    }
}

class College {
    private int id;
    private String name;
    private int contact;
    private String address;
    private int pincode;

    public College(int id, String name, int contact, String address, int pincode) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.pincode = pincode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getContact() {
        return contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPincode() {
        return pincode;
    }

}