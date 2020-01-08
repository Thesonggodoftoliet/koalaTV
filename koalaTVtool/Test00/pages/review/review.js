const {
  $Toast
} = require('../../dist/base/index');
var app = getApp(); //获取url
Page({
  formSubmit(e) {
    /*  console.log(wx.getStorageSync('user_token'));
        console.log(e.detail.value.pinglun);
        console.log("");
        console.log(wx.getStorageSync('user_bar').barid);
        console.log(wx.getStorageSync('user_bar').hostid);
    */
    wx.request({
      url: 'http://47.106.186.164:8080/koalaTV/api/bar/deployreply',
      data: {
        token: wx.getStorageSync('user_token'),
        content: e.detail.value.pinglun,
        pic: "",
        barid: wx.getStorageSync('user_bar').barid,
        hostid: wx.getStorageSync('user_bar').hostid,
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      method: 'post',
      success: function(res) {
        //        console.log(e)
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))

        if (!res.data.tag) {
          $Toast({
            content: '评论失败！',
            type: 'warning'
          });
        } else {
          $Toast({
            content: '评论成功！',
            type: 'success'
          });
        }
      }
    })
    var that = this;
    that.setData({
      inputValue: ""
    })
    that.onLoad();
  },

  /**
   * 页面的初始数据
   */
  data: {
    disabled: true,
    isTapped: false,
    title: "",
    name: "",
    time: "",
    detail: "",
    listPL: [],
    inputValue: "",
    imgerrs: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    var that = this
    wx.request({

      url: "http://47.106.186.164:8080/koalaTV/api/bar/getreplies", //相应帖子页面
      data: {
        hostid: wx.getStorageSync('user_bar').hostid,
        barid: wx.getStorageSync('user_bar').barid,
        token: wx.getStorageSync('user_token'),
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        //        console.log(res.data)
        //        console.log(wx.getStorageSync('user_bar'));
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        //        console.log(wx.getStorageSync('user_token'))


        that.setData({
          list: wx.getStorageSync('user_bar'), //主贴内容
          listPL: res.data.reply //评论内容
        })
        //        console.log(that.data.listPL);
      },
      fail: function(res) {
        console.log('请求失败');
      }
    })

  },

  serviceSelection() {
    this.setData({
      isTapped: true
    })
  },

  serviceSelection0() {
    this.setData({
      isTapped: false
    })
  },

  reinput(e) {
    var that = this;
    if (e.detail.value != "") {
      that.setData({
        disabled: false
      })
    } else {
      that.setData({
        disabled: true
      })
    }
  },

  imgsuccess: function(e) {
    var that = this;
    that.setData({
      imgerrs: 1
    })
  },

  _deletepost: function(e) {
    //    console.log(wx.getStorageSync('user_token'));
    //    console.log(e.currentTarget.dataset.list);
    //    console.log(e.currentTarget.dataset.list)
    var that = this
    wx.request({
      url: "http://47.106.186.164:8080/koalaTV/api/bar/deletepost", //相应帖子页面
      data: {
        token: wx.getStorageSync('user_token'),
        hostid: e.currentTarget.dataset.list.hostid,
        barid: e.currentTarget.dataset.list.barid,
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        //        console.log(res.data)
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))
        wx.switchTab({
          url: '../home/home',
        })
      },
      fail: function(res) {
        console.log('请求失败');
      }
    })
    that.onLoad();
  },

  _editpost: function(e) {
    //do something
    try {
      wx.setStorageSync('user_list', e.currentTarget.dataset.list)
    } catch (e) {}

    wx.navigateTo({
      url: '../modify/modify',
    })
  },

  _deletereply: function(e) {
    //    console.log(wx.getStorageSync('user_token'));
    //    console.log(e.currentTarget.dataset.list);
    var that = this
    wx.request({
      url: "http://47.106.186.164:8080/koalaTV/api/bar/deletereply", //相应帖子页面
      data: {
        token: wx.getStorageSync('user_token'),
        hostid: e.currentTarget.dataset.list.hostid,
        postid: e.currentTarget.dataset.list.postid,
        barid: e.currentTarget.dataset.list.barid,
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        //        console.log(res.data)
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))

      },
      fail: function(res) {
        console.log('请求失败');
      }
    })
    that.onLoad();
  },

  _editreply: function(e) {
    //do something
    try {
      wx.setStorageSync('user_list', e.currentTarget.dataset.list)
    } catch (e) { }
    console.log(e.currentTarget.dataset.list)
    wx.navigateTo({
      url: '../modifyreview/modifyreview',
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
    var that = this
    wx.request({

      url: "http://47.106.186.164:8080/koalaTV/api/bar/getreplies", //相应帖子页面
      data: {
        hostid: wx.getStorageSync('user_bar').hostid,
        barid: wx.getStorageSync('user_bar').barid,
        token: wx.getStorageSync('user_token'),
      },
      method: 'post',
      header: {
        'content-type': 'application/json'
      },
      success: function(res) {
        //        console.log(res.data)
        //        console.log(wx.getStorageSync('user_bar'));
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))


        that.setData({
          list: wx.getStorageSync('user_bar'), //主贴内容
          listPL: res.data.reply //评论内容
        })
        //        console.log(that.data.listPL);
      },
      fail: function(res) {
        console.log('请求失败');
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

  }
})