# **SafeKeyboard**
Android自定义安全软键盘

预览<br>

* 1 . `AndroidMenifest.xml` 文件中添加 `"android:windowSoftInputMode="stateAlwaysHidden">"`, 兼容低版本系统, 重新进入软件界面系统软键盘自动弹出的问题。

* 2 . 解决特殊键盘图标在不同屏幕上显示变形问题, 不需要手动设置图片显示时与按键边界的边距。
* 3 . `SafeKeyboard` 提供接口设置特殊按键的自定义图片
## **更新**
### 一、 2019/01/08

*  重新赋值每个按键对应的keycode
