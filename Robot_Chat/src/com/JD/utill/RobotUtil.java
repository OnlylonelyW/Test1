package com.JD.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 人工智能客服机器人系统
 * @author Sun
 * @version 1.0
 * 
 *
 */
public class RobotUtil {
	/**
	 * 对话机器人，获取答案
	 * @author Sun
	 * @return 回复的结果
	 * @param 输入的消息
	 */
	public static String getResult(String message){
		StringBuffer buff = new StringBuffer();
		URL urlObj = null;
		URLConnection uc = null;
		InputStreamReader reader = null;
		BufferedReader br = null;
		try{
			String question = URLEncoder.encode(message,"utf-8");
			String url = "http://www.tuling123.com/openapi/api?key=7698233d4e5a452bb848f36b412c1e78&info="+question;
			//建立连接
			urlObj = new URL(url);
			//打开连接
			uc = urlObj.openConnection();
			//连接上
			uc.connect();
			//获取结果
			reader = new InputStreamReader(uc.getInputStream(),"utf-8");
			//建立缓存流
			br = new BufferedReader(reader);
			String temp = null;
			while((temp = br.readLine())!=null){
				buff.append(temp);
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try{
					reader.close();;
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return buff.toString();
	}
	//程序的入口
	public static void main(String [] args){
		System.out.println("大家好");
		String str = RobotUtil.getResult("讲个笑话");
		System.out.println(str);
	}
}
