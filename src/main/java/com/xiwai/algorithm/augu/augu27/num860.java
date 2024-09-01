package com.xiwai.algorithm.augu.augu27;

public class num860 {

}

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[0] != 5) {
                return false;
            }
            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (ten > 0) {
                        ten--;
                        {
                            if (five > 0)
                                five--;
                            else
                                return false;
                        }
                        break;
                    }
                    if (ten == 0) {
                        if (five >= 3)
                            five -= 3;
                        else
                            return false;
                    }
            }
        }
        return true;
    }
}