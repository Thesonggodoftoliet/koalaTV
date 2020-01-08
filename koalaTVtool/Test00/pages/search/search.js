// pages/search/search.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    keyword: "",
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
    console.log(options)
    var that = this
    wx.request({
      url: 'http://47.106.186.164:8080/koalaTV/api/bar/searchpost',
      data: {
        token: wx.getStorageSync('user_token'),
        keyword: options.search
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))

        //console.log(res)
        that.setData({
          list: res.data.bars
        })
      },
      fail: function(res) {
        console.log('submit fail');
      }
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

  formSubmit(e) {
    //    console.log(e.detail.value)
    wx.navigateTo({
      url: '../search/search?search=' + e.detail.value.find, //这里是重点！！！页面信息传递，要结合我的上一篇博客看
    })
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