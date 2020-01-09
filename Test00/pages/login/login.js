// pages/login/login.js
const app = getApp()
Page({
  /**
   * 页面的初始数据
   */
  data: {
    disabled: false,
    phone: '',
    userpassword: '',
    noinput: false,
    pwdinput: false,
  },
  noinput: function(e) {
    this.setData({
      phone: e.detail.value,
    });
    this.setData({
      noinput: true
    });
    if (this.data.noinput == true && this.data.pwdinput == true) {
      this.setData({
        disabled: false
      });
    }
  },
  pwdinput: function(e) {
    this.setData({
      userpassword: e.detail.value
    });
    this.setData({
      pwdinput: true
    });
    if (this.data.noinput == true && this.data.pwdinput == true) {
      this.setData({
        disabled: false
      });
    }
  },
  formSubmit: function(e) {
    wx.showLoading({
      title: '登录中...',
    })

    this.setData({
      disabled: true
    });

    wx.request({
      url: app.globalData.url + "auth/login",
      data: {
        phone: e.detail.value.phone,
        userpassword: e.detail.value.userpassword
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      method: 'post',
      success: function(res) {
        try {
          wx.setStorageSync('user_token', res.data.token)
        } catch (e) {}
        console.log(wx.getStorageSync('user_token'))


        if (res.statusCode == 200) {
          if (res.data.tag == -2 || res.data.tag == -1) {
            wx.showToast({
              title: '账号或密码错误',
              icon: 'none',
              duration: 2000
            })
          } else if (res.data.tag == 0) {
            wx.showToast({
              title: '服务器错误',
              icon: 'none',
              duration: 2000
            })
          } else {
            wx.showToast({
              title: '登录成功',
              icon: 'success',
              duration: 2000
            })
            setTimeout(function() {
              wx.switchTab({
                url: '../home/home',
              })
            }, 2000)
          }
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    this.setData({
      disabled: false
    });
    var student = wx.getStorageSync('student');
    if (typeof(student) == 'object' && student.phone != '' && student.classid != '') {
      wx.switchTab({
        url: '../home/home.wxml',
      })
    }
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
    if (this.data.phone == '' || this.data.userpassword == '') {
      this.setData({
        disabled: true
      });
    } else {
      this.setData({
        disabled: false
      });
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