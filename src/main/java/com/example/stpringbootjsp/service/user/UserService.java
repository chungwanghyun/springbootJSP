package com.example.stpringbootjsp.service.user;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stpringbootjsp.constant.Constant;
import com.example.stpringbootjsp.mapper.user.UserMapper;
import com.example.stpringbootjsp.model.user.User;
import com.example.stpringbootjsp.model.user.UserInputForm;
import com.example.stpringbootjsp.model.user.UserList;
import com.example.stpringbootjsp.model.user.UserListForm;
import com.example.stpringbootjsp.service.file.FileService;
import com.example.stpringbootjsp.util.Util;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	FileService fileService;

	@Transactional
	public void insertUser(UserInputForm userInputModelParam) throws Exception {
		// オブジェクトコピー
		User user = new User();
		BeanUtils.copyProperties(userInputModelParam, user);
		// Dateデータ型変換
		user.setBirthday(Util.getDateFromString(Constant.DATE_FORMAT_1, userInputModelParam.getBirthday()));
		// Array->String変換
		user.setHobby(String.join(",", userInputModelParam.getHobby()));
		user.setCUser(user.getId());
		user.setUUser(user.getId());

		// 登録
		int result = userMapper.insertUser(user);

		// 登録OK
		if (result == 1) {
			// ファイル保存
			if (userInputModelParam.getUserFileTemp1() != null && userInputModelParam.getUserFileTemp1().length() > 0) {
				// ディレクトリー作成
				fileService.makeDir(Paths.get(Constant.USER_PATH));

				// Tempからファイルを移動させる
				fileService.move(Paths.get(Constant.USER_TEMP_PATH + userInputModelParam.getUserFileTemp1()),
						Paths.get(Constant.USER_PATH + userInputModelParam.getUserFileTemp1()));
			} else {
				// Temp用ディレクトリー作成
				fileService.makeDir(Paths.get(Constant.USER_TEMP_PATH));

				// ファイルを保存する
				if (!userInputModelParam.getUserFile1().isEmpty()) {
					fileService.save(userInputModelParam.getUserFile1(), Paths.get(Constant.USER_TEMP_PATH));
				}
			}

			if (userInputModelParam.getUserFileTemp2() != null && userInputModelParam.getUserFileTemp2().length() > 0) {
				// Temp用ディレクトリー作成
				fileService.makeDir(Paths.get(Constant.USER_PATH));

				// Tempからファイルを移動させる
				fileService.move(Paths.get(Constant.USER_TEMP_PATH + userInputModelParam.getUserFileTemp2()),
						Paths.get(Constant.USER_PATH + userInputModelParam.getUserFileTemp2()));
			} else {
				// ディレクトリー作成
				fileService.makeDir(Paths.get(Constant.USER_TEMP_PATH));

				// ファイルを保存する
				if (!userInputModelParam.getUserFile2().isEmpty()) {
					fileService.save(userInputModelParam.getUserFile2(), Paths.get(Constant.USER_TEMP_PATH));
				}
			}
		}
	}

	@Transactional
	public Page<UserList> list(UserListForm userListForm, Optional<Integer> page, Optional<Integer> size)
			throws Exception {
		// ページ情報チェック
		int tmepCurrentPage = page.orElse(Constant.PAGE_COUNT_1);
		int tempPageSize = size.orElse(Constant.PAGE_COUNT_2);
		// ページ情報設定
		Pageable pageable = PageRequest.of(tmepCurrentPage - 1, tempPageSize);
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startCount = currentPage * pageSize;

		//        // ソート情報チェック
		//        String sortTemp = sort.orElse("id ASC");

		// オブジェクトコピー
		UserList userList = new UserList();
		BeanUtils.copyProperties(userListForm, userList);

		// offset設定
		userList.setOffsetCount(startCount);
		// limit設定
		userList.setLimitCount(pageSize);
		//        // ソート設定
		//        userList.setSort(sortTemp);

		// リスト取得
		List<UserList> list = userMapper.listUser(userList);
		// リスト件数取得
		long listCount = userMapper.listUserCount(userList);
		// ページリスト設定
		Page<UserList> userListPage = new PageImpl<UserList>(list, PageRequest.of(currentPage, pageSize), listCount);

		return userListPage;
	}

	//	public List<Integer> pageNumber(Page<UserList> userList) throws Exception {
	//		List<Integer> result = new ArrayList<Integer>();
	//        // ページ数取得
	// 		int totalPages = userList.getTotalPages();
	// 		if (totalPages > 0) {
	// 			// 表示するページ番号設定
	// 			if(totalPages <= Constant.MAX_PAGE_10) {
	// 				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	//	                 .boxed()
	//	                 .collect(Collectors.toList());
	// 				result = pageNumbers;
	// 			} else {
	// 				int start = userList.getPageable().getPageNumber() + 1 -(Constant.MAX_PAGE_10/2);
	// 				int end = start + Constant.MAX_PAGE_10 - 1;
	//
	// 				if (start < 1) {
	// 	                start = 1;
	// 	                end = start + Constant.MAX_PAGE_10 - 1;
	// 	            }
	//
	// 				if(end > totalPages) {
	// 					end = totalPages;
	// 					start = end - Constant.MAX_PAGE_10 + 1;
	//
	// 				}
	// 				List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
	// 		                 .boxed()
	// 		                 .collect(Collectors.toList());
	// 	 				result = pageNumbers;
	// 			}
	//         }
	//		return result;
	//	}

	//	@Transactional
	//	public List<TrackingListResult> list(TrackingListParam trackingListParam) throws Exception {
	//		// リスト結果
	//        List<TrackingListResult> trackingListResult = new ArrayList<TrackingListResult>();
	//
	//		// trackingデートリスト取得
	//        List<TrackingList> trackingDateList = trackingMapper.selectTrackingDateList(trackingListParam);
	//        for (TrackingList trackingDate : trackingDateList) {
	//            TrackingListResult trackingList = new TrackingListResult();
	//            trackingList.setDate(trackingDate.getcDatetime());
	//            // trackingリスト取得
	//            trackingListParam.setDate(trackingDate.getcDatetime());
	//            trackingList.setTrackingList(trackingMapper.selectTrackingList(trackingListParam));
	//            // リスト設定
	//            trackingListResult.add(trackingList);
	//        }
	//		return trackingListResult;
	//	}

}
