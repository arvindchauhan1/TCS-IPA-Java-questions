import java.util.Scanner;

public class FootwearProgram {

    static int getCountByType(Footwear[] arr, String ftype) {
        int count = 0;
        for (Footwear footwear : arr) {
            if (footwear.getFtype().toLowerCase().equals(ftype.toLowerCase())) {
                count++;
            }
        }

        return count;
    }

    static Footwear getSecondHighestPriceByBrand(Footwear arr[], String fname) {
        int h = Integer.MIN_VALUE, sh = Integer.MIN_VALUE;
        Footwear res = null;
        for (Footwear footwear : arr) {
            if (footwear.getFname().toLowerCase().equals(fname.toLowerCase())) {
                int tprice = footwear.getPrice();
                if (tprice > h) {
                    sh = h;
                    //
                    res = new Footwear(footwear.getFid(), footwear.getFname(), footwear.getFtype(),
                            footwear.getPrice());
                    h = tprice;
                } else if (tprice > sh && tprice != h) {
                    res = new Footwear(footwear.getFid(), footwear.getFname(), footwear.getFtype(),
                            footwear.getPrice());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Footwear footwears[] = new Footwear[5];

        for (int i = 0; i < footwears.length; i++) {
            int a;
            String b;
            String c;
            int d;

            a = Integer.parseInt(sc.nextLine());
            b = sc.nextLine();
            c = sc.nextLine();
            d = Integer.parseInt(sc.nextLine());

            footwears[i] = new Footwear(a, b, c, d);
        }

        String type = sc.nextLine();
        String name = sc.nextLine();

        int ans1 = getCountByType(footwears, type);
        if (ans1 != 0) {
            System.out.println(ans1);
        } else {
            System.out.println("Footwear not available");
        }

        Footwear ans2 = getSecondHighestPriceByBrand(footwears, name);
        if (ans2 != null) {
            System.out.println(ans2.getFid());
            System.out.println(ans2.getFname());
            System.out.println(ans2.getPrice());
        } else {
            System.out.println("Brand not available");
        }

        sc.close();
    }
}

class Footwear {

    private int fid;
    private String fname;
    private String ftype;
    private int price;

    // Constructor
    public Footwear(int fid, String fname, String ftype, int price) {
        this.fid = fid;
        this.fname = fname;
        this.ftype = ftype;
        this.price = price;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getFid() {
        return fid;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFtype() {
        return ftype;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
