package es.florida.AE04;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ASCII {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introducir el Passwd: ");
		String pwd = teclado.nextLine();

		System.out.println(conversion(pwd));
		System.out.println(getMD5(pwd));
		teclado.close();

	}

	public static String conversion(String pwd) {

		int longitud = pwd.length();
		String nuevoPasswd = "";
		char nuevoCaracter;

		for (int i = 0; i < longitud; i++) {

			char caracter = pwd.charAt(i);
			int numeroASCII = (int) caracter;

			if ((numeroASCII > 33) && (numeroASCII < 126)) {
				nuevoCaracter = ((char) (numeroASCII + 1));
			} else {
				nuevoCaracter = (char) 42;
			}
			nuevoPasswd = nuevoPasswd + nuevoCaracter;
		}
		return nuevoPasswd;
	}

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
