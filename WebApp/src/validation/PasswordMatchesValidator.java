package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	private String firstFieldName;
	private String secondFieldName;
	private String errorMessagename;

	@Override
	public void initialize(final PasswordMatches constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		errorMessagename = constraintAnnotation.errorMessage();
	}

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {

		boolean toReturn = false;

		try {
			final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

			toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
		} catch (final Exception ignore) {

			System.out.println(ignore.toString());
		}

		if (!toReturn) {

			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessagename).addNode(secondFieldName)
					.addConstraintViolation(); //adding errror mesege to second field(confirmPass)
		}

		return toReturn;
	}
}