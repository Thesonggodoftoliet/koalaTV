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
    list: [],
    disabled:"false"
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
//  console.log(wx.getStorageSync('user_list'))
    var that = this;
    that.setData({
      list: wx.getStorageSync('user_list')
    })

    that.setData({
      titleValue: that.data.list.title,
      textvalue: that.data.list.content,
      img_arr: that.data.list.pic
    })

    var that = this
  },

  formSubmit: function(e) {
    var that = this;
    console.log(e.detail.value.content)
    wx.request({
      header: {
        'content-type': 'application/json'
      },
      url: "http://47.106.186.164:8080/koalaTV/api/bar/modifypost",
      data: {
        token: wx.getStorageSync('user_token'),
        hostid: that.data.list.hostid,
        barid: that.data.list.barid,
        content: e.detail.value.content,
        pic:"",
      },
      method: 'post',
      success: function(res) {
        console.log(res);
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}

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
  },

})