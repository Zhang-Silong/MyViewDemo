package com.example.myviewtest.ui.fragment

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myviewtest.R
import com.example.myviewtest.view.propertyanimator.*
import com.example.myviewtest.view.test.utils.dp

val provinceList = listOf("北京市", "上海市", "天津市", "重庆市","河北省", "山西省", "辽宁省",
    "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "香港特别行政区", "北京市", "上海市", "天津市", "重庆市",
    "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "澳门特别行政区")
class ContentFragment : Fragment() {

    private var viewId: Int? = null

    companion object {
        fun newInstance(id: Int): ContentFragment {
            val contentFragment = ContentFragment()
            val args = Bundle()
            args.putInt("view_id", id)
            contentFragment.arguments = args
            return contentFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewId = arguments?.getInt("view_id")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewId?.let { inflater.inflate(it, container, false) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*when (viewId) {
            R.layout.circle_view -> {
                val circleView = view.findViewById<CircleView>(R.id.circleView)
                ObjectAnimator.ofFloat(circleView, "radius", 150.dp).apply {
                    startDelay = 1000
                    start()
                }
            }
            R.layout.camera_view -> {
                val cameraView = view.findViewById<CameraAnimatorView>(R.id.cameraView)
                ObjectAnimator.ofFloat(cameraView, "topFlip", 60f).apply {
                    startDelay = 1000
                    duration = 1500
                    start()
                }
            }
            else -> {}
        }*/
    }

    override fun onResume() {
        super.onResume()
        when (viewId) {
            R.layout.circle_view -> {
                val circleView = view?.findViewById<CircleView>(R.id.circleView)
                ObjectAnimator.ofFloat(circleView, "radius", 150.dp).apply {
                    startDelay = 1000
                    start()
                }
            }
            R.layout.camera_view -> {
                val cameraView = view?.findViewById<CameraAnimatorView>(R.id.cameraView)
                val bottomFlipAnimator = ObjectAnimator.ofFloat(cameraView, "bottomFlip", 60f).apply {
                    startDelay = 1000
                    duration = 1000
                }
                val flipRotationAnimator = ObjectAnimator.ofFloat(cameraView, "flipRotation", 270f).apply {
                    startDelay = 200
                    duration = 1000
                }
                val topFlipAnimator = ObjectAnimator.ofFloat(cameraView, "topFlip", -60f).apply {
                    startDelay = 200
                    duration = 1000
                }
                AnimatorSet().apply {
                    playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
                    start()
                }
            }
            R.layout.point_view -> {
                val pointView = view?.findViewById<PointView>(R.id.pointView)
                ObjectAnimator.ofObject(pointView, "point", PointEvaluator(), PointF(100.dp, 200.dp)).apply {
                    startDelay = 1000
                    duration = 2000
                    start()
                }
            }
            R.layout.province_view -> {
                val provinceView = view?.findViewById<ProvinceView>(R.id.provinceView)
                ObjectAnimator.ofObject(provinceView, "province", ProvinceEvaluator(), "澳门特别行政区").apply {
                    startDelay = 1000
                    duration = 10000
                    start()
                }
            }
            else -> {}
        }
    }


}