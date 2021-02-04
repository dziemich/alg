package leetcode;

public class MyAtoi {
  public int myAtoi2(String s) {
    long store = 0;
    boolean digitsStarted = false;
    boolean isNegative = false;
    boolean plusEncountered = false;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        digitsStarted = true;
        store *= 10;
        store += Character.getNumericValue(c);

        if (isNegative && (long) Integer.MAX_VALUE + 1 < store) {
          System.out.println(store);
          return Integer.MIN_VALUE;
        }
        if (!isNegative && store > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        }
      } else {
        if (digitsStarted) break;
        if (c == ' ') continue;
        else if (c == '+') {
          if (plusEncountered) break;
          else {
            plusEncountered = true;
            digitsStarted = true;
          }
        } else if (c == '-') {
          isNegative = true;
          digitsStarted = true;
        } else {
          break;
        }
      }
    }

    if (isNegative) {
      store *= -1;
    }

    return (int) store;
  }

  public int myAtoi(String s) {
    long acc = 0;
    int sign = 1;

    String t = s.trim();

    for(int i = 0; i < t.length(); i++){
      char c = t.charAt(i);

      if(Character.isDigit(c)){
        acc *= 10;
        acc += (c - '0');
        if(sign == 1 && acc >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(sign == -1 && acc >= (long) Integer.MAX_VALUE + 1) return Integer.MIN_VALUE;

      } else {
        if(i == 0 && (c == '-' || c == '+')){
          sign = c == '-' ? -1 : 1;
        } else {
          return (int) (acc * sign);
        }
      }
    }

    return (int) (acc * sign);
  }


}
