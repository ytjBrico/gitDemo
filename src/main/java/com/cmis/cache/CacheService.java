package com.cmis.cache;

import com.cmis.entity.User;

public interface CacheService {
	User cacheResult(String id, String cacheName);
	Object cachePut(String id, Object o, String cacheName);
}
