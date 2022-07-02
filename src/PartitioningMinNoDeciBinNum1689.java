public class PartitioningMinNoDeciBinNum1689 {
    public int minPartitions(String n) {
        int result = 0;
        for(int i = 0 ; i < n.length() ; i++) {
            result = Math.max(result, n.charAt(i) - '0');
        }
        return result;
    }

    public static void main(String[] args) {
        PartitioningMinNoDeciBinNum1689 test = new PartitioningMinNoDeciBinNum1689();
        String tester = "3992910";
        int ans = test.minPartitions(tester);
        System.out.println(ans);
    }
}
