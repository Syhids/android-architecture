/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.addedittask;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.R;

import static com.example.android.architecture.blueprints.todoapp.util.ActivityUtils.getActivity;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Main UI for the add task screen. Users can enter a task title and description.
 */
public class AddEditTaskView extends ScrollView implements AddEditTaskContract.View {

    private TextView mTitle;

    private TextView mDescription;

    private AddEditTaskContract.Presenter mPresenter;

    private boolean mActive;

    public AddEditTaskView(Context context) {
        super(context);
        init();
    }

    public AddEditTaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.addtask_view_content, this);
        mTitle = (TextView) findViewById(R.id.add_task_title);
        mDescription = (TextView) findViewById(R.id.add_task_description);

        mActive = true;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActive = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mActive = false;
    }

    @Override
    public void showEmptyTaskError() {
        Snackbar.make(mTitle,
                getResources().getString(R.string.empty_task_message), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showTasksList() {
        Activity activity = getActivity(this);
        activity.setResult(Activity.RESULT_OK);
        activity.finish();
    }

    @Override
    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void setDescription(String description) {
        mDescription.setText(description);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void setPresenter(AddEditTaskContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    // TODO: This should be in the view contract
    public String getTitle() {
        return mTitle.getText().toString();
    }

    // TODO: This should be in the view contract
    public String getDescription() {
        return mDescription.getText().toString();
    }
}
