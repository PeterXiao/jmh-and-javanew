package j16;

public class JEP395 {
    static record Point(int x, int y) {}
    public static void main(String[] args) {
        var p = new Point(1, 4);
        System.out.println(p.x + " " + p.y);
    }
}