package com.knziha.plod.dictionaryBuilder;

import java.util.ArrayList;

import com.knziha.rbtree.RBTNode;

public class ArrayListTree<T extends Comparable<T>> {
	//wonderful!
	
	private final ArrayList<T> data;
	
	
	ArrayListTree(){
		data = new  ArrayList<>();
	}
	
	public int insert(T val){
		if(data.size()==0 || data.get(data.size()-1).compareTo(val)<=0) {
			data.add(data.size(),val);
			return data.size()-1;
		}
		int idx = reduce(val,0,data.size());
		if(val.compareTo(data.get(idx))==0)
		while(idx<data.size()-1 && val.compareTo(data.get(idx+1))==0) {
			idx++;
		}
		data.add(idx,val);
		return idx;
	}
	
	public int reduce(T val,int start,int end) {//via mdict-js
        int len = end-start;
        if (len > 1) {
          len = len >> 1;
          return val.compareTo(data.get(start + len - 1))>0
                    ? reduce(val,start+len,end)
                    : reduce(val,start,start+len);
        } else {
          return start;
        }
    }
	
	public void inOrderDo() {
		for(T dataLet:data) {
			inOrderDo_.dothis(new RBTNode<T>(dataLet,false,null,null,null));
		}
	}
	com.knziha.rbtree.RBTree_duplicative.inOrderDo inOrderDo_;
	public void SetInOrderDo(com.knziha.rbtree.RBTree_duplicative.inOrderDo inOrderDo) {
		inOrderDo_=inOrderDo;
	}
	
	
	
}
