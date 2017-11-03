package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by 林其望 on 2017/11/3.
 */
public class TokenCache {
    public static final String TOKEN_PREFIX="token_";
    private static org.slf4j.Logger logger= LoggerFactory.getLogger(TokenCache.class);

    private static LoadingCache<String,String> localcache= CacheBuilder.newBuilder()
            .initialCapacity(1000)
            .maximumSize(10000)
            .expireAfterAccess(12, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });
    public static void setKey(String key,String value){
        localcache.put(key,value);
    }
    public static String getKey(String key){
        String value=null;
        try {
            value=localcache.get(key);
            if ("null".equals(value)){
                return null;
            }
        } catch (ExecutionException e) {
            logger.error("localCache  get error ",e);
        }
        return value;
    }

}
