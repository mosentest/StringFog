
- 加密前：
```
String a = "This is a string!";
```

- 加密后：
```
String a = StringFog.decrypt("ABCDEFGHIJKLMN");
```

- 运行时：
```
decrypt: "ABCDEFGHIJKLMN" => "This is a string!"
```

### 混淆
StringFog和混淆完全不冲突，也不需要配置反混淆，实际上StringFog配上混淆效果会更好！

### 使用
由于开发了gradle插件，所以在集成时非常简单，不会影响到打包的配置。插件已经上传到jcenter，直接引用依赖就可以。

##### 1、在根目录build.gradle中引入插件依赖。
```
buildscript {
    repositories {
        maven { url 'https://jitpack.io' }
    }
    dependencies {
        ...
        classpath 'com.github.moz1q1.StringFog:gradle-plugin:m1.0.2'
        // 选用加解密算法库，默认实现了xor和aes-cbc两种简单算法，也可以使用自己的加解密库。
        classpath 'com.github.moz1q1.StringFog:xor:m1.0.2'
    }
}
```

##### 2、在app或lib的build.gradle中配置插件。
```
apply plugin: 'stringfog'

stringfog {
    // 这是加解密key，可以自由定义。
    key 'Hello World'
    // 开关
    enable true
    // 加解密库的实现类路径，需和上面配置的加解密算法库一致。
    implementation 'com.github.megatronking.stringfog.xor.StringFogImpl'
    // 指定需加密的代码包路径，可配置多个，未指定将默认全部加密。
    fogPackages = ['com.xxx.xxx']
}
```

##### 3、在app或lib的build.gradle中引入加解密库依赖。
```
dependencies {
      ...
      // 这里要和上面选用的加解密算法库一致，用于运行时解密。
      implementation 'com.github.moz1q1.StringFog:xor:m1.0.2'
}
```

### 扩展

#### 注解反加密
如果开发者有不需要自动加密的类，可以使用注解StringFogIgnore来忽略：
```
@StringFogIgnore
public class Test {
    ...
}
```
#### 自定义加解密算法实现
实现IStringFog接口，参考stringfog-ext目录下面的两种算法实现。注意某些算法在不同平台上会有差异，可能出现在运行时无法正确解密的问题。
```
public final class StringFogImpl implements IStringFog {

    @Override
    public String encrypt(String data, String key) {
        // 自定义加密
    }

    @Override
    public String decrypt(String data, String key) {
        // 自定义解密
    }

    @Override
    public boolean overflow(String data, String key) {
        // 最大字符串长度为65536，这里要校验加密后是否出现长度溢出，如果溢出将不进行加密。
        // 这里可以控制符合某些条件的字符串不加密。
    }

}
