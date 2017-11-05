public class IntersectRectangle {
    public static class Rectangle {
        int x, y, width, height;
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public static Rectangle istersectRectangle(Rectangle r1, Rectangle r2) {
        if (!isInteract(r1, r2)) {
            return Rectangle(0, 0, -1, -1);
        }
        return Rectangle(
            Math.max(r1.x, r2.x),
            Math.max(r1.y, r2.y),
            Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x),
            Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y)
        );
    }

    public static boolean isInteract(Rectangle r1, Rectangle r2) {
        return r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x
            && r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y;
    }
}
