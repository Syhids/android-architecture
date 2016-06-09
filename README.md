# TODO-MVP Fragmentless

Project owner: [Manuel Jiménez](https://github.com/Syhids)

### Summary

This sample is an adapted version of [TODO-MVP](https://github.com/googlesamples/android-architecture/tree/todo-mvp) without the use of Fragments. Changes are kept at a minimum to clearly see the difference between both versions.

### Implementation

The MVP View is now a class extending from android.View instead of a Fragment. The view is inserted directly into the activity's [layout](https://github.com/Syhids/android-architecture/blob/todo-mvp-fragmentless/todoapp/app/src/main/res/layout/tasks_act.xml).

### Purpose

This approach could reduce the [lifecycle](https://github.com/xxv/android-lifecycle/raw/master/complete_android_fragment_lifecycle.png) complexity of an activity, since fragments live on top of them and also expose their own lifecycle.
