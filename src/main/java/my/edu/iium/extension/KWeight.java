package my.edu.iium.extension;

public class KWeight {
	private double weight;
	private int price;
	private int id;

	protected int getWeightDiff(int centerValue, int pointID) {
		try {
			return (int)(centerValue - getWeight(pointID));
		} catch (Exception e) {
			return KNN.getKCP().get(centerValue).intValue();
		}
	}

	protected int getWeight(int id) {
		this.weight = CFV.getFv(id).getPrice_2();
		this.price = CFV.getFv(id).getPrice_2();
		this.id = id;
		int counter = 4;
		try {processor_type();counter++;} catch (Exception e) {}
		try {processor_series();counter += 4;} catch (Exception e) {}
		try {cache();counter++;} catch (Exception e) {}
		try {processor_speed();counter += 3;} catch (Exception e) {}
		try {touch_screen();counter++;} catch (Exception e) {}
		try {ram();counter++;} catch (Exception e) {}
		try {hard_drive_type();counter++;} catch (Exception e) {}
		try {battery_life();counter++;} catch (Exception e) {}
		try {usb3();counter++;} catch (Exception e) {}
		try {usb2();counter++;} catch (Exception e) {}
		try {wireless_Band();counter++;} catch (Exception e) {}
		return (int) (this.weight / counter);
	}

	private void processor_type() {
		if (CFV.getFv(id).getProcessor_type() == 0)
			this.weight += this.price;
		else
			this.weight += (price * 0.75);
	}

	private void processor_series() {
		if (CFV.getFv(id).getProcessor_series() == 7)
			this.weight += 4 * this.price;
		else if (CFV.getFv(id).getProcessor_series() == 5)
			this.weight += 4 * (price * 0.85);
		else if (CFV.getFv(id).getProcessor_series() == 3)
			this.weight += 4 * (price * 0.70);
		else if (CFV.getFv(id).getProcessor_series() == 1)
			this.weight += 4 * (price * 0.55);
		else if (CFV.getFv(id).getProcessor_series() == 0)
			this.weight += 4 * (price * 0.40);
	}

	private void cache() {
		this.weight += this.price * (CFV.getFv(id).getCache() / 4);
	}

	private void processor_speed() {
		this.weight += 3 * this.price * (CFV.getFv(id).getProcessor_speed() / 2.5);
	}

	private void touch_screen() {
		if (CFV.getFv(id).getTouch_screen() == 1)
			this.weight += this.price;
		else
			this.weight += (price * 0.75);
	}

	private void ram() {
		this.weight += this.price * (CFV.getFv(id).getRam() / 8);
	}

	private void hard_drive_type() {
		if (CFV.getFv(id).getHard_drive_type() == 3)
			this.weight += this.price;
		else if (CFV.getFv(id).getHard_drive_type() == 2)
			this.weight += (price * 0.75);
		else if (CFV.getFv(id).getHard_drive_type() == 1)
			this.weight += (price * 0.55);
	}

	private void battery_life() {
		this.weight += this.price * (CFV.getFv(id).getBattery_life() / 8);
	}

	private void usb3() {
		this.weight += this.price * (CFV.getFv(id).getUsb3() / 2);
	}

	private void usb2() {
		this.weight += this.price * (CFV.getFv(id).getUsb2() / 3);
	}

	private void wireless_Band() {
		if (CFV.getFv(id).getWireless_Band() == 1)
			this.weight += this.price;
		else
			this.weight += (price * 0.75);
	}
}

/*
try {
processor_type();
counter++;
processor_series();
counter += 4;
cache();
counter++;
processor_speed();
counter += 3;
touch_screen();
counter++;
ram();
counter++;
hard_drive_type();
counter++;
battery_life();
counter++;
usb3();
counter++;
usb2();
counter++;
wireless_Band();
counter++;
} catch (Exception e) {}
*/