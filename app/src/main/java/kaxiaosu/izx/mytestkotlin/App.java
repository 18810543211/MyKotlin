package kaxiaosu.izx.mytestkotlin;

import android.app.Application;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.dolit.siteparser.Module;

/**
 * Created by haohaitao on 17/7/6.
 */

public class App extends Application {

    private static App instance;
    private Module parseModule = new Module();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    private void initParseModule() {
        String packagePath = this.getCacheDir() + "/script.spp";
        String key = "7c5f041288e839998581e12deb6609e9";
        try {
            InputStream is = getResources().getAssets().open("script.spp");
            FileOutputStream fos = new FileOutputStream(new File(packagePath));
            byte[] buffer = new byte[1024];
            while (true) {
                int len = is.read(buffer);
                if (len == -1) {
                    break;
                }
                fos.write(buffer, 0, len);
            }
            is.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        parseModule.setLogLevel(Module.PSL_DEBUG);
        int ret = parseModule.init(packagePath, key, this.getApplicationContext());
        if (ret != 0) {
            Toast.makeText(getBaseContext(), "初始化失败，返回值：" + ret, Toast.LENGTH_SHORT).show();
        }
    }

    public Module getParseModule() {
        return parseModule;
    }

    @Override
    public void onTerminate() {
        instance = null;
        if (parseModule != null) {
            parseModule.uninit();
        }
        super.onTerminate();
    }

    public static App getInstance() {
        return instance;
    }
}