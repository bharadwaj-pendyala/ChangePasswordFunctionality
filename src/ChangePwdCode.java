import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class ChangePwdCode {

	String pwdReq = "newPwdMatchesReEnterPwd";
	Boolean bn;

	public void gatherPwdInfo() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter old Pwd: ");
		String oldPwd = sc.nextLine();
		System.out.println("Enter new Pwd: ");
		String newPwd = sc.nextLine();
		System.out.println("Re-enter new Pwd: ");
		String newPwdVerf = sc.nextLine();

		switch (pwdReq) {

		case "newPwdMatchesReEnterPwd":
			System.out.println("Verifying if re-entered pwd is matching with new pwd");
			if (newPwd.equals(newPwdVerf)) {
				bn = true;
				System.out.println("Password Match Successful");
			} else {
				bn = false;
				System.out.println("Re-Entered password is not matching with new pwd");
				break;
			}
		case "newPwdLength":
			System.out.println("new Pwd should atleast be 18 characters in length");
			if (newPwd.length() >= 18) {
				bn = true;
				System.out.println("Length check is Successful");
			} else {
				bn = false;
				System.out.println("Please check the length, it should be 18");
				break;
			}

		case "noDuplicatesGreaterThan4":

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
					break;
				}
			}

			System.out.println("Duplicate Characters validation is successful");

		case "noMoreThan4SpecChar":

			String specChar = newPwd.replaceAll("^A-Za-z0-9", "");
			int diffChar = ((newPwd.length()) - (specChar.length()));
			if (diffChar <= 4) {
				System.out.println("Special Character check is less than 4, hence valid");
			} else {
				System.out.println("Special Character are more than 4");
				break;
			}

		case "halfShouldntBeANumber":

			int newPwdLen = newPwd.length();
			String pwdNumerics = newPwd.replaceAll("[^0-9]", "");
			if (pwdNumerics.length() < (newPwdLen / 2)) {
				System.out.println("Pwd contains valid number of Numerics");
			} else {
				System.out.println("Pwd contains more than permitted number of numerics");
				break;
			}

		case "alphaNumericCheck":

			final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{18,}$";

			final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

			if (PASSWORD_PATTERN.matcher(newPwd).matches()) {
				System.out.println("Pwd matches the requirements, hence replacing the old Pwd");
				System.out.println("Replacing password");
				System.out.println("newPWd is " + oldPwd.replace(oldPwd, newPwd));
			} else {
				System.out.println("Pwd doesn't meet alpha numeric and special character requiements");
				break;
			}
		}

		sc.close();

	}

	public static void main(String args[]) {

		ChangePwdCode cp = new ChangePwdCode();
		cp.gatherPwdInfo();

	}

}