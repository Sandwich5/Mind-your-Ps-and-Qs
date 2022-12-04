import java.math.BigInteger;

public class Program
{
    public static void main(String[] args)
    { 
        // initial data
        BigInteger cipher = new BigInteger("421345306292040663864066688931456845278496274597031632020995583473619804626233684");
        BigInteger mod = new BigInteger("631371953793368771804570727896887140714495090919073481680274581226742748040342637");
        BigInteger e = new BigInteger("65537");

        // factoring p, q -> https://www.dcode.fr/prime-factors-decomposition
        // maybe good idea to make offline decomposition util? -> a problem for future me...
        BigInteger p = new BigInteger("1461849912200000206276283741896701133693");
        BigInteger q = new BigInteger("431899300006243611356963607089521499045809");

        // compute message
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger d = e.modInverse(phi);
        BigInteger result = cipher.modPow(d, mod);

        System.out.println("M = " + new String(result.toByteArray()));
    }
}