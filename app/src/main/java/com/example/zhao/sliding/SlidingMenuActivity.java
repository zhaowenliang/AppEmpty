package com.example.zhao.sliding;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import com.example.zhao.myapplication.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class SlidingMenuActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);

        initSlidingMenu(true);
    }

    /**
     * 初始化侧滑菜单
     * @param isSliding 能否侧拉
     */
    private void initSlidingMenu(boolean isSliding) {
        MenuFragment menuFragment = new MenuFragment();
        setBehindContentView(R.layout.menu_frame);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame, menuFragment).commit();

        SlidingMenu menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        if (isSliding) {
            menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        } else {
            menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
        // 设置菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setBackgroundResource(R.mipmap.menu_bg);
        // 背景层动画
        menu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (percentOpen * 0.25 + 0.75);
                canvas.scale(scale, scale, canvas.getWidth(), canvas.getHeight() / 2);
            }
        });
        // 主界面动画
        menu.setAboveCanvasTransformer(new SlidingMenu.CanvasTransformer() {
            @Override
            public void transformCanvas(Canvas canvas, float percentOpen) {
                float scale = (float) (1 - percentOpen * 0.1);
                canvas.scale(scale, scale, 0, canvas.getHeight() / 2);
            }
        });
    }

    public void clickSlidingMenu(View view) {
        getSlidingMenu().toggle();
    }

}
