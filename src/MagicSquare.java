public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {

        int sum = 0;
        int[] row1 = array2d[0];

        for (int i = 0; i < row1.length; i ++) {

            sum += row1[i];

        }

        return sum;

    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {

        int[] sum = new int[array2d.length];

        if (calculateCheckSum(array2d) != checkSum) {

            return false;

        }

        sum[0] = calculateCheckSum(array2d);

        for (int i = 1; i < array2d.length; i++) {

            for (int j = 0; j < array2d[i].length; j++) {

                sum[i] += array2d[i][j];

            }

        }

        for (int i = 0; i < sum.length; i++) {

            if (sum[i] != checkSum) {

                return false;
            }

        }

        return true;

    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {

        int[] sum = new int[array2d.length];

        for (int i = 0; i < array2d.length; i++) {

            for (int j = 0; j < array2d[i].length; j++) {

                sum[i] += array2d[j][i];

            }

        }

        for (int i = 0; i < sum.length; i++) {

            if (sum[i] != checkSum) {

                return false;

            }

        }

        return true;

    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i <= array2d.length; i++) {

            sum1 += array2d[i][i];

        }

        for (int i = 0; i <= array2d.length; i++) {

            for (int j = array2d.length; j >= 0; j--) {

                sum2 += array2d[i][j];

            }


        }

        if (sum1 == checkSum && sum2 == checkSum) {

            return true;

        }

        return false;

    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {

        if (magicRows(array2d,calculateCheckSum(array2d)) == magicColumns(array2d,calculateCheckSum(array2d)) == magicDiagonals(array2d,calculateCheckSum(array2d))) {

            return true;

        }

        return false;

    }

}
