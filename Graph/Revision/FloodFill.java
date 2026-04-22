class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        if (image[sr][sc] == color) {
            return image;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });

        int originalColor = image[sr][sc];
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int vertex[] = q.remove();
            int row = vertex[0];
            int col = vertex[1];

            if (row - 1 >= 0 && image[row - 1][col] == originalColor) {
                image[row - 1][col] = color;
                q.add(new int[] { row - 1, col });
            }
            if (row + 1 < m && image[row + 1][col] == originalColor) {
                image[row + 1][col] = color;
                q.add(new int[] { row + 1, col });
            }
            if (col - 1 >= 0 && image[row][col - 1] == originalColor) {
                image[row][col - 1] = color;
                q.add(new int[] { row, col - 1 });
            }
            if (col + 1 < n && image[row][col + 1] == originalColor) {
                image[row][col + 1] = color;
                q.add(new int[] { row, col + 1 });
            }
        }
        return image;
    }
}