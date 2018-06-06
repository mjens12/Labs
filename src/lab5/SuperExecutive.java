package lab5;

public class SuperExecutive extends Executive {

	private double bonus;

	public SuperExecutive(String eName, String eAddress, String ePhone,
			String socSecNumber, double rate) {
		super(eName, eAddress, ePhone, socSecNumber, rate);
	}

	public double pay() {
		double payment = super.pay() + bonus;

		bonus = 0;

		return payment;
	}

	public String toString() {
		String result = super.toString();

		result += " \n(EMP)\nSocial Security Number: "
				+ socialSecurityNumber;

		return result;
	}

}
