package com.yorkyu.loadingdialogfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yorkyu.loadingdialogfragment.R;

/**
 * @author: YorkYu
 * @version: V1.0
 * @project: LoadingDialogFragment
 * @package: com.yorkyu.loadingdialogfragment.fragment
 * @description: description
 * @date: 2017/4/11
 * @time: 16:45
 */
public class TestFragment extends Fragment {
    public static TestFragment newInstance() {

        TestFragment fragment = new TestFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.test_fragment, container, false);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
