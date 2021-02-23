package com.dsl.doctor.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dsl.base.ext.request
import com.dsl.base.network.getService
import com.dsl.base.viewmodel.BaseViewModel
import com.dsl.doctor.bean.FetchTacticsRequestBean
import com.dsl.doctor.bean.TacticsResponseData
import com.dsl.doctor.network.DoctorplusApi
import com.dsl.state.ResultState
import com.dsl.util.BeanUtil

/**
 * @author dsl-abben
 * on 2020/03/02.
 */
class HomepageViewModel : BaseViewModel() {

    /**
     * 互联网攻略文章
     */
    var nextPageNum = 0L
    var fetchTactics = MutableLiveData<ResultState<TacticsResponseData>>()

    /**
     * 第一页
     */
    fun refreshTactics() {
        fetchTacticsData(1L)
    }

    /**
     * 下一页
     */
    fun nextTactics() {
        fetchTacticsData(nextPageNum + 1)
    }

    private fun fetchTacticsData(next: Long) {
        request(
            {
                getService(DoctorplusApi::class.java).fetchTactisList(
                    BeanUtil.beanToMap(
                        FetchTacticsRequestBean(next.toString())
                    )
                )
            },
            fetchTactics
        )
    }
}
