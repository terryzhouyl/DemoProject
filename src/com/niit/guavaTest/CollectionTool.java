package com.niit.guavaTest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;
import com.niit.bean.User;

public class CollectionTool {

	public static void main(String[] args) {
		
		List<String> list = Lists.newArrayList("a2","b","cwe");
		//List<String> list2=  Lists.newArrayListWithCapacity(100);
		
		//Iterator<String> it = list.iterator();
		//System.out.println(Iterators.contains(it, "a"));
		//Iterator<List<String>> its = Iterators.partition(it, 3);
//		User user = new User();
//		user.setOpenid("123");
//		List<User> list2 = Lists.newArrayList(user);
//		ImmutableMap<String,User> stringsByIndex =
//		Maps.uniqueIndex(list2.iterator(), new Function<User,String>() {
//			@Override
//			public String apply(User user) {
//				return user.getOpenid();
//			}
//		});
//		System.out.println(stringsByIndex);
//		Map<String,Integer> left = ImmutableMap.of("a",1,"b",2,"c",3);
//		Map<String,Integer> right = ImmutableMap.of("b",2,"c",3,"d",4);
//		MapDifference<String,Integer> diff = Maps.difference(left, right);
//		System.out.println(diff.entriesInCommon());
//		System.out.println(diff.entriesOnlyOnLeft());
//		System.out.println(diff.entriesOnlyOnRight());
//		System.out.println(diff.entriesDiffering());
		
//		ImmutableSet<String> digits = ImmutableSet.of("one","two","three","four","five","six","seven","eight","nine");
//		Function<String,Integer>  lengthFunction = new 
//				Function<String, Integer>() {
//					@Override
//					public Integer apply(String string) {
//						return string.length();
//					}
//		};
//		ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);
//		System.out.println(digitsByLength);
		
//		ArrayListMultimap<String,Integer> multimap = ArrayListMultimap.create();
//		ArrayListMultimap<String,Integer> multimap2 = ArrayListMultimap.create();
//		multimap.putAll("b",Ints.asList(2,4,6));
//		multimap.putAll("a",Ints.asList(4,2,1));
//		multimap.putAll("c",Ints.asList(2,5,3));
//		ArrayListMultimap<Integer,String> inverse = Multimaps.invertFrom(multimap,multimap2);
		
		Map<String,Integer> map = ImmutableMap.of("a",1,"b",1,"c",2);
		SetMultimap<String,Integer> multimap = Multimaps.forMap(map);
		System.out.println(multimap);
		
		//Multimap inverse = Multimaps.invertFrom(multimap, HashMultimap.create());
		
		
	}
}
