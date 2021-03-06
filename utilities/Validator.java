import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String TIME12HOURS_PATTERN = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
	private static final String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
	private static final String EMAIL_PATTERN = "[A-Za-z0-9-_]+\\.+[A-Za-z0-9-_]+\\@[A-Za-z0-9]+\\.+[A-Za-z]{2,4}+[\\.[A-Za-z]{2}]?";
	private static final String SSN_PATTERN = "^(\\d{3}-?\\d{2}-?\\d{4})$";
	
	public Validator() {

	}

	public boolean timeValidate(final String time) {
		pattern = Pattern.compile(TIME12HOURS_PATTERN);
		matcher = pattern.matcher(time);
		return matcher.matches();
	}

	public boolean emailValidate(final String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public boolean dateValidate(final String date) {
		pattern = Pattern.compile(DATE_PATTERN);
		matcher = pattern.matcher(date);

		if (matcher.matches()) {

			matcher.reset();

			if (matcher.find()) {

				String day = matcher.group(1);
				String month = matcher.group(2);
				int year = Integer.parseInt(matcher.group(3));

				if (day.equals("31")
						&& (month.equals("4") || month.equals("6")
								|| month.equals("9") || month.equals("11")
								|| month.equals("04") || month.equals("06") || month
									.equals("09"))) {
					return false; // only 1,3,5,7,8,10,12 has 31 days
				} else if (month.equals("2") || month.equals("02")) {
					// leap year
					if (year % 4 == 0) {
						if (day.equals("30") || day.equals("31")) {
							return false;
						} else {
							return true;
						}
					} else {
						if (day.equals("29") || day.equals("30")
								|| day.equals("31")) {
							return false;
						} else {
							return true;
						}
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		Validator timeValidator = new Validator();
		boolean bool = timeValidator.emailValidate("r.rajan@yahoo.com");
		//boolean bool = timeValidator.timeValidate("11:02 am");
		System.out.println("Validated to : " + bool);
	}

}
