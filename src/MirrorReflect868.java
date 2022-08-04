class MirrorReflect858 {
    
    // public int mirrorReflection(int p, int q) {
    //     int squareLen = p;
    //     int step = q;

    //     int currx = 0; int curry = 0;

    //     while(true) {
    //        if(currx > squareLen || curry > squareLen) {

    //        }
    //     }

    // }

    public int mirrorReflection(int p, int q) {
        //ap = bq;
        int a = 1;
        int b = 1;
        while(true) {
            if(a*p == b*q) {
                if(a%2 == 1 && b % 2 == 0) {
                    return 2;
                }
                if(a%2 == 1 && b % 2 == 1) {
                    return 1;
                }
                if (a % 2 == 0 && b % 2 == 1) {
                    return 0;
                }

            } else {
                if(b*q > a*p) {
                    a++;
                } else {
                    b++;
                }
            }
        }
    }
}