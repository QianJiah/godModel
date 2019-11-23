package com.loong.login.response;

import androidx.annotation.NonNull;

/**
 * author: Hao
 * date: 2019/11/4 20:02
 * description:
 */
public class JiaYouUser {

    private String msg;
    private int status;
    private Data date;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setData(Data date) {
        this.date = date;
    }

    public Data getData() {
        return date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @NonNull
    @Override
    public String toString() {
        return "JiaYouUser:[ status:" + status +", data:{ userName:" +date.getUserName() +
                ",createTime:" + date.getCreateTime() + ",updateTime:" + date.getUpdateTime()+ "} ]";
    }
}

class Data {

    private String userName;
    private String createTime;
    private String updateTime;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

}
