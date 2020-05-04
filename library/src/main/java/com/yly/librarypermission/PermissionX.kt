package com.yly.librarypermission

import androidx.fragment.app.FragmentActivity

/*
 * 项目名： PermissionX
 * 包 名：  com.yly.librarypermission
 * 文件名： PermissionX
 * 创建者： YLY
 * 时 间：  2020-05-04 14:29
 * 描 述：  TODO
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity,vararg permissions: String,
                callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }
}