import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class UnitTestableCode {

	public boolean passwordRentryCheck(String newPwd, String newPwdVerf) {

		if (newPwd.equals(newPwdVerf)) {
			System.out.println("There is a match");
			return true;
		} else {
			System.out.println("There isnt a match");
			return false;
		}
	}

	public boolean passwordLengthCheck(String newPwd) {

		if (newPwd.length() >= 18) {
			System.out.println("Length of pwd is acceptable");
			return true;
		} else {
			System.out.println("Length of pwd isn't acceptable");
			return false;
		}

	}

	public boolean duplicateCharLessThan4(String newPwd) {

		char[] charArr = newPwd.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : charArr) {
			if (hm.containsKey(c)) {
				int keyCount = hm.get(c);
				hm.put(c, keyCount + 1);
			} else {
				hm.put(c, 1);
			}
		}
		Set<Character> st = hm.keySet();
		for (char ch : st) {
			if (hm.get(ch) > 4) {
				System.out.println(ch + " " + hm.get(ch));
				return false;
			}
		}
		System.out.println("Duplicate Characters validation is successful");
		return true;
	}

	public boolean noMoreThan4SpecChar(String newPwd) {
		String specChar = newPwd.replaceAll("[^A-Za-z0-9]", "");
		int diffChar = ((newPwd.length()) - (specChar.length()));
		if (diffChar <= 4) {
			System.out.println("Special Character check is less than 4, hence valid");
			return true;
		} else {
			System.out.println("Special Character are more than 4");
			return false;
		}

	}

	public boolean halfShouldntBeANumber(String newPwd) {
		int newPwdLen = newPwd.length();
		String pwdNumerics = newPwd.replaceAll("[^0-9]", "");
		if (pwdNumerics.length() < (newPwdLen / 2)) {
			System.out.println("Pwd contains valid number of Numerics");
			return true;
		} else {
			System.out.println("Pwd contains more than permitted number of numerics");
			return false;
		}
	}

	public boolean alphaNumericCheck(String newPwd) {
		final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{18,}$";
		final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

		if (PASSWORD_PATTERN.matcher(newPwd).matches()) {
			return true;
		} else {
			System.out.println("Pwd doesn't meet alpha numeric and special character requiements");
			return false;
		}
	}

	public boolean pwdReplacement(String oldPwd, String newPwd, String newPwdVerf) {

		if (passwordRentryCheck(newPwd, newPwdVerf) && passwordLengthCheck(newPwd) && duplicateCharLessThan4(newPwd)
				&& noMoreThan4SpecChar(newPwd) && halfShouldntBeANumber(newPwd) && alphaNumericCheck(newPwd)) {
			System.out.println("Replacing old pwd with new pwd "+ newPwd);
			return true;
		} else {
			System.out.println("Recheck the entered new password as its not meeting the password requirements");
			return false;
		}
	}

	public static void main(String args[]) {
		UnitTestableCode ub = new UnitTestableCode();
		ub.pwdReplacement("A123mnbvcxzlkjhgfds^", "Mweenbvcxzlkjhgf##22", "Mweenbvcxzlkjhgf##22");
		
	}

}
