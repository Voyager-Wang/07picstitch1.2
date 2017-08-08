package cn.wangtao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import cn.wangtao.stitch.StitchImgs;

/**
 * 
 * @author wangtao34
 * @time 2017年8月8日 下午4:35:44
 */
public class Test {

	@org.junit.Test
	public void testStitch() {
		List<String> filePath = new ArrayList<String>();
		filePath.add("l1.jpg");
		filePath.add("m1.jpg");
		filePath.add("r1.jpg");
		String destPath = "newresult.jpg";
		StitchImgs stitchImgs = new StitchImgs();
		// junit不支持多线程，所以保持默认，不显示图片
//		stitchImgs.setShowResult(true);
//		stitchImgs.setShowSrc(true);
		boolean result = stitchImgs.stitchImags(filePath, destPath);

		assertEquals(true, result);
	}
	@org.junit.Test
	public void testStitch2() {
		List<String> filePath = new ArrayList<String>();
		filePath.add("left1.jpg");
		filePath.add("right1.jpg");
		String destPath = "newresult2.jpg";
		StitchImgs stitchImgs = new StitchImgs();
		// junit不支持多线程，所以保持默认，不显示图片
//		stitchImgs.setShowResult(true);
//		stitchImgs.setShowSrc(true);
		boolean result = stitchImgs.stitchImags(filePath, destPath);

		assertEquals(true, result);
	}
	@org.junit.Test
	public void testStitch3() {
		List<String> filePath = new ArrayList<String>();
		filePath.add("left.jpg");
		filePath.add("right.jpg");
		String destPath = "newresult1.jpg";
		StitchImgs stitchImgs = new StitchImgs();
		// junit不支持多线程，所以保持默认，不显示图片
//		stitchImgs.setShowResult(true);
//		stitchImgs.setShowSrc(true);
		boolean result = stitchImgs.stitchImags(filePath, destPath);

		assertEquals(true, result);
	}

	public static void main(String[] args) {
		List<String> filePath = new ArrayList<String>();
		filePath.add("l1.jpg");
		filePath.add("m1.jpg");
		filePath.add("r1.jpg");
		String destPath = "newresult.jpg";
		StitchImgs stitchImgs = new StitchImgs();
		stitchImgs.setShowResult(true);
		stitchImgs.setShowSrc(false);
		boolean result = stitchImgs.stitchImags(filePath, destPath);

		System.out.println(result);
	}

}
