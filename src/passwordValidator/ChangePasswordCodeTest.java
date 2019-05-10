package passwordValidator;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class ChangePasswordCodeTest {

	ChangePasswordCode cd = new ChangePasswordCode();

	/*
	 * Valid Password Test Data
	 */
	String validNewPwd = "Pjhoiuytrewq#33mnbv";
	String validReEnterNewPwd = "Pjhoiuytrewq#33mnbv";
	String validoldPwdEntered = "A123mnbvcxzlkjhgfds^";
	String validoldPwdInSystemBeforeChange = "A123mnbvcxzlkjhgfds^";

	/*
	 * InValid Password Test Data
	 */
	String invalidNewPwdNoSpecChar = "Acn1Clkjhgffdsapoiuu";
	String invalidNewPwdNoNumbrs = "Acnmnbvccxzklhjkasdghsd*";
	String invalidReEnterNewPWd = "Pjhoiuytrewq#";
	String invalidPwdLength = "peanutMNN##";
	String invalidDupCharLengthMoreThan4 = "AAAAAACNutella!44098?";
	String invalidSpecCharMoreThan4 = "#######aAmnbvcv213kmiuytrer";
	String invalidPwdWithHalfNumbers = "1234567891124@Amertnvcb";
	String invalidAlphaNumericCheckData = "AcaciaHouseofCardsBen";
	String invalidOlwPwdEntered = "A123mnbvcxzlkjhgfds";

	/*
	 * Making sure tests are passing for all the above cases Positive Happy path
	 * scenarios
	 */

	@Test
	public void TC_01_Verifying_if_reEntered_password_is_valid() {
		Assert.assertTrue(cd.passwordRentryCheck(validNewPwd, validReEnterNewPwd));
	}

	@Test
	public void TC_02_Verifying_if_password_length_is_acceptable() {
		Assert.assertTrue(cd.passwordLengthCheck(validReEnterNewPwd));
	}

	@Test
	public void TC_03_Verifying_if_password_contains_less_than_4_Duplicates_of_same_char() {
		Assert.assertTrue(cd.duplicateCharLessThan4(validReEnterNewPwd));
	}

	@Test
	public void TC_04_Verifying_if_password_contains_no_more_than_4_spec_chars() {
		Assert.assertTrue(cd.noMoreThan4SpecChar(validReEnterNewPwd));
	}

	@Test
	public void TC_05_Validating_if_password_consits_less_than_50percent_of_numbers() {
		Assert.assertTrue(cd.halfShouldntBeANumber(validReEnterNewPwd));
	}

	@Test
	public void TC_06_Verifying_if_password_entered_is_complying_with_alphanumeric_validations() {
		Assert.assertTrue(cd.alphaNumericCheck(validReEnterNewPwd));
	}

	@Test
	public void TC_07_Verifying_if_entered_oldPwd_is_Matching_with_old_password_in_system() {
		Assert.assertTrue(cd.oldPwdEnteredMatchingWithSysPwd(validoldPwdEntered, validoldPwdInSystemBeforeChange));
	}

	@Test
	public void TC_08_Verfying_if_newPwd_is_not_equal_to_oldPwdEntered() {
		Assert.assertTrue(cd.oldPwdEqualityWithNewPwd(validoldPwdEntered, validNewPwd));
	}
	/*
	 * Making sure all the tests are failing, If you want tests to pass kindly
	 * replace all inputs with valid test data provided above. Negative Test
	 * scenarios
	 */

	@Test
	public void TC_09_Verifying_if_reEntered_password_is_valid() {
		Assert.assertTrue(cd.passwordRentryCheck(validNewPwd, invalidReEnterNewPWd));
	}

	@Test
	public void TC_10_Verifying_if_password_length_is_acceptable() {
		Assert.assertTrue(cd.passwordLengthCheck(invalidPwdLength));
	}

	@Test
	public void TC_11_Verifying_if_password_contains_less_than_4_Duplicates_of_same_char() {
		Assert.assertTrue(cd.duplicateCharLessThan4(invalidDupCharLengthMoreThan4));
	}

	@Test
	public void TC_12_Verifying_if_password_contains_no_more_than_4_spec_chars() {
		Assert.assertTrue(cd.noMoreThan4SpecChar(invalidSpecCharMoreThan4));
	}

	@Test
	public void TC_13_Validating_if_password_consits_less_than_50percent_of_numbers() {
		Assert.assertTrue(cd.halfShouldntBeANumber(invalidPwdWithHalfNumbers));
	}

	@Test
	public void TC_14_Verifying_if_password_entered_is_complying_with_alphanumeric_validations() {
		Assert.assertTrue(cd.alphaNumericCheck(invalidAlphaNumericCheckData));
	}

	@Test
	public void TC_15_Verifying_if_entered_oldPwd_is_Matching_with_old_password_in_system() {
		Assert.assertTrue(cd.oldPwdEnteredMatchingWithSysPwd(validoldPwdEntered, invalidOlwPwdEntered));
	}

	@Test
	public void TC_16_Verfying_if_newPwd_is_not_equal_to_oldPwdEntered() {
		Assert.assertTrue(cd.oldPwdEqualityWithNewPwd(validoldPwdEntered, validoldPwdEntered));
	}

}
