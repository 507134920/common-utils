package com.utils.file.uuidUtil;

import java.util.Random;
import java.util.UUID;



/**
 * @author lj
 * 功能描述 ID生成策略
 */
public class UUIDUtil {

	public static void main(String[] args) {
		for(int i=0; i< 10; i++){
			System.out.println(getRandom());
		}
		System.out.println(getUUID());
	}

	/**
	 * 获得一个UUID
	 * @return String UUID
	 */
	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		//去掉“-”符号
		return uuid.replaceAll("-", "");
	}



	public static long getRandom() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

}
