class Robot {
    int w, h, x, y, dir;
    int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
    }

    public void step(int num) {
        int perimeter = 2 * (w + h - 2);
        num %= perimeter;
        if (num == 0) num = perimeter;

        while (num-- > 0) {
            int nx = x + d[dir][0];
            int ny = y + d[dir][1];

            if (nx < 0 || ny < 0 || nx >= w || ny >= h) {
                dir = (dir + 1) % 4;
                num++;
                continue;
            }

            x = nx;
            y = ny;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}