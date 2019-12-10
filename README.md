# Spaniel

> A simple and lightweight Android permission application framework.

[中文文档](https://github.com/kongxiaojun/Spaniel/blob/master/README_CN.md)

Efficiently obtain permissions. Internally, we obtain authorization through reflection calls to hidden APIs or newly created fragments. Frees the caller from having to care about the Activity / Fragment's onRequestPermissionsResult method.

## Download

Add it in your root build.gradle at the end of repositories:

```css
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

Add the dependency

```css
    dependencies {
            implementation 'com.github.kongxiaojun:Spaniel:1.0.0'
    }
```

## Usage

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

# References

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
