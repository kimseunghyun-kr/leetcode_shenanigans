class FirstNLastPosElemSortedArr34 {
    final int[] deadEnd = { -1, -1 };

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return deadEnd;
        }
        int startPsn = binSearchStart(nums, 0, nums.length, target);
        if (startPsn == -1) {
            return deadEnd;
        }

        // return deadEnd;

        int endPsn = binSearchEnd(nums, 0, nums.length, target);

        return new int[] {startPsn, endPsn};
    }

    public int binSearchStart(int[] arr, int start, int end, int target) {
        int mid = (end + start) / 2;

        if(mid >= arr.length || mid < 0) {
            return -1;
        }

        if (arr[mid] == target && (mid == 0 || arr[mid - 1] < arr[mid])) {
            return mid;
        } else {
            if (start >= end) {
                return -1;
            } else {
                if (arr[mid] >= target) {
                    int LHAns = binSearchStart(arr, start, mid, target);
                    if (LHAns != -1) {
                        return LHAns;
                    }
                } else {
                    int RHAns = binSearchStart(arr, mid + 1, end, target);
                    if (RHAns != -1) {
                        return RHAns;
                    }
                }

                return -1;
            }
        }
    }



    public int binSearchEnd(int[] arr, int start, int end, int target) {
        int mid = (end + start) / 2;
        
        if(mid >= arr.length || mid < 0) {
            return -1;
        }

        if (arr[mid] == target && (mid == arr.length-1 || arr[mid +1] > arr[mid])) {
            return mid;
        } else {
            if (start >= end) {
                return -1;
            } else {
                if (arr[mid] > target) {
                    int LHAns = binSearchEnd(arr, start, mid, target);
                    if (LHAns != -1) {
                        return LHAns;
                    }
                } else {
                    int RHAns = binSearchEnd(arr, mid + 1, end, target);
                    if (RHAns != -1) {
                        return RHAns;
                    }
                }

                return -1;
            }
        }
    }

    public static void main(String[] args) {
        FirstNLastPosElemSortedArr34 test = new FirstNLastPosElemSortedArr34();
        int[] tested = {1,1,2};
        int[] ans = test.searchRange(tested, 2);
        System.out.printf("start : %d | end : %d", ans[0] , ans[1]);
    }
}
