public class CountVowelPerm1220 {

    final int T = 1000000007;
    public int countVowelPermutation(int n) {
        //0 = a 1= e 2=i 3 =o 4= u
        long[] DpArr = new long[5]; // prev letter ends in;

        for(int i = 0 ; i < n ; i++) {
            long[] tempDpArr = new long[5];
            for(int j =0 ; j < 5 ; j++) {
                if(i == 0) {
                    tempDpArr[j] = 1;
                } else {
                    switch (j) {
                        case 0: //if prev letter ended with a
                            tempDpArr[1] += DpArr[0]% T; //curr letter ending with e += a
                            break;

                        case 1: //if prev letter ended with e
                            tempDpArr[0] += DpArr[1] % T;  //curr letter ending with a += e
                            tempDpArr[2] += DpArr[1] % T;
                            break;

                        case 2:
                            tempDpArr[0] += DpArr[2] % T;  //curr letter ending with a += i
                            tempDpArr[1] += DpArr[2] % T;
                            tempDpArr[3] += DpArr[2] % T;
                            tempDpArr[4] += DpArr[2] % T;
                            break;

                        case 3:
                            tempDpArr[2] += DpArr[3] % T;
                            tempDpArr[4] += DpArr[3] % T;
                            break;

                        case 4:
                            tempDpArr[0] += DpArr[4] % T;
                            break;
                    }
                }
            }
            DpArr = tempDpArr;
        }

        long ans = 0;

        for(int j =0 ; j < 5 ; j++) {
            ans += (DpArr[j] % T);
        }

        return (int)(ans  % T);



    }
}
