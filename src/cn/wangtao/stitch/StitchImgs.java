package cn.wangtao.stitch;

import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;

import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;

import cn.wangtao.image.ShowImgThread;
import cn.wangtao.opencv.OpenCVStitchUtil;

/**
 * 
 * @author wangtao34
 * @time 2017年8月8日 下午4:08:37
 */
public class StitchImgs {
	private boolean showSrc = false;
	private boolean showResult = false;
	
	public boolean stitchImags(List<String> imgList, String destPath) {
		// 读文件
		int size = imgList.size();
		Mat[] mats = new Mat[size];
		for(int i=0;i<size;i++) {
			Mat mat = imread(imgList.get(i));
			mats[i] = mat;
			if(showSrc){
				ShowImgThread showImg= new ShowImgThread(mats[i], "src_pic"+i);
				Thread thread = new Thread(showImg);
				thread.start();
			}
		}
		if(imgList.size()==1) {
			return true;
		}
		// 拼接
		MatVector imgs = new MatVector();
		imgs.put(mats);
		Mat result = OpenCVStitchUtil.doStitch(imgs);
		imgs.close();
		// 存储
		if(result == null) {
			return false;
		}
		if(showResult){
			ShowImgThread showImg= new ShowImgThread(result, "result");
			Thread thread = new Thread(showImg);
			thread.start();
		}
		imwrite(destPath, result);
		return true;
	}
	
	public void setShowSrc(boolean showSrc) {
		this.showSrc = showSrc;
	}
	public void setShowResult(boolean showResult) {
		this.showResult = showResult;
	}
}
