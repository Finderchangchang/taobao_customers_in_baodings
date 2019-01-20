package gy.myproject.callback

import java.io.Serializable

/**
 * Created by Administrator on 2017/11/16.
 */
/**
 * Created by Finder丶畅畅 on 2017/5/13 00:04
 * QQ群481606175
 */
class LzyResponse<T> : Serializable {

    var code: Int = 0
    var msg: String = ""
    var url: String = ""
    var data: T? = null
}
