
public class SampleTest {

	public void specChar(String newPwd) {
		String specChar = newPwd.replaceAll("[^A-Za-z0-9]", "");
		int diffChar = ((newPwd.length()) - (specChar.length()));
		if (diffChar <= 4) {
			System.out.println("Special Character check is less than 4, hence valid");
		} else {
			System.out.println("Special Character are more than 4");
		}
	}

	public static void main(String args[]) {
		SampleTest st = new SampleTest();
		st.specChar("$$$$$$$12344Acbvccvdgsdsdhgsjhg$$$$");
	}
}
