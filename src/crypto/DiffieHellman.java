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
		for (BigInteger out = BigInteger.ONE.add(BigInteger.ONE); out.compareTo(p) <= 0; out = out.add(BigInteger.ONE)) {
			boolean ok = true;
			for (int i = 0; i < factors.size() && ok; i++) {
				ok &= !out.modPow(phi.divide(factors.get(i)), p).equals(BigInteger.ONE);
			}
			if (ok) {
				return out;
			}
		}
		return null;
	}
	
	public boolean isPrimRoot(BigInteger a, BigInteger p) {
		BigInteger phi = p.subtract(BigInteger.ONE);
		byte b[] = new byte[1];
		b[0] = 2;
		for (BigInteger i = new BigInteger(b); i.compareTo(phi) == -1; i = i.nextProbablePrime()) {
			if (phi.mod(i).compareTo(BigInteger.ZERO) != 0) {
				continue;
			}
			if (a.modPow(phi.divide(i), p).compareTo(BigInteger.ONE) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public BigInteger genG2(BigInteger p) {
		byte b[] = new byte[1];
		b[0] = 2;
		BigInteger generator = new BigInteger(b);
		while (!isPrimRoot(generator, p) && generator.compareTo(p) < 1) {
			generator = generator.add(BigInteger.ONE);
		}
		return generator;
	}
	
	public static void main(String[] args) {
		DiffieHellman dh = new DiffieHellman();
		BigInteger p = dh.genP(32);
		System.out.println(p);
		System.out.println(dh.genG2(p));
		System.out.println(dh.genG(p));
	}
}
