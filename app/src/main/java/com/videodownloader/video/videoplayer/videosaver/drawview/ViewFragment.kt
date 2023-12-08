package com.videodownloader.video.videoplayer.videosaver.drawview

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.big
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.medium
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.size
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.small
import com.videodownloader.video.videoplayer.videosaver.drawview.databinding.FragmentViewBinding
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentViewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val container = binding.linearLayout
        drawView()

    }

    fun drawView() {
        val size = getSize()
        val color = getColor()
        val viewDraw = getViewDraw(size, color)
        binding.linearLayout.removeAllViews()
        binding.linearLayout.addView(viewDraw)
    }

    private fun getViewDraw(size: Int, color: Int): View? {

        when (MainActivity.shape) {
            Shape.Circle -> {
                val circleView = CircleView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                circleView.layoutParams = layoutParams
                circleView.setCircleColor(color)

                return circleView
            }

            Shape.Triangle -> {
                val triangleView = TriangleView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                triangleView.layoutParams = layoutParams
                triangleView.setTriangleColor(color)
                return triangleView

            }

            Shape.Rectangle -> {
                val rectangleView = RectangleView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                rectangleView.layoutParams = layoutParams
                rectangleView.setRectangleColor(color)
                return rectangleView

            }

            Shape.Pentagon -> {
                val pentagonView = PentagonView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                pentagonView.layoutParams = layoutParams
                pentagonView.setPentagonColor(color)
                return pentagonView

            }

            Shape.Hexagon -> {
                val hexagonView = HexagonView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                hexagonView.layoutParams = layoutParams
                hexagonView.setHexagonColor(color)
                return hexagonView

            }

            Shape.Octagon -> {
                val octagonView = OctagonView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                octagonView.layoutParams = layoutParams
                octagonView.setOctagonColor(color)
                return octagonView

            }

            Shape.Star -> {
                val starView = StarView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                starView.layoutParams = layoutParams
                starView.setStarColor(color)
                return starView
            }

            Shape.Heart -> {
                val heartView = HeartView(requireContext())
                val layoutParams = ViewGroup.LayoutParams(size, size)
                heartView.layoutParams = layoutParams
                heartView.setHeartColor(color)
                return heartView

            }
        }

        return  null

    }

    fun getColor(): Int {
        val random = Random.Default
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }


    private fun getSize(): Int {

        when (size) {
            Size.Small -> return small
            Size.Medium -> return medium
            Size.Big -> return big
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}