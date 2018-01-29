package my.edu.iium.extension;

import java.util.ArrayList;
import java.util.List;

public class FV_BackUp {
	/*
	 * PRICE_original $ price per cash
	 * 
	 * PRICE_after_discount $ price per cash
	 * 
	 * processor_type 0 = intel 1 = amd
	 * 
	 * processor_series 0 = celereon 1 = pentium 3 = 3cores 5 = 5cores 7 =
	 * 7cores
	 * 
	 * cache number is capasity per MB
	 * 
	 * processor_speed number is speed per Ghz
	 * 
	 * touch_screen 0 = no 1 = yes
	 * 
	 * RAM number is capasity per GB
	 * 
	 * hard_drive_type 1 = magnatic 2 = sata 3 = ssd
	 * 
	 * hard_drive_size_GB number is capasity per GB
	 * 
	 * screen_size 1 = 11 inche 3 = 13 inche 4 = 14 inche 5 = 15 inche 7 = 17
	 * inche
	 * 
	 * battery_life number is duration of hours
	 * 
	 * usb3 number of ports
	 * 
	 * usb2 number of ports
	 * 
	 * dvd number of ports
	 * 
	 * camera 0 = no 1 = yes
	 * 
	 * weight 1 = between 1.0 to 1.5 2 = between 1.5 to 2 3 = between 2.0 to 2.5
	 * 4 = between 2.5 to 3 8 = greater than 4
	 * 
	 * Wireless_Band 0 = single 1 = double
	 */
	private static List<Integer> ID = new ArrayList<Integer>();
	private static List<Integer> price_1 = new ArrayList<Integer>();
	private static List<Integer> price_2 = new ArrayList<Integer>();
	private static List<Integer> processor_type = new ArrayList<Integer>();
	private static List<Integer> processor_series = new ArrayList<Integer>();
	private static List<Double> processor_speed = new ArrayList<Double>();
	private static List<Integer> cache = new ArrayList<Integer>();
	private static List<Integer> touch_screen = new ArrayList<Integer>();
	private static List<Integer> ram = new ArrayList<Integer>();
	private static List<Integer> hard_drive_type = new ArrayList<Integer>();
	private static List<Integer> hard_drive_size_GB = new ArrayList<Integer>();
	private static List<Integer> screen_size = new ArrayList<Integer>();
	private static List<Integer> battery_life = new ArrayList<Integer>();
	private static List<Integer> usb3 = new ArrayList<Integer>();
	private static List<Integer> usb2 = new ArrayList<Integer>();
	private static List<Integer> dvd = new ArrayList<Integer>();
	private static List<Integer> camera = new ArrayList<Integer>();
	private static List<Integer> weight = new ArrayList<Integer>();
	private static List<Integer> Wireless_Band = new ArrayList<Integer>();

	protected static int getID(int id) {
		return ID.get(id).intValue();
	}

	protected static void setID(int counter, int id) {
		ID.add(counter, new Integer(id));
	}

	protected static int getIdSize() {
		return ID.size();
	}

	protected static int getPrice_1(int id) {
		return price_1.get(id).intValue();
	}

	protected static void setPrice_1(int id, int price) {
		price_1.add(id, new Integer(price));
	}

	protected static int getPrice_2(int id) {
		return price_2.get(id).intValue();
	}

	protected static void setPrice_2(int id, int price) {
		price_2.add(id, new Integer(price));
	}

	protected static int getProcessor_type(int id) {
		return processor_type.get(id).intValue();
	}

	protected static void setProcessor_type(int id, int type) {
		processor_type.add(id, new Integer(type));
	}

	protected static int getProcessor_series(int id) {
		return processor_series.get(id).intValue();
	}

	protected static void setProcessor_series(int id, int series) {
		processor_series.add(id, new Integer(series));
	}

	protected static double getProcessor_speed(int id) {
		return processor_speed.get(id).doubleValue();
	}

	protected static void setProcessor_speed(int id, double speed) {
		processor_speed.add(id, new Double(speed));
		;
	}

	protected static int getCache(int id) {
		return cache.get(id).intValue();
	}

	protected static void setCache(int id, int cache_size) {
		cache.add(id, new Integer(cache_size));
	}

	protected static int getTouch_screen(int id) {
		return touch_screen.get(id).intValue();
	}

	protected static void setTouch_screen(int id, int touch) {
		touch_screen.add(id, new Integer(touch));
	}

	protected static int getRam(int id) {
		return ram.get(id).intValue();
	}

	protected static void setRam(int id, int RAM) {
		ram.add(id, new Integer(RAM));
	}

	protected static int getHard_drive_type(int id) {
		return hard_drive_type.get(id).intValue();
	}

	protected static void setHard_drive_type(int id, int type) {
		hard_drive_type.add(id, new Integer(type));
	}

	protected static int getHard_drive_size_GB(int id) {
		return hard_drive_size_GB.get(id).intValue();
	}

	protected static void setHard_drive_size_GB(int id, int hard_drive_size) {
		hard_drive_size_GB.add(id, new Integer(hard_drive_size));
	}

	protected static int getScreen_size(int id) {
		return screen_size.get(id).intValue();
	}

	protected static void setScreen_size(int id, int size) {
		screen_size.add(id, new Integer(size));
	}

	protected static int getBattery_life(int id) {
		return battery_life.get(id).intValue();
	}

	protected static void setBattery_life(int id, int battery) {
		battery_life.add(id, new Integer(battery));
	}

	protected static int getUsb3(int id) {
		return usb3.get(id).intValue();
	}

	protected static void setUsb3(int id, int usb) {
		usb3.add(id, new Integer(usb));
	}

	protected static int getUsb2(int id) {
		return usb2.get(id).intValue();
	}

	protected static void setUsb2(int id, int usb) {
		usb2.add(id, new Integer(usb));
	}

	protected static int getDvd(int id) {
		return dvd.get(id).intValue();
	}

	protected static void setDvd(int id, int dvds) {
		dvd.add(id, new Integer(dvds));
	}

	protected static int getCamera(int id) {
		return camera.get(id).intValue();
	}

	protected static void setCamera(int id, int cameras) {
		camera.add(id, new Integer(cameras));
	}

	protected static int getWeight(int id) {
		return weight.get(id).intValue();
	}

	protected static void setWeight(int id, int weight_kg) {
		weight.add(id, new Integer(weight_kg));
	}

	protected static int getWireless_Band(int id) {
		return Wireless_Band.get(id).intValue();
	}

	protected static void setWireless_Band(int id, int wireless_Band) {
		Wireless_Band.add(id, new Integer(wireless_Band));
	}
}
