 var app = getApp() //获取url
 Page({
   data: {
     img_arr: [],
     titleValue: "",
     content: "",
     hostid: "",
     disabled: "true",
     pic: [],
     textvalue: "",
   },

   formSubmit: function(e) {
     this.upload(e)
   },
   /**
    * 问题：
    *一张图片上传
    */
   upload: function(e) {
     var that = this;
     /*
          console.log(that.data.hostid);
          console.log(e.detail.value.content);
          console.log(that.data.img_arr[0]);
          console.log(wx.getStorageSync('user_token'));
     */
     if (that.data.img_arr[0] == null) //当用户不发图时
     {
       wx.request({
         header: {
           'content-type': 'application/json'
         },
         url: app.globalData.url + "bar/deploypost",
         data: {
           token: wx.getStorageSync('user_token'),
           hostid: wx.getStorageSync('user_hostidforpost'),
           content: e.detail.value.content,
           pic: "",
         },
         method: 'post',
         success: function(res) {
           console.log(res);
           try {
             wx.setStorageSync('user_token', res.data.token)
           } catch (e) {}

           console.log(wx.getStorageSync('user_token'));
           if (res) {
             wx.showToast({
               title: '发送话圈成功！',
               duration: 3000
             });
             setTimeout(() => {
               wx.switchTab({
                 url: '../../pages/home/home',
               })
             }, 1000);
           }
           that.setData({
             textvalue: "",
           })
         },
         fail: function(res) {
           wx.showToast({
             title: '发送话圈失败！',
             icon: 'none',
             duration: 3000
           });
           that.setData({
             textvalue: "",
           })
         }
       })
     } else {
       //       console.log(that.data.img_arr[0])
       //       console.log(that.data.pic)
       wx.request({
         header: {
           'content-type': 'application/json'
         },
         url: app.globalData.url + "bar/deploypost",
         data: {
           token: wx.getStorageSync('user_token'),
           hostid: wx.getStorageSync('user_hostidforpost'),
           content: e.detail.value.content,
           pic: that.data.pic,
         },
         method: 'post',
         success: function(res) {
           console.log(res);
           try {
             wx.setStorageSync('user_token', res.data.token)
           } catch (e) {}

           //           console.log(wx.getStorageSync('user_token'));
           if (res.data.tag == 1) {
             wx.showToast({
               title: '发送话圈成功！',
               duration: 3000
             });
             setTimeout(() => {
               wx.switchTab({
                 url: '../../pages/home/home',
               })
             }, 1000);
             that.setData({
               textvalue: "",
               img_arr: null,
             })
           } else {
             wx.showToast({
               title: '发送话圈失败！',
               icon: 'none',
               duration: 3000
             });
             that.setData({
               textvalue: "",
               img_arr: null,
             })
           }
         },
         fail: function(res) {
           console.log("连接服务器失败");
         }
       })
     }
   },
   upimg: function() {
     var that = this;
     wx.chooseImage({ //选择图片
       count: 1, //一张图片
       sizeType: ['original', 'compressed'],
       success: function(res) {
         console.log(res.tempFilePaths)
         that.setData({
           img_arr: res.tempFilePaths,
         })
         wx.uploadFile({
           url: app.globalData.url + "manage/uploadpic",
           filePath: that.data.img_arr[0],
           name: 'pic',
           header: {
             'content-type': 'application/json'
           },
           data: {
             contentType: false, //传输内容
             processData: false,
           },
           method: 'post',
           success(res) {
             that.setData({
               pic: JSON.parse(res.data).url,
             })
           },
         })
       }
     })
   },

   check(e) {
     var that = this;
     if (e.detail.value != "") {
       that.setData({
         disabled: false,
       })
     } else {
       that.setData({
         disabled: true,
       })
     }
   },

   onLoad: function() {
     console.log(wx.getStorageSync('user_nameforpost'))
    var that = this;
    that.setData({
      titleValue:wx.getStorageSync('user_nameforpost')
    })
   },
 })