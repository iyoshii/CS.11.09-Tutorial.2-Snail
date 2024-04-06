public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null || !isPerfectSquare(array2d)) {
            return new int[0];
        }

        int length = array2d.length;
        int[] result = new int[length * length];

        int index = 0;
        int rowStart = 0;
        int rowEnd = length - 1;
        int colStart = 0;
        int colEnd = length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int col = colStart; col <= colEnd; col++) {
                result[index++] = array2d[rowStart][col];
            }

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                result[index++] = array2d[i][colEnd];
            }

            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result[index++] = array2d[rowEnd][i];
                }

                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result[index++] = array2d[i][colStart];
                }

                colStart++;
            }
        }

        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null || !isPerfectSquare(array1d)) {
            return new int[0][0];
        }

        int length = (int) Math.sqrt(array1d.length);
        int[][] result = new int[length][length];

        int index = 0;
        int rowStart = 0;
        int rowEnd = length - 1;
        int colStart = 0;
        int colEnd = length - 1;

        for (int[] row : result) {
            if (rowStart <= rowEnd) {
                for (int i = colStart; i <= colEnd; i++) {
                    row[i] = array1d[index++];
                }

                rowStart++;
            }

            for (int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = array1d[index++];
            }

            colEnd--;

            if (rowStart <= rowEnd) {
                int[] bottomRow = result[rowEnd];

                for (int i = colEnd; i >= colStart; i--) {
                    bottomRow[i] = array1d[index++];
                }

                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result[i][colStart] = array1d[index++];
                }

                colStart++;
            }
        }

        return result;
    }


    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for(int num : array1d){
            System.out.println(num + " ");
        }

        System.out.println();
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for(int[] row : array2d){
            for(int num : row){
                System.out.println(num + " ");
            }

            System.out.println();
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int sqrt = (int) Math.sqrt(array1d.length);
        return sqrt * sqrt == array1d.length;
    }

    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        for (int[] nums : array2d) {
            if (nums.length != array2d.length) {
                return false;
            }
        }

        return true;
    }
}
