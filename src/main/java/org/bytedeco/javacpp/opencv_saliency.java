// Targeted by JavaCPP version 1.4.5-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_videoio.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_flann.*;
import static org.bytedeco.javacpp.opencv_features2d.*;

public class opencv_saliency extends org.bytedeco.javacpp.presets.opencv_saliency {
    static { Loader.load(); }

// Parsed from <opencv2/saliency.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
 //
 //  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
 //
 //  By downloading, copying, installing or using the software you agree to this license.
 //  If you do not agree to this license, do not download, install,
 //  copy or use the software.
 //
 //
 //                           License Agreement
 //                For Open Source Computer Vision Library
 //
 // Copyright (C) 2014, OpenCV Foundation, all rights reserved.
 // Third party copyrights are property of their respective owners.
 //
 // Redistribution and use in source and binary forms, with or without modification,
 // are permitted provided that the following conditions are met:
 //
 //   * Redistribution's of source code must retain the above copyright notice,
 //     this list of conditions and the following disclaimer.
 //
 //   * Redistribution's in binary form must reproduce the above copyright notice,
 //     this list of conditions and the following disclaimer in the documentation
 //     and/or other materials provided with the distribution.
 //
 //   * The name of the copyright holders may not be used to endorse or promote products
 //     derived from this software without specific prior written permission.
 //
 // This software is provided by the copyright holders and contributors "as is" and
 // any express or implied warranties, including, but not limited to, the implied
 // warranties of merchantability and fitness for a particular purpose are disclaimed.
 // In no event shall the Intel Corporation or contributors be liable for any direct,
 // indirect, incidental, special, exemplary, or consequential damages
 // (including, but not limited to, procurement of substitute goods or services;
 // loss of use, data, or profits; or business interruption) however caused
 // and on any theory of liability, whether in contract, strict liability,
 // or tort (including negligence or otherwise) arising in any way out of
 // the use of this software, even if advised of the possibility of such damage.
 //
 //M*/

// #ifndef __OPENCV_SALIENCY_HPP__
// #define __OPENCV_SALIENCY_HPP__

// #include "opencv2/saliency/saliencyBaseClasses.hpp"
// #include "opencv2/saliency/saliencySpecializedClasses.hpp"

/** \defgroup saliency Saliency API
<p>
Many computer vision applications may benefit from understanding where humans focus given a scene.
Other than cognitively understanding the way human perceive images and scenes, finding salient
regions and objects in the images helps various tasks such as speeding up object detection, object
recognition, object tracking and content-aware image editing.
<p>
About the saliency, there is a rich literature but the development is very fragmented. The principal
purpose of this API is to give a unique interface, a unique framework for use and plug sever
saliency algorithms, also with very different nature and methodology, but they share the same
purpose, organizing algorithms into three main categories:
<p>
**Static Saliency**: algorithms belonging to this category, exploit different image features that
allow to detect salient objects in a non dynamic scenarios.
<p>
**Motion Saliency**: algorithms belonging to this category, are particularly focused to detect
salient objects over time (hence also over frame), then there is a temporal component sealing
cosider that allows to detect "moving" objects as salient, meaning therefore also the more general
sense of detection the changes in the scene.
<p>
**Objectness**: Objectness is usually represented as a value which reflects how likely an image
window covers an object of any category. Algorithms belonging to this category, avoid making
decisions early on, by proposing a small number of category-independent proposals, that are expected
to cover all objects in an image. Being able to perceive objects before identifying them is closely
related to bottom up visual attention (saliency).
<p>
![Saliency diagram](pics/saliency.png)
<p>
To see how API works, try tracker demo:
<https://github.com/fpuja/opencv_contrib/blob/saliencyModuleDevelop/modules/saliency/samples/computeSaliency.cpp>
<p>
\note This API has been designed with PlantUML. If you modify this API please change UML.
<p>
*/

// #endif //__OPENCV_SALIENCY_HPP__


// Parsed from <opencv2/saliency/saliencyBaseClasses.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
 //
 //  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
 //
 //  By downloading, copying, installing or using the software you agree to this license.
 //  If you do not agree to this license, do not download, install,
 //  copy or use the software.
 //
 //
 //                           License Agreement
 //                For Open Source Computer Vision Library
 //
 // Copyright (C) 2014, OpenCV Foundation, all rights reserved.
 // Third party copyrights are property of their respective owners.
 //
 // Redistribution and use in source and binary forms, with or without modification,
 // are permitted provided that the following conditions are met:
 //
 //   * Redistribution's of source code must retain the above copyright notice,
 //     this list of conditions and the following disclaimer.
 //
 //   * Redistribution's in binary form must reproduce the above copyright notice,
 //     this list of conditions and the following disclaimer in the documentation
 //     and/or other materials provided with the distribution.
 //
 //   * The name of the copyright holders may not be used to endorse or promote products
 //     derived from this software without specific prior written permission.
 //
 // This software is provided by the copyright holders and contributors "as is" and
 // any express or implied warranties, including, but not limited to, the implied
 // warranties of merchantability and fitness for a particular purpose are disclaimed.
 // In no event shall the Intel Corporation or contributors be liable for any direct,
 // indirect, incidental, special, exemplary, or consequential damages
 // (including, but not limited to, procurement of substitute goods or services;
 // loss of use, data, or profits; or business interruption) however caused
 // and on any theory of liability, whether in contract, strict liability,
 // or tort (including negligence or otherwise) arising in any way out of
 // the use of this software, even if advised of the possibility of such damage.
 //
 //M*/

// #ifndef __OPENCV_SALIENCY_BASE_CLASSES_HPP__
// #define __OPENCV_SALIENCY_BASE_CLASSES_HPP__

// #include "opencv2/core.hpp"
// #include <opencv2/core/persistence.hpp>
// #include "opencv2/imgproc.hpp"
// #include <iostream>
// #include <sstream>
// #include <complex>

/** \addtogroup saliency
 *  \{
<p>
/************************************ Saliency Base Class ************************************/

@Namespace("cv::saliency") @NoOffset public static class Saliency extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Saliency(Pointer p) { super(p); }

  /**
   * \brief Destructor
   */

  /**
   * \brief Compute the saliency
   * @param image        The image.
   * @param saliencyMap      The computed saliency map.
   * @return true if the saliency map is computed, false otherwise
   */
  public native @Cast("bool") boolean computeSaliency( @ByVal Mat image, @ByVal Mat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal UMat image, @ByVal UMat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal GpuMat image, @ByVal GpuMat saliencyMap );
}

/************************************ Static Saliency Base Class ************************************/
@Namespace("cv::saliency") public static class StaticSaliency extends Saliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StaticSaliency(Pointer p) { super(p); }


    /** \brief This function perform a binary map of given saliency map. This is obtained in this
    way:
    <p>
    In a first step, to improve the definition of interest areas and facilitate identification of
    targets, a segmentation by clustering is performed, using *K-means algorithm*. Then, to gain a
    binary representation of clustered saliency map, since values of the map can vary according to
    the characteristics of frame under analysis, it is not convenient to use a fixed threshold. So,
    *Otsu's algorithm* is used, which assumes that the image to be thresholded contains two classes
    of pixels or bi-modal histograms (e.g. foreground and back-ground pixels); later on, the
    algorithm calculates the optimal threshold separating those two classes, so that their
    intra-class variance is minimal.
    <p>
    @param _saliencyMap the saliency map obtained through one of the specialized algorithms
    @param _binaryMap the binary map
     */
  public native @Cast("bool") boolean computeBinaryMap( @ByVal Mat _saliencyMap, @ByVal Mat _binaryMap );
  public native @Cast("bool") boolean computeBinaryMap( @ByVal UMat _saliencyMap, @ByVal UMat _binaryMap );
  public native @Cast("bool") boolean computeBinaryMap( @ByVal GpuMat _saliencyMap, @ByVal GpuMat _binaryMap );

}

/************************************ Motion Saliency Base Class ************************************/
@Namespace("cv::saliency") public static class MotionSaliency extends Saliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionSaliency(Pointer p) { super(p); }


}

/************************************ Objectness Base Class ************************************/
@Namespace("cv::saliency") public static class Objectness extends Saliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Objectness(Pointer p) { super(p); }


}

/** \} */

 /* namespace saliency */
 /* namespace cv */

// #endif


// Parsed from <opencv2/saliency/saliencySpecializedClasses.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
 //
 //  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
 //
 //  By downloading, copying, installing or using the software you agree to this license.
 //  If you do not agree to this license, do not download, install,
 //  copy or use the software.
 //
 //
 //                           License Agreement
 //                For Open Source Computer Vision Library
 //
 // Copyright (C) 2014, OpenCV Foundation, all rights reserved.
 // Third party copyrights are property of their respective owners.
 //
 // Redistribution and use in source and binary forms, with or without modification,
 // are permitted provided that the following conditions are met:
 //
 //   * Redistribution's of source code must retain the above copyright notice,
 //     this list of conditions and the following disclaimer.
 //
 //   * Redistribution's in binary form must reproduce the above copyright notice,
 //     this list of conditions and the following disclaimer in the documentation
 //     and/or other materials provided with the distribution.
 //
 //   * The name of the copyright holders may not be used to endorse or promote products
 //     derived from this software without specific prior written permission.
 //
 // This software is provided by the copyright holders and contributors "as is" and
 // any express or implied warranties, including, but not limited to, the implied
 // warranties of merchantability and fitness for a particular purpose are disclaimed.
 // In no event shall the Intel Corporation or contributors be liable for any direct,
 // indirect, incidental, special, exemplary, or consequential damages
 // (including, but not limited to, procurement of substitute goods or services;
 // loss of use, data, or profits; or business interruption) however caused
 // and on any theory of liability, whether in contract, strict liability,
 // or tort (including negligence or otherwise) arising in any way out of
 // the use of this software, even if advised of the possibility of such damage.
 //
 //M*/

// #ifndef __OPENCV_SALIENCY_SPECIALIZED_CLASSES_HPP__
// #define __OPENCV_SALIENCY_SPECIALIZED_CLASSES_HPP__

// #include <cstdio>
// #include <string>
// #include <iostream>
// #include <stdint.h>
// #include "saliencyBaseClasses.hpp"
// #include "opencv2/core.hpp"

/** \addtogroup saliency
 *  \{
<p>
/************************************ Specific Static Saliency Specialized Classes ************************************/

/** \brief the Spectral Residual approach from  \cite SR
<p>
Starting from the principle of natural image statistics, this method simulate the behavior of
pre-attentive visual search. The algorithm analyze the log spectrum of each image and obtain the
spectral residual. Then transform the spectral residual to spatial domain to obtain the saliency
map, which suggests the positions of proto-objects.
 */
@Namespace("cv::saliency") @NoOffset public static class StaticSaliencySpectralResidual extends StaticSaliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StaticSaliencySpectralResidual(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public StaticSaliencySpectralResidual(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public StaticSaliencySpectralResidual position(long position) {
        return (StaticSaliencySpectralResidual)super.position(position);
    }


  public StaticSaliencySpectralResidual() { super((Pointer)null); allocate(); }
  private native void allocate();

  public static native @Ptr StaticSaliencySpectralResidual create();

  public native @Cast("bool") boolean computeSaliency( @ByVal Mat image, @ByVal Mat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal UMat image, @ByVal UMat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal GpuMat image, @ByVal GpuMat saliencyMap );

  public native @Override void read( @Const @ByRef FileNode fn );
  public native @Override void write( @ByRef FileStorage fs );

  public native int getImageWidth();
  public native void setImageWidth(int val);
  public native int getImageHeight();
  public native void setImageHeight(int val);

}


/** \brief the Fine Grained Saliency approach from \cite FGS
<p>
This method calculates saliency based on center-surround differences.
High resolution saliency maps are generated in real time by using integral images.
 */
@Namespace("cv::saliency") public static class StaticSaliencyFineGrained extends StaticSaliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public StaticSaliencyFineGrained(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public StaticSaliencyFineGrained(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public StaticSaliencyFineGrained position(long position) {
        return (StaticSaliencyFineGrained)super.position(position);
    }


  public StaticSaliencyFineGrained() { super((Pointer)null); allocate(); }
  private native void allocate();

  public static native @Ptr StaticSaliencyFineGrained create();

  public native @Cast("bool") boolean computeSaliency( @ByVal Mat image, @ByVal Mat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal UMat image, @ByVal UMat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal GpuMat image, @ByVal GpuMat saliencyMap );
}




/************************************ Specific Motion Saliency Specialized Classes ************************************/

/**
 * A Fast Self-tuning Background Subtraction Algorithm.
 *
 * This background subtraction algorithm is inspired to the work of B. Wang and P. Dudek [2]
 * [2]  B. Wang and P. Dudek "A Fast Self-tuning Background Subtraction Algorithm", in proc of IEEE Workshop on Change Detection, 2014
 *
 */
/** \brief the Fast Self-tuning Background Subtraction Algorithm from \cite BinWangApr2014
 */
@Namespace("cv::saliency") @NoOffset public static class MotionSaliencyBinWangApr2014 extends MotionSaliency {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public MotionSaliencyBinWangApr2014(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public MotionSaliencyBinWangApr2014(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public MotionSaliencyBinWangApr2014 position(long position) {
        return (MotionSaliencyBinWangApr2014)super.position(position);
    }

  public MotionSaliencyBinWangApr2014() { super((Pointer)null); allocate(); }
  private native void allocate();

  public static native @Ptr MotionSaliencyBinWangApr2014 create();

  public native @Cast("bool") boolean computeSaliency( @ByVal Mat image, @ByVal Mat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal UMat image, @ByVal UMat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal GpuMat image, @ByVal GpuMat saliencyMap );

  /** \brief This is a utility function that allows to set the correct size (taken from the input image) in the
    corresponding variables that will be used to size the data structures of the algorithm.
    @param W width of input image
    @param H height of input image
  */
  public native void setImagesize( int W, int H );
  /** \brief This function allows the correct initialization of all data structures that will be used by the
    algorithm.
  */
  public native @Cast("bool") boolean init();

  public native int getImageWidth();
  public native void setImageWidth(int val);
  public native int getImageHeight();
  public native void setImageHeight(int val);

}

/************************************ Specific Objectness Specialized Classes ************************************/

/**
 * \brief Objectness algorithms based on [3]
 * [3] Cheng, Ming-Ming, et al. "BING: Binarized normed gradients for objectness estimation at 300fps." IEEE CVPR. 2014.
 */

/** \brief the Binarized normed gradients algorithm from \cite BING
 */
@Namespace("cv::saliency") @NoOffset public static class ObjectnessBING extends Objectness {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ObjectnessBING(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ObjectnessBING(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public ObjectnessBING position(long position) {
        return (ObjectnessBING)super.position(position);
    }


  public ObjectnessBING() { super((Pointer)null); allocate(); }
  private native void allocate();

  public static native @Ptr ObjectnessBING create();

  public native @Cast("bool") boolean computeSaliency( @ByVal Mat image, @ByVal Mat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal UMat image, @ByVal UMat saliencyMap );
  public native @Cast("bool") boolean computeSaliency( @ByVal GpuMat image, @ByVal GpuMat saliencyMap );

  public native void read();
  public native void write();

  /** \brief Return the list of the rectangles' objectness value,
    <p>
    in the same order as the *vector\<Vec4i\> objectnessBoundingBox* returned by the algorithm (in
    computeSaliencyImpl function). The bigger value these scores are, it is more likely to be an
    object window.
     */
  public native @StdVector FloatPointer getobjectnessValues();

  /** \brief This is a utility function that allows to set the correct path from which the algorithm will load
    the trained model.
    @param trainingPath trained model path
     */
  public native void setTrainingPath( @Str BytePointer trainingPath );
  public native void setTrainingPath( @Str String trainingPath );

  /** \brief This is a utility function that allows to set an arbitrary path in which the algorithm will save the
    optional results
    <p>
    (ie writing on file the total number and the list of rectangles returned by objectess, one for
    each row).
    @param resultsDir results' folder path
     */
  public native void setBBResDir( @Str BytePointer resultsDir );
  public native void setBBResDir( @Str String resultsDir );

  public native double getBase();
  public native void setBase(double val);
  public native int getNSS();
  public native void setNSS(int val);
  public native int getW();
  public native void setW(int val);

}

/** \} */


/* namespace saliency */
 /* namespace cv */

// #endif


}
