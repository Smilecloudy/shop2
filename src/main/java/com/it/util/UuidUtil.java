package com.it.util;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * UUID工具类
 */
public final class UuidUtil {

	public static String getUuid(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		return str;
	}

	public static void main(String[] args) throws Exception{
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
		System.out.println(UuidUtil.getUuid());
	}
}
