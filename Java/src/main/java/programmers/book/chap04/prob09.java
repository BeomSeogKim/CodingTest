package programmers.book.chap04;

public class prob09 {
    public int solution(int n) {
        String str = Integer.toString(n, 3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.valueOf(reversed, 3);
    }

    public static void main(String[] args) {
        prob09 prob09 = new prob09();
        System.out.println(prob09.solution(125));
    }
}
