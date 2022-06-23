import java.util.HashMap;

class Roman_to_Int {
    HashMap<Character, Integer> romanSet = new HashMap<>();

    public int romanToInt(String s) {
        romanSet.put('I', 1);
        romanSet.put('V', 5);
        romanSet.put('X', 10);
        romanSet.put('L', 50);
        romanSet.put('C', 100);
        romanSet.put('D', 500);
        romanSet.put('M', 1000);
        char[] chars = s.toCharArray();
        int resultNum = 0;
        Character prevChar = (char) 0;

        for (Character c : chars) {
            if (prevChar.equals((char) 0)) {
                if (c.equals('I') || c.equals('X') || c.equals('C')) {
                    prevChar = c;
                } else {
                    resultNum += romanSet.get(c);
                }

            } else {
                if (prevChar.equals('I')) {
                    if (c.equals('V')) {
                        resultNum += 4;
                    } else if (c.equals('X')) {
                        resultNum += 9;
                    } else {
                        resultNum += romanSet.get(prevChar) + romanSet.get(c);
                    }

                    prevChar = (char) 0;
                } else if (prevChar.equals('X')) {
                    if (c.equals('L')) {
                        resultNum += 40;
                    } else if (c.equals('C')) {
                        resultNum += 90;
                    } else {
                        if(c.equals('I')) {
                            resultNum += romanSet.get(prevChar);
                            prevChar = c;
                        } else {
                            resultNum += romanSet.get(prevChar) + romanSet.get(c);
                        }
                    }


                    if(c.equals('I')) {
                        prevChar = c;
                    } else {
                        prevChar = (char) 0;
                    }

                } else if (prevChar.equals('C')) {
                    if (c.equals('D')) {
                        resultNum += 400;
                    } else if (c.equals('M')) {
                        resultNum += 900;
                    } else {
                        if(c.equals('I') || c.equals('X')){
                            resultNum += romanSet.get(prevChar);
                        } else {
                            resultNum += romanSet.get(prevChar) + romanSet.get(c);
                        }

                    }

                    if(c.equals('I') || c.equals('X')) {
                        prevChar = c;
                    } else {
                        prevChar = (char) 0;
                    }

                } else {

                }

            }


        }

        if (prevChar != (char) 0) {
            resultNum += romanSet.get(prevChar);
        }


        return resultNum;

    }
}