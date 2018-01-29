package my.edu.iium.extension;

import java.util.ArrayList;
import java.util.List;

public class KNN {
	public static int ErrorArea[] = new int[100];
	public static int errorCounter = 0;
	private static boolean performKNN = false;
	private static int k = 1;
	private static int randomSelectedBase = 100;
	private static List<Integer> KCP = new ArrayList<Integer>();
	private static List<Integer> KCPnew = new ArrayList<Integer>();
	private static ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();

	public KNN() {
	}
	
	protected static boolean performAlgo() {
		KNN.setK();
		if (KNN.getK() > 1) {
			if (setKCP()) {
				try {
					boolean isUpdated = false;
					isUpdated = isKCPupdated();
					ErrorArea[errorCounter++] = 100019; // first error area if occurred next line
					return true;
//					return isUpdated;
				} catch (Exception e) {
					ErrorArea[errorCounter++] = 100020; // first error area if occurred next line
					KNN.performKNN = false;
					return KNN.performKNN;
				}
			} else {
				KNN.performKNN = false;
				return KNN.performKNN;
			}
		} else {
			KNN.performKNN = false;
			return KNN.performKNN;
		}
	}

	protected static void setK() {
		int k;
		k = CFV.getFv(CFV.getSize() - 1).getPrice_2();
		k -= CFV.getFv(0).getPrice_2();
		k = (int) (k / randomSelectedBase);
		KNN.k = k;
	}

	protected static int getK() {
		return k;
	}

	private static boolean setKCP() {
		try {
			int smallest = CFV.getFv(3).getPrice_2();
			try{
				for(FV fvs : CFV.getFv())
					if(smallest > fvs.getPrice_2())
						smallest = fvs.getPrice_2();
			}catch(Exception e){/* couldn't find the smallest value */}
//			KCBeginning.add(0, CFV.getFv(0).getPrice_2());
			KCP.add(0, smallest);
			for(int counter = 1; counter<k ; counter++){
				KCP.add(counter, KCP.get(counter-1).intValue()+randomSelectedBase);
//				KCPnew.add(counter, 0);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static void calculateDistance(){
		try{
			ArrayList<Integer> subList = new ArrayList<Integer>();
			ErrorArea[errorCounter++] = 90001; // error area if occurred next line
			for (int centerIndex = 0; centerIndex < k; centerIndex++) {
				int counter=0;
				KWeight kw = new KWeight();
				try{
					for(FV fvs : CFV.getFv()){
						int centerValue = KCP.get(centerIndex).intValue();
						int pointID = fvs.getID();
						int diff = kw.getWeightDiff(centerValue, pointID); 
						subList.add(counter, diff);
					}
					distance.add(centerIndex,subList);
				}catch(Exception e){
					/* couldn't set the distance */
					ErrorArea[errorCounter++] = 90002; // error area if occurred next line
					distance.get(centerIndex).add(counter,1000);
					// been set far so it will be ignored since it has error
				}
			}
			ErrorArea[errorCounter++] = 90003; // error area if occurred next line
		}catch(Exception e){
			ErrorArea[errorCounter++] = 90004; // error area if occurred next line
		}
	}
	
	private static void setKCPnew(){
		try{
			ErrorArea[errorCounter++] = 90005; // error area if occurred next line
			for(int centerIndex=0; centerIndex<k ; centerIndex++){
				try{
					int mean = 0, counter = 0;
					for(int objectID=0; objectID<CFV.getSize() ; objectID++){
						try{
							int distanceOfObject = distance.get(centerIndex).get(objectID).intValue();
							if(distanceOfObject != 1000){
								mean+= distanceOfObject;
								counter++;
							}
						}catch(Exception e){}
					}
					mean = (int) (mean / counter);
					KCPnew.add(centerIndex, mean);
				}catch(Exception e){
					ErrorArea[errorCounter++] = 90006; // error area if occurred next line
				}
			}
		}catch(Exception e){
			ErrorArea[errorCounter++] = 90007; // error area if occurred next line			
		}
	}
	
	private static boolean isKCPupdated() {
		ErrorArea[errorCounter++] = 90008; // error area if occurred next line
		calculateDistance();
		ErrorArea[errorCounter++] = 90009; // error area if occurred next line
		try {
			for (int counter = 0; counter < CFV.getSize(); counter++) {
				int centerSelected = 0;
				int leastDistance = distance.get(centerSelected).get(counter).intValue();
				for (int centerIndex = 0; centerIndex < k; centerIndex++) {
					if(leastDistance > distance.get(centerIndex).get(counter).intValue()){
						centerSelected = centerIndex;
						leastDistance = distance.get(centerSelected).get(counter).intValue();
					}else{
						distance.get(centerIndex).add(counter,1000);
						// been set far so it will be ignored since it has error
					}
				}
			}
		ErrorArea[errorCounter++] = 90010; // error area if occurred next line
		setKCPnew();
		ErrorArea[errorCounter++] = 90011; // error area if occurred next line
		return true;
		} catch (Exception e) {
			/* Failed to set KCB means KNN fails */}
		ErrorArea[errorCounter++] = 90010; // error area if occurred next line
		return false;
	}

	protected static boolean isPerformKNN() {
//		if(performKNN){ // a test of KNN is performed 
//			try{
//				for(int i=0 ; i<k ; i++)
//					KCP.add(i, 36900);
//			}catch(Exception e){
//				
//			}
//		}
		return performKNN;
	}

	protected static List<Integer> getKCP() {
		return KCP;
	}
	
//	protected static int getKCP(int index) {
//		return KCP.get(index).intValue();
//	}

}