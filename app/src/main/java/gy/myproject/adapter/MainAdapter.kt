package gy.myproject.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import gy.myproject.fragment.TaoFragment
import gy.myproject.fragment.UserFragment
import java.util.ArrayList

/**
 * Created by Administrator on 2017/11/11.
 */

class MainAdapter(fm: FragmentManager, type: Int) : FragmentPagerAdapter(fm) {
    internal var list: MutableList<Fragment> = ArrayList()

    init {
        if (type == 1) {
            list.add(TaoFragment())
            //list.add(VehicleFragment())
            list.add(UserFragment())

        }  else {
//            list.add(Transaction1Fragment())
//            list.add(Transaction2Fragment())
        }
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return list.size
    }

}
