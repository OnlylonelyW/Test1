package com.JD.utill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * �˹����ܿͷ�������ϵͳ
 * @author Sun
 * @version 1.0
 * 
 *
 */
public class RobotUtil {
	/**
	 * �Ի������ˣ���ȡ��
	 * @author Sun
	 * @return �ظ��Ľ��
	 * @param �������Ϣ
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
			//��������
			urlObj = new URL(url);
			//������
			uc = urlObj.openConnection();
			//������
			uc.connect();
			//��ȡ���
			reader = new InputStreamReader(uc.getInputStream(),"utf-8");
			//����������
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
	//��������
	public static void main(String [] args){
		System.out.println("��Һ�");
		String str = RobotUtil.getResult("����Ц��");
		System.out.println(str);
	}
}
