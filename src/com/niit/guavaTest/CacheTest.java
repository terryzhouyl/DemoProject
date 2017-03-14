package com.niit.guavaTest;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;

public class CacheTest {

	
	
	public static void main(String[] args) {
		
		LoadingCache<String,Object> graphs = 
			CacheBuilder.newBuilder()
			.maximumSize(1000)
			.build(
				new CacheLoader<String,Object>() {
					@Override
					public Object load(String arg0) throws Exception {
						 //return createExpensiveGraph(key); 
						return null;
					}
				}
			);
		
		Cache<String,Object> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.build();
		try {
			cache.get("1", new Callable<Object>() {
				@Override
				public Object call() throws Exception {
					return null;
				}
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		
		
		LoadingCache<String,Object> graphs2 = 
		CacheBuilder.newBuilder()
				.maximumWeight(100000)
				.weigher(new Weigher<String,Object>() {
					@Override
					public int weigh(String s, Object o) {
						return 0;
					}
				})
				.build(
					new CacheLoader<String,Object>() {
						@Override
						public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
							
							return super.reload(key, oldValue);
						}

						@Override
						public Object load(String arg0) throws Exception {
							
							return null;
						}
						
						
						
					});
			    
		
		RemovalListener<String,Object> removalListener 
		= new RemovalListener<String, Object>() {
			@Override
			public void onRemoval(RemovalNotification<String, Object> removal) {
				removal.getKey();
				removal.getCause();
			}
		};
		
		
		LoadingCache<String,Object> graphs3 = 
				CacheBuilder.newBuilder()
						.maximumSize(1000)
						.refreshAfterWrite(1, TimeUnit.MINUTES)
						.build(new CacheLoader<String,Object>() {

							@Override
							public ListenableFuture<Object> reload(String key, Object oldValue) throws Exception {
								String a = "1";
								if(a.equals("1")) {  // 
									return null;
								}
								else {  // asynchronous!
									ListenableFutureTask<Object> task = ListenableFutureTask.create(new Callable<Object>() {

										@Override
										public Object call() throws Exception {
											return null;
										}
									});
									//executor.execute(task);
									return task;
								}
							}
							@Override
							public Object load(String arg0) throws Exception {
								return null;
							}
						});
		
	}
}
