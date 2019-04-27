## GOS

对象存储。目前仅支持JPG图片存储。

### 简易用法

#### 上传图片

```
POST 10.214.213.13:9966/image
key:image
value:图片对象

返回
{
  Code：int
  Msg：string
  data: string //data包含的是对应文件存储的key，获取文件需要用到这个key
}
```

#### 下载图片

```
GET 10.214.213.13:9966/image/{GosKey}
其中GosKey就是上传后返回的key
```

 