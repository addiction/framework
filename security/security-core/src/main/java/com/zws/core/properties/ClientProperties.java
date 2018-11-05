package com.zws.core.properties;

import com.zws.core.support.SecurityConstants;
import lombok.Data;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/11/5
 */
@Data
public class ClientProperties {

    private String loginProcessingUrl = SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL;

    private String passwordTokenUrl;
}