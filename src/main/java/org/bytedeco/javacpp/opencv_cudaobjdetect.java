// Targeted by JavaCPP version 1.4.4: DO NOT EDIT THIS FILE

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
import static org.bytedeco.javacpp.opencv_calib3d.*;
import static org.bytedeco.javacpp.opencv_objdetect.*;
import static org.bytedeco.javacpp.opencv_video.*;
import static org.bytedeco.javacpp.opencv_cudaarithm.*;
import static org.bytedeco.javacpp.opencv_cudafilters.*;
import static org.bytedeco.javacpp.opencv_cudaimgproc.*;
import static org.bytedeco.javacpp.opencv_cudawarping.*;

public class opencv_cudaobjdetect extends org.bytedeco.javacpp.presets.opencv_cudaobjdetect {
    static { Loader.load(); }

// Parsed from <opencv2/cudaobjdetect.hpp>

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
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
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

// #ifndef OPENCV_CUDAOBJDETECT_HPP
// #define OPENCV_CUDAOBJDETECT_HPP

// #ifndef __cplusplus
// #endif

// #include "opencv2/core/cuda.hpp"
// #include "opencv2/objdetect.hpp"

/**
  \addtogroup cuda
  \{
      \defgroup cudaobjdetect Object Detection
  \}
 */

/** \addtogroup cudaobjdetect
 *  \{ */

//
// HOG (Histogram-of-Oriented-Gradients) Descriptor and Object Detector
//

/** \brief The class implements Histogram of Oriented Gradients (\cite Dalal2005) object detector.
<p>
\note
    -   An example applying the HOG descriptor for people detection can be found at
        opencv_source_code/samples/cpp/peopledetect.cpp
    -   A CUDA example applying the HOG descriptor for people detection can be found at
        opencv_source_code/samples/gpu/hog.cpp
    -   (Python) An example applying the HOG descriptor for people detection can be found at
        opencv_source_code/samples/python/peopledetect.py
 */
@Namespace("cv::cuda") public static class HOG extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HOG(Pointer p) { super(p); }

    /** \brief Creates the HOG descriptor and detector.
    <p>
    @param win_size Detection window size. Align to block size and block stride.
    @param block_size Block size in pixels. Align to cell size. Only (16,16) is supported for now.
    @param block_stride Block stride. It must be a multiple of cell size.
    @param cell_size Cell size. Only (8, 8) is supported for now.
    @param nbins Number of bins. Only 9 bins per cell are supported for now.
     */
    public static native @Ptr HOG create(@ByVal(nullValue = "cv::Size(64, 128)") Size win_size,
                               @ByVal(nullValue = "cv::Size(16, 16)") Size block_size,
                               @ByVal(nullValue = "cv::Size(8, 8)") Size block_stride,
                               @ByVal(nullValue = "cv::Size(8, 8)") Size cell_size,
                               int nbins/*=9*/);
    public static native @Ptr HOG create();

    /** Gaussian smoothing window parameter. */
    public native void setWinSigma(double win_sigma);
    public native double getWinSigma();

    /** L2-Hys normalization method shrinkage. */
    public native void setL2HysThreshold(double threshold_L2hys);
    public native double getL2HysThreshold();

    /** Flag to specify whether the gamma correction preprocessing is required or not. */
    public native void setGammaCorrection(@Cast("bool") boolean gamma_correction);
    public native @Cast("bool") boolean getGammaCorrection();

    /** Maximum number of detection window increases. */
    public native void setNumLevels(int nlevels);
    public native int getNumLevels();

    /** Threshold for the distance between features and SVM classifying plane.
     *  Usually it is 0 and should be specified in the detector coefficients (as the last free
     *  coefficient). But if the free coefficient is omitted (which is allowed), you can specify it
     *  manually here. */
    public native void setHitThreshold(double hit_threshold);
    public native double getHitThreshold();

    /** Window stride. It must be a multiple of block stride. */
    public native void setWinStride(@ByVal Size win_stride);
    public native @ByVal Size getWinStride();

    /** Coefficient of the detection window increase. */
    public native void setScaleFactor(double scale0);
    public native double getScaleFactor();

    /** Coefficient to regulate the similarity threshold. When detected, some
     *  objects can be covered by many rectangles. 0 means not to perform grouping.
     *  See groupRectangles. */
    public native void setGroupThreshold(int group_threshold);
    public native int getGroupThreshold();

    /** Descriptor storage format:
     *    - **DESCR_FORMAT_ROW_BY_ROW** - Row-major order.
     *    - **DESCR_FORMAT_COL_BY_COL** - Column-major order. */
    public native void setDescriptorFormat(@Cast("cv::HOGDescriptor::DescriptorStorageFormat") int descr_format);
    public native @Cast("cv::HOGDescriptor::DescriptorStorageFormat") int getDescriptorFormat();

    /** \brief Returns the number of coefficients required for the classification.
     */
    public native @Cast("size_t") long getDescriptorSize();

    /** \brief Returns the block histogram size.
     */
    public native @Cast("size_t") long getBlockHistogramSize();

    /** \brief Sets coefficients for the linear SVM classifier.
     */
    public native void setSVMDetector(@ByVal Mat detector);
    public native void setSVMDetector(@ByVal UMat detector);
    public native void setSVMDetector(@ByVal GpuMat detector);

    /** \brief Returns coefficients of the classifier trained for people detection.
     */
    public native @ByVal Mat getDefaultPeopleDetector();

    /** \brief Performs object detection without a multi-scale window.
    <p>
    @param img Source image. CV_8UC1 and CV_8UC4 types are supported for now.
    @param found_locations Left-top corner points of detected objects boundaries.
    @param confidences Optional output array for confidences.
     */
    public native void detect(@ByVal Mat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoublePointer confidences/*=NULL*/);
    public native void detect(@ByVal Mat img,
                            @ByRef PointVector found_locations);
    public native void detect(@ByVal Mat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detect(@ByVal Mat img,
                            @ByRef PointVector found_locations,
                            @StdVector double[] confidences/*=NULL*/);
    public native void detect(@ByVal UMat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoublePointer confidences/*=NULL*/);
    public native void detect(@ByVal UMat img,
                            @ByRef PointVector found_locations);
    public native void detect(@ByVal UMat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detect(@ByVal UMat img,
                            @ByRef PointVector found_locations,
                            @StdVector double[] confidences/*=NULL*/);
    public native void detect(@ByVal GpuMat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoublePointer confidences/*=NULL*/);
    public native void detect(@ByVal GpuMat img,
                            @ByRef PointVector found_locations);
    public native void detect(@ByVal GpuMat img,
                            @ByRef PointVector found_locations,
                            @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detect(@ByVal GpuMat img,
                            @ByRef PointVector found_locations,
                            @StdVector double[] confidences/*=NULL*/);

    /** \brief Performs object detection with a multi-scale window.
    <p>
    @param img Source image. See cuda::HOGDescriptor::detect for type limitations.
    @param found_locations Detected objects boundaries.
    @param confidences Optional output array for confidences.
     */
    public native void detectMultiScale(@ByVal Mat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoublePointer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal Mat img,
                                      @ByRef RectVector found_locations);
    public native void detectMultiScale(@ByVal Mat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal Mat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector double[] confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal UMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoublePointer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal UMat img,
                                      @ByRef RectVector found_locations);
    public native void detectMultiScale(@ByVal UMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal UMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector double[] confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal GpuMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoublePointer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal GpuMat img,
                                      @ByRef RectVector found_locations);
    public native void detectMultiScale(@ByVal GpuMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector DoubleBuffer confidences/*=NULL*/);
    public native void detectMultiScale(@ByVal GpuMat img,
                                      @ByRef RectVector found_locations,
                                      @StdVector double[] confidences/*=NULL*/);

    /** \brief Returns block descriptors computed for the whole image.
    <p>
    @param img Source image. See cuda::HOGDescriptor::detect for type limitations.
    @param descriptors 2D array of descriptors.
    @param stream CUDA stream.
     */
    public native void compute(@ByVal Mat img,
                             @ByVal Mat descriptors,
                             @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal Mat img,
                             @ByVal Mat descriptors);
    public native void compute(@ByVal UMat img,
                             @ByVal UMat descriptors,
                             @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal UMat img,
                             @ByVal UMat descriptors);
    public native void compute(@ByVal GpuMat img,
                             @ByVal GpuMat descriptors,
                             @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void compute(@ByVal GpuMat img,
                             @ByVal GpuMat descriptors);
}

//
// CascadeClassifier
//

/** \brief Cascade classifier class used for object detection. Supports HAAR and LBP cascades. :
<p>
\note
   -   A cascade classifier example can be found at
        opencv_source_code/samples/gpu/cascadeclassifier.cpp
    -   A Nvidea API specific cascade classifier example can be found at
        opencv_source_code/samples/gpu/cascadeclassifier_nvidia_api.cpp
 */
@Name("cv::cuda::CascadeClassifier") public static class CudaCascadeClassifier extends Algorithm {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CudaCascadeClassifier(Pointer p) { super(p); }

    /** \brief Loads the classifier from a file. Cascade type is detected automatically by constructor parameter.
    <p>
    @param filename Name of the file from which the classifier is loaded. Only the old haar classifier
    (trained by the haar training application) and NVIDIA's nvbin are supported for HAAR and only new
    type of OpenCV XML cascade supported for LBP. The working haar models can be found at opencv_folder/data/haarcascades_cuda/
     */
    public static native @Ptr CudaCascadeClassifier create(@Str BytePointer filename);
    public static native @Ptr CudaCascadeClassifier create(@Str String filename);
    /** \overload
     */
    public static native @Ptr CudaCascadeClassifier create(@Const @ByRef FileStorage file);

    /** Maximum possible object size. Objects larger than that are ignored. Used for
     *  second signature and supported only for LBP cascades. */
    public native void setMaxObjectSize(@ByVal Size maxObjectSize);
    public native @ByVal Size getMaxObjectSize();

    /** Minimum possible object size. Objects smaller than that are ignored. */
    public native void setMinObjectSize(@ByVal Size minSize);
    public native @ByVal Size getMinObjectSize();

    /** Parameter specifying how much the image size is reduced at each image scale. */
    public native void setScaleFactor(double scaleFactor);
    public native double getScaleFactor();

    /** Parameter specifying how many neighbors each candidate rectangle should have
     *  to retain it. */
    public native void setMinNeighbors(int minNeighbors);
    public native int getMinNeighbors();

    public native void setFindLargestObject(@Cast("bool") boolean findLargestObject);
    public native @Cast("bool") boolean getFindLargestObject();

    public native void setMaxNumObjects(int maxNumObjects);
    public native int getMaxNumObjects();

    public native @ByVal Size getClassifierSize();

    /** \brief Detects objects of different sizes in the input image.
    <p>
    @param image Matrix of type CV_8U containing an image where objects should be detected.
    @param objects Buffer to store detected objects (rectangles).
    @param stream CUDA stream.
    <p>
    To get final array of detected objects use CascadeClassifier::convert method.
    <p>
    <pre>{@code
        Ptr<cuda::CascadeClassifier> cascade_gpu = cuda::CascadeClassifier::create(...);

        Mat image_cpu = imread(...)
        GpuMat image_gpu(image_cpu);

        GpuMat objbuf;
        cascade_gpu->detectMultiScale(image_gpu, objbuf);

        std::vector<Rect> faces;
        cascade_gpu->convert(objbuf, faces);

        for(int i = 0; i < detections_num; ++i)
           cv::rectangle(image_cpu, faces[i], Scalar(255));

        imshow("Faces", image_cpu);
    }</pre>
    <p>
    \sa CascadeClassifier::detectMultiScale
     */
    public native void detectMultiScale(@ByVal Mat image,
                                      @ByVal Mat objects,
                                      @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void detectMultiScale(@ByVal Mat image,
                                      @ByVal Mat objects);
    public native void detectMultiScale(@ByVal UMat image,
                                      @ByVal UMat objects,
                                      @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void detectMultiScale(@ByVal UMat image,
                                      @ByVal UMat objects);
    public native void detectMultiScale(@ByVal GpuMat image,
                                      @ByVal GpuMat objects,
                                      @ByRef(nullValue = "cv::cuda::Stream::Null()") Stream stream);
    public native void detectMultiScale(@ByVal GpuMat image,
                                      @ByVal GpuMat objects);

    /** \brief Converts objects array from internal representation to standard vector.
    <p>
    @param gpu_objects Objects array in internal representation.
    @param objects Resulting array.
     */
    public native void convert(@ByVal Mat gpu_objects,
                             @ByRef RectVector objects);
    public native void convert(@ByVal UMat gpu_objects,
                             @ByRef RectVector objects);
    public native void convert(@ByVal GpuMat gpu_objects,
                             @ByRef RectVector objects);
}

/** \} */

 // namespace cv { namespace cuda {

// #endif /* OPENCV_CUDAOBJDETECT_HPP */


}
