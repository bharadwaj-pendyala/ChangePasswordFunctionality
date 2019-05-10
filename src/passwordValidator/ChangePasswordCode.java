package passwordValidator;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

public class ChangePasswordCode {

	public boolean oldPwdEnteredMatchingWithSysPwd(String oldPwd, String oldPwdinSystem) {
		System.out.println("Verifying if old password in system is matching with entered old password while changing");
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

	public boolean halfShouldntBeANumber(String newPwd) {
		int newPwdLen = newPwd.length();
		String pwdNumerics = newPwd.replaceAll("[^0-9]", "");
		if (pwdNumerics.length() > 0 && pwdNumerics.length() < (newPwdLen / 2)) {
			System.out.println("Pwd contains valid number of Numerics");
			return true;
		} else if (pwdNumerics.length() == 0) {
			System.out.println("Pwd contains no Numerics at all");
			return false;
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

	public boolean oldPwdEqualityWithNewPwd(String oldPwd, String newPwd) {
		System.out.println("Verifying if new pwd entered is not same as old one");
		if (oldPwd.equals(newPwd)) {
			System.out.println("oldPwd equality is not matching with new Pwd");
			return true;
		} else {
			System.out.println("oldPwd equality is matching with new Pwd, Kindly re-enter valid new pwd");
			return false;
		}
	}

	public boolean pwdReplacement(String oldPwdinSystem, String oldPwd, String newPwd, String newPwdVerf) {

		if (oldPwdEnteredMatchingWithSysPwd(oldPwd, oldPwdinSystem) && passwordRentryCheck(newPwd, newPwdVerf)
				&& passwordLengthCheck(newPwd) && duplicateCharLessThan4(newPwd) && noMoreThan4SpecChar(newPwd)
				&& halfShouldntBeANumber(newPwd) && alphaNumericCheck(newPwd)
				&& oldPwdEqualityWithNewPwd(oldPwd, newPwd)) {
			System.out.println("Replacing old pwd with new pwd " + newPwd);
			return true;
		} else {
			System.out.println("Recheck the entered new password as its not meeting the password requirements");
			return false;
		}
	}

	public static void main(String args[]) {
		ChangePasswordCode ub = new ChangePasswordCode();
		ub.pwdReplacement("A123mnbvcxzlkjhgfds^", "A123mnbvcxzlkjhgfds^", "Pjhoiuytrewq#33mnbv", "Pjhoiuytrewq#33mnbv");

	}

}
