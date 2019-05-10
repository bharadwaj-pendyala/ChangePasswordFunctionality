import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChangePwdCode {

	UnitTestableCode cd = new UnitTestableCode();
	
	@Test
	public void pwdReEntryMatch() {
		Assert.assertTrue(cd.passwordRentryCheck("asdsdsdsdsds", "asdsdsdsdsds"));
	}
	
	@Test
	public void pwdLengthCheck() {
		Assert.assertTrue(cd.passwordLengthCheck("sdsdsdsdsdsdsSDSdsdsdsdsdsdsd"));
	}
	
	@Test
	public void dupCharCheck() {
		Assert.assertTrue(cd.duplicateCharLessThan4("@#$Acnbvcxzlkjhdg@34iu"));
	}

	@Test
	public void specCharCheck() {
		Assert.assertTrue(cd.noMoreThan4SpecChar(")ACb1Cfesd"));
	}
	
	@Test
	public void halfOfPwdShouldntBeNumber() {
		Assert.assertTrue(cd.halfShouldntBeANumber("KLSdskldjsdkjsds90"));
	}
	
	@Test
	public void alphaNumericCheck() {
		Assert.assertTrue(cd.alphaNumericCheck("!CaN232ASDsdsndsdsdsdsdsdsdsd"));
	}
	
	
}
