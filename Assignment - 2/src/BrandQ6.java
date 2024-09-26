public class BrandQ6 {
    void showBrand(){
        System.out.println("This ia a generic Brand");
    }
}
class Phone extends BrandQ6{
    void phoneCategory(){
        System.out.println("This is a phone Category");
    }
}

class Laptop extends BrandQ6 {
    void laptopCategory() {
        System.out.println("This is a Laptop category");
    }

    public class Main1 {
        public static void main(String[] args) {
            Phone phone = new Phone();
            Laptop laptop = new Laptop();
            phone.showBrand();
            phone.phoneCategory();
            laptop.showBrand();
            laptop.laptopCategory();
        }
    }
}
