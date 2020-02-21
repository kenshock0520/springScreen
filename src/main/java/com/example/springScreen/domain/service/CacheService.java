/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springScreen.domain.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	
	//キャッシュを返却するメソッド。
	@Cacheable(value="applicationCache")
	public Map<String,String> getCacheValue(){
		Map<String,String> result = selectCacheValue();
	    if(result == null){
	        // nullではなく、""を返すと間違ってキャッシュされてしまうので注意
	         return null;
	    }else{
	        return result;
	    }
	}
	
	private Map<String,String> selectCacheValue(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		map.put("key5","value5");
		map.put("key6","value6");
		
		try {
			Thread.sleep(20000);
		}catch(Exception e) {
			System.out.println("error:"+e);
		}
		return map;
	}
	
	public Map<String,String> selectCacheValue3(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("keyUpdate1","Updatevalue1");
		map.put("keUpdatey2","Updatevalue2");
		map.put("keyUpdate3","Updatevalue3");
		map.put("keyUpdate4","Updatevalue4");
		map.put("keyUpdate5","Updatevalue5");
		map.put("keyUpdate6","Updatevalue6");
		
		try {
			Thread.sleep(20000);
		}catch(Exception e) {
			System.out.println("error:"+e);
		}
		return map;
	}
	
	//キャッシュを更新するメソッド
	@CachePut(value = "applicationCache")
	public Map<String,String> setCacheValue(){
		Map<String,String> map = selectCacheValue3();
		return map;
	}
	
//	@Cacheable(value="applicationCache2")
	public Map<String,String> getCacheValue2(){
		Map<String,String> result = selectCacheValue2();
	    if(result == null){
	        // nullではなく、""を返すと間違ってキャッシュされてしまうので注意
	         return null;
	    }else{
	        return result;
	    }
	}
	
	private Map<String,String> selectCacheValue2(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("キー1","値1");
		map.put("キー2","値2");
		map.put("キー3","値3");
		map.put("キー4","値4");
		map.put("キー5","値5");
		map.put("キー6","値6");
		
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			System.out.println("error:"+e);
		}
		return map;
	}
}