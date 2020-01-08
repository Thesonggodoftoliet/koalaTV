// pages/my/my.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    hostlist: [],
    title: "",
    writer: " ",
    time: "",
    number: "",
    picaddress: "",
    imgerrs: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
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
    that.setData({
      hostlist: wx.getStorageSync('user_huaquan')
    })
    //    console.log(that.data.hostlist)
    wx.request({
      url: "http://47.106.186.164:8080/koalaTV/api/bar/getallbar",
      data: {
        token: (wx.getStorageSync('user_token')),
        hostid: that.data.hostlist.hostid
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
        //        console.log(that.data.list);
      },
    })
  },

  imgerr: function(e) {
    var that = this;
    that.data.imgerrs[e.currentTarget.dataset.index] = 0;
    that.setData({
      imgerrs: that.data.imgerrs
    })
  },

  imgsuccess: function(e) {
    //console.log(e);
    var that = this;
    that.data.imgerrs[e.currentTarget.dataset.index] = 1;
    that.setData({
      imgerrs: that.data.imgerrs
    })
  },

  topost: function(e) {
    console.log(e.currentTarget.dataset)
    try {
      wx.setStorageSync('user_hostidforpost', e.currentTarget.dataset.list.hostid),
      wx.setStorageSync('user_nameforpost', e.currentTarget.dataset.list.username)
    } catch (e) {}
    wx.switchTab({
      url: '../post/post',
    })
  },

  savebar: function (e) {
    //    console.log(e.currentTarget.dataset.list);

    try {
      wx.setStorageSync('user_bar', e.currentTarget.dataset.list);
    } catch (e) {
      //      console.log("error", e);
    }
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

  }
})