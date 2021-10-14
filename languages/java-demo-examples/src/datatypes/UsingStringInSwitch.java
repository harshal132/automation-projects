package datatypes;

public class UsingStringInSwitch {

	public static void main(String[] args) {

		String currentDay = args[0];

		switch (currentDay) {
		case "MONDAY":
		case "TUESDAY":
		case "WEDNESDAY":
			System.out.println("boring");
			break;
		case "THURSDAY":
			System.out.println("getting better");
			break;
		case "FRIDAY":
		case "SATURDAY":
		case "SUNDAY":
			System.out.println("much better");
			break;

		}
	}
}
