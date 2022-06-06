public class Powxn {
    public double mypow(double x, int n) {
        int magnitude = n<0 ? -n : n;
        double result = 1;
        if(n == Integer.MIN_VALUE) {
            magnitude = Integer.MAX_VALUE;
        }
        if( n < 0 ) {
            if(n == Integer.MIN_VALUE) {
                double actlans = powRecurse(x,magnitude) * x;
                return 1/actlans;
            }
            return 1/ powRecurse(x, magnitude);
        } else {
            return powRecurse(x, magnitude);
        }
    }

    public double powRecurse(double base, int pow) {
        if(pow == 0) {
            return 1;
        }
        else if(pow % 2 == 1) {
            double next = powRecurse(base, pow>>1);
            return base * next * next;
        } else {
            double next = powRecurse(base, pow>>1);
            return next * next;
        }
    }


    public static void main(String[] args) {
        Powxn test = new Powxn();
        System.out.println(test.mypow(2
                ,-2147483648));
        test.mypow(-1.00000
                ,-2147483648);
    }
}
