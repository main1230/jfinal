package com.jfinal.zzl.utils.zxing;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class ZxingTools {
	
	public static void main(String[] args) {
		try {
			getCodeImg("http://www.baidu.com", "f.jpg");
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param text 二维码内容
	 * @param name 二维码图片名称
	 * @throws WriterException
	 * @throws IOException
	 */
	public static void getCodeImg(String text, String name) throws WriterException, IOException {
		int width = 300; // 二维码图片宽度
		int height = 300; // 二维码图片高度
		String format = "jpg";// 二维码的图片格式
		
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	// 内容所使用字符集编码
		
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File("E:/"/* + File.separator + "download" + File.separator*/ + name);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
}
