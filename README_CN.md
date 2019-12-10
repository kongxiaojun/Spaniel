# Spaniel

> 一款简单轻巧的Android应用程序权限申请框架。

高效的申请权限，在内部我们使用了反射调用隐藏API与添加新Fragment的方式确保权限高效稳定的申请。使用者无需关心Activity或Fragment onRequestPermissionsResult方法。

## Download

添加以下代码到最外层build.gradle:

```css
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

添加引用

```css
    dependencies {
            implementation 'com.github.kongxiaojun:Spaniel:1.0.0'
    }
```

## 使用方法

```java
                SpaPermissions.getInstance().requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(MainActivity.this, "onGranted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(MainActivity.this, "onDenied", Toast.LENGTH_SHORT).show();
                    }
                });
```

# 参考

[https://github.com/anthonycr/Grant](https://github.com/anthonycr/Grant)

[https://github.com/tbruyelle/RxPermissions](https://github.com/tbruyelle/RxPermissions)

# License

```
   Copyright 2019 kongxiaojun

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
