package com.videodownloader.video.videoplayer.videosaver.drawview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.videodownloader.video.videoplayer.videosaver.drawview.databinding.ActivityMainBinding

enum class Shape { Circle, Triangle, Rectangle, Pentagon, Hexagon, Octagon, Star, Heart }
enum class Size { Small, Medium, Big }
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        var shape: Shape = Shape.Circle
        var size: Size = Size.Medium
        var small = 200
        var medium = 500
        var big = 800
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //init view bindding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = FragmentAdapterSelect(this)
        binding.viewpager.offscreenPageLimit = 3
        binding.viewpager.isUserInputEnabled = false
        binding.viewpager.adapter = adapter
        binding.viewpager.currentItem = 0

        binding.tabInput.setOnClickListener {
            binding.viewpager.currentItem = 0
        }

        binding.tabView.setOnClickListener {
            binding.viewpager.currentItem = 1
        }
    }

    fun drawView() {
        (supportFragmentManager.fragments[1] as ViewFragment).drawView()
    }


}

class FragmentAdapterSelect(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2 // Number of fragments

    override fun createFragment(position: Int): Fragment {
        val curFragment = when (position) {
            0 -> InputFragment()
            1 -> ViewFragment()
            else -> InputFragment()
        }

        return curFragment
    }
}