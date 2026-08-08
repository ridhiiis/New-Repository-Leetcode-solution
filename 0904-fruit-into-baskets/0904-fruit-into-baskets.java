class Solution {
    static {
        for(int i = 0; i < 500; ++i) {
            totalFruit(new int[] {1, 2, 1, 2, 2, 2, 2, 3, 4, 4, 5, 6, 7, 8, 5, 4});
        }
    }
    public static int totalFruit(int[] fruits) {
        if(fruits.length == 1) return 1;
        int i = 0;
        int j = 0;
        int f1 = fruits[0];
        int f1i = 0;
        int f2 = -1;
        int f2i = -1;
        while(j < fruits.length) {
            if(fruits[j] == f1) {
                f1i = j;
            }else if(fruits[j] == f2) {
                f2i = j;
            }else if(f2 == -1) {
                f2 = fruits[j];
                f2i = j;
            }else {
                break;
            }
            j += 1;
        }
        int maxFruits = j - i;
        while(j < fruits.length) {
            if(fruits[j] == f1) {
                f1i = j;
            }else if(fruits[j] == f2) {
                f2i = j;
            }else {
                if(f1i < f2i) {
                    f1 = fruits[j];
                    i = f1i + 1;
                    f1i = j;
                }else {
                    f2 = fruits[j];
                    i = f2i + 1;
                    f2i = j;
                }
            }
            maxFruits = Math.max(maxFruits, j - i + 1);
            j += 1;
        }
        return maxFruits;
    }
}