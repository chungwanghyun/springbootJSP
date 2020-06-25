package com.example.stpringbootjsp.service.user;

import java.nio.file.Paths;
import java.util.List;

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
import com.example.stpringbootjsp.model.user.UserInputModel;
import com.example.stpringbootjsp.model.user.UserList;
import com.example.stpringbootjsp.model.user.UserListModel;
import com.example.stpringbootjsp.service.file.FileService;
import com.example.stpringbootjsp.util.Util;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	FileService fileService;

	@Transactional
	public void insertUser(UserInputModel userInputModelParam) throws Exception {
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
		if(result == 1) {
			// ファイル保存
			if(userInputModelParam.getUserFileTemp1() != null && userInputModelParam.getUserFileTemp1().length() > 0) {
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

			if(userInputModelParam.getUserFileTemp2() != null && userInputModelParam.getUserFileTemp2().length() > 0) {
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
	public Page<UserList> list(UserListModel userListModel, Pageable pageable) throws Exception {
		int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;

        userListModel.setMinCount(startItem);
        userListModel.setMaxCount(pageSize);
        // リスト取得
        List<UserList> list =  userMapper.listUser(userListModel);
        // リスト件数取得
        long listCount = userMapper.listUserCount(userListModel);
        // ページリスト設定
        Page<UserList> userPage = new PageImpl<UserList>(list, PageRequest.of(currentPage, pageSize), listCount);

		return userPage;
	}

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
