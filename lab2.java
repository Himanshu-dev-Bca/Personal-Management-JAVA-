class order {
    void recentorder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] reorderedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                reorderedMatrix[i][j] = matrix[rows - 1 - i][cols - 1 - j];
            }
        }

        System.out.println("Reordered Matrix:");
        printMatrix(reorderedMatrix);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + (j + 1 == matrix[i].length ? "" : " "));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] sample = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        new order().recentorder(sample);
    }
}

