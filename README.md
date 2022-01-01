# SampleApp
Demonstrates font not found with robolectric `4.7.3` while targetting sdk 31. 

While accessing font using `ResourcesCompat.getFont(context, R.font.font_name)` tests fail with `Resources$NotFoundException` error. 

**But if you annotate the test with `@Config(sdk = [30])` it passes.**

# How to run

Clone this project and run `./gradlew :app:testDebugUnitTest --info`. Or after cloning, open the project in AndroidStudio and search for `MainActivityTest` and run it. 

# StackTrace
```
Font resource ID #0x7f080000 could not be retrieved.
android.content.res.Resources$NotFoundException: Font resource ID #0x7f080000 could not be retrieved.
	at androidx.core.content.res.ResourcesCompat.loadFont(ResourcesCompat.java:537)
	at androidx.core.content.res.ResourcesCompat.getFont(ResourcesCompat.java:372)
	at com.example.sample_lib.CommonFont.getFont(CommonFont.kt:7)
	at com.example.sampleapp.MainActivity.updateTextView(MainActivity.kt:18)
	at com.example.sampleapp.MainActivity.onCreate(MainActivity.kt:12)
	at android.app.Activity.performCreate(Activity.java:8051)
	at android.app.Activity.performCreate(Activity.java:8031)
	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1329)
	at org.robolectric.android.internal.RoboMonitoringInstrumentation.callActivityOnCreate(RoboMonitoringInstrumentation.java:284)
	at org.robolectric.android.controller.ActivityController.lambda$create$0(ActivityController.java:113)
	at org.robolectric.shadows.ShadowPausedLooper.runPaused(ShadowPausedLooper.java:203)
	at org.robolectric.android.controller.ActivityController.create(ActivityController.java:113)
	at org.robolectric.android.controller.ActivityController.create(ActivityController.java:118)
	at org.robolectric.android.internal.RoboMonitoringInstrumentation.startActivitySyncInternal(RoboMonitoringInstrumentation.java:103)
	at org.robolectric.android.internal.LocalActivityInvoker.startActivity(LocalActivityInvoker.java:33)
	at org.robolectric.android.internal.LocalActivityInvoker.startActivity(LocalActivityInvoker.java:38)
	at androidx.test.core.app.ActivityScenario.launchInternal(ActivityScenario.java:265)
	at androidx.test.core.app.ActivityScenario.launch(ActivityScenario.java:195)
	at com.example.sampleapp.MainActivityTest.testTextView(MainActivityTest.kt:18)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:591)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$0(SandboxTestRunner.java:274)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:88)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:834)
	Suppressed: org.robolectric.android.internal.AndroidTestEnvironment$UnExecutedRunnablesException: Main looper has queued unexecuted runnables. This might be the cause of the test failure. You might need a shadowOf(Looper.getMainLooper()).idle() call.
```

# Workaround

Annotate tests with `@Config(sdk = [30])` fixes the issue
