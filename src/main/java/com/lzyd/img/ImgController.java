package com.lzyd.img;

import com.lzyd.img.utils.BaiDuApi;
import com.lzyd.img.utils.ImgUtils;
import com.lzyd.img.utils.Tess4J;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@RequestMapping(value = "/img")
@RestController
public class ImgController {

	@RequestMapping("/test")
	@ResponseBody
	@Test
	public void test() throws IOException {
		String OriginalImg = "C:\\Users\\mayn\\Desktop\\0331\\code\\oi2.jpg";
		//识别样本输出地址
		String ocrResult = "C:\\Users\\mayn\\Desktop\\0331\\code\\or.jpg";
		//去噪点
		ImgUtils.removeBackground(OriginalImg, ocrResult);
		//裁剪边角
		ImgUtils.cuttingImg(ocrResult);
		//OCR识别
		String code = Tess4J.executeTess4J(ocrResult);
		//输出识别结果
		System.out.println("Ocr识别结果: \n" + code);


	}




	public static void main(String[] args) throws IOException {
		// 识别图片的文件（修改为自己的图片路径）
		String imagePath = "C:\\Users\\mayn\\Desktop\\0331\\code\\oi2.jpg";
		File file = new File(imagePath);

		//图片转图片流
		BufferedImage img = ImageIO.read(file);
		// 这里对图片黑白处理,增强识别率.这里先通过截图,截取图片中需要识别的部分
		img = ImageHelper.convertImageToGrayscale(img);
		// 图片锐化,自己使用中影响识别率的主要因素是针式打印机字迹不连贯,所以锐化反而降低识别率
//        img = ImageHelper.convertImageToBinary(img);
		// 图片放大5倍,增强识别率(很多图片本身无法识别,放大7倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大7倍)
		img = ImageHelper.getScaledInstance(img, img.getWidth() * 7, img.getHeight() * 7);
		File outputfile = new File("C:\\Users\\mayn\\Desktop\\0331\\code\\or.jpg");
		ImageIO.write(img, "jpg", outputfile);



		ITesseract instance = new Tesseract();
		//设置训练库的位置
		String path = "D:\\workspace\\my_test\\tessdata";
		//打印一下路径，看有没有问题
		instance.setDatapath(path);
		//chi_sim ：简体中文， eng    根据需求选择语言库
		instance.setLanguage("eng");
		String result = null;
		try {
			long startTime = System.currentTimeMillis();
			result =  instance.doOCR(outputfile);
			long endTime = System.currentTimeMillis();
			System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
		} catch (TesseractException e) {
			e.printStackTrace();
		}

		System.out.println("result: "+result);
	}


	@RequestMapping("/test3")
	@ResponseBody
	@Test
	public void test3() throws IOException {
		String s = BaiDuApi.accurateBasic();
		System.out.println(s);

	}


}
