package com.alphaomega.demo.service;

import java.util.ArrayList;
import java.util.Enumeration;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;

public class SerialService {
	
	public static final void start() {
		
		
	}
	
    /**
     * 查找所有可用端口
     * @return 可用端口名称列表
     */
    public static final ArrayList<String> findPort() {

        //获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();    
        ArrayList<String> portNameList = new ArrayList<>();
        
		try {
	        //将可用串口名添加到List并返回该List
	        while (portList.hasMoreElements()) {
	            String portName = portList.nextElement().getName();
	            System.out.println("获取到串口：" + portName);
	            portNameList.add(portName);
	        }
		}catch(Exception e) {
			System.out.println(e);
		}


        return portNameList;
    }

}
