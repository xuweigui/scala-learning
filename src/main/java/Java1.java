import scala.math.BigInt;

/**
 * Created by gary on 12/06/15.
 */
public class Java1 {

    public static void main(String[] args) {
        for (int i = 30; i>=15; i--) {
            System.out.println(Hi.fact(BigInt.apply(i)));
        }
    }

    public static void callScala() {
        for (int i = 30; i>=15; i--) {
            System.out.println(Hi.fact(BigInt.apply(i)));
        }
    }
}
