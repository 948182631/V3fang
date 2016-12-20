package com.fang.util;

import java.io.File;
import java.util.Hashtable;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class CreateTwoDimension {
	/**
	 * width 二维码的宽度
	 * height 二维码的高
	 * text 生成二维码的文字
	 * */
	@SuppressWarnings("unchecked")
	public static String create( int width,int height, String text) throws Exception { 
        //二维码的图片格式 
        String format = "jpg"; 
        Hashtable hints = new Hashtable(); 
        String path = "/"+text+".jpg";
        //内容所使用编码 
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); 
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, 
                BarcodeFormat.QR_CODE, width, height, hints); 
        //生成二维码 
        File outputFile = new File(path); 
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile); 
		return path;
    } 
}
