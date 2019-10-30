package com.loong.login.response;

import java.util.List;

/**
 * author: Hao
 * date: 2019/10/10 11:33
 * description:
 */
public class LoginResult {
    /**
     * 登录正确的回复
     * {"data":{"admin":false,"chapterTops":[],"collectIds":[],"email":"","icon":"",
     * "id":21972,"nickname":"13413611836","password":"","publicName":"13413611836",
     * "token":"","type":0,"nickname":"13413611836"},
     * "errorCode":0,"errorMsg":""
     * }
     */

    private String email;
    private String icon;
    private int id;
    private String password;
    private String token;
    private int type;
    private String nickname;
    private List<?> chapterTops;
    private List<?> collectIds;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<?> getChapterTops() {
        return chapterTops;
    }

    public void setChapterTops(List<?> chapterTops) {
        this.chapterTops = chapterTops;
    }

    public List<?> getCollectIds() {
        return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
        this.collectIds = collectIds;
    }

    @Override
    public String toString() {
        return "LoginResult[ email=" + email + ",nickname=" + nickname + ",password=" + password + "" +
                ",token=" + token + ",id=" + id + ",type=" + type + "]";
    }
}
