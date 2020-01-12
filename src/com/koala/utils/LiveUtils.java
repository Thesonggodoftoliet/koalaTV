package com.koala.utils;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.live.v20180801.LiveClient;
import com.tencentcloudapi.live.v20180801.models.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 直播工具类.
 * @author Marting.Lee
 * 2020/1/2
 */
public class LiveUtils {

    /**
      *调用接口获取正在推流的直播间号.
      * @return java.util.List(java.lang.Integer)
      **/
    public static List<Integer> getLives(){
        List<Integer> roomid = new ArrayList<>();
        try{
            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);
            String params = "{}";
            DescribeLiveStreamOnlineListRequest req = DescribeLiveStreamOnlineListRequest.fromJsonString(params, DescribeLiveStreamOnlineListRequest.class);

            DescribeLiveStreamOnlineListResponse resp = client.DescribeLiveStreamOnlineList(req);
            String object = DescribeLiveStreamOnlineListRequest.toJsonString(resp);
            JSONObject jsonObject =new JSONObject(object);
            JSONArray jsonArray = jsonObject.getJSONArray("OnlineInfo");
            for (int i = 0;i<jsonArray.length();i++){
                roomid.add(Integer.valueOf(jsonArray.getJSONObject(i).getString("StreamName")));
                System.out.println(roomid.get(i));
            }

        } catch (TencentCloudSDKException | JSONException e) {
            System.out.println(e.toString());
        }

        return roomid;
    }

    /**
      *根据房间号返回在线观看人数.
      * @param roomid int
      * @return int
      **/
    public static int getNum(int roomid){
        int num = 0;
        try{

            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"StreamName\":\""+roomid+"\",\"StartTime\":\""+TimeUtils.dateToStr(5)+"\",\"EndTime\":\""+TimeUtils.dateToStr(5)+"\"}";
            DescribeStreamPlayInfoListRequest req = DescribeStreamPlayInfoListRequest.fromJsonString(params, DescribeStreamPlayInfoListRequest.class);

            DescribeStreamPlayInfoListResponse resp = client.DescribeStreamPlayInfoList(req);

            System.out.println(DescribeStreamPlayInfoListRequest.toJsonString(resp));
            JSONObject jsonObject = new JSONObject(DescribeStreamPlayInfoListRequest.toJsonString(resp));
            num = jsonObject.getJSONArray("DataInfoList").getJSONObject(0).getInt("Online");
        } catch (TencentCloudSDKException | JSONException e) {
            System.out.println(e.toString());
        }

        return num;
    }

    public static void forbidRoom(int roomid,String time){

        try{

            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"AppName\":\"33772\",\"DomainName\":\"33772.livepush.myqcloud.com\",\"StreamName\":\""+roomid+"\",\"ResumeTime\":\""+time+"\"}";
            ForbidLiveStreamRequest req = ForbidLiveStreamRequest.fromJsonString(params, ForbidLiveStreamRequest.class);

            ForbidLiveStreamResponse resp = client.ForbidLiveStream(req);

            System.out.println(ForbidLiveStreamRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }

    public static void resumeRoom(int roomid){
        try{

            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"AppName\":\"33772\",\"DomainName\":\"33772.livepush.myqcloud.com\",\"StreamName\":\""+roomid+"\"}";
            ResumeLiveStreamRequest req = ResumeLiveStreamRequest.fromJsonString(params, ResumeLiveStreamRequest.class);

            ResumeLiveStreamResponse resp = client.ResumeLiveStream(req);

            System.out.println(ResumeLiveStreamRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
