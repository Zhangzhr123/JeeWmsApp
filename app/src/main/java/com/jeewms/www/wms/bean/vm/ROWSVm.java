package com.jeewms.www.wms.bean.vm;

/**
 * Created by 13799 on 2018/6/3.
 */

public class ROWSVm {
        private NoticeId om_notice_id;
        private RecordState userdata;
        private NoticeId zhong_wen_qch;

        public NoticeId getOm_notice_id() {
            return om_notice_id;
        }

        public void setOm_notice_id(NoticeId om_notice_id) {
            this.om_notice_id = om_notice_id;
        }

        public RecordState getUserdata() {
            return userdata;
        }

        public void setUserdata(RecordState userdata) {
            this.userdata = userdata;
        }

        public NoticeId getZhong_wen_qch() {
            return zhong_wen_qch;
        }

        public void setZhong_wen_qch(NoticeId zhong_wen_qch) {
            this.zhong_wen_qch = zhong_wen_qch;
        }



}
