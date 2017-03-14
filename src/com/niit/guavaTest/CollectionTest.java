package com.niit.guavaTest;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Table;
import com.niit.bean.User;

public class CollectionTest {

	public static final ImmutableSet<String> COLOR_NAMES = 
			ImmutableSet.of("red", "orange", "yellow", "green", "blue");
	
	public static void main(String[] args) {
//		Set<Bar> set = new HashSet<>();
//		set.add(new Bar());
//		set.add(new Bar());
//		ImmutableSet.<Bar>builder()
//		.addAll(set)
//		.add(new Bar())
//		.build();
		
		//Multimap<String, V>
		
		//ListMultimap<String,Object> listmap = new 
		
//		ListMultimap<String,Object> listmap = ArrayListMultimap.create();
//		listmap.put("a",1);
//		listmap.put("a",2);
//		listmap.put("a",3);
//		
//		listmap.put("b",4);
//		listmap.put("b",5);
//		listmap.put("b",6);
//		
//		listmap.put("c",3);
//		listmap.put("c",4);
//		listmap.put("c",5);
		
		//Map<String,Collection<Object>> map = listmap.asMap();
		//System.out.println(map);
		
		//Collection<Map.Entry<String,Object>> collection = listmap.entries();
		//System.out.println(collection);
		
		//Set<String>	keyset = listmap.keySet();
		//System.out.println(keyset);
		
		//Multiset<String> ms = listmap.keys();
		//System.out.println(ms);
		
		//Collection<Object> objs =  listmap.values();
		//System.out.println(objs);
		
//		Table<String, String,Object> graph = HashBasedTable.create();
//		graph.put("v1","v1",4);
//		graph.put("v1","v2",4);
//		graph.put("v1","v3",4);
//		
//		graph.put("v2","v1",4);
//		graph.put("v2","v2",4);
//		graph.put("v2","v3",4);
//		
//		graph.put("v3","v1",4);
//		graph.put("v3","v2",4);
//		graph.put("v3","v3",4);
//		
//		
//		System.out.println(graph.get("v2", "v1"));
//		System.out.println(graph.row("v1"));
//		System.out.println(graph.column("v3"));
//		System.out.println(graph.rowKeySet());
		
		User user = new User();
		ClassToInstanceMap<User> numberDefaults = MutableClassToInstanceMap.create();
		numberDefaults.putInstance(User.class, user);
	}
}

class Bar{}

class Foo {
	Set<Bar> bars; 
	Foo(Set<Bar> bars) {
		this.bars = ImmutableSet.copyOf(bars); //defensive copy!
	}
}
