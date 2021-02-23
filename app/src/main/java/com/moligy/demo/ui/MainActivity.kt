package com.moligy.demo.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dsl.base.activity.BaseActivity
import com.dsl.constant.RouterActivityPath
import com.moligy.demo.R
import com.moligy.demo.databinding.ActivityMainBinding
import com.moligy.demo.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = RouterActivityPath.PAGER_MAIN)
class MainActivity : BaseActivity<HomeViewModel, ActivityMainBinding>() {
    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?) {
        jump.setOnClickListener {
            when (it?.id) {
                R.id.jump -> {
                    ARouter.getInstance().build(RouterActivityPath.PAGER_DOCTOR_MAIN)
                        .navigation()
                }
            }
        }
    }
}
