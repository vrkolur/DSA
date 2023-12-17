package Graph;

public class Island_Perimeter {

    private int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return getPerimeter(i, j, n, m, grid);
            }
        }
        return 0;
    }

    
    private int getPerimeter(int i, int j, int n, int m, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m)
        return 1;
        if (grid[i][j] == 0)
        return 1;
        if (grid[i][j] == -1)
        return 0;
        int perimeter = 0;
        grid[i][j] = -1;
        perimeter += getPerimeter(i + 1, j, n, m, grid);
        perimeter += getPerimeter(i - 1, j, n, m, grid);
        perimeter += getPerimeter(i, j + 1, n, m, grid);
        perimeter += getPerimeter(i, j - 1, n, m, grid);

        return perimeter;
    }

    public static void main(String[] args) {
        Island_Perimeter ob = new Island_Perimeter();
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(ob.islandPerimeter(grid));
    }
}
