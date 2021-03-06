package passwordValidator;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

public class ChangePasswordCode {

	public boolean oldPwdEnteredMatchingWithSysPwd(String oldPwd, String oldPwdinSystem) {

		if (oldPwd.equals(oldPwdinSystem)) {
			System.out.println("Old Pwd entered is matching with old password in system");
			return true;
		} else {
			System.out.println("Old Pwd enetered is not matching with the one in system!");
			return false;
		}
	}

	public boolean passwordRentryCheck(String newPwd, String newPwdVerf) {

		if (newPwd.equals(newPwdVerf)) {
			System.out.println("New pwd and re-entered pwd are matching");
			return true;
		} else {
			System.out.println("New pwd and re-entered pwd are not matching");
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
				System.out.println(ch + " has been used for:" + " " + hm.get(ch));
				return false;
			}
		}
		System.out.println("Duplicate Characters validation is successful");
		return true;
	}

	public boolean noMoreThan4SpecChar(String newPwd) {
		String specChar = newPwd.replaceAll("[^A-Za-z0-9]", "");
		int diffChar = ((newPwd.length()) - (specChar.length()));
		if (diffChar != 0 && diffChar <= 4) {
			System.out.println("Special Character check is less than 4, hence valid");
			return true;
		} else if (newPwd.length() == specChar.length()) {
			System.out.println("There are no special characters in the entered password");
			return false;
		} else {
			System.out.println("Special Character are more than 4");
			return false;
		}

	}

	public boolean halfPwdShouldntBeANumber(String newPwd) {
		int newPwdLen = newPwd.length();
		String pwdNumerics = newPwd.replaceAll("[^0-9]", "");
		if (pwdNumerics.length() > 0 && pwdNumerics.length() < (newPwdLen / 2)) {
			System.out.println("Pwd contains valid number of numerics less than half");
			return true;
		} else if (pwdNumerics.length() == 0) {
			System.out.println("Pwd contains no numerics at all");
			return false;
		} else {
			System.out.println("Pwd contains more than permitted number of numerics more than half");
			return false;
		}
	}

	public boolean alphaNumericAndPwdLenghCheck(String newPwd) {

		final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{18,}$";
		final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

		if (PASSWORD_PATTERN.matcher(newPwd).matches()) {
			System.out.println("Pwd is following alpha numeric, special character and length requiements");
			return true;
		} else {
			System.out.println("Pwd doesn't meet alpha numeric, special character and length requiements");
			return false;
		}
	}

	public boolean oldPwdEqualityWithNewPwd(String oldPwd, String newPwd) {

		if (oldPwd.equals(newPwd)) {
			System.out.println("oldPwd equality is matching with new Pwd, Kindly re-enter valid new pwd");
			return false;
		} else {
			System.out.println("oldPwd equality is not matching with new Pwd");
			return true;
		}
	}

	public boolean pwdReplacement(String oldPwdinSystem, String oldPwd, String newPwd, String newPwdVerf) {

		if (oldPwdEnteredMatchingWithSysPwd(oldPwd, oldPwdinSystem) && passwordRentryCheck(newPwd, newPwdVerf)
				&& duplicateCharLessThan4(newPwd) && noMoreThan4SpecChar(newPwd) && halfPwdShouldntBeANumber(newPwd)
				&& alphaNumericAndPwdLenghCheck(newPwd) && oldPwdEqualityWithNewPwd(oldPwd, newPwd)) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Replacing old pwd with new pwd " + newPwd);
			return true;
		} else {
			System.out.println("----------------------------------------------------------");
			System.out.println("Recheck the entered new password as its not meeting the password requirements");
			return false;
		}
	}

	public static void main(String args[]) {
		ChangePasswordCode ub = new ChangePasswordCode();
		ub.pwdReplacement("A123mnbvcxzlkjhgfds^", "A123mnbvcxzlkjhgfds^", "Pjhoaciuytwq#33mnbv", "Pjhoaciuytwq#33mnbv");

	}

}
