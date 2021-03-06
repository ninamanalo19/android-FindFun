package com.ninaestoye.findfun.network

import com.ninaestoye.findfun.utils.Constants
import okhttp3.Interceptor
import okhttp3.Response

class FFInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
//            .addHeader("app-id", Constants.APP_ID)
            .build();
        return chain.proceed(request);
    }
}