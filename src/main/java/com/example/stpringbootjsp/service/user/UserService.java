package com.example.stpringbootjsp.service.user;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.stpringbootjsp.mapper.user.UserMapper;
import com.example.stpringbootjsp.model.user.User;
import com.example.stpringbootjsp.model.user.UserInputModel;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;

	@Transactional
	public int insertUser(UserInputModel userInputModelParam) throws Exception {
		// オブジェクトコピー
		User user = new User();
        BeanUtils.copyProperties(userInputModelParam, user);

		Date currentDate = new Date();
//		user.setUsersSeq(loginParam.getSeq());
//		user.setcDatetime(currentDate);
//		user.setcUser(loginParam.getFirstNm() + loginParam.getLastNm());
//		user.setuDatetime(currentDate);
//		user.setuUser(loginParam.getFirstNm() + loginParam.getLastNm());
        // 登録
        return userMapper.insertUser(user);
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
