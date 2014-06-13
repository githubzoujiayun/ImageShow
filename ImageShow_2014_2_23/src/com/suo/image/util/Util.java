package com.suo.image.util;

import java.io.File;

import com.suo.image.TestApplication;

import android.app.Activity;
import android.app.ActivityManager;

public class Util {
	public static void printMemoryInfo(){
		 ActivityManager am;  
		 ActivityManager.MemoryInfo memoryInfo;
		 am=(ActivityManager) TestApplication.getAppContext().getSystemService(Activity.ACTIVITY_SERVICE);
		 memoryInfo=new ActivityManager.MemoryInfo();
		 am.getMemoryInfo(memoryInfo);
//		 Log.d("ʣ���ڴ�(M)��" + memoryInfo.availMem/(1024*1024));
	}
	
	public static boolean fileExists(String filename){
		File imgFile = new File(filename);
		if(imgFile.exists()){
			return true;
		}
		return false;
	}
}
