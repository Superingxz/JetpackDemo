package com.dsl.doctor.network

import com.dsl.base.BaseApiResponse
import com.dsl.doctor.bean.TacticsResponseData
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author dsl-abben
 * on 2020/03/01.
 */
interface DoctorplusApi {
    /**
     * 获取互联网攻略列表
     */
    @GET("app/tactic/getTacticPage.do")
    suspend fun fetchTactisList(@QueryMap map: Map<String, @JvmSuppressWildcards Any>): BaseApiResponse<TacticsResponseData>
}
