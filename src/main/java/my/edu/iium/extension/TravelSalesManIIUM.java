package my.edu.iium.extension;

import com.rapidminer.example.*;
import com.rapidminer.operator.*;
import com.rapidminer.operator.ports.*;

public class TravelSalesManIIUM extends Operator {
	private InputPort exampleSetInput = getInputPorts().createPort("example set");
	private OutputPort exampleSetOutput1 = getOutputPorts().createPort("knn");
	private OutputPort exampleSetOutput2 = getOutputPorts().createPort("tsp");
	private String PRICE_original = "PRICE_original";
	private String PRICE_after_discount = "PRICE_after_discount";
	private String processor_type = "processor_type";
	private String processor_series = "processor_series";
	private String cache = "cache";
	private String processor_speed = "processor_speed";
	private String touch_screen = "touch_screen";
	private String RAM = "RAM";
	private String hard_drive_type = "hard_drive_type";
	private String hard_drive_size_GB = "hard_drive_size_GB";
	private String screen_size = "screen_size";
	private String battery_life = "battery_life";
	private String usb3 = "usb3";
	private String usb2 = "usb2";
	private String dvd = "dvd";
	private String camera = "camera";
	private String weight = "weight";
	private String Wireless_Band = "Wireless_Band";
	private ExampleSet exampleSet;
	private Attributes attributes;

	public TravelSalesManIIUM(OperatorDescription description) {
		super(description);
	}
	
	private void subDoWork() throws Exception{
		int counter = 0;
		for (Example ex : exampleSet) {
			CFV.setID(counter);
			for (Attribute attr : exampleSet.getAttributes()) {
				try {
					fetch(attr, ex, attributes, counter);
				} catch (Exception e) {}
			}
			CFV.setFv();
			counter++;
		}
	}
	
	private void setExampleSet() throws Exception {
		int showValue[];
		if(KNN.isPerformKNN()){
			showValue = new int[KNN.getK()];
			int counter = 0;
			for (int value : KNN.getKCP()) {
				showValue[counter] = value;
				counter++;
			}
		}else{
			showValue = new int[KNN.ErrorArea.length];
			int counter = 0;
			for (;counter<showValue.length;) {
				showValue[counter] = KNN.ErrorArea[counter];
				counter++;
			}
		}
		int i = 0;
		for (Example ex : exampleSet) {
			for (Attribute attr : exampleSet.getAttributes()) {
				try {
					ex.setValue(attr, showValue[i++]);
				} catch (Exception e) {
					/* Failed to write on data set */}
			}
		}
	}

	public void doWork() throws OperatorException {
		super.doWork();
		int functionsCounter = 0;
		try {
			exampleSet = exampleSetInput.getData(ExampleSet.class);
			attributes = exampleSet.getAttributes();
		}catch (UserError e) {e.printStackTrace();}
		try {
			subDoWork();
			functionsCounter++;
			KNN.performAlgo();
			functionsCounter++;
//			TSP.performAlgo();
//			functionsCounter++;
			setExampleSet();
			functionsCounter++;
			exampleSetOutput1.deliver(exampleSet);
			exampleSetOutput2.deliver(exampleSet);
		} catch (Exception e1) {
			functionsCounter *= 100;
		}
		if(functionsCounter>99 | functionsCounter==0)
			;// do something regarding this error
	}
	
	private void fetch(Attribute attr, Example ex, Attributes attrs, int id) throws Exception {
		if (attr == attrs.get(PRICE_original)) {
			CFV.setPrice_1((int) ex.getValue(attr));
		} else if (attr == attrs.get(PRICE_after_discount)) {
			CFV.setPrice_2((int) ex.getValue(attr));
		} else if (attr == attrs.get(processor_type)) {
			CFV.setProcessor_type((int) ex.getValue(attr));
		} else if (attr == attrs.get(processor_series)) {
			CFV.setProcessor_series((int) ex.getValue(attr));
		} else if (attr == attrs.get(cache)) {
			CFV.setCache((int) ex.getValue(attr));
		} else if (attr == attrs.get(processor_speed)) {
			CFV.setProcessor_speed(ex.getValue(attr));
		} else if (attr == attrs.get(touch_screen)) {
			CFV.setTouch_screen((int) ex.getValue(attr));
		} else if (attr == attrs.get(RAM)) {
			CFV.setRam((int) ex.getValue(attr));
		} else if (attr == attrs.get(hard_drive_type)) {
			CFV.setHard_drive_type((int) ex.getValue(attr));
		} else if (attr == attrs.get(hard_drive_size_GB)) {
			CFV.setHard_drive_size_GB((int) ex.getValue(attr));
		} else if (attr == attrs.get(screen_size)) {
			CFV.setScreen_size((int) ex.getValue(attr));
		} else if (attr == attrs.get(battery_life)) {
			CFV.setBattery_life((int) ex.getValue(attr));
		} else if (attr == attrs.get(usb3)) {
			CFV.setUsb3((int) ex.getValue(attr));
		} else if (attr == attrs.get(usb2)) {
			CFV.setUsb2((int) ex.getValue(attr));
		} else if (attr == attrs.get(dvd)) {
			CFV.setDvd((int) ex.getValue(attr));
		} else if (attr == attrs.get(camera)) {
			CFV.setCamera((int) ex.getValue(attr));
		} else if (attr == attrs.get(weight)) {
			CFV.setWeight((int) ex.getValue(attr));
		} else if (attr == attrs.get(Wireless_Band)) {
			CFV.setWireless_Band((int) ex.getValue(attr));
		}
	}

	public boolean writesIntoExistingData() {
		return true;
	}
}



// Attribute attrs[] = new Attribute[2];
// attrs[0] = AttributeFactory.createAttribute("attr1", Ontology.NUMERICAL);
// attrs[1] = AttributeFactory.createAttribute("attr1", Ontology.STRING);
//// exampleSet.getAttributes()
// Example example;
// example.
// example.setValue(attrs[0], "0");
// for (Attribute attri : attributes)
// attributes.remove(attri);
// attrs[0].setTableIndex(5);
// attrs[1].setTableIndex(5);
//// DataRow row = new DataRow();
// attrs[0].setValue(row, getApplyCount());
// attributes.addRegular(attrs[0]);
// attributes.addRegular(attrs[1]);