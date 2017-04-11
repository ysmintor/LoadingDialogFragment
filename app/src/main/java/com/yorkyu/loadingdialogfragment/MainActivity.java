package com.yorkyu.loadingdialogfragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;
import com.yorkyu.loadingdialogfragment.fragment.TestDialog;
import com.yorkyu.loadingdialogfragment.fragment.TestFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private FloatingActionMenu mFloatingActionMenu;
    private com.github.clans.fab.FloatingActionButton mLoadingFab;
    private com.github.clans.fab.FloatingActionButton mEmptyFab;
    private com.github.clans.fab.FloatingActionButton mErrorFab;
    private com.github.clans.fab.FloatingActionButton mNoNetworkFab;
    private com.github.clans.fab.FloatingActionButton mContentFab;
    private Button mBtnAdd;
    private Button mBtnRemove;
    private TextView mTv;
    private android.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mFloatingActionMenu = (FloatingActionMenu) findViewById(R.id.main_fab_menu);
        mLoadingFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.main_fab_loading);
        mEmptyFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.main_fab_empty);
        mErrorFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.main_fab_error);
        mNoNetworkFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.main_fab_no_network);
        mContentFab = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.main_fab_content);
        mLoadingFab.setOnClickListener(this);
        mEmptyFab.setOnClickListener(this);
        mErrorFab.setOnClickListener(this);
        mNoNetworkFab.setOnClickListener(this);
        mContentFab.setOnClickListener(this);

        mTv = (TextView) findViewById(R.id.tv);

        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnRemove = (Button) findViewById(R.id.btn_remove);

        mBtnAdd.setOnClickListener(this);
        mBtnRemove.setOnClickListener(this);
        fragmentManager = getFragmentManager();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_fab_loading:
                break;
            case R.id.main_fab_empty:
                break;
            case R.id.main_fab_error:
                showError();
                break;
            case R.id.main_fab_no_network:
                break;
            case R.id.main_fab_content:
                break;
            case R.id.btn_add:

                fragmentManager.beginTransaction().replace(R.id.container, TestFragment.newInstance(), "tag")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack("tag")
                        .commit();

                mTv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mTv.setText("changed ");
                    }
                }, 2000);
                break;
            case R.id.btn_remove:
//                fragmentManager.popBackStack("tag", android.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fragmentManager.popBackStack();
                mTv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mTv.setText("restored");
                    }
                }, 2000);
                break;
            default:
                break;
        }
//        mFloatingActionMenu.toggle(false);
    }

    private void showError() {
        FragmentManager fm = getSupportFragmentManager();
        TestDialog dialog = TestDialog.newInstance();
        dialog.show(fm, "error");
    }
}
