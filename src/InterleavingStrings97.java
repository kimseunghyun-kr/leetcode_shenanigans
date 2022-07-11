class InterleavingStrings97 {

    public boolean isInterleave(String s1, String s2, String s3) {
    		if(s3.length() == s2.length() + s1.length()) {
			StringBuilder s1sb = new StringBuilder(s1);
			StringBuilder s2sb = new StringBuilder(s2);
			StringBuilder s3sb = new StringBuilder(s3);
			boolean[][] dpArr = new boolean[s1.length()+1][s2.length()+1];

			for(int s1i = 0 ; s1i < s1sb.length()+1 ; s1i++ ) {
				for(int s2i = 0 ; s2i < s2sb.length()+1 ; s2i++) {
					if(s1i ==0 && s2i == 0) {
						dpArr[s1i][s2i] = true;
					} else {
						if(s1i == 0) {
							dpArr[s1i][s2i] = dpArr[s1i][s2i-1] && s3sb.charAt(s1i+s2i-1) == s2sb.charAt(s2i-1);
						} else if (s2i == 0 ) {

							dpArr[s1i][s2i] = dpArr[s1i-1][s2i] && s3sb.charAt(s1i+s2i-1) == s1sb.charAt(s1i-1);
						} else {
							dpArr[s1i][s2i] = (dpArr[s1i-1][s2i] && s3sb.charAt(s1i+s2i-1) == s1sb.charAt(s1i-1)) ||
								(dpArr[s1i][s2i-1] &&  s3sb.charAt(s1i+s2i-1) == s2sb.charAt(s2i-1)); 
						}
					}
		
				}
			}

			return dpArr[s1.length()][s2.length()];
		} else {
			return false;
		}
    

	}
}
