package basiccipher;

import java.util.Random;

public class ShiftCipher {

	private int key;
	public final static char[] LATIN_ALP = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public ShiftCipher() {
		this.key = genKey();
	}

	public int genKey() {
		Random r = new Random();
		key = r.nextInt(26);
		return key;
	}

	public int getKey() {
		return key;
	}

	public void loadKey() {
		System.out.println(this.key);
	}

	public String encrypt(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || text.length() == 0)
			return "please put some longer text.";

		for (char c : text.toLowerCase().toCharArray()) {
			int index = 0;
			int alp_len = LATIN_ALP.length;
			boolean found = false;
			
			for (int i = 0; i < alp_len; i++) {
				if (LATIN_ALP[i] == c) {
					found = true;
					index = (i + key) % 26;
					sb.append(LATIN_ALP[index]);

				}
			}
			if (!found) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public String decrypt(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || text.length() == 0)
			return "please put some longer text.";

		for (char c : text.toLowerCase().toCharArray()) {
			int index = 0;
			int alp_len = LATIN_ALP.length;
			boolean found = false;
			
			for (int i = 0; i < alp_len; i++) {
				if (LATIN_ALP[i] == c) {
					found = true;
					index = (26-key+i) % 26;
					sb.append(LATIN_ALP[index]);

				}
			}
			if (!found) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ShiftCipher s = new ShiftCipher();
		String plainText = "Dear sister, by the time you read this, I'll be dead.";
		String ec=s.encrypt(plainText);
		String dc= s.decrypt(ec);
		System.out.println(dc);
	}
}
