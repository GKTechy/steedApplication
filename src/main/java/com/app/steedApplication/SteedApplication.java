package com.app.steedApplication;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.app.steedApplication")
@EnableAutoConfiguration(exclude = { //
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SteedApplication {
	
//	public static SecretKeySpec generateMySQLAESKey(final String key, final String encoding) {
//		try {
//			final byte[] finalKey = new byte[16];
//			int i = 0;
//			for(byte b : key.getBytes(encoding))
//				finalKey[i++%16] ^= b;			
//			return new SecretKeySpec(finalKey, "AES");
//		} catch(UnsupportedEncodingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(SteedApplication.class, args);
		
//		try {
//			// Decrypt
//					final Cipher decryptCipher = Cipher.getInstance("AES");	        				
//					decryptCipher.init(Cipher.DECRYPT_MODE, generateMySQLAESKey("your super secret passphrase", "UTF-8"));
//					System.out.println(new String(decryptCipher.doFinal(Hex.decodeHex("56A34D7AB6225616799F6559AA388F07C2C9E53983111BDD5F49F36461AAD789".toCharArray()))));
//			 
//					// Encrypt
//					final Cipher encryptCipher = Cipher.getInstance("AES");	        				
//					encryptCipher.init(Cipher.ENCRYPT_MODE, generateMySQLAESKey("your super secret passphrase", "UTF-8"));		
//					System.out.println(String.format("Select aes_decrypt(unhex('%s'), 'your super secret passphrase');", new String(Hex.encodeHex(encryptCipher.doFinal("Hallo nach Aachen".getBytes("UTF-8"))))));
//		} catch (InvalidKeyException e) {
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (NoSuchPaddingException e) {
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (DecoderException e) {
//			e.printStackTrace();
//		}
				
	}
	
	

}
