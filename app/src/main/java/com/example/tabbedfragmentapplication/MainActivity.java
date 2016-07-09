package com.example.tabbedfragmentapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tabbedfragmentapplication.fragments.TabbedFragmentExample;
import com.support.tabbedfragmentapplication.R;
import com.example.tabbedfragmentapplication.fragments.TabbedFragmentCustomViewExample;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    TabbedFragmentCustomViewExample mCustomFragment;
    TabbedFragmentExample mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (mFragment == null) {
            mFragment = new TabbedFragmentExample();
        }
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mFragment);
        fragmentTransaction.commit();
        Button button = (Button) findViewById(R.id.switch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                Fragment attachedFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
                if (attachedFragment != null && attachedFragment instanceof TabbedFragmentExample) {
                    if (mCustomFragment == null) {
                        mCustomFragment = new TabbedFragmentCustomViewExample();
                    }
                    fragment = mCustomFragment;
                } else if (attachedFragment != null && attachedFragment instanceof TabbedFragmentCustomViewExample) {
                    if (mFragment == null) {
                        mFragment = new TabbedFragmentExample();
                    }
                    fragment = mFragment;
                }
                if (fragment !=null) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}
