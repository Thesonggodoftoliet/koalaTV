package com.koala.service.impl;

import com.koala.service.Tencent;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.live.v20180801.LiveClient;
import com.tencentcloudapi.live.v20180801.models.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 集合腾讯云直播接口.
 * @author Marting.Lee
 * 2020/1/3
 */
public class TencentImpl implements Tencent {
    Date now = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
      *获取一个月内带宽数据.
      * @return java.lang.String
      **/
    @Override
    public String getBandwidth() {
        try{
            Calendar ca = Calendar.getInstance();
            ca.setTime(now);
            ca.add(Calendar.MONTH,-1);
            String today = simpleDateFormat.format(now);
            Date old = ca.getTime();
            String thatday = simpleDateFormat.format(old);
            System.out.println("thatday "+thatday);

            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"StartTime\":\""+thatday+"\",\"EndTime\":\""+today+"\",\"Granularity\":1440}";
            DescribeBillBandwidthAndFluxListRequest req = DescribeBillBandwidthAndFluxListRequest.fromJsonString(params, DescribeBillBandwidthAndFluxListRequest.class);

            DescribeBillBandwidthAndFluxListResponse resp = client.DescribeBillBandwidthAndFluxList(req);

            System.out.println(DescribeBillBandwidthAndFluxListRequest.toJsonString(resp));
            return DescribeBillBandwidthAndFluxListRequest.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    /**
      *获取省份数据.
      * @return java.lang.String
      **/
    @Override
    public String getProvince() {
        try{
            Date old = new Date(now.getTime()-10*60*1000);
            String today = simpleDateFormat.format(old);
            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"StartTime\":\""+today+"\",\"EndTime\":\""+today+"\"}";
            DescribeGroupProIspPlayInfoListRequest req = DescribeGroupProIspPlayInfoListRequest.fromJsonString(params, DescribeGroupProIspPlayInfoListRequest.class);

            DescribeGroupProIspPlayInfoListResponse resp = client.DescribeGroupProIspPlayInfoList(req);

            System.out.println("得到的回复"+DescribeGroupProIspPlayInfoListRequest.toJsonString(resp));
            return DescribeGroupProIspPlayInfoListRequest.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    /**
      *获取实时在线人数.
      * @return java.lang.String
      **/
    @Override
    public String getOnline() {
        try{
            Credential cred = new Credential("AKID73kDTT2nAIBqHWOEnSwBAvSkmbDZqsgF", "d27yaw73lERVLwIOFsFMGyRfdLp35xe5");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("live.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            LiveClient client = new LiveClient(cred, "ap-guangzhou", clientProfile);

            String params = "{}";
            DescribeLiveDomainPlayInfoListRequest req = DescribeLiveDomainPlayInfoListRequest.fromJsonString(params, DescribeLiveDomainPlayInfoListRequest.class);

            DescribeLiveDomainPlayInfoListResponse resp = client.DescribeLiveDomainPlayInfoList(req);

            System.out.println(DescribeLiveDomainPlayInfoListRequest.toJsonString(resp));
            return DescribeLiveDomainPlayInfoListRequest.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
