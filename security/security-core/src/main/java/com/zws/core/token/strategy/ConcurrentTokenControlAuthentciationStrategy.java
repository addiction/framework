package com.zws.core.token.strategy;

import com.zws.core.token.IndexNameOauth2Store;
import com.zws.core.token.exception.TokenAuthenticationException;
import org.springframework.security.core.Authentication;

import java.util.Map;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/10/26
 */
public class ConcurrentTokenControlAuthentciationStrategy implements TokenAuthenticationStrategy{

    private IndexNameOauth2Store findByIndexNameOauth2Repository;


    @Override
    public void onAuthentication(Authentication authentication) throws TokenAuthenticationException {
        String userName = authentication.getName() == null ? ""
                : authentication.getName();
        Map<String, String> map = findByIndexNameOauth2Repository.findByIndexNameAndIndexValue(IndexNameOauth2Store.PRINCIPAL_NAME_INDEX_NAME,userName);
    }
}
