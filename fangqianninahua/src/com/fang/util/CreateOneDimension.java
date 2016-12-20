package com.fang.util;
import java.io.File;
import java.util.Hashtable;
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.common.BitMatrix;  
  
/** 
 * @blog http://sjsky.iteye.com 
 * @author Michael 
 */  
public class CreateOneDimension {  
  
    /** 
     * 编码 
     * @param contents 
     * @param width 
     * @param height 
     * @param imgPath 
     */  
    public static String  encode( int width,int height, String text) {  
        int codeWidth = 3 + // start guard  
                (7 * 6) + // left bars  
                5 + // middle guard  
                (7 * 6) + // right bars  
                3; // end guard  
        codeWidth = Math.max(codeWidth, width);  
        String path = "/"+text+".png";
        try {  
        	
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text,  
                    BarcodeFormat.CODE_39, codeWidth, height, null);  
            File outputFile = new File(path); 
            MatrixToImageWriter.writeToFile(bitMatrix, "png", outputFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return path;  
    }  
  
}