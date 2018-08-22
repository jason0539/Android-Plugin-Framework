package com.example.pluginmain;

import com.alibaba.android.arouter.launcher.ARouter;
import com.limpoxe.fairy.core.FairyGlobal;
import com.limpoxe.fairy.core.PluginApplication;
import com.tencent.bugly.crashreport.CrashReport;
//import com.tencent.bugly.crashreport.CrashReport;
//import com.umeng.analytics.MobclickAgent;

public class MyApplication extends PluginApplication {
	@Override
	public void onCreate() {
		super.onCreate();

        //bugly SDK
        CrashReport.initCrashReport(getApplicationContext(), "c38ae3f8a6", true);

        //UMENG SDK
        //MobclickAgent.setDebugMode(true);
        //MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);

        FairyGlobal.setLogEnable(true);
        FairyGlobal.setLocalHtmlenable(true);
        FairyGlobal.setLoadingResId(R.layout.loading);
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        //Just for test custom Mapping Processor
        FairyGlobal.registStubMappingProcessor(new TestCoustProcessor());
	}
}
