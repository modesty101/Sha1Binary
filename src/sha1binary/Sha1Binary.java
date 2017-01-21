package sha1binary;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/**
 * 바이너리 파일을 읽어 SHA-1 알고리즘으로 암호화합니다.
 * 
 * @author <a href="mailto:modesty101@daum.net">김동규</a>
 * @since 2017
 */
public class Sha1Binary {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream(new File("test.txt"));

		System.out.println("Total file size : +" + fis.available());
		/*
		int content;
		while ((content = fis.read()) != -1) {
			// convert to char and display it
			System.out.print((char) content);
		}
		*/
		byte[] readBuf = new byte[fis.available()];
		while (fis.read(readBuf) != -1) {

		}
		String re = new String(readBuf);
		System.out.println(re);

		fis.close();
		
		// String password = "<test>hi</test>";
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(re.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println();
		System.out.println("Hex format : " + sb.toString());
		
		/*
		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		*/
		
		//System.out.println("Hex format : " + hexString.toString());
	}
}
