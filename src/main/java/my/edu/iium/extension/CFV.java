package my.edu.iium.extension;

import java.util.ArrayList;

//	CFV stands for control fetch values
public class CFV {
	private static ArrayList<FV> fv = new ArrayList<FV>();
	// private static ArrayList<KV> kv = new ArrayList<KV>();
	private static FV row = new FV();
	// private static int counter = 0; // must reach to 19

	protected static int getSize() {
		return fv.size();
	}
	
	protected static ArrayList<FV> getFv() {
		return fv;
	}

	protected static FV getFv(int id) {
		return fv.get(id);
	}

	protected static void setFv() {
		try {
			fv.add(row);
			row = new FV();
		} catch (Exception e) {
			row = new FV();
		}
	}

	protected static void setID(int iD) {
		row.setID(iD);
	}

	protected static void setPrice_1(int price_1) {
		row.setPrice_1(price_1);
	}

	protected static void setPrice_2(int price_2) {
		row.setPrice_2(price_2);
	}

	protected static void setProcessor_type(int processor_type) {
		row.setProcessor_type(processor_type);
	}

	protected static void setProcessor_series(int processor_series) {
		row.setProcessor_series(processor_series);
	}

	protected static void setProcessor_speed(double processor_speed) {
		row.setProcessor_speed(processor_speed);
	}

	protected static void setCache(int cache) {
		row.setCache(cache);
	}

	protected static void setTouch_screen(int touch_screen) {
		row.setTouch_screen(touch_screen);
	}

	protected static void setRam(int ram) {
		row.setRam(ram);
	}

	protected static void setHard_drive_type(int hard_drive_type) {
		row.setHard_drive_type(hard_drive_type);
	}

	protected static void setHard_drive_size_GB(int hard_drive_size_GB) {
		row.setHard_drive_size_GB(hard_drive_size_GB);
	}

	protected static void setScreen_size(int screen_size) {
		row.setScreen_size(screen_size);
	}

	protected static void setBattery_life(int battery_life) {
		row.setBattery_life(battery_life);
	}

	protected static void setUsb3(int usb3) {
		row.setUsb3(usb3);
	}

	protected static void setUsb2(int usb2) {
		row.setUsb2(usb2);
	}

	protected static void setDvd(int dvd) {
		row.setDvd(dvd);
	}

	protected static void setCamera(int camera) {
		row.setCamera(camera);
	}

	protected static void setWeight(int weight) {
		row.setWeight(weight);
	}

	protected static void setWireless_Band(int wireless_Band) {
		row.setWireless_Band(wireless_Band);
	}
}