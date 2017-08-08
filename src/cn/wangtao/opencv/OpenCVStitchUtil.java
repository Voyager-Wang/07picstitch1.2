package cn.wangtao.opencv;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_stitching.CylindricalWarper;
import org.bytedeco.javacpp.opencv_stitching.Stitcher;
import org.bytedeco.javacpp.opencv_stitching.SurfFeaturesFinder;
import org.bytedeco.javacpp.opencv_stitching.WarperCreator;

public class OpenCVStitchUtil {
	// 是否启用gpu
	private static boolean try_use_gpu = false;

	/**
	 * 拼接
	 * 
	 * @author wangtao34
	 * @time 2017年8月8日 下午3:48:55
	 * @param imgs
	 * @return
	 */
	public static Mat doStitch(MatVector imgs) {
		Stitcher stitcher = initStitcher(try_use_gpu);
		Mat pano = new Mat();
		try {
			int result = stitcher.estimateTransform(imgs);
			if (result == 0) {
				stitcher.composePanorama(pano);
			} else {
				pano.release();
				pano = null;
			}
		} catch (Exception e) {
			if (pano != null) {
				pano.release();
				pano = null;
			}
			return null;
		}
		try {
			stitcher.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pano;
		}
		return pano;
	}

	/**
	 * 初始化拼接参数
	 * 
	 * @author wangtao34
	 * @time 2017年8月8日 下午3:48:34
	 * @param gpuEnable
	 * @return
	 */
	public static Stitcher initStitcher(boolean gpuEnable) {
		Stitcher stitcher = Stitcher.createDefault(gpuEnable);
		CylindricalWarper cylindricalWarper = new CylindricalWarper();
		WarperCreator wp = new WarperCreator(cylindricalWarper);
		stitcher.setWarper(wp);
		SurfFeaturesFinder featureFinder = new SurfFeaturesFinder();
		stitcher.setFeaturesFinder(featureFinder);
		return stitcher;
	}
	
	public static void setTry_use_gpu(boolean try_use_gpu) {
		OpenCVStitchUtil.try_use_gpu = try_use_gpu;
	}
}