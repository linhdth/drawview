package com.videodownloader.video.videoplayer.videosaver.drawview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.shape
import com.videodownloader.video.videoplayer.videosaver.drawview.MainActivity.Companion.size
import com.videodownloader.video.videoplayer.videosaver.drawview.databinding.FragmentInputBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {
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

    lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.groupShape.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId will contain the ID of the selected RadioButton
            when (checkedId) {
                R.id.Circle -> {
                    shape = Shape.Circle
                    (activity as MainActivity).drawView()
                }

                R.id.Triangle -> {
                    shape = Shape.Triangle
                    (activity as MainActivity).drawView()

                }

                R.id.Rectangle -> {
                    shape = Shape.Rectangle
                    (activity as MainActivity).drawView()

                }

                R.id.Pentagon -> {
                    shape = Shape.Pentagon
                    (activity as MainActivity).drawView()

                }

                R.id.Hexagon -> {
                    shape = Shape.Hexagon
                    (activity as MainActivity).drawView()

                }

                R.id.Octagon -> {
                    shape = Shape.Octagon
                    (activity as MainActivity).drawView()

                }

                R.id.Star -> {
                    shape = Shape.Star
                    (activity as MainActivity).drawView()

                }

                R.id.Heart -> {
                    shape = Shape.Heart
                    (activity as MainActivity).drawView()

                }

                else -> {
                    shape = Shape.Circle
                    (activity as MainActivity).drawView()

                }
            }
        })
        binding.groupSize.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId will contain the ID of the selected RadioButton
            when (checkedId) {
                R.id.small -> {
                    size = Size.Small
                    (activity as MainActivity).drawView()

                }

                R.id.medium -> {
                    size = Size.Medium
                    (activity as MainActivity).drawView()


                }

                R.id.big -> {
                    size = Size.Big
                    (activity as MainActivity).drawView()

                }

                else -> {
                    size = Size.Small
                    (activity as MainActivity).drawView()

                }
            }
        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InputFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}