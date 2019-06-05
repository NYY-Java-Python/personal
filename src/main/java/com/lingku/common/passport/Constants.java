package com.lingku.common.passport;

/**
 *
 * @author xiaolong.tian
 * @date 2018/2/6
 * @description
 */
public interface Constants {
    interface DBStatus{
        //登录
        Integer TRUE = 1;
        Integer FALSE = 0;
    }


    interface Reg{
        //手机
        String MOBILE = "^1[3456789][0-9]{9}$";
        //15位 旧身份证。
        String IDENTITY_NO = "(^\\d{17}[\\dX]$)|(^\\d{15}$)";
    }

    interface Status{
        Integer NORMAL = 0;
        Integer DELETE = 1;
        Integer DELETEROLE = 2;
    }

    interface RedisKey{
        String OPENID_PREFIX = "distribution_openid:";
    }

    String TOKEN = "Authorization";

    String MENUANDMETHOD = ":";
}
