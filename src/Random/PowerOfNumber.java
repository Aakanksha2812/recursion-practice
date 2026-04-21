package Random;

public class PowerOfNumber {
    int powerOfnumb(int n){
        return (int) Math.pow(n,1.5);
    }
    public static void main(String[] args){
        PowerOfNumber p=new PowerOfNumber();
        System.out.println(p.powerOfnumb(3));
    }
}
