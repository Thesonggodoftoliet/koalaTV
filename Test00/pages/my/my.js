var app = getApp();

// pages/my/my.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

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
    wx.request({
      url: app.globalData.url + "bar/getfollow",
      data: {
        token: (wx.getStorageSync('user_token')),
      },
      headers: {
        'Content-Type': 'application/json'
      },
      method: 'post',
      success: function(res) {
        //        console.log(res);
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        that.setData({
          list: res.data.hosts,
        })
        //        console.log(that.data.list);
      }
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
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },

  savehost: function(e) {
//    console.log(e.currentTarget.dataset.list);
    try {
      wx.setStorageSync('user_huaquan', e.currentTarget.dataset.list);
    } catch (e) {
      //console.log("error", e);
    }
//    console.log(wx.getStorageSync('user_huaquan'))
  }
})