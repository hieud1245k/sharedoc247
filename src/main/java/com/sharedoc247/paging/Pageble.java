package com.sharedoc247.paging;

import com.sharedoc247.sort.Sorter;

public interface Pageble {
	
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
