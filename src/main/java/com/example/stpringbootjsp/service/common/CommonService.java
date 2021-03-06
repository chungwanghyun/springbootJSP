package com.example.stpringbootjsp.service.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.stpringbootjsp.constant.Constant;

@Service
public class CommonService {

	public List<Integer> pageNumber(int totoalPage, int currentPage) throws Exception {

		List<Integer> result = new ArrayList<Integer>();
        // ページ数取得
 		int totalPages = totoalPage;
 		if (totalPages > 0) {
 			// 表示するページ番号設定
 			if(totalPages <= Constant.MAX_PAGE_10) {
 				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                 .boxed()
	                 .collect(Collectors.toList());
 				result = pageNumbers;
 			} else {
 				int start = currentPage + 1 -(Constant.MAX_PAGE_10/2);
 				int end = start + Constant.MAX_PAGE_10 - 1;

 				if (start < 1) {
 	                start = 1;
 	                end = start + Constant.MAX_PAGE_10 - 1;
 	            }

 				if(end > totalPages) {
 					end = totalPages;
 					start = end - Constant.MAX_PAGE_10 + 1;

 				}
 				List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
 		                 .boxed()
 		                 .collect(Collectors.toList());
 	 				result = pageNumbers;
 			}
         }
		return result;
	}

}
