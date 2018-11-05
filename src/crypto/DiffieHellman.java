package crypto;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class DiffieHellman {

	public BigInteger genP(int bits) {
		SecureRandom r = new SecureRandom();
		while (true) { //need to make sure it is a safe prime (if p = 2q+1 and q is also prime)
			BigInteger q = BigInteger.probablePrime(bits, r);
			BigInteger p = (q.multiply(new BigInteger("2"))).add(BigInteger.ONE);
			if (p.isProbablePrime(100)) {
				return p;
			}
		}
	}
	
	public BigInteger genG(BigInteger p) {
		List<BigInteger> factors = new ArrayList<BigInteger>();
		BigInteger phi = p.subtract(BigInteger.ONE);
		BigInteger n = phi;
		for (BigInteger i = BigInteger.ONE.add(BigInteger.ONE); i.multiply(i).compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			if (n.mod(i).equals(BigInteger.ZERO)) {
				factors.add(i);
				while (n.mod(i).equals(BigInteger.ZERO)) {
					n = n.divide(i);
				}
			}
		}
		if (n.compareTo(BigInteger.ONE) > 0) {
			factors.add(n);
		}
		SecureRandom rng = new SecureRandom();
		for (BigInteger out = new BigInteger(p.bitLength(), rng);;out = new BigInteger(p.bitLength(), rng)) {
			if (out.equals(new BigInteger("2")) || out.compareTo(p) > 0) {
				continue;
			}
			boolean ok = true;
			for (int i = 0; i < factors.size() && ok; i++) {
				ok &= !out.modPow(phi.divide(factors.get(i)), p).equals(BigInteger.ONE);
			}
			if (ok) {
				return out;
			}
		}
	}
	
	public static void main(String[] args) {
		DiffieHellman dh = new DiffieHellman();
		BigInteger p = dh.genP(32);
		System.out.println(p);
		System.out.println(dh.genG(p));
	}
}
