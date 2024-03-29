var app = getApp();
Page({

  onPullDownRefresh: function () {
    wx.showNavigationBarLoading(); //在标题栏中显示加载图标
    var that = this
    wx.request({
      url: app.globalData.url + "bar/getposts",
      data: {
        token: (wx.getStorageSync('user_token')),
      },
      headers: {
        'Content-Type': 'application/json'
      },
      method: 'post',
      success: function (res) {
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) { }
        console.log(wx.getStorageSync('user_token'))

        that.setData({
          list: res.data.post,
        })
        //console.log(that.data.list);
      },
      complete: function (res) {
        wx.hideNavigationBarLoading(); //完成停止加载图标
        wx.stopPullDownRefresh();
      }
    })
  },

  img: function() {
    wx.navigateTo({
      url: '../img/img'
    })
  },
  getUserInfo: function(e) {
/*    console.log(e.detail.userInfo)
    wx.request({
      url: app.globalData.url + 'all',
      data: {
        'writer': e.detail.userInfo.nickName,
        'pic': e.detail.userInfo.avatarUrl,
        method: 'POST',
        header: {
          'content-type': 'application/json'
        },
        success: function(res) {
          console.log('submit successs');
        },
        fail: function(res) {
          console.log('submit fail');
        }
      }
    })
*/  },
  formSubmit(e) {
//    console.log(e.detail.value)
    wx.navigateTo({
      url: '../search/search?search=' + e.detail.value.find, //这里是重点！！！页面信息传递，要结合我的上一篇博客看
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
    title: "",
    writer: " ",
    time: "",
    number: "",
    picaddress: "",
    imgerrs: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    list:[],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    /*    var that = this
        wx.request({
          url: "http://47.106.186.164:8080/koalaTV/api/bar/getposts",
          data: {
            token: (wx.getStorageSync('user_token')),
          },
          headers: {
            'Content-Type': 'application/json'
          },
          method:'post',
          success: function (res) {
            //将获取到的json数据，存在名字叫list的这个数组中
            console.log(res.data);
            that.setData(
              {
                list: res.data.data,
                //res代表success函数的事件对，data是固定的，list是数组
              })
          }
        })

    */
  },
  tempData: function() {},
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    var that = this
//    console.log(wx.getStorageSync('user_token'))
    wx.request({
      url: app.globalData.url + "bar/getposts",
      data: {
        token: (wx.getStorageSync('user_token')),
      },
      headers: {
        'Content-Type': 'application/json'
      },
      method: 'post',
      success: function(res) {
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))

        that.setData({
          list: res.data.post,
        })
//        console.log(that.data.list.length);
      },
    })
  },

  savebar: function(e) {
    //    console.log(e.currentTarget.dataset.list);

    try {
      wx.setStorageSync('user_bar', e.currentTarget.dataset.list);
    } catch (e) {
//      console.log("error", e);
    }
  },

  imgerr: function(e) {
    var that = this;
    that.data.imgerrs[e.currentTarget.dataset.index] = 0;
    that.setData({
      imgerrs: that.data.imgerrs
    })
  },

  imgsuccess: function(e) {
 //   console.log(e);
    var that = this;
    that.data.imgerrs[e.currentTarget.dataset.index] = 1;
    that.setData({
      imgerrs: that.data.imgerrs
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */


  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})